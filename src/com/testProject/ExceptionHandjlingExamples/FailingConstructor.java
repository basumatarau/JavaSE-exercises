package com.testProject.ExceptionHandjlingExamples;

import java.io.*;

public class FailingConstructor {
    private BufferedReader bufferedReader;

    String getLine() throws IOException{
        String result = null;
        if(bufferedReader.ready()){
            result = bufferedReader.readLine();
        }
        return result;
    }

    FailingConstructor(String filename) throws Exception {
        FileReader reader = null;
        BufferedReader br = null;
        try {
            File file = new File(filename);
            reader = new FileReader(file);
            br = new BufferedReader(reader);
        } catch (FileNotFoundException e) {
            System.out.println("couldn't open file: " + filename);
        } catch (Exception e) {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e2) {
                System.out.println("resource disposal error: " + filename);
            }
            throw e;
        } finally {
            bufferedReader = br;
        }
    }

    void dispose(){
        try{
            bufferedReader.close();
        }catch (IOException e){
            System.out.println("disposal error");
        }
    }

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + File.separator + "src" +
                File.separator + FailingConstructor.class.getName().replaceAll("[.]", File.separator) + ".java";
        try {
            String line;
            FailingConstructor failingConstructor = new FailingConstructor(path);
            while((line=failingConstructor.getLine())!=null){
                System.out.println(line);
            }
            failingConstructor.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
