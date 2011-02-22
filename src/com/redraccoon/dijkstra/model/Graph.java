package com.redraccoon.dijkstra.model;

import java.util.ArrayList;
import com.redraccoon.dijkstra.model.Edge;

/**
 * Represents a graph.
 *
 *  Algorithm copied from Wikipedia.org: http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm#Algorithm
 *  ==================================================================================================
 *  Let the node at which we are starting be called the initial node. Let the distance of node Y be the distance from the initial
 *  node to Y. Dijkstra's algorithm will assign some initial distance values and will try to improve them step by step.
 *  1. Assign to every node a distance value: set it to zero for our initial node and to infinity for all other nodes.
 *  2. Mark all nodes as unvisited. Set initial node as current.
 *  3. For current node, consider all its unvisited neighbors and calculate their tentative distance. For example, if current node
 *     (A) has distance of 6, and an edge connecting it with another node (B) is 2, the distance to B through A will be 6+2=8. If
 *     this distance is less than the previously recorded distance, overwrite the distance.
 *  4. When we are done considering all neighbors of the current node, mark it as visited. A visited node will not be checked
 *     ever again; its distance recorded now is final and minimal.
 *  5. If all nodes have been visited, finish. Otherwise, set the unvisited node with the smallest distance (from the initial node,
 *     considering all nodes in graph) as the next "current node" and continue from step 3.
 *  
 *	Notes
 *	=====
 *	This implementation is a working demonstration of how Dijkstra's algorithm could be implemented
 *	Legal inputs are assumed for all data
 *	The graph (all nodes and edges) is initialised with an array of Edges
 *	The output is text based to the standard console
 *	Integer.MAX_VALUE is the starting distance for all nodes (apart from the source which is 0)
 *	Each node is uniquely identified by a positive integer, starting at 0 for the source, and sequential
 *	Edges do not have unique ids, they are unique based on the 2 nodes that they join
 *	Each edge has a length that is greater than zero
 *	Every node must be joined to 1 or more other nodes
 *
 * @author Stewart Wright
 *  
 */
public class Graph {
	
	private Node[] nodes;

	public Node[] getNodes() {
		return nodes;
	}
	
	private int noOfNodes;
	
	public int getNoOfNodes() {
		return noOfNodes;
	}

	private Edge[] edges;
	
	public Edge[] getEdges() {
		return edges;
	}
	
	private int noOfEdges;
	
	public int getNoOfEdges() {
		return noOfEdges;
	}
		
	/**
	 * Constructor that builds the whole graph from an Array of Edges
	 */
	public Graph(Edge[] edges){
		
		// The edges are passed in, so store them
		this.edges = edges;

		// Create all the nodes, ready to be updated with the edges
		this.noOfNodes = calculateNoOfNodes(edges);
		this.nodes = new Node[this.noOfNodes];
		for (int n = 0; n < this.noOfNodes; n++) {
			this.nodes[n] = new Node();
		}		
		
		// Add all the edges to the nodes. Each edge is added to 2 nodes (the "to" and the "from")
		this.noOfEdges = edges.length;
		for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
			this.nodes[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
			this.nodes[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
		}
		
	}
	
	/**
	 * Calculate the number of nodes in an array of edges
	 * 
	 * @param edges An array of edges that represents the graph.
	 * @return The number of nodes in the graph.
	 *
	 */
	private int calculateNoOfNodes(Edge[] edges) {
		int noOfNodes = 0;
		for (Edge e:edges ) {
			if (e.getToNodeIndex() > noOfNodes) noOfNodes = e.getToNodeIndex();
			if (e.getFromNodeIndex() > noOfNodes) noOfNodes = e.getFromNodeIndex();
		}
		noOfNodes++;	
		return noOfNodes;		
	}
	
	/**
	 * Uses Dijkstra's algorithm to calculate the shortest distance from the source to all nodes
	 * 
	 */
	public void calculateShortestDistances() {
		
		// Set node 0 as the source
		this.nodes[0].setDistanceFromSource(0);
		int nextNode = 0;
		
		// Visit every node, in order of stored distance
		for (int i = 0; i < this.nodes.length; i++) {
			
			// Loop round the edges that are joined to the current node
			ArrayList<Edge> currentNodeEdges = this.nodes[nextNode].getEdges();
			for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
	
				// Determine the joined edge neighbour of the current node
				int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);
				
				// Only interested in an unvisited neighbour
				if (!this.nodes[neighbourIndex].isVisited()) {
					
					// Calculate the tentative distance for the neighbour
					int tentative = this.nodes[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();
					
					// Overwrite if the tentative distance is less than what's currently stored
					if (tentative < nodes[neighbourIndex].getDistanceFromSource()) {
						nodes[neighbourIndex].setDistanceFromSource(tentative);
					}
					
				}
				
			}
			
			// All neighbours are checked so this node is now visited
			nodes[nextNode].setVisited(true);
			
			// The next node to visit must be the one with the shortest distance.
			nextNode = getNodeShortestDistanced();
		
		}

	}
	
	/**
	 * Scans the unvisited nodes and calculates which one has the shortest distance from the source.
	 * 
	 * @return The index of the node with the smallest distance
	 */
	private int getNodeShortestDistanced() {
		
		int storedNodeIndex = 0;
		int storedDist = Integer.MAX_VALUE;
		
		for (int i = 0; i < this.nodes.length; i++) {
			int currentDist = this.nodes[i].getDistanceFromSource();			
			if (!this.nodes[i].isVisited() && currentDist < storedDist) {
				storedDist = currentDist;
				storedNodeIndex = i;
			}
			
		}
		
		return storedNodeIndex;
	}
	
	/**
	 * Overrides Object.toString() to show the contents of the graph
	 * 
	 */
	public String toString() {

		String output = "Number of nodes = " + this.noOfNodes;
		output += "\nNumber of edges = " + this.noOfEdges;

		for (int i = 0; i < this.nodes.length; i++) {
			output += ("\nThe shortest distance from node 0 to node " + i + " is " + nodes[i].getDistanceFromSource());
		}
		
		return output;

	}

}
