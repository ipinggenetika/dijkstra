package com.redraccoon.dijkstra.model;

/**
 * Represents an edge in a graph.
 *
 * @author Stewart Wright
 *  
 */
public class Edge {
	
	private int fromNodeIndex;
	
	public int getFromNodeIndex() {
		return fromNodeIndex;
	}

	private int toNodeIndex;

	public int getToNodeIndex() {
		return toNodeIndex;
	}

	private int length;

	public int getLength() {
		return length;
	}

	public Edge(int fromNodeIndex, int toNodeIndex, int length) {
		this.fromNodeIndex = fromNodeIndex;
		this.toNodeIndex = toNodeIndex;
		this.length = length;
	}

	/**
	 * Determines the neighbouring node of a supplied node, based on the 2 nodes connected by this edge.
	 * 
	 * @param nodeIndex The index of one of the nodes that this edge joins.
	 * @return The index of the neighbouring node.
	 *
	 */
	public int getNeighbourIndex(int nodeIndex) {
		if (this.fromNodeIndex == nodeIndex) {
			return this.toNodeIndex;
		} else {
			return this.fromNodeIndex;
		}
	}
			
}