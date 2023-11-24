package com.project;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.project.csv.Neighbor;

public class leitorrcsv {

    public static void main(String[] args) {
        String file = "src/main/java/com/project/csv/csv.csv";

        Map<Integer, List<Neighbor>> graph = new HashMap<>();

        try (
                CSVReader reader = new CSVReader(new FileReader(file))) {

            List<String[]> lines = reader.readAll();

            for (String[] line : lines) {
                int node = Integer.parseInt(line[1]);

                List<Neighbor> neighbors = new ArrayList<>();
                for (int i = 2; i < line.length; i += 2) {
                    int neighbor = Integer.parseInt(line[i]);
                    int distance = Integer.parseInt(line[i + 1]);
                    neighbors.add(new Neighbor(neighbor, distance));
                }

                graph.put(node, neighbors);
            }

            for (Map.Entry<Integer, List<Neighbor>> entry : graph.entrySet()) {
                int node = entry.getKey();
                List<Neighbor> neighbors = entry.getValue();

                System.out.println("Node " + node + " é vizinho de: ");
                for (Neighbor neighbor : neighbors) {
                    System.out.println(neighbor.getNode() + "(distância: " + neighbor.getDistance() + "km), ");
                }
                System.out.println();
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
    }
}