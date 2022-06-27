package com.nagarro.java.assignment2.datastructuretype;

public class Iterator {
	private int size = 0;
	private int pos = 0;
	private Node curr;


	public Iterator(List llHead) {
		this.size = llHead.size();
		this.curr = llHead.getHead();
	}

	public boolean hasNext() {
		return (++pos <= this.size);

	}

	public Node next() {
		Node retNode = new Node(this.curr.data);
		this.curr = this.curr.next;
		return retNode;
	}

}