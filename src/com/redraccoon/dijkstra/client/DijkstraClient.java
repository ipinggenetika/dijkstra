package com.redraccoon.dijkstra.client;

import com.redraccoon.dijkstra.model.Edge;
import com.redraccoon.dijkstra.model.Graph;

/**
 * Client code to demonstrate Dijkstra's algorithm
 * 
 * @author Stewart Wright
 *
 */
public class DijkstraClient {
	
	public static void main(String[] args) {
	
		// Define the edges of the graph
	
		Edge[] edges =
			{	new Edge(0,2,1),
				new Edge(0,3,4),
				new Edge(0,4,2),
				new Edge(0,1,3),
				new Edge(1,3,2),
				new Edge(1,4,3),
				new Edge(1,5,1),
				new Edge(2,4,1),
				new Edge(3,5,4),
				new Edge(4,5,2),
				new Edge(4,6,7),
				new Edge(4,7,2),
				new Edge(5,6,4),
				new Edge(6,7,5)
			};
		
		// Create the graph
		
		Graph graph = new Graph(edges);
		
		// Update the graph with the shortest distances
		
		graph.calculateShortestDistances();
		
		// Display the graph
		
		System.out.println(graph.toString());
	
	}

}