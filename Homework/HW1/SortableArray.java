package homework1;

import java.util.Arrays;
import java.util.Iterator;

/*
 * extends means that you're creating a subclass. Implements 
 * means you're using the elements of a java interface in your class
 */

public class SortableArray<T extends Comparable<T>> implements Iterable<T> {
	//extends 

	private T[] items;
	private int size;

	public SortableArray(int len) {
		this.size= len;
		items= (T[]) new Comparable [size]; //items in that array are type T and those items implement the 
		//comparable interface
		size=len;
		//an array of comparable objects and cast it tp T[]
	}
	public boolean add(T item) { //adds if the array is false
		if ( isFull() == false) {
			for (int i=0; i < size; i++) {
				if (items[i] == null) {
					items[i]= item; //adds item to the array
					return true;}
			}
		}
		return false;  
	}
	public  T remove() { //if last value doesn't equal to null return null
		if (items[size-1] != null) 
			return items[size-1];
		return null;
	}
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int count= 0; //stop when you reach the end: 

			public boolean hasNext() {
				return count < size; // replace this
			}

			public T next() {
				return items[count++];  // replace this
			}
		};
	}
	public boolean isFull() { //check if one value is null if there is, return true
		for (T item: items) 
			if (item== null) //check if the second to the last digit is there
				return false;    
		return true;
	}
	
	
	public void sort() {
		// will require one line of code
		// look up the Arrays class: 
		if (isFull())Arrays.parallelSort(items);
	}

}
