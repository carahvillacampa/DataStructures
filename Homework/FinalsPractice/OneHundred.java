package FinalsPractice;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class OneHundred<T> {
	private int n;
	private Node first;
	private Node last;
	
	
	private class Node{
		T data;
		Node next;
	}
	
	public void addFirst(T item) {
		
		Node firstNode= first;
		firstNode= new Node();
		firstNode.data= item;
		if(size ()== 1) first= last;
		n++;
	
	}
	public int size() {
		return n;
	}
	
	public T remove() {
		if (size() ==0 ) return null;
		else {
			Node temp= first;
			first= first.next;
			n--;
		
		return temp.data; //remember scope of temp is just in the else statement
		}
		
	}
	
	public Iterator<T> iterator()  {
        return new ListIterator();  
    }

    // an iterator over a linked list
    private class ListIterator implements Iterator<T> {
        private Node current; //temp Node

        // creates a new iterator
        public ListIterator() {
            current = first; //make current point to first
        }

        // is there a next item in the iterator?
        public boolean hasNext() {
            return first != null;
        }

        // this method is optional in Iterator interface
        public void remove() {
            
        }

        // returns the next item in the iterator (and advances the iterator)
        public T next() {
        	T data= current.data;
        	current= current.next; //move to the next node
        	return data;
        	
            
        }
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
