package com.project.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No {

    private String nome;

    // Lista de nós que descreve o caminho mais curto calculado a partir do nó de origem
    private LinkedList<No> caminhoMaisCurto = new LinkedList<>();

    private double distancia = Double.POSITIVE_INFINITY;

    // adjacentNodes é usado para associar vizinhos com o comprimento da aresta
    private Map<No, Double> nosAdjacentes = new HashMap<>();

    public No(String nome) {
        this.nome = nome;
    }

    public void adicionarDestino(No destino, double distancia) {
        nosAdjacentes.put(destino, distancia);
        destino.getNosAdjacentes().put(this, distancia); //adiciona a aresta no sentido oposto para grafos não direcionados
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<No> getCaminhoMaisCurto() {
        return caminhoMaisCurto;
    }

    public void setCaminhoMaisCurto(LinkedList<No> caminhoMaisCurto) {
        this.caminhoMaisCurto = caminhoMaisCurto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Map<No, Double> getNosAdjacentes() {
        return nosAdjacentes;
    }

    public void setNosAdjacentes(Map<No, Double> nosAdjacentes) {
        this.nosAdjacentes = nosAdjacentes;
    }
    
    public void adicionarAresta(No destino, double distancia) {
        nosAdjacentes.put(destino, distancia);
        destino.getNosAdjacentes().put(this, distancia); //adiciona a aresta no sentido oposto
    }
}
