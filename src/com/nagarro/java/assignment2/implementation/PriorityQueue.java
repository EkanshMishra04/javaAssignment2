package com.nagarro.java.assignment2.implementation;

import java.util.ArrayList;
import com.nagarro.java.assignment2.datastructuretype.Heap;

//-----------------------------------------------------------------------------------//
class PqIterator {

	private int size = 0;
	private int pos = -1;
	private ArrayList<Integer> arr;

	public PqIterator(PriorityQueue pq) {
		this.size = pq.h.len();
		this.arr = pq.h.getArray();
	}

	public boolean hasNext() {
		return (++pos < this.size);
	}
	public int next() {
		return this.arr.get(pos);
	}
}

//-----------------------------------------------------------------------------------//
public class PriorityQueue {

	public Heap h;

	public PriorityQueue() {
		this.h = new Heap();
	}

//------------------------------------------------------------------------------------//
	public boolean enqueue(int input) {
		this.h.insert(input);
		return true;
	}

//------------------------------------------------------------------------------------//
	public boolean dequeue() {
		this.h.deleteNode();
		return true;
	}

//-----------------------------------------------------------------------------------//
	public int peek() {
		return this.h.getTop();
	}

//------------------------------------------------------------------------------------//
	public void contains(int input) {
		if (this.h.contains(input))
			System.out.println("Yes the Priority Queue has the input " + input);
		else
			System.out.println("No the Priority Queue doesnot have the input " + input);
	}

//-------------------------------------------------------------------------------------//
	public void traverse() {
		this.h.printArray();
	}

//--------------------------------------------------------------------------------------//
	public void reverse() {
		this.h.reverse();
	}

//---------------------------------------------------------------------------------------//
	public void center() {
		System.out.println("The center element is " + this.h.center());
	}
//--------------------------------------------------------------------------------------//
	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();
		pq.enqueue(100);
		pq.enqueue(16);
		pq.enqueue(25);
		pq.enqueue(11);
		pq.enqueue(121);
		pq.enqueue(181);
		pq.enqueue(49);
		pq.enqueue(64);
		pq.traverse();
		System.out.print(pq.peek() + "\n");
//		pq.contains(26);
//		pq.reverse();
		System.out.println(pq.peek());
		System.out.println("Pq delteleed");
//		pq.dequeue();
//		pq.traverse();
//		pq.dequeue();
//		pq.traverse();
//		pq.dequeue();
//		pq.traverse();
//		pq.dequeue();
		pq.traverse();
		pq.center();
		System.out.println("Now using Iterator-->>");
		PqIterator itr = new PqIterator(pq);
		while(itr.hasNext())
			System.out.println(itr.next());
	}
}
