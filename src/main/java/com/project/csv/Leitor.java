package com.project.csv;

import com.project.dijkstra.Grafo;
import com.project.dijkstra.No;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leitor {
    private static final String csv = "src/main/java/com/project/csv/csv.csv";

    public static void LerCSVAdicionarAoGrafo(Grafo grafo, String csv) {
        try (CSVReader reader = new CSVReader(new FileReader(csv))) {
            String[] colunas;

            while ((colunas = reader.readNext()) != null) {
                String origem = colunas[0];
                String adjacente = (colunas[1]);
                double distancia = tryParseDouble(colunas[2]);

                No no = grafo.getNoPeloNome(origem);
                if (no == null) {
                    no = new No(origem);
                    grafo.adicionarNo(no);
                }

                No noAdjacente = grafo.getNoPeloNome(adjacente);
                if (noAdjacente == null) {
                    noAdjacente = new No(adjacente);
                    grafo.adicionarNo(noAdjacente);
                }


                grafo.adicionarAresta(no, noAdjacente, distancia);

                no.adicionarDestino(noAdjacente, distancia);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    public static String formatarSaida(String grafo, List<Grafo> grafoList) {
        StringBuilder resultado = new StringBuilder();
        resultado.append(String.format("%s: ", grafo));

        for (Grafo g : grafoList) {
            resultado.append(String.format("%s (%s) - %.2f km, ", g.getOrigem(), g.getAdjacente(), g.getDistancia()));
        }

        // Remove a vírgula do final
        if (resultado.length() > 0) {
            resultado.setLength(resultado.length() - 2);
        }

        return resultado.toString();
    }

    private static double tryParseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}