package com.CodeHeap.IO.OSExecute;

import java.io.File;

public class OSExecuteDemo {
    public static void main(String[] args) {
        OSExecute.command("ls -al");
        String path = System.getProperty("user.dir") +File.separator + "out" + File.separator
                + "production" + File.separator + "JavaSE-exercises" + File.separator
                + OSExecuteDemo.class.getName().replaceAll("\\.", File.separator) + ".class";

        System.out.println(OSExecute.command("javap "+path));
    }
}
