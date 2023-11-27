package com.project.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {

    public static Grafo calcularCaminhoMaisCurto(Grafo grafo, No origem, No destino) {
        
        origem.setDistancia(0);

        Set<No> nosVisitados = new HashSet<>();
        Set<No> nosNaoVisitados = new HashSet<>();

        nosNaoVisitados.add(origem);

        while (!nosNaoVisitados.isEmpty()) {
            No noAtual = obterNoComMenorDistancia(nosNaoVisitados);
            nosNaoVisitados.remove(noAtual);

            for (Entry <No, Double> parAdjacencia : noAtual.getNosAdjacentes().entrySet()) {
                No noAdjacente = parAdjacencia.getKey();
                Double pesoAresta = parAdjacencia.getValue();
                
                if (!nosVisitados.contains(noAdjacente)) {
                    calcularDistanciaMinima(noAdjacente, pesoAresta, noAtual);
                    nosNaoVisitados.add(noAdjacente);
                }
            }
            nosVisitados.add(noAtual);

            //fazer o loop até atingir o nó destino
            if (noAtual.equals(destino)) {
                break;
            }
        }
        return grafo;
    }

    //Retorna o nó com a menor distância do conjunto de nós não visitados
    private static No obterNoComMenorDistancia(Set <No> nosNaoVisitados) {
        No noComMenorDistancia = null;
        double menorDistancia = Double.MAX_VALUE;
        
        for (No no : nosNaoVisitados) {
            double distanciaNo = no.getDistancia();
            
            if(distanciaNo < menorDistancia) {
                menorDistancia = distanciaNo;
                noComMenorDistancia = no;
            }
        }
        return noComMenorDistancia;
    }

    //compara a distancia atual com a recem calculada enquanto segue o novo caminho explorado
    private static void calcularDistanciaMinima(No noAvaliado, Double pesoAresta, No noOrigem) {
        double distanciaOrigem = noOrigem.getDistancia();

        if (distanciaOrigem + pesoAresta < noAvaliado.getDistancia()) {
            noAvaliado.setDistancia(distanciaOrigem + pesoAresta);
            LinkedList<No> caminhoMaisCurto = new LinkedList<>(noOrigem.getCaminhoMaisCurto());
            caminhoMaisCurto.add(noOrigem);
            noAvaliado.setCaminhoMaisCurto(caminhoMaisCurto);
        }
    }

}
