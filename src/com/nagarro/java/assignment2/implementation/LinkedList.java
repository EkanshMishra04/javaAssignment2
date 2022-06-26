package com.nagarro.java.assignment2.implementation;

import com.nagarro.java.assignment2.datastructuretype.List;
import com.nagarro.java.assignment2.datastructuretype.Node;

public class LinkedList<T> implements List {

	private Node<T> tail = null;
	private Node<T> head = null;

//----------------------------------------------------------------------------------------//
	private boolean insertAtFirst(T data) {
		Node<T> node = new Node<>(data);
		node.next = head;
		this.tail = node;
		this.head = node;
		return true;
	}

//----------------------------------------------------------------------------------------//
	public boolean insert(T data) {
		if (head == null) {
			this.insertAtFirst(data);
			return true;
		} else if (this.tail == null)
			return false;
		Node<T> node = new Node<>(data);
		this.tail.next = node;
		this.tail = node;
		return true;
	}

//---------------------------------------------------------------------------------------//
	public boolean insertAtPosition(T data, int pos) {
		if (this.head == null || pos < 0)
			return false;

		if (this.size() < pos)
			return false;

		if (this.size() == pos) {
			return insert(data);
		}

		if (pos == 0) {
			Node<T> node = new Node<>(data);
			node.next = this.head;
			this.head = node;
			return true;
		}

		Node<T> curr = this.head;
		while (pos > 0) {
			curr = curr.next;
			pos--;
		}

		Node<T> node = new Node<>(data);
		this.tail.next = node;
		this.tail = node;
		return true;
	}

//-------------------------------------------------------------------------------------//
	@Override
	public Node<T> center() {
		if (this.size() == 0 || this.size() == 1 || this.size() == 2)
			return this.head;

		Node<T> slow = this.head;
		Node<T> fast = this.head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

//-------------------------------------------------------------------------------------//
	@Override
	public Integer size() {
		int len = 0;
		Node<T> curr = this.head;
		while (curr != null) {
			curr = curr.next;
			len++;
		}
		return len;

	}

//------------------------------------------------------------------------------------//
	@Override
	public void traverse() {
		Node<T> curr = this.head;
		while (curr != null) {
			System.out.println(curr.data);
			curr = curr.next;
		}
	}

//-------------------------------------------------------------------------------------//
	public boolean delete(T key) {
		int size = this.size();
		if (size == 0) {
			return false;
		}
		Node<T> curr = this.head;
		Node<T> prev = this.head;
		while (curr != null) {
			if (curr.data == key) {
				prev.next = curr.next;
				break;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		if (curr == null || curr == key) {
			return true;
		}
		return false;
	}

//-------------------------------------------------------------------------------------//
	public boolean deleteAtPosition(int pos) {

		if (this.size() == 0 || this.size() < pos) {
			return false;
		}
		boolean flag = false;
		Node<T> curr = this.head;
		Node<T> prev = this.head;
		int dist = 1;
		while (curr != null) {
			if (dist == pos) {
				prev.next = curr.next;
				flag = true;
				break;
			}
			dist++;
			prev = curr;
			curr = curr.next;
		}
		return flag;
	}

//-----------------SORT---------------------------------------------------------------//
//----------------ITERATOR------------------------------------------------------------//
//------------------------------------------------------------------------------------//
	@Override
	public Node<T> reverse() {
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

//-------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.insert(12);
		ll.insert(14);
		ll.insert(16);
		ll.insert(18);
		ll.insert(20);
		ll.insert(22);
		ll.insert(24);
		ll.insert(26);
		ll.insert(28);
		ll.insert(30);
		ll.traverse();
		System.out.println("size of linkedlist is " + ll.size());
		System.out.println("center element is " + ll.center().data);
		System.out.println(ll.deleteAtPosition(8));
		ll.traverse();
		ll.head = ll.reverse();
		ll.traverse();

	}

	@Override
	public Node<T> iterator() {
		return null;


	}

	@Override
	public Node<T> sort() {
		return null;
	}

}
