package com.codeHeap.annotation.annoProcessingExample;

import com.google.auto.service.AutoService;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AutoService(Processor.class)
public class InterfaceExtractorProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);

    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {

        Set<String> supportedAnnoTypes = new HashSet<>();
        supportedAnnoTypes.add(ExtractInterface.class.getCanonicalName());

        return supportedAnnoTypes;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (TypeElement typeElement : set) {
            Set<? extends Element> elementsAnnotatedWith
                    = roundEnvironment.getElementsAnnotatedWith(typeElement);

            Map<Boolean, ? extends List<? extends Element>> annoTypes = elementsAnnotatedWith.stream().collect(
                    Collectors.partitioningBy(element ->
                            element.getKind().isClass() && element.getEnclosedElements().stream()
                                    .anyMatch(el -> ((Element) el).getModifiers().contains(Modifier.PUBLIC)
                                            && !((Element) el).asType().getKind().isPrimitive()
                                    ))
            );

            List<? extends Element> qualified = annoTypes.get(true);
            List<? extends Element> notQualified = annoTypes.get(false);

            notQualified.forEach(
                    element ->
                            processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                                    "@ExtractInterface(value = \"interface name\") " +
                                            "is applied to classes")
            );
            if (qualified.size() == 0) {
                continue;
            }

            for (Element element : qualified) {
                try {
                    String className = element.asType().getClass().getName();

                    String packageName = null;
                    int lastDot = className.lastIndexOf('.');
                    if (lastDot > 0) {
                        packageName = className.substring(0, lastDot);
                    }

                    String simpleClassName = className.substring(lastDot + 1);
                    String interfaceSimpleName = element.getAnnotation(ExtractInterface.class).value();
                    String interfaceName = simpleClassName.substring(0, lastDot) + interfaceSimpleName;

                    JavaFileObject sourceFile
                            = processingEnv.getFiler().createSourceFile(interfaceName);

                    PrintWriter out = new PrintWriter(sourceFile.openWriter());

                    if (packageName != null) {
                        out.print("package ");
                        out.print(packageName);
                        out.println(";");
                        out.println();
                    }

                    out.print("public interface ");
                    out.print(interfaceSimpleName);
                    out.println(" {");
                    out.println();

                    for (Element enclosedElement : element.getEnclosedElements()) {
                        if (enclosedElement.getModifiers().contains(Modifier.PUBLIC) &&
                                !enclosedElement.asType().getKind().isPrimitive()) {
                            out.print(((ExecutableType) enclosedElement).getReturnType() + " ");
                            out.print(enclosedElement.getSimpleName() + "(");
                            int i = 0;
                            String delimiter = "";
                            for (TypeMirror parameterType : ((ExecutableType) enclosedElement).getParameterTypes()) {
                                out.print(delimiter + parameterType + " var" + i++);
                                delimiter = ", ";
                            }
                            out.print(");\n");
                        }
                    }

                    out.println("}");

                } catch (IOException e) {
                    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                            "source file writing error");
                }
            }

        }
        return true;
    }
}
