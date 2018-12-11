package com.codeHeap.annotation.usingDeprecatedApt;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class InterfaceExtractorProcessor implements AnnotationProcessor {

    AnnotationProcessorEnvironment env;
    private List<MethodDeclaration> interfaceMethods = new ArrayList<>();

    InterfaceExtractorProcessor(AnnotationProcessorEnvironment env){
        this.env = env;
    }

    @Override
    public void process() {
        for (TypeDeclaration typeDeclaration : env.getTypeDeclarations()) {
            ExtractInterface annotation = typeDeclaration.getAnnotation(ExtractInterface.class);
            if(annotation==null){
                continue;
            }
            for (MethodDeclaration method : typeDeclaration.getMethods()) {
                if(method.getModifiers().contains(Modifier.PUBLIC)
                && !(method.getModifiers().contains(Modifier.STATIC))){
                    interfaceMethods.add(method);
                }
            }
            if(interfaceMethods.size()>1){
                try{
                    PrintWriter out = env.getFiler().createSourceFile(annotation.value());
                    out.print("package " + typeDeclaration.getQualifiedName() + ";");
                    out.print("public interface " + annotation.value() + "{");
                    for (MethodDeclaration method : typeDeclaration.getMethods()) {
                        out.print(" public "+ method.getReturnType() + " " + method.getSimpleName() + "(");
                        int i = 0;
                        String delimiter = "";
                        for (ParameterDeclaration parameter : method.getParameters()) {
                            out.print(delimiter + parameter.getType() + " " + parameter.getSimpleName());
                            delimiter = ", ";
                        }
                        out.println(");");
                    }
                    out.println("}");
                    out.close();
                }catch (IOException e){
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
