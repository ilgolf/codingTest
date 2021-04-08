package ds_test;

import java.util.*;

class Node {
	int key;
	Node left = null;
	Node right = null;
}

class Tree {
	Node root;
	
	void insert(int key) {
		if(root == null) {
			Node node = new Node();
			node.key = key;
			root = node;
			return;
		}
		
		if(checkKey(key)) {
			System.out.println("Áßº¹Å° : " + key);
			return;
		}
		Node cur = root;
		Node node = new Node();
		node.key = key;
		while(true) {
			
			if(cur.key < key) {
				
				if(cur.right == null) {
					cur.right = node;
					System.out.println(key);
					break;
				}
				cur = cur.right;
			}
			if(cur.key > key) {
				if(cur.left == null) {
					cur.left = node;
					break;
				}
				cur = cur.left;
			}
		}
	}
	
	boolean checkKey(int key) {
		Node cur = root;
		while(true) {
			if(cur.key == key) {
				return true;
			}
			if(cur.key < key ) {
				if(cur.left == null) {
					return false;
				}
				cur = cur.left;
			}
			
			if(cur.key < key) {
				if(cur.right == null) {
					return false;
				}
				cur = cur.right;
			}
		}
	}
	
	void print() {
		Stack<Node> stack = new Stack<>();
	}
}

public class Test01 {
	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(10);
		tree.insert(10);
		tree.insert(11);
		tree.insert(12);
		tree.insert(13);
	}
}
