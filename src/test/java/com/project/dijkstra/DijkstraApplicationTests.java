package com.project.dijkstra;

import com.project.dijkstra.Dijkstra;
import com.project.dijkstra.Graph;
import com.project.dijkstra.Node;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class DijkstraApplicationTests {

	@Test
	public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");

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
    
        List <Node> shortestPathForNodeB = Arrays.asList(nodeA);
        List <Node> shortestPathForNodeC = Arrays.asList(nodeA);
        List <Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
        List <Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
        List <Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

        for (Node node : graph.getNodes()) {
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
