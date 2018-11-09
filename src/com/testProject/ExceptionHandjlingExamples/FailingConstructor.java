package com.testProject.ExceptionHandjlingExamples;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FailingConstructor {
    private static String fileContent;

    public String getFileContent() {
        return fileContent;
    }

    FailingConstructor(String filename) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filename)));
        StringBuilder sb = new StringBuilder();
        while (bufferedReader.ready()) {
            sb.append(bufferedReader.readLine()).append('\n');
        }
        fileContent = sb.toString();
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+File.separator+"src"+
                File.separator+ FailingConstructor.class.getName().replaceAll("[.]",File.separator)+".java";
        try {
            FailingConstructor failingConstructor = new FailingConstructor(path);
            System.out.println(failingConstructor.getFileContent());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
