package com.project.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Grafo {
    
    // Representa um grafo como um conjunto de nós
    private Set<No> nos = new HashSet<>();

    public void adicionarNo(No no) {
        nos.add(no);
    }

    public Set<No> getNos() {
        return nos;
    }

    public void setNos(Set<No> nos) {
        this.nos = nos;
    }
}
