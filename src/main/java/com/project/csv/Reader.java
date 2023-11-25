package com.project.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Reader {
    
    public static void main(String[] args) {
        String csv = "src/main/java/com/project/csv/csv.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csv))) {
            String[] columns;
            Map<String, List<Dados>> municipioDadosMap = new HashMap<>();

            while ((columns = reader.readNext()) != null) {
                int node = tryParseInt(columns[0]);
                String origin = columns[1];
                String neighbor = (columns[2]);
                double distance = tryParseDouble(columns[3]);

                String municipio = buscarMunicipio(node);

                Dados dados = new Dados(node, origin, neighbor, distance, municipio);

                municipioDadosMap.computeIfAbsent(municipio, k -> new ArrayList<>()).add(dados);
            }

            municipioDadosMap.forEach((node, dadosList) -> {
                System.out.println(node + ", " + dadosList.get(0).getOrigin() + ", ");
                for (Dados dados : dadosList) {
                    System.out.println(dados.getNeighbor() + " - " + dados.getDistance() + " km, ");
                } 
                System.out.println();
            });

        //* municipioDadosMap.forEach((municipio, dadosList) -> {
       //     System.out.println("Municipio: " + municipio);
     //       for (Dados dados : dadosList) {
  ///              System.out.println("Node: " + dados.getNode() + ", origem: " + dados.getOrigin() + ", vizinho: " + dados.getNeighbor() + ", distancia: " + dados.getDistance() + "km");
//
           // }

        // }); 
        

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }

    private static String buscarMunicipio(int node) {
        Map<Integer, String> municipios = new HashMap<>();
        municipios.put(1, "Municipio node 01");
        return municipios.getOrDefault(node, "Municipio_desconhecido");
    }

    public static String formatarSaida(String municipio, List<Dados> dadosList) {
        StringBuilder resultado = new StringBuilder();
        resultado.append(municipio).append(": ");

        for (Dados dados : dadosList) {
            resultado.append(dados.getOrigin())
                .append(" (").append(dados.getNeighbor()).append(") - ")
                .append(dados.getDistance()).append(" km, ");
        }

        //remove a virgula do final
        if (resultado.length() > 0) {
            resultado.setLength(resultado.length() - 2);
        }

        return resultado.toString();

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

}
