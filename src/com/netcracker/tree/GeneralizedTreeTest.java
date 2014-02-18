package com.netcracker.tree;

import java.util.LinkedList;
import java.util.Queue;

class GeneralizedBinaryTree<T extends Number> {
	public Node root;
	private Double summa=new Double(0);

	class Node {
		Node left;
		Node right;
		T value;

		Node(T value) {
			this.value = value;
		}

		public void showNode() {
			System.out.println(this.value);
		}
	}

	public void add(T value) {
		Node x = root, y = null;
		while (x != null) {
			if (x.value.doubleValue() == value.doubleValue()) {
				return;
			} else {
				y = x;
				if (x.value.doubleValue() > value.doubleValue()) {
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
			if (y.value.doubleValue() > value.doubleValue()) {
				y.left = newNode;
			} else {
				y.right = newNode;
			}
		}
	}

	public Double getSumma() {
		return traverseAndPlus(root);
	}

	private Double traverseAndPlus(Node node) {
		summa=new Double(summa.doubleValue()+node.value.doubleValue());
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

public class GeneralizedTreeTest {
	public static void main(String args[]) {
		GeneralizedBinaryTree <Double> tree = new GeneralizedBinaryTree<Double>();
		tree.add(5.9);
		tree.add(3.1);
		tree.add(2.0);
		tree.add(4.0);
		tree.add(7.6);
		tree.add(6.5);
		tree.add(13.0);
		tree.traverseLevelOrder();
		System.out.println("Summa: " + tree.getSumma());
	}
}