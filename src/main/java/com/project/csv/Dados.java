package com.project.csv;

public class Dados {
    private final int node;
    private final String origem;
    private final String vizinho;
    private final double distancia;
    private final String municipio;

    public Dados(int node, String origem, String vizinho, double distancia, String municipio) {
        this.node = node;
        this.origem = origem;
        this.vizinho = vizinho;
        this.distancia = distancia;
        this.municipio = municipio;
    }

    public int getNode() {
        return node;
    }

    public String getOrigem() {
        return origem;
    }

    public String getVizinho() {
        return vizinho;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getMunicipio() {
        return municipio;
    }
}