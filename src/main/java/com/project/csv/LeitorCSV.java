package com.project.csv;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;

class LeitorCSV {
    public static void main(String[] args) {
        String file = "src//main/java/com/project/csv/planilha.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(";");

                for(String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            
        } 
        finally {
            try {
                reader.close();
            } 
            catch (IOException e) {

            }
        }
    }
    
}