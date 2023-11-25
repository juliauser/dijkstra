package com.project.dijkstra;

import com.project.dijkstra.Dijkstra;
import com.project.dijkstra.Grafo;
import com.project.dijkstra.No;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class DijkstraApplicationTests {

	@Test
	public static void main(String[] args) {
        No nodeA = new No("A");
        No nodeB = new No("B");
        No nodeC = new No("C");
        No nodeD = new No("D");
        No nodeE = new No("E");
        No nodeF = new No("F");

        nodeA.addDestination(nodeB, 10);
        nodeA.addDestination(nodeC, 15);

        nodeB.addDestination(nodeD, 12);
        nodeB.addDestination(nodeF, 15);

        nodeC.addDestination(nodeE, 10);

        nodeD.addDestination(nodeE, 2);
        nodeD.addDestination(nodeF, 1);

        nodeF.addDestination(nodeE, 5);

        Graph graph = new Graph();

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeF);

        graph = Dijkstra.calculateShortestPathFromSource(graph, nodeA);

        //after the calculation the shortest path distance attributes are set for each node in the graph
    
        List <No> shortestPathForNodeB = Arrays.asList(nodeA);
        List <No> shortestPathForNodeC = Arrays.asList(nodeA);
        List <No> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List <No> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List <No> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (No node : graph.getNodes()) {
            switch (node.getName()) {
                case "B":
                    assertTrue(node.getShortestPath().equals(shortestPathForNodeB));
                    break;
                case "C":
                    assertTrue(node.getShortestPath().equals(shortestPathForNodeC));
                    break;
                case "D":
                    assertTrue(node.getShortestPath().equals(shortestPathForNodeD));
                    break;
                case "E":
                    assertTrue(node.getShortestPath().equals(shortestPathForNodeE));
                    break;
                case "F":
                    assertTrue(node.getShortestPath().equals(shortestPathForNodeF));
                    break;
            }
        }
    }

}
