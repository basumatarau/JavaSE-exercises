package com.codeHeap.io.OSExecute;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class OSExecute {
    public static List<String> command(String command) {

        boolean err = false;

        List<String> result = new ArrayList<>();
        try {
            Process process = new ProcessBuilder(command.split(" ")).start();

            BufferedReader results = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = results.readLine()) != null) {
                result.add(line);
            }
            BufferedReader errors = new BufferedReader(
                    new InputStreamReader(process.getErrorStream())
            );
            while ((line = errors.readLine()) != null) {
                System.err.println(line);
                err = true;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (err) {
            throw new OSExecutionException("Error execution command: " + command);
        }
        return result;
    }
}
