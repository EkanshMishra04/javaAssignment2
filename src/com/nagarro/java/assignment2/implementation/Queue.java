package com.nagarro.java.assignment2.implementation;

import com.nagarro.java.assignment2.datastructuretype.Node;

public class Queue<T> {

	private Node<T> front=null;
	private Node<T> rear=null;
	private Integer size=0;

	public boolean enqueue(T data) {
		Node<T> node = new Node<>(data);
		if (this.front == null) {
			this.front = this.rear = node;
		} else {
			this.rear.next = node;
			this.rear=node;
		}
		this.size += 1;
		return true;
	}

	public boolean dequeue() {
		if (this.front == null)
			return false;
		this.front = this.front.next;
		this.size -= 1;
		return true;
	}

	public Node<T> peek() {
		if (this.front == null)
			return null;
		return this.front;
	}

	public boolean contains(T key) {
		if (this.front == null)
			return false;
		Node<T> curr = this.front;
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
	public Integer size() {
		return this.size;
	}
	
	
	public Node<T> center(){	
		if (this.front == null)
			return null;
		Node<T> curr = this.front;
		int len =0;
		while (curr != null) {
			if (len==this.size/2) {
			break;
			}
			len+=1;
		curr = curr.next;
	}
		return curr;
}
//---------------------------------------------------------------------------------//
	//public Node<T> sort()//
//---------------------------------------------------------------------------------//
	public Node<T> reverse(){
		if (this.size() == 0 || this.size() == 1)
			return this.front;
		this.rear=this.front;
		Node<T> curr = this.front;
		Node<T> prev = null;
		Node<T> frwd;
		while (curr != null) {
			frwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = frwd;
		}
		this.front = prev;
		return this.front;
	}
//Iterator
	public void Traverse() {
		if(this.front==null)
			return;
		Node<T> curr = this.front;
		while(curr!=null) {
			System.out.println(curr.data);
			curr=curr.next;
		}
	}
	public static void main(String[] args) {
		Queue<String> q = new Queue<>();
		q.enqueue("ABC");
		q.enqueue("DEF");
		q.enqueue("GHI");
		q.enqueue("JKL");
		q.enqueue("MNO");
		q.enqueue("PQR");
		q.Traverse();
		System.out.println("hahaha");
		q.dequeue();
		q.Traverse();
		System.out.println("queue has size of "+q.size());
		System.out.println("hahaha");
		System.out.println("center is "+q.center().data);
		System.out.println("hahaha");
		System.out.println(q.contains("MNO"));
		System.out.println("hahaha");
		System.out.println(q.peek().data);
		
		

	}

}
