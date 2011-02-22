package com.redraccoon.dijkstra.model;

import java.util.ArrayList;

/**
 * Represents a node in a graph.
 *
 * @author Stewart Wright
 *  
 */
public class Node {
	
	private int distanceFromSource = Integer.MAX_VALUE;

	public int getDistanceFromSource() {
		return distanceFromSource;
	}

	public void setDistanceFromSource(int distanceFromSource) {
		this.distanceFromSource = distanceFromSource;
	}

	private boolean visited = false;

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	private ArrayList<Edge> edges = new ArrayList<Edge>();

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

}