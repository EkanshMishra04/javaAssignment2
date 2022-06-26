package com.nagarro.java.assignment2.implementation;

import com.nagarro.java.assignment2.datastructuretype.List;
import com.nagarro.java.assignment2.datastructuretype.Node;

public class Stack<T> implements List {

	private Node<T> head = null;
	private Integer size = 0;

//-------------------------public methods--------------------------------------------------//
	public boolean push(T data) {
		Node<T> node = new Node<>(data);
		if (this.head == null) {
			this.head = node;
			this.head.next = null;
			this.size += 1;
		} else {
			node.next = this.head;
			this.head = node;
			this.size += 1;
		}
		return true;
	}

	public Node<T> pop() {
		if (this.size <= 0) {
			System.err.println("Stack is Empty!");
			return null;
		}
		Node<T> node = head;
		head = head.next;
		this.size = this.size - 1;
		return node;
	}

	public Node<T> peek() {
//		if()
		return this.head;
	}

	public boolean contains(T key) {
		if (this.size <= 0)
			return false;
		boolean flag = false;
		Node<T> curr = this.head;
		while (curr != null) {
			if (curr.data == key) {
				flag = true;
				break;
			}
			curr = curr.next;
		}
		return flag;
	}

	@Override
	public void traverse() {
		if (this.size == 0)
			return;
		Node<T> curr = head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

	@Override
	public Node<T> center() {
		if (this.size <= 0)
			return null;
		Integer half = Math.floorDiv(size, 2);
		Node<T> curr = head;
		int count = 1;
		while (curr != null && count != half) {
			curr = curr.next;
			count += 1;
		}
//		System.out.println("Center element is "+curr.data);
		return curr;
	}

	@Override
	public Integer size() {
		return this.size;
	}

	@Override
	public Object sort() {
		return null;
	}

	@Override
	public Object reverse() {
		if (this.size() == 0 || this.size() == 1)
			return this.head;

		Node<T> curr = this.head;
		Node<T> prev = null;
		Node<T> frwd;
		while (curr != null) {
			frwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = frwd;
		}
		this.head = prev;
		return this.head;
	}

	@Override
	public Object iterator() {
		return null;
	}

	public static void main(String[] args) {
		Stack<Integer> stk = new Stack<>();
//		System.out.println("head is "+stk.head);
		stk.push(80);
		stk.push(82);
		stk.push(84);
		stk.push(86);
		stk.push(88);
		stk.push(90);
		stk.push(92);
		stk.push(94);
		stk.push(96);
		stk.push(98);
		stk.push(100);
		stk.push(102);
		System.out.println("Stack has a size of " + stk.size());
		System.out.println("Stack has a center of " + stk.center().data);
		System.out.println("Stack has elements of ");
		stk.traverse();
//		System.out.println("popped element is " + stk.pop().data);
		System.out.println("peeked element is "+stk.peek().data);
//stk.pop();
//stk.pop();
//stk.pop();
//stk.pop();
//stk.traverse();
		stk.reverse();
		stk.traverse();
	}
}
