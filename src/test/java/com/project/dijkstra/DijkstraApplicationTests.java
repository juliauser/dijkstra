package com.project.dijkstra;

import com.project.dijkstra.Dijkstra;
import com.project.dijkstra.Grafo;
import com.project.dijkstra.No;
import com.project.dijkstra.Veiculo;
import com.project.dijkstra.Pedagio;

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

        System.out.println("Qual o veículo?");
        String tipoVeiculo = sc.nextLine();

        System.out.println("Deseja fazer alguma parada no caminho?");
        int parada = sc.nextInt();

        Grafo grafo = new Grafo(7, partida, destino, getDistancia);

        String caminhoCsv = "src/main/java/com/project/csv/csv.csv";
        Leitor.LerCSVAdicionarAoGrafo(grafo, caminhoCsv);

        No noOrigem = grafo.getNoPeloNome(partida);
        No noDestino = grafo.getNoPeloNome(destino);

        Dijkstra.calcularCaminhoMaisCurto(grafo, noOrigem, noDestino);
        //Pedagio.calcularPedagio(noOrigem, noDestino);

        for (No no : grafo.getNos()) {
            System.out.println("Caminho mais curto de " + noOrigem.getNome() + " para " + no.getNome() + ": " + no.getCaminhoMaisCurto());
            System.out.println("Distância: " + no.getDistancia());
            System.out.println("-----------------------------");
        }

        sc.close();
    }
}
