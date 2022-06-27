package com.nagarro.java.assignment2.implementation;

import com.nagarro.java.assignment2.datastructuretype.List;
import com.nagarro.java.assignment2.datastructuretype.MergeSort;
import com.nagarro.java.assignment2.datastructuretype.Node;
import com.nagarro.java.assignment2.datastructuretype.Iterator;

//------------------------------------------------------------------------------//
public class LinkedList implements List {

	private Node tail = null;
	private Node head = null;
	private Integer size = 0;

	@Override
	public Node getHead() {
		return this.head;
	}

//----------------------------------------------------------------------------------------//
	private boolean insertAtFirst(Integer data) {
		Node node = new Node(data);
		node.next = head;
		this.tail = node;
		this.head = node;

		return true;
	}

//----------------------------------------------------------------------------------------//
	public void insert(Integer data) {
		boolean flag = false;
		if (head == null) {
			this.insertAtFirst(data);
			this.size += 1;
			flag = true;
		} else if (this.tail == null) {
			System.err.println("some how tail pointer has not been incremented!");
			flag = false;
		} else {
			Node node = new Node(data);
			this.tail.next = node;
			this.tail = node;
			this.size += 1;
			flag = true;
		}
		if (flag)
			System.out.println("Properly Insertion Done!");
		else
			System.exit(1);
	}

//---------------------------------------------------------------------------------------//
	public boolean insertAtPosition(Integer data, int pos) {
		boolean flag;
		if (this.head == null || pos < 1) {
			System.err.println("Dear User Position Starts From 1!");
			flag = false;
		}
		if (this.size() < pos) {
			flag = false;
			return flag;
		}
		if (this.size() == pos) {
			this.insert(data);
		}

		if (pos == 0) {
			Node node = new Node(data);
			node.next = this.head;
			this.head = node;
			flag = true;
		}

		Node curr = this.head;
		while (pos > 0) {
			curr = curr.next;
			pos--;
		}

		Node node = new Node(data);
		this.tail.next = node;
		this.tail = node;
		flag = true;
		return flag;
	}

//-------------------------------------------------------------------------------------//
	@Override
	public Node center() {
		if (this.size() == 0 || this.size() == 1 || this.size() == 2)
			return this.head;

		Node slow = this.head;
		Node fast = this.head.next;

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
		Node curr = this.head;
		while (curr != null) {
			curr = curr.next;
			len++;
		}
		return len;

	}

//------------------------------------------------------------------------------------//
	@Override
	public void traverse() {
		System.out.println("\nPrinting the linked list contents - ");
		String str = "";
		Node curr = this.head;
		while (curr != null) {
			str = str + curr.data + "-->";
			curr = curr.next;
		}
		System.out.println(str + "X\n");
	}

//-------------------------------------------------------------------------------------//
	public boolean delete(Integer key) {
		int size = this.size();
		if (size == 0) {
			return false;
		}
		Node curr = this.head;
		Node prev = this.head;
		while (curr != null) {
			if (curr.data == key) {
				prev.next = curr.next;
				break;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return (curr == null || curr.data == key);
	}

//-------------------------------------------------------------------------------------//
	public boolean deleteAtPosition(int pos) {

		if (this.size() == 0 || this.size() < pos || pos < 1) {
			System.err.println("\n!!Some Error while Deletion as Linkedlist is empty or position is less than 1!!\n");
			return false;
		}
		boolean flag = false;
		Node curr = this.head;
		Node prev = this.head;
		int dist = 1;
		while (curr != null) {
			if (dist == pos) {
				prev.next = curr.next;
				flag = true;
				System.out.println("Deletion done as position " + pos + "\n");
				break;
			}
			dist++;
			prev = curr;
			curr = curr.next;

		}

		return flag;
	}

//------------------------------------------------------------------------------------//
	@Override
	public Node sort() {
		this.head = MergeSort.mergeSort(this.head);
		System.out.println("LinkedList has been sorted.\n");
		this.traverse();
		return this.head;
	}

//----------------ITERATOR------------------------------------------------------------//
//------------------------------------------------------------------------------------//
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
		System.out.println("Linked list has been reversed.\n");
		this.traverse();
		return this.head;
	}

//-------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
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
		ll.reverse();
		System.out.println("Printing via Iterator!");
		Iterator itr = new Iterator(ll);
		while (itr.hasNext()) {
			System.out.println(itr.next().data);
		}
		System.out.println("size of linkedlist is " + ll.size());
		System.out.println("center element is " + ll.center().data);
		ll.deleteAtPosition(0);
//		ll.traverse();
//		System.out.println();
		ll.head = ll.reverse();
//		System.out.println();
//		ll.traverse();
//		System.out.println();
		ll.sort();
//		ll.traverse();
	}
}
