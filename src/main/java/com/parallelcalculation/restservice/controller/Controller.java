package com.parallelcalculation.restservice.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Controller {

    private static final String CALCULATION_FILE_PATH = "./src/resources/CalculationCPP.exe";

    public static String getCalculationResult(String arraySize, String threadNumber){

        StringBuffer result = new StringBuffer();

        Process process = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {

            System.out.printf("\nExecute file\n");
            process = new ProcessBuilder(CALCULATION_FILE_PATH, arraySize, threadNumber).start();
            System.out.printf("Looks like its fine\n");

            System.out.printf("Read output...\n");
            inputStream = process.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String line;

            System.out.printf("Output of running file is:\n\n");

            while ( !(line = bufferedReader.readLine()).equals(null)
                    && !line.contains("end")
                    && !line.contains("Invalid") )  {

                System.out.printf(line);
                result.append(line + "\n");
            }

            System.out.printf("\nClose file\n");
            process.destroy();
            inputStream.close();
            inputStreamReader.close();
            bufferedReader.close();

        } catch (Exception e){
            System.out.printf(e.getMessage());
        }

        return result.toString();
    }
}