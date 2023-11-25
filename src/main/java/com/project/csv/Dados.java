package com.project.csv;

public class Dados {
    private final int node;
    private final String origin;
    private final String neighbor;
    private final double distance;
    private final String municipio;

    public Dados(int node, String origin, String neighbor, double distance, String municipio) {
        this.node = node;
        this.origin = origin;
        this.neighbor = neighbor;
        this.distance = distance;
        this.municipio = municipio;
    }

    public int getNode() {
        return node;
    }

    public String getOrigin() {
        return origin;
    }

    public String getNeighbor() {
        return neighbor;
    }

    public double getDistance() {
        return distance;
    }

    public String getMunicipio() {
        return municipio;
    }
    
}
