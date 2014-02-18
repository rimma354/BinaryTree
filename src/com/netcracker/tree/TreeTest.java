package com.netcracker.tree;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
	public Node root;
	private int summa;

	class Node {
		Node left;
		Node right;
		Integer value;

		Node(Integer value) {
			this.value = value;
		}

		public void showNode() {
			System.out.println(this.value);
		}
	}

	public void add(Integer value) {
		Node x = root, y = null;
		while (x != null) {
			int cmp = value.compareTo(x.value);
			if (cmp == 0) {
				return;
			} else {
				y = x;
				if (cmp < 0) {
					x = x.left;
				} else {
					x = x.right;
				}
			}
		}
		Node newNode = new Node(value);
		if (y == null) {
			root = newNode;
		} else {
			if (value.compareTo(y.value) < 0) {
				y.left = newNode;
			} else {
				y.right = newNode;
			}
		}
	}

	public int getSumma() {
		return traverseAndPlus(root);
	}

	private int traverseAndPlus(Node node) {
		summa += node.value;
		if (node.left != null)
			traverseAndPlus(node.left);
		if (node.right != null)
			traverseAndPlus(node.right);
		return summa;
	}

	public void traverseLevelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		Node top = root;
		queue.add(top);
		while (!queue.isEmpty()) {
			top = queue.poll();
			top.showNode();
			if (top.left != null)
				queue.add(top.left);
			if (top.right != null)
				queue.add(top.right);
		}
	}
}

public class TreeTest {
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.add(5);
		tree.add(3);
		tree.add(2);
		tree.add(4);
		tree.add(7);
		tree.add(6);
		tree.add(13);
		tree.traverseLevelOrder();
		System.out.println("Summa: " + tree.getSumma());
	}
}