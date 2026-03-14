// Copyright 2025 Alex Chandarana
public class LinkedBST <T extends Comparable<T>>{
	private class Node {
		T data;
		Node left;
		Node right;
		public Node(T d) {
			data = d;
			left = right = null;
		}
	}
	
	private Node root;
	public LinkedBST() {
		root = null;
	}
	public void add(T data) {
		if (root == null) {
			root = new Node(data);
		} else {
			add(root, data);
		}
	}
	
	private Node add(Node node, T data) {
		if (node == null) {
			node = new Node(data);
		} 
		if (data.compareTo(node.data) == -1) {
			return node;
		}
		
		// Checks where to put the new node
		else if (data.compareTo(node.data) < 0) {
			node.left = add(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			node.right = add(node.right, data);
		}
		return node;
	}
	
	public void remove(T data) {
		root = remove(root, data);
	}

	private Node remove(Node node, T data) {
		if (node == null) {
			return null;
		}
		
		// -1 means there's an issue
		if (data.compareTo(node.data) == -1) {
			return node;
		}
		else if (data.compareTo(node.data) < 0) {
			node.left = remove(node.left, data);
		}
		else if (data.compareTo(node.data) > 0) {
			node.right = remove(node.right, data);
		} 
		else {
			if (node.right == null) {
				return node.left;
			} else if (node.left == null) {
				return node.right;
			}
		}
		return node;
	}
	
	public void printPreorder() {
		printPreorder(root);
	}
	private void printPreorder(Node node) {
		if (node == null) return;
		System.out.println(node.data);
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	public void printInorder() {
		printInorder(root);
	}
	private void printInorder(Node node) {
		if (node == null) return;
		printInorder(node.left);
		System.out.println(node.data);
		printInorder(node.right);
	}
	
	public void printPostorder() {
		printPostorder(root);
	}
	private void printPostorder(Node node) {
		if (node ==  null) return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.println(node.data);
	}

	public boolean search(T data) {
		return search(root, data);
	}
	private boolean search(Node node, T data) {
		if (node == null)
			return false;
		int cmp = data.compareTo(node.data);
		if (cmp < 0)
			return search(node.left, data);
		else if (cmp > 0)
			return search(node.right, data);
		else
			return true;
	}
}
