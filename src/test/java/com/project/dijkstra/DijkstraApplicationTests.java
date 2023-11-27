package com.project.dijkstra;

import com.project.dijkstra.Dijkstra;
import com.project.dijkstra.Grafo;
import com.project.dijkstra.No;

import java.io.FileReader;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.project.csv.Leitor;

class DijkstraApplicationTests {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Qual o ponto de partida?");
        String partida = sc.nextLine();

        System.out.println("Qual o ponto de chegada?");
        String destino = sc.nextLine();

        Grafo grafo = new Grafo(7, partida, destino);
        Leitor.LerCSVAdicionarAoGrafo(grafo, "src/main/java/com/project/csv/csv.csv");


        No noOrigem = grafo.getNoPeloNome(partida);
        No noDestino = grafo.getNoPeloNome(destino);

        Dijkstra.calcularCaminhoMaisCurto(grafo, noOrigem, noDestino);

        for (No no : grafo.getNos()) {
            System.out.println("Caminho mais curto de " + noOrigem.getNome() + " para " + no.getNome() + ": " + no.getCaminhoMaisCurto());
            System.out.println("Distância: " + no.getDistancia());
            System.out.println("-----------------------------");
        }

        sc.close();
    }
}
