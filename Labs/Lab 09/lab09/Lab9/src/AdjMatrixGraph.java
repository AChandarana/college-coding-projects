// Copyright 2025 Alex Chandarana

import java.util.*;
public class AdjMatrixGraph {

	// Sets up matrix, queue, and linked lists
	public static final int DEF_VERT_COUNT = 10;
	private double [][] adjMatrix;
	private LinkedList<Integer> markedList;
	private Queue<Integer> vQ;
	
	public AdjMatrixGraph(int size) {
		init(size);
	}
	public AdjMatrixGraph() {
		init(DEF_VERT_COUNT);
	}
	private void init(int size) {
		if (size <= 0) {
			init(DEF_VERT_COUNT);
			return;
		}
		
		// sets the materix to a 2d array
		adjMatrix = new double[size][size];
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int ii = 0; ii < adjMatrix[i].length; ii++) {
				adjMatrix[i][ii] = 0;
			}
		}
		markedList = new LinkedList<Integer>();
		vQ = new LinkedList<Integer>();
	}
	
	// changes values in the matrix to point to vertices
	public void addEdge(int from, int to, int wght) {
		if (!isValid(from) || !isValid(to)) return;
		adjMatrix[from][to] = wght;
	}
	
	// checks if an index is within the bounds of the matrix
	private boolean isValid(int i) {
		return i >= 0 && i <= adjMatrix.length;
	}

	// goes line by line to print a square of the values in the matrix
	public void printAdjMatrix() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int ii = 0; ii < adjMatrix[i].length; ii++) {
				System.out.print(adjMatrix[i][ii] + " ");
			}
			System.out.print("\n");
		}
	}

	public void printDFS() {
		markedList.clear();
		printDFS(0);
	}

	public void printBFS() {
		markedList.clear();
		vQ.clear();
		markedList.add(0);
		vQ.add(0);
		System.out.println(0);
		while (!vQ.isEmpty()) {
			int current = vQ.remove();
			markedList.add(current);
			for (int i = 0; i < adjMatrix.length; i++) {
				if (!markedList.contains(i) && !vQ.contains(i) && adjMatrix[current][i] != 0) {
					System.out.println(i);
					vQ.add(i);
				}
			}
		}
	}

	public void printDFS(int i) {
		System.out.println(i);
		markedList.add(i);
		for(int j = 0; j < adjMatrix.length; j++) {
			if (adjMatrix[i][j] != 0 && !markedList.contains(j)) {
				printDFS(j);
			}
		}
	}
	
	// Seperate from method to avoid issues with calling this from the printDFS() method
	public void printDFSFrom(int i) {
		markedList.clear();
		System.out.println(i);
		markedList.add(i);
		for(int j = 0; j < adjMatrix.length; j++) {
			if (adjMatrix[i][j] != 0 && !markedList.contains(j)) {
				printDFSFrom(j);
			}
		}
	}
	
	public void printBFSFrom(int i) {
		markedList.clear();
		vQ.clear();
		markedList.add(i);
		vQ.add(i);
		System.out.println(i);
		while (!vQ.isEmpty()) {
			int current = vQ.remove();
			markedList.add(current);
			for (int j = 0; j < adjMatrix.length; j++) {
				if (!markedList.contains(j) && !vQ.contains(j) && adjMatrix[current][j] != 0) {
					System.out.println(j);
					vQ.add(j);
				}
			}
		}
	}

}
