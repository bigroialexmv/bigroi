package com.bigroi.classwork.lesson07;

class Tree {	
	Node root;
	public void put(int key, String value) {
		Node newNode =  new Node(key, value);
		if (root == null) {
			root = newNode;
		} else {
			put(root, newNode);
		}
	}
	
	void put(Node node, Node newNode) {
		if (node.key < newNode.key) {
			if (node.right == null) {
				node.right = newNode;
			} else {
				put(node.right, newNode);
			}
		} else {
			if (node.left == null) {
				node.left = newNode;
			} else {
				put(node.left, newNode);
			}
		}
	}
}

class Node {
	int key;	
	String value;	
	Node left;
	Node right;
	public Node(int key, String value) {	
		this.key = key;
		this.value = value;
	}
}

public class TreeSampleApp {

	public static void main(String[] args) {		
		Tree tree = new Tree();
		tree.put(17, "val17");
		tree.put(20, "val20");
		tree.put(8, "val8");
		tree.put(5, "val5");
		tree.put(9, "val9");
		tree.put(19, "val19");
		tree.put(25, "val10");
	}

}
