package com.nagarro.java.assignment2.datastructuretype;

import java.util.ArrayList;

public class Heap {

	public ArrayList<Integer> array;
	int size;

	public Heap() {
		this.array = new ArrayList<Integer>();
		this.size = array.size();
	}

//---------------------------------------------------------------------------------------------------------//
	private void heapify(ArrayList<Integer> hT, int i) {
		int size = hT.size();
		// Find the largest among root, left child and right child
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (l < size && hT.get(l) > hT.get(largest))
			largest = l;
		if (r < size && hT.get(r) > hT.get(largest))
			largest = r;

		// Swap and continue heapifying if root is not largest
		if (largest != i) {
			int temp = hT.get(largest);
			hT.set(largest, hT.get(i));
			hT.set(i, temp);

			this.heapify(hT, largest);
		}
	}

//---------------------Function to insert an element into the tree---------------------------------------//
	void insert(ArrayList<Integer> hT, int newNum) {
		int size = hT.size();
		if (size == 0) {
			hT.add(newNum);
		} else {
			hT.add(newNum);
			for (int i = size / 2 - 1; i >= 0; i--) {
				this.heapify(hT, i);
			}
		}
	}

//---------------------get top priority element from the heap and return--------------------------------//
	private int getTop() {
		return this.array.get(0);

	}

//---------------------Function to delete an element from the tree--------------------------------------//
	void deleteNode() {
		ArrayList<Integer> hT=this.array;
		int num = this.getTop();
		int size = hT.size();
		int i;
		for (i = 0; i < size; i++) {
			if (num == hT.get(i))
				break;
		}

		int temp = hT.get(i);
		hT.set(i, hT.get(size - 1));
		hT.set(size - 1, temp);

		hT.remove(size - 1);
		for (int j = size / 2 - 1; j >= 0; j--) {
			this.heapify(hT, j);
		}
	}

//--------------------------------Print the tree-----------------------------------------------------//
	void printArray() {
		for (Integer i : this.array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

//--------------------------------- Driver code------------------------------------------------------//
	public static void main(String args[]) {

		Heap h = new Heap();
		h.insert(h.array, 3);
		h.insert(h.array, 4);
		h.insert(h.array, 9);
		h.insert(h.array, 5);
		h.insert(h.array, 2);

	    System.out.println("Max-Heap array: ");
	    h.printArray();
//
	    h.deleteNode();
	    h.deleteNode();
	    System.out.println("After deleting an element: ");
	    h.printArray();
	}
}