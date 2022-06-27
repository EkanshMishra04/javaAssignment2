package com.nagarro.java.assignment2.implementation;

import java.util.ArrayList;

import com.nagarro.java.assignment2.datastructuretype.HashNode;
import com.nagarro.java.assignment2.datastructuretype.List;
import com.nagarro.java.assignment2.datastructuretype.Node;

class HtIterator {
	private int size = 0;
	private int pos = 0;
	private Integer total;
//	private HashNode[] HashArr;
//	private ArrayList<HashNode>arr ;
	
	public HtIterator(HashTable ht) {
		this.size = ht.size();
		System.out.println(ht.arr.);
	}
	
//	private void addElements() {
//		for(int i=0;i<this.size;i++)
//		{
//			HashNode temp = HashArr.;
//			while(temp!=null)
//			{
//				arr.add(temp);
//				temp=temp.next;
//			}
//		}
//		for(HashNode item: arr) {
//			System.out.println(item.key+" "+item.value);
//		}
	}
	
//	public boolean hasNext() {
//		return (++pos <= this.total);
//
//	}
//
//	public Node next() {
//		
//		return retNode;
	


//--------------------------//
public class HashTable {
	private Integer size;
	public HashNode[] arr;

//------------//
	public HashTable(int inputSize) {
		this.size = inputSize;
		arr = new HashNode[size];
	}
	
//	public HashNode[] getArr() {
//		return this.arr;
//	}
//----------------------------------------------------------------------------------------------------//
	private int hash(String key) {
		int hashCode = key.length() % size;
		return hashCode;
	}
//----------------------------------------------------------------------------------------------------//
//	public HashNode[]  getArr() {
//		return this.arr;
//		}
//----------------------------------------------------------------------------------------------------//
	public boolean insert(String key, String value) {
		if(key==null){
		System.err.println("Key cannot be null.. Exiting!");
		System.exit(1);
		}
		int hashCode = this.hash(key);
		HashNode node = new HashNode(key, value);
		// first input
		if (this.arr[hashCode] == null) {
			this.arr[hashCode] = node;
			return true;
		}
		// multiple input
		else {
			HashNode curr = this.arr[hashCode];
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = node;
		}
		return true;
	}

//------------------------------------------------------------------------------------//
	public boolean delete(String k) {
		if (this.contains(k)) {
			int hashCode = this.hash(k);
			HashNode curr = this.arr[hashCode];
			if (curr.key == k) {
				this.arr[hashCode] = curr.next;
				return true;
			} else {
				while (curr.next.key != k) {
					curr = curr.next;
				}
				curr.next = curr.next.next;
				return true;
			}
		} else
			return true;
	}

//-------------------------------------------------------------------------------------//
	public boolean contains(String k) {
		int hashCode = this.hash(k);
		HashNode curr = this.arr[hashCode];
		if (curr == null)
			return false;
		else if (curr.key == k)
			return true;
		else {
			while (curr != null) {
				if (curr.key == k)
					return true;
				curr = curr.next;
			}
			return false;
		}
	}

//--------------------------------------------------------------------------------------//
	public String getValueByKey(String k) {
		if (this.contains(k)) {
			int hashCode = this.hash(k);
			HashNode temp = this.arr[hashCode];
			while (temp.key != k) {
				temp = temp.next;
			}
			return temp.value;
		} else {
			String msg = "No such key found!";
			return msg;
		}
	}
//-----------------------------------------------------------------------------------------//
	public Integer size() {
		return this.size;
	}
//------------------------------------------------------------------------------------------//
//	Iterator
//------------------------------------------------------------------------------------------//
	public void traverse() {
		HashNode ptr;
		System.out.println("Printing content of the hash table");
		for (int i = 0; i < this.size; i++) {
			ptr = this.arr[i];
			while (ptr != null) {
				System.out.println("key is " + ptr.key + " and Value is " + ptr.value);
				ptr = ptr.next;
			}

		}
	}
	
	public static void main(String[] args) {
		HashTable ht = new HashTable(5);
		ht.insert("abc","123");
		ht.insert("def","456");
		ht.insert("ghi","789");
		ht.insert("jhl","123");
//		ht.insert(null,"3245");
//		ht.traverse();
//		System.out.println(ht.contains("ghi"));
//		System.out.println(ht.contains("xyz"));
//		System.out.println(ht.getValueByKey("ghi"));
//		System.out.println(ht.getValueByKey("xyz"));
//		ht.delete("ghi");
//		ht.traverse();
//		ht.delete("xyz");
//		ht.traverse();
		System.out.println(ht.size());
		HtIterator itr = new HtIterator(ht);
//		itr.
		
	}
	
}
