package hw6;

import java.util.Iterator;



// a singly linked list
// makes removing the last item very difficult
//your job is to write the get, contains, and set methods 

public class LinkedList300<T> implements List300<T> {

	private class Node<T> { //node and its inner class
		public T item;
		public Node next;
		
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	private Node<T> first; //initialize first and last node to be null
	private Node<T> last;
	private int size;
	
	public LinkedList300() {
		first = null;
		last = null;
		size = 0;
	}

	public String toString() {
		if (size == 0) return "[]";
		StringBuilder b = new StringBuilder("[");
		for (T item : this)
			b.append(item + ", ");
		// get rid of the ", "
		b.delete(b.length()-2, b.length());
		b.append("]");
		return b.toString();
		}
	
	// In the test code, I call listEquals occasionally to make
	// sure that my methods do the same thing as the corresponding
	// Java ArrayList or LinkedList methods.  That is why the 
	// print statements are in the code.  Once I'm certain the code 
	// works properly, I would take them out.
	public boolean listEquals(Iterable<T> javaList) {
		Iterator<T> it = iterator(), javaIt = javaList.iterator();
		int i;
		for (i=0; it.hasNext() && javaIt.hasNext(); i++) {
			T mine = it.next();
			T other = javaIt.next();
			if (!mine.equals(other)) {
				System.out.println("lists are not equal at index " + i);
				return false;
			}
		}
		if (it.hasNext() != javaIt.hasNext()) {
			System.out.println("lists are not equal at index " + i);
			return false;
		}
		return true;
	}

	// add at the end
	public boolean add(T item) {  //if item is null, make the first node the same as the last node
		if (first == null) {
			first = new Node<T>(item, null);
			last = first;
		}
		else {
			last.next = new Node<T>(item, null); 
			last = last.next;
		}
		size++;
		return true;
	}

	public boolean add(int idx, T item) {
		if (idx == 0) { //if it's the first position, assign it to the first node
			Node<T> newNode = new Node<T>(item, first);
			first = newNode;
			if (last== null) last = newNode;  //if the last node is empty, make the first node the last node too
		}
		else if (idx > size) 
			return false;
		else if (idx == size) {
			last.next = new Node<T>(item, null);
			last = last.next;
		}
		else {
			Node<T> n = first;
			for (int i=1; i<idx; i++)
				n = n.next;
			n.next = new Node<T>(item, n.next);
			if (last == n)
				last = n.next;
		}
		size++;
		return true;
	}

	public T set(int idx, T item) {
		Node temp= first;
		int count=0;
		T item1;
		while(temp.next != null) {
			if(count == idx) {
				break;
			}
			temp= temp.next;
			count++;
		}
		item1= (T) temp.item;
		temp.item= item;
		return item1;
	}

	public boolean contains(T item) {
		Node<T> firstNode= first;
		for(Node x= first; x!= null; x= x.next) {
			if(x.item== item) {
				return true;
			}
		}
		return false;
	}
		
		
		/*
		Node<T> firstNode= first;
		while (firstNode != null) {
			if (firstNode.item== item) {
				return true;
			}
			firstNode= firstNode.next;
		}
	
		return false;
		*/
	

	public T get(int idx) {
		
		
		Node temp= first;
		int count=0;
		T item1;
		while(temp.next != null) {
			if(count == idx) {
				break;
			}
			temp= temp.next;
			count++;
		}
		
		return (T) temp.item; 
		
	}

	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	/* I didn't bother to write these.  You don't need to either. */	
	public boolean remove(T item) {
		return false;
	}
    
	public T remove(int idx) {
		return null;
	}
	
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private Node<T> n = first;
			
			public boolean hasNext() {
				return n != null;
			}
			
			public T next() {
				T answer = n.item;
				n = n.next;
				return answer;
			}
		};
	}
}
