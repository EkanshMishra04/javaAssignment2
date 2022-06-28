package com.nagarro.java.assignment2.datastructuretype;

import java.util.ArrayList;

public class Heap {

	private ArrayList<Integer> array;
	
	public Heap() {
		this.array = new ArrayList<>();
	}
	public ArrayList<Integer> getArray(){
		return this.array;
	}
//----------------------------Internal Method to Perform Heapify Action-----------------------------------------------------------//
	private void heapify(int i) {
		ArrayList<Integer> hT = this.array;
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

			this.heapify(largest);
		}
	}
//-------------------------------------------------------------------------//
	public int center() {
		int mid = this.array.size();
		mid=mid/2;
		return this.array.get(mid);
	}

//----------------------Reverse action ----------------------------//

	public void reverse() {
		ArrayList<Integer> newArr = new ArrayList<>();
		for(int i=this.array.size()-1;i>=0;i--)
		{
			newArr.add(this.array.get(i));
		}

		for (Integer i : newArr) {
			System.out.print(i + " ");
		}
		this.array=newArr;
		System.out.println();	
	}
//---------------------Function to insert an element into the tree---------------------------------------//
	public void insert(int newNum) {
		ArrayList<Integer> hT = this.array;
		int size = hT.size();
		if (size == 0) {
			hT.add(newNum);
		} else {
			hT.add(newNum);
			for (int i = size / 2 - 1; i >= 0; i--) {
				this.heapify(i);
			}
		}
	}
//-------------------------------------------------------------------------------------------//
		public int len() {
			return this.array.size();
		}
//---------------------get top priority element from the heap and return--------------------------------//
	public int getTop() {
		return this.array.get(0);

	}

//---------------------Function to delete an element from the tree--------------------------------------//
	public void deleteNode() {
		ArrayList<Integer> hT = this.array;
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
			this.heapify(j);
		}
	}

//--------------------------------Print the tree-----------------------------------------------------//
	public void printArray() {
		for (Integer i : this.array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
//------------------------------Contains??-----------------------------------------------------------//
	public boolean contains(int input)
	{
		for(Integer item : this.array)
		{
			if(item==input)
				return true;
		}
		return false;
}
}