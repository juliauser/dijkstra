package com.project.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
    private final int no;
    private final String origem;
    private final String adjacente;
    private final double distancia;

    private Set<No> nos = new HashSet<>();

    public Grafo(int no, String origem, String adjacente, double distancia) {
        this.no = no;
        this.origem = origem;
        this.adjacente = adjacente;
        this.distancia = distancia;
    }

    public void adicionarNo(No no) {
        nos.add(no);
    }

    public int getNo() {
        return no;
    }


    public Set<No> getNos() {
        return nos;
    }

    public void setNos(Set<No> nos) {
        this.nos = nos;
    }

    public String getOrigem() {
        return origem;
    }

    public String getAdjacente() {
        return adjacente;
    }
    public double getDistancia() {
        return distancia;
    }

    public No getNoPeloNome(String nome) {
        for (No no : nos) {
            if (no.getNome().equals(nome)) {
                return no;
            }
        }
        return null;
    }

    public void adicionarAresta(No origem, No destino, double distancia) {
        origem.adicionarDestino(destino, distancia);
    }

}