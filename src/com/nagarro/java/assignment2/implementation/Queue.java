package com.nagarro.java.assignment2.implementation;

import com.nagarro.java.assignment2.datastructuretype.Iterator;
import com.nagarro.java.assignment2.datastructuretype.List;
import com.nagarro.java.assignment2.datastructuretype.MergeSort;
import com.nagarro.java.assignment2.datastructuretype.Node;

public class Queue implements List{

	private Node front = null;
	private Node rear = null;
	private Integer size = 0;

//------------------------------------------------//
	public boolean enqueue(Integer data) {
		Node node = new Node(data);
		if (this.front == null) {
			this.front = this.rear = node;
		} else {
			this.rear.next = node;
			this.rear = node;
		}
		this.size += 1;
		return true;
	}
//------------------------------------------------//
	public boolean dequeue() {
		if (this.front == null)
			return false;
		this.front = this.front.next;
		this.size -= 1;
		return true;
	}
//------------------------------------------------//
	@Override
	public Node getHead() {
		return this.front;
	}
//------------------------------------------------//
	public Node peek() {
		if (this.front == null)
			return null;
		return this.front;
	}

//------------------------------------------------//
	public boolean contains(Integer key) {
		if (this.front == null)
			return false;
		Node curr = this.front;
		boolean flag = false;
		while (curr != null) {
			if (curr.data == key) {
				flag = true;
				break;
			}
			curr = curr.next;
		}
		return flag;
	}

//------------------------------------------------//
	public Integer size() {
		return this.size;
	}

//------------------------------------------------//
	public Node center() {
		if (this.front == null)
			return null;
		Node curr = this.front;
		int len = 0;
		while (curr != null) {
			if (len == this.size / 2) {
				break;
			}
			len += 1;
			curr = curr.next;
		}
		return curr;
	}

//---------------------------------------------------------------------------------//
	public Node sort() {
		this.front = MergeSort.mergeSort(this.front);
		this.rear = this.front;
		while (this.rear.next != null) {
			this.rear = this.rear.next;
		}
		System.out.println("LinkedList has been sorted.\n");
		this.traverse();
		return this.front;
	}

//---------------------------------------------------------------------------------//
	public Node reverse() {
		if (this.size() == 0 || this.size() == 1)
			return this.front;
		this.rear = this.front;
		Node curr = this.front;
		Node prev = null;
		Node frwd;
		while (curr != null) {
			frwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = frwd;
		}
		this.front = prev;
		return this.front;
	}
//------------------------------------------------------------------------------------//
	public void traverse() {
		if (this.front == null)
			return;
		String str ="";
		Node curr = this.front;
		while (curr != null) {
			str = str+curr.data+"-->";
			curr = curr.next;
		}
		System.out.println("Queue Traversal is "+str+"X");
	}
//------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.traverse();

		q.dequeue();
		q.traverse();
		System.out.println("queue has size of " + q.size());
		System.out.println("center is " + q.center().data);
		System.out.println("Query for contain is "+q.contains(5));
		
		System.out.println("Peeked data is "+q.peek().data);

		System.out.println("Iterator Now Accessing Data");
		Iterator itr = new Iterator(q);
		while(itr.hasNext())
			System.out.println("data is - "+itr.next().data);

	}


}
