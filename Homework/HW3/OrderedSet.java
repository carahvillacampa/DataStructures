
package homework3;

import java.util.Iterator;
import java.util.ArrayList;

public class OrderedSet<T extends Comparable<T>>implements Set300 <T>{
	private int size;
	private T [] items;
	
	public OrderedSet(int len) {
		this.items= (T[]) new Comparable[len];
		size= 0;
	}

	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		ArrayList<T> newList = new ArrayList<T>(); 
		if(isFull()) {
			expandArray();
		}
	
		for (int i=0; i<size; i++)
			if (items[i].equals(item)) 
				return false;
			
		for (int j=0; j<size; j++)
			if (item.compareTo((T) items[j]) < 0) {
				shiftR(j);
				items[j] = item;
				size++;
				return true;
			}
		items[size++] = item;
		return true;
		
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
			for (int i=0; i< size; i++) {
				if(items[i]== item) {
					items[i]= null;
					return true;
				};
			}
			size--;
			return false;
		}
	private void shiftR(int sIndex) {
		for (int i=size; i>sIndex; i--)
			items[i] = items[i-1];
	}
	
	public boolean contains(T item) {
		return contains(item, 0, size-1);
	}
	
	public boolean contains(T item, int bottom, int top) {
		int middleInt, compareItems;
		if (bottom > top) {
			return false;
		}
		middleInt = (bottom + top)/2;
		compareItems = item.compareTo((T) items[middleInt]);
		
		if (compareItems == 0) {
			return true;
		}
			
		else if (compareItems < 0) {
			return contains(item, bottom, middleInt-1);
		}
			
		else {
			return contains(item, middleInt+1, top);
		}
	}
	

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		//generic method
			return new Iterator<T>() {
				private int count=0;
				
				public boolean hasNext() {
					return count < items.length;
				}
				
				public T next() {
					return (T) items[count++];
				}
			};
		
		}
	
	public void expandArray(){
		Comparable<T> twice []= (T[]) new Comparable[items.length*2];

		for (int i=0; i < size;i++) {
			twice[i]= items[i];
		items= (T[]) twice;
			}
		}
		
		
		
	public boolean isFull() { //check if one value is null if there is, return true
		return size== items.length;
	}
	
	public String toString() {
		StringBuilder b = new StringBuilder("{ ");
		for (T item: this) {
			if (item != null)
				b.append(item.toString() + " ");
		}
		b.append("}");
		return b.toString();
	}
	
	
	public static void main(String[] args) {
		Set300<Integer> set = new OrderedSet<Integer>(12);
		for (int i=0; i<10; i++) {
			int x = (int) (10. * (Math.random()));
			System.out.println("Add " + x + " " + set.add(x)); }
		System.out.println("Set is " + set);
		for (int i=0; i<10; i++) {
			int x = (int) (10. * (Math.random()));
			System.out.println("Contains " + x + " " + set.contains(x)); }
		System.out.println("Set is " + set);
		for (int i=0; i<10; i++) {
			int x = (int) (10. * (Math.random()));
			System.out.println("Remove " + x + " " + set.remove(x)); }
		System.out.println("Set is " + set);
	}

}
