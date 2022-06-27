package com.nagarro.java.assignment2.implementation;

import com.nagarro.java.assignment2.datastructuretype.Iterator;
import com.nagarro.java.assignment2.datastructuretype.List;
import com.nagarro.java.assignment2.datastructuretype.MergeSort;
import com.nagarro.java.assignment2.datastructuretype.Node;

public class Stack implements List {

	private Node head = null;
	private Integer size = 0;

	@Override
	public Node getHead() {
		return this.head;
	}

//-------------------------public methods--------------------------------------------------//
	public boolean push(Integer data) {
		Node node = new Node(data);
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

//-----------------------------------------------------------------------------------------//
	public Node pop() {
		if (this.size <= 0) {
			System.err.println("Stack is Empty!");
			return null;
		}
		Node node = head;
		head = head.next;
		this.size = this.size - 1;
		return node;
	}

//-------------------------------------------------------------------------------------------//
	public Node peek() {
		return this.head;
	}

//------------------------------------------------------------------------------------------//
	public boolean contains(Integer key) {
		if (this.size <= 0)
			return false;
		boolean flag = false;
		Node curr = this.head;
		while (curr != null) {
			if (curr.data == key) {
				flag = true;
				break;
			}
			curr = curr.next;
		}
		return flag;
	}

//-------------------------------------------------------------------------------------------//
	@Override
	public void traverse() {
		if (this.size == 0)
			return;
		System.out.println("printing stack content");
		Node curr = head;
		String str="";
		while (curr != null) {
			str = str+curr.data+"-->";
			curr = curr.next;
		}
		System.out.println(str+"X\n");
	}

//-------------------------------------------------------------------------------------------//
	@Override
	public Node center() {
		if (this.size <= 0)
			return null;
		Integer half = Math.floorDiv(size, 2);
		Node curr = head;
		int count = 1;
		while (curr != null && count != half) {
			curr = curr.next;
			count += 1;
		}
//		System.out.println("Center element is "+curr.data);
		return curr;
	}

//---------------------------------------------------------------------------------------------//
	@Override
	public Integer size() {
		return this.size;
	}
//--------------------------------------------------------------------------------------------//

	@Override
	public Node reverse() {
		if (this.size() == 0 || this.size() == 1)
			return this.head;

		Node curr = this.head;
		Node prev = null;
		Node frwd;
		while (curr != null) {
			frwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = frwd;
		}
		this.head = prev;
		return this.head;
	}

//------------------------------------------------------------------------------------------------//
	@Override
	public Node sort() {
		this.head = MergeSort.mergeSort(head);
		return this.head;
	}

//---------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		Stack stk = new Stack();
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
		System.out.println("Stack has a size of " + stk.size()+"\n");
		System.out.println("Printing elemets via Iterator class");
		Iterator itr = new Iterator(stk);
		while (itr.hasNext())
			System.out.println(itr.next().data);
		
		System.out.println("\nStack has a center with element value " + stk.center().data+"\n");

		stk.traverse();
		System.out.println("popped element is " + stk.pop().data+"\n");
		System.out.println("peeked element is " + stk.peek().data+"\n");
		stk.sort();
		stk.traverse();
		
		stk.reverse();
		stk.traverse();

		
	}

}
