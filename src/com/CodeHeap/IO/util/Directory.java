package com.CodeHeap.IO.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
    public static File[] local(File dir, final String regex){
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File file, String s) {
                return pattern.matcher(s).matches();
            }
        });
    }

    public static File[] local(String dir, final String regex){
        return local(new File(dir), regex);
    }

    public static class TreeInfo implements Iterable<File>{
        List<File> files = new ArrayList<>();
        List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other){
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString(){
            return dirs + "\n\n" + files;
        }
    }

    static TreeInfo recurseDirs(File startDir, String regex){
        TreeInfo result = new TreeInfo();
        for (File file : startDir.listFiles()) {
            if(file.isDirectory()){
                result.dirs.add(file);
                result.addAll(recurseDirs(file, regex));
            }else{
                if(file.getName().matches(regex)){
                    result.files.add(file);
                }
            }
        }
        return result;
    }


    public static TreeInfo walk(String start, String regex){
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex){
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start){
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start){
        return recurseDirs(new File(start), ".*");
    }

}
