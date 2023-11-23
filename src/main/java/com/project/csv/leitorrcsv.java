package com.project.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leitorrcsv {
    
    String file = "src//main/java/com/project/csv/planilha.csv";
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            text.append(line);
            text.append("\n");
        }
        bufferedReader.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

    public String readTheLine(BufferedReader reader) throws IOException {
        int size;
        String[] string = new String[size];


        return result;
    }
}
