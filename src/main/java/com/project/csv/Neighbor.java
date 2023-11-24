package com.project.csv;

public class Neighbor {
    private final int node;
    private final int distance;

    public Neighbor(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int getNode() {
        return node;
    }

    public int getDistance() {
        return distance;
    }
}
