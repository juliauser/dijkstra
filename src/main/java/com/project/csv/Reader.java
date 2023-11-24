package com.project.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Reader {
    
    public static void main(String[] args) {
        String csv = "src/main/java/com/project/csv/csv.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csv))) {
            String[] columns;
            Map<Integer, String> municipios = createMap();

            while ((columns = reader.readNext()) != null) {
                int node = tryParseInt(columns[0]);
                String origin = columns[1];
                int neighbor = tryParseInt(columns[2]);
                double distance = tryParseDouble(columns[3]);

                String municipio = municipios.getOrDefault(node, "Municipio não localizado.");

                System.out.println("Node: " + node + ", Origem: " + origin + ", vizinho: " + neighbor +
                                    ", distancia: " + distance + ", municipio: " + municipio);
                
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }

    private static int tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static double tryParseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private static Map<Integer, String> createMap() {
        Map <Integer, String> municipios = new HashMap<>();
        municipios.putAll(municipios);
        return municipios;

    }

}
