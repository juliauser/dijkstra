package com.project.csv;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class Leitor {

    public static void main(String[] args) {
        String csv = "src/main/java/com/project/csv/csv.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csv))) {
            String[] colunas;
            Map<String, List<Dados>> municipioDadosMap = new HashMap<>();

            while ((colunas = reader.readNext()) != null) {
                int node = tryParseInt(colunas[0]);
                String origem = colunas[1];
                String vizinho = (colunas[2]);
                double distancia = tryParseDouble(colunas[3]);

                String municipio = buscarMunicipio(node);

                Dados dados = new Dados(node, origem, vizinho, distancia, municipio);

                municipioDadosMap.computeIfAbsent(municipio, k -> new ArrayList<>()).add(dados);
            }

            municipioDadosMap.forEach((municipio, dadosList) -> {
                System.out.println(municipio + ", " + dadosList.get(0).getOrigem() + ", ");
                for (Dados dados : dadosList) {
                    System.out.print(dados.getVizinho() + " - " + dados.getDistancia() + " km, ");
                } 
                System.out.println();
            });

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

    }

    private static String buscarMunicipio(int node) {
        Map<Integer, String> municipios = new HashMap<>();
        municipios.put(1, "Município Node 01");
        return municipios.getOrDefault(node, "Município_Desconhecido");
    }

    public static String formatarSaida(String municipio, List<Dados> dadosList) {
        StringBuilder resultado = new StringBuilder();
        resultado.append(municipio).append(": ");

        for (Dados dados : dadosList) {
            resultado.append(dados.getOrigem())
                .append(" (").append(dados.getVizinho()).append(") - ")
                .append(dados.getDistancia()).append(" km, ");
        }

        // Remove a vírgula do final
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