package homework4;

import java.util.Iterator;

public class ArrayStack300<T> implements Stack300<T> {
	private T items[];
	private int size;
	
	public ArrayStack300(int capacity) {
		items = (T[]) new Object[capacity];
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean push(T item) {
		if (size == items.length) expand(); 
		items[size++] = item;
		return true;
	}
	
	public void expand() {
		T temp[] = (T[]) new Object[size*2];
		for (int i=0; i<size; i++)
			temp[i] = items[i];
		items = temp;
	}
	
	public T pop() {
		if (size == 0)
			return null;
		else return items[--size];
	}
	
	public T peek() {
		if (size == 0)
			return null;
		else return items[size];
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			private int i=0;
			
			public boolean hasNext( ) {
				return i < items.length;
			}
			
			public T next() {
				return items[i++];
			}
		};
	}
	
	public static void main(String[] args) {
		ArrayStack300<Integer> st = new ArrayStack300<Integer>(5);
		for (int x=0; x<10; x++)	
			st.push(x);
		while (!st.isEmpty())
			System.out.println(st.pop());
	}
}