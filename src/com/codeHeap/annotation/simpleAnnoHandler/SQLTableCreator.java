package com.codeHeap.annotation.simpleAnnoHandler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SQLTableCreator {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("arguments: annotated class");
            System.exit(0);
        }
        for (String className : args) {
            Class<?> aClass = Class.forName(className);
            DBTable dbTable = aClass.getAnnotation(DBTable.class);
            if (dbTable == null) {
                System.out.println("No @DBTable annotations present in the class" + className);
                continue;
            }

            String tableName = dbTable.name();
            if (tableName.length() < 1) {
                tableName = className.toUpperCase();
            }

            List<String> columnDefinitions = new ArrayList<>();
            for (Field field : aClass.getDeclaredFields()) {
                String colName;
                Annotation[] annotations = field.getAnnotations();
                if (annotations.length < 1) {
                    continue;
                }
                if (annotations[0] instanceof SQLInteger) {
                    SQLInteger ann = (SQLInteger) annotations[0];
                    if (ann.name().length() < 1) {
                        colName = field.getName().toUpperCase();
                    } else {
                        colName = ann.name();
                    }
                    columnDefinitions.add(colName + " INT" + getConstraints(ann.constrains()));
                }
                if (annotations[0] instanceof SQLString) {
                    SQLString ann = (SQLString) annotations[0];
                    if (ann.name().length() < 1) {
                        colName = field.getName().toUpperCase();
                    } else {
                        colName = ann.name();
                    }
                    columnDefinitions.add(colName + " VARCHAR(" + ann.value() + ")"
                            + getConstraints(ann.constraints()));
                }

                StringBuilder createTableQuery = new StringBuilder(
                        "CREATE TABLE " + tableName + "(");
                String delimiter = "";
                for (String columnDefinition : columnDefinitions) {
                    createTableQuery.append(delimiter)
                            .append('\n')
                            .append('\t')
                            .append(columnDefinition);
                    delimiter = ", ";
                }
                createTableQuery.append(");");

                System.out.println(createTableQuery);
            }
        }
    }

    private static String getConstraints(Constraints constrains) {
        String result = "";
        if (!constrains.allowNull()) {
            result += " NOT NULL";
        }
        if (constrains.primaryKey()) {
            result += " PRIMARY KEY";
        }
        if (constrains.unique()) {
            result += " UNIQUE";
        }
        return result;
    }
}
