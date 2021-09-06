package com.lidia.algorithms;

import java.util.Iterator;
import java.util.LinkedList;

public class DepthFirstSearch {
	
	private int numVertices;
	
	// Array  of lists for
    // Adjacency List Representation
    private LinkedList<Integer> adjList[];
    
    @SuppressWarnings("unchecked")
    DepthFirstSearch(int v) {
    	numVertices = v;
    	adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
        	adjList[i] = new LinkedList();
    }
    
    // Function to add an edge into the graph
    void addEdge(int v, int w) {
    	adjList[v].add(w); // Add w to v's list.
    }
    
    
    // A function used by DFS
    void DFSUtil(int v, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    
    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as false by default in java)
        boolean visited[] = new boolean[numVertices];
 
        // Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
    
	public static void main(String[] args) {
		DepthFirstSearch g = new DepthFirstSearch(4);
		
		input1(g);
//		input2(g);
       
        System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
 
        g.DFS(2);
//        g.DFS(3); //3
//        g.DFS(1);
	}

	private static void input2(DepthFirstSearch g) {
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
	}

	private static void input1(DepthFirstSearch g) {
		g.addEdge(0, 2);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 0);
		g.addEdge(3, 3);
	}

}
