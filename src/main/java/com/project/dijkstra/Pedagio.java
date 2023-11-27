package com.project.dijkstra;

import java.util.Arrays;
import java.util.List;

public class Pedagio {

    public static void main(String[] args) {
        No origem = getNoPeloNome(origem);
        No destino = getNoPeloNome(destino);



        calcularPedagio(origem, destino);
    }
    
    private static void calcularPedagio (origem, destino) {
        List<String> rotasComPedagio = Arrays.asList("2-3", "3,2");

        String rotaAtual = origem.getNome() + " - " + destino.getNome();

        if (rotasComPedagio.contains(rotaAtual)) {
            adicionarPedagio(origem, destino, 5.0);
        }
    }

    //adiciona o valor do pedagio no custo da rota
    private static void adicionarPedagio(No origem, No destino, double ValorPedagio) {
        Double distancia = origem.getNosAdjacentes().get(destino);
        if (distancia != null) {
            origem.getNosAdjacentes().put(destino, distancia + ValorPedagio);
        } else {
            System.out.println("Erro.");
        }
    }

}
