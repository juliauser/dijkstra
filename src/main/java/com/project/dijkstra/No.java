package com.project.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class No {

    private String nome;

    // Lista de nós que descreve o caminho mais curto calculado a partir do nó de origem
    private LinkedList<No> caminhoMaisCurto = new LinkedList<>();

    // Todas as distâncias de nó são inicializadas com o valor MAX por padrão
    private Integer distancia = Integer.MAX_VALUE;

    // adjacentNodes é usado para associar vizinhos com o comprimento da aresta
    private Map<No, Integer> nosAdjacentes = new HashMap<>();

    public No(String nome) {
        this.nome = nome;
    }

    public void adicionarDestino(No destino, int distancia) {
        nosAdjacentes.put(destino, distancia);
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

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Map<No, Integer> getNosAdjacentes() {
        return nosAdjacentes;
    }

    public void setNosAdjacentes(Map<No, Integer> nosAdjacentes) {
        this.nosAdjacentes = nosAdjacentes;
    }
}
