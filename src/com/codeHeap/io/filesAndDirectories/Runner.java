package com.codeHeap.io.filesAndDirectories;


public class Runner {
    public static void main(String[] args) {
        if(args.length==0){
            System.out.println(Directory.walk("."));
            PrettyPrint.print(Directory.walk(".").dirs);
            PrettyPrint.print(Directory.walk(".", ".*class.*").files);

        }else {
            for (String arg : args) {
                System.out.println(Directory.walk(arg));
            }
        }
    }
}
