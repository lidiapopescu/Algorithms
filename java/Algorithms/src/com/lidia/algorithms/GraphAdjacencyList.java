package com.lidia.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GraphAdjacencyList {

	private int numVertices;
	private LinkedList<Integer> adjList[];

	GraphAdjacencyList(int v) {
		numVertices = v;
		adjList = new LinkedList[v];
		for (int i = 0; i < v; ++i)
	        	adjList[i] = new LinkedList();
	}
	
	// Function to add an edge into the graph
    void addEdge(int v, int w) {
    	adjList[v].add(w); // Add w to v's list.
    }
    
	// Add edge
	static void addEdge(ArrayList<ArrayList<Integer>> am, int s, int d) {
		am.get(s).add(d);
		am.get(d).add(s);
	}

	// Print the graph
	static void printGraph(List<List<Integer>> am) {
		for (int i = 0; i < am.size(); i++) {
			System.out.print("Vertex " + i + ":");
			for (int j = 0; j < am.get(i).size(); j++) {
				System.out.print(" -> " + am.get(i).get(j));
			}
			System.out.println();
		}
	}
	/**
	 * maxE - denotes the maximum number of nodes
	 * e - denotes the number of edges
	 */
//	public void adjacencyList(int maxE, int e) {
//		List<Integer> listEdges = new ArrayList<>();
//		List<Integer> listCosts = new ArrayList<>();
//		
//		
//	}
	
	/**
	 * Enter the number of vertices: 
		4
		Enter the number of edges: 
		6
		How many edges for 1 ?
		3
		Which?
		1 2 4
		How many edges for 2 ?
		2
		Which?
		3 4
		How many edges for 3 ?
		1
		Which?
		4
		How many edges for 4 ?
		0
		Which?
		Vertex 0: -> 1 -> 2 -> 4
		Vertex 1: -> 3 -> 4
		Vertex 2: -> 4
		Vertex 3:
	 * */
	public static void main(String[] args) {
		
		version1();
		
	}

	private static void version1() {
		// Create the graph
	    List<List<Integer>> am =null;
		
		int maxE, e, x, y;//, w;
		List<Integer> listEdges = new ArrayList<>();
//		List<Integer> listCosts = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the number of vertices: ");
			maxE = sc.nextInt();
			System.out.println("Enter the number of edges: ");
			e = sc.nextInt();
			am = new ArrayList<List<Integer>>(maxE);
			
			for (int i=0; i<maxE; i++) {
				System.out.println("How many edges for "+(i+1) +" ?");
				x = sc.nextInt();
				System.out.println("Which?");
				listEdges = new ArrayList<>();
				for (int j=0; j<x; j++) {
					y = sc.nextInt();
					listEdges.add(y);
				}
				am.add(listEdges);
				
//				addEdge(am, x, y);
			}
			printGraph(am);
			
		} catch (Exception e2) {
			System.out.println("Something went wrong");
		}
		sc.close();
	}
}
