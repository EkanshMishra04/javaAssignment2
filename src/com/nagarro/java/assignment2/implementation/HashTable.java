package com.nagarro.java.assignment2.implementation;

import java.util.ArrayList;

import com.nagarro.java.assignment2.datastructuretype.HashNode;


class HtIterator {
	private int size = 0;
	private int pos = -1;
	private ArrayList<HashNode>HashArr ;
	
	public HtIterator(HashTable ht) {
		this.HashArr = ht.getHashArr();
		this.size = this.HashArr.size();
	}
	
	public boolean hasNext() {
		return (++pos < this.size);
	}

	public HashNode next() {
		return this.HashArr.get(pos);
	}
}


//--------------------------//
public class HashTable {
	private Integer size=1024;
	private ArrayList<HashNode> HashArr = new ArrayList<>();
	private HashNode[] arr;

//------------//
	public HashTable() {
		arr = new HashNode[size];
	}

//----------------------------------------------------------------------------------------------------//
	private int hash(String key) {
		return key.length() % size;
	}

//----------------------------------------------------------------------------------------------------//
	public ArrayList<HashNode>  getHashArr() {
		return this.HashArr;
		}
//----------------------------------------------------------------------------------------------------//
	public boolean insert(String key, String value) {
		if (key == null) {
			System.err.println("Key cannot be null.. Exiting!");
			System.exit(1);
		}
		
		int hashCode = this.hash(key);
		HashNode node = new HashNode(key, value);
		
		// first input
		if (this.arr[hashCode] == null) {
			this.arr[hashCode] = node;
			this.HashArr.add(node);
			return true;
		}
		// multiple input
		else {
			if(this.contains(key)) {
				
				HashNode curr = this.arr[hashCode];
				while (curr.key!=key) {
					curr = curr.next;
				}
				for(HashNode item:HashArr) {
					if(item.key==key) {
						item.value=value;
					break;
					}
				}
				curr.value=value;
			}
			else {
			HashNode curr = this.arr[hashCode];
			while (curr.next != null && curr.key!=key) {
				curr = curr.next;
			}
			curr.next = node;
			this.HashArr.add(node);
		}
		return true;
	}
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
			return "No such key found!";
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
		HashTable ht = new HashTable();
		ht.insert("abc", "123");
		ht.insert("defg", "456");
		ht.insert("hijkl", "789");
		ht.insert("mnopqr", "123");
		ht.insert("ekansh", "mishra");
		ht.insert("papa456", "mummy");
		ht.insert("chacha67899", "chachi");
		ht.insert("mnopqr", "786");
	  //ht.insert(null,"3245");
		ht.traverse();
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
		while(itr.hasNext())
		{
			System.out.print(itr.next().key+" -->>> "+itr.next().value+"\n");
		}
	
}
}
