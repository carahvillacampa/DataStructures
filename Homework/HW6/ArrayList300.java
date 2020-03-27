package hw6;

/*
 *  CSC 300 Spring 2019 -- Lytinen
 *  This is the full-fledged version of an array-based 
 *  implementation of List.  It uses a wrap-around array.  
 *  When data shifting is necessary (as it is in add(i,item) and
 *  remove(i)), we determine which way to shift based on 
 *  i.  If the i is less than halfway
 *  through the list, then data is shifted from the left
 *  otherwise it's to the right.
 *  
 *  Notice that because of wrap-around, the front of the
 *  list does not necessary correspond to index 0 in the
 *  array.
 */

import java.util.Iterator;
import java.util.List;

//your job is to write the get, contains, and set methods 
public class ArrayList300<T> implements List300<T> {
	// the initial capacity can be whatever we want.
	// In Java, by default the initial capacity of
	// ArrayList is 10.
	private static final int INIT_CAPACITY = 5;
	
	private T[] items = (T[]) new Object[INIT_CAPACITY];
	// front is the index where the list begins, and
	// back is where it ends.  At times, it will be the
	// case that front > back, which would indicate that
	// wrap-around has occurred.
	
	// Note that the size of the list is somewhat difficult
	// to compute based on the values of front and back.
	// If there is no wrap-around, size = (back-front)+1.
	// If there is wrap-around, size = (back-front)+items.length+1
	private int size;
	
	public ArrayList300() {
		// by convention we'll indicate an empty list by
		// setting front and back to -1
		size = 0;
	}

	public String toString() {
		if (size == 0) return "[]";
		StringBuilder b = new StringBuilder("[");
		for (T item : this)
			b.append(item + ", ");
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

	// array is full (size == length-1).  Make an array twice the length
	// copy data from the old array to the new one, and the new one 
	// is stored in the "items" instance variable
	private void expand() {
		T[ ] newItems = (T[ ]) new Object[items.length*2];
		for (int i=0; i<size; i++)
			newItems[i] = items[i];
		items = newItems;
	}
	
	public boolean add(T item) {
		if (size == items.length) expand();
		// special case:  in an empty list, back and front are both -1.
		// So they should now both be set to 0.
		items[size++] = item;
		return true;
	}

	// Add is written to decide which way to shift, in order
	// to make room and place the new item at the position specified
	// by idx.  If idx is less than half of the size of the list, 
	// then left shifting is performed to make room
	// for item.  Otherwise, right shifting is performed.
	public boolean add(int idx, T item) {
		// case 1:  idx > size
		if (idx > size+1)
			return false;
		// case 2: add to the end
		if (size == items.length) expand();
		if (idx == size) 
			add(item); // at the end
		// case 3:  add somewhere else
		else {
			rightShift(idx, size-1);
			items[idx] = item;
			size++;
		}	 
		return true;
	}

	// Shift all data to the right that is between the start index
	// and the end index (inclusive). 
	public void rightShift(int start, int end) {
		for (int i=end+1; i>start; i--)
			items[i] = items[i-1];
	}
	
	// returns the current value stored in position idx
	public T set(int idx, T item) {
		T item1= items[idx];
		items[idx]= item;
		return item1;
	}

	// return true if item is in the list, or false otherwise.
	public boolean contains(T item) {
		for (int i=0; i < size; i++) {
			if (item.equals(items[i])) return true;
		}
	
		return false;
	}

	public T get(int idx) { 
		return items[idx];
	}

	public void clear() {
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public boolean remove(T item) {
		if (contains(item)) return false;
		int idx;
		for (idx = 0; !item.equals(items[idx]); idx++)
			leftShift(idx+1,size-1);
		size--;
		return true;
	}

	// Remove is written to decide which way to shift, in order
	// to remove the item at the position specified by idx.  
	// If idx is less than half of the size of the list, 
	// then right shifting is performed to remove the item.
	// Otherwise, left shifting is performed.
	public T remove(int idx) {
		if (idx >= size) return null;
		T answer = items[idx];
		leftShift(idx+1, size-1);
		size--;
		return answer;
	}
	
	// Shift all data to the left that is between the start index
	// and the end index (inclusive). 
	public void leftShift(int start, int end) {
		System.out.println("leftShift(" + start + ", " + end + ")");
		for (int i=start; i<=end; i++)
			items[i-1] = items[i];
	}
	

	public Iterator<T> iterator() {
		//System.out.println("front = " + front + " back = " + back);
		return new Iterator<T>() {
			private int i = 0;
			
			public boolean hasNext() {
				return i < size;
			}

			public T next() {
				T answer = items[i++];
				return answer;
			}
						
		};		
	}

}

