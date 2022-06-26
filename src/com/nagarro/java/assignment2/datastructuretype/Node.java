package com.nagarro.java.assignment2.datastructuretype;

public final class Node<E> extends Object {
	public E data;
	public Node<E> next;

	public Node(E value) {
		this.data = value;
		this.next = null;
	}
}
