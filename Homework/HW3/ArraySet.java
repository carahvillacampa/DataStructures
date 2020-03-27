package homework3;


import java.util.Arrays;
import java.util.Iterator;

public class ArraySet<T> implements Set300 <T>{
	private int size;
	private T [] items;
	
	public ArraySet(int len) {
		this.size= len;
		this.items= (T[]) new Comparable[size];

	}

	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		if(isFull()) {
			expandArray();
		}
		for (int i=0; i< items.length; i++) {		
			if(items[i] == null) {
				items[i]= item;
				return true;
			}	
		}
		size++;
		return false;
		
	}
	public boolean expandArray(){
		T[] twice= (T[]) new Comparable[items.length*2];
		//int x= 0;
		for (int i=0; i < size;i++) {
			twice[i]= items[i];
		items= twice;
		}
		//for (T item: items) {
			//twice[item]= items[item];
			//x++;
		return true;
		}
		//items= twice;

	public boolean isFull() { //check if one value is null if there is, return true
		for (T item: items) 
			if (item== null) //check if the second to the last digit is there
				return false;    
		return true;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		for (int i=0; i< items.length; i++) {
			if(items[i]== item) {
				items[i]= null;
				return true;
			}
		}
		size--;
		return false;
	}
	

	@Override
	public Iterator<T> iterator() {//generic method
		return new Iterator<T>() {
			int count=0;
			
			public boolean hasNext() {
				return count < items.length;
			}
			
			public T next() {
				return items[count++];
			}
		};
	
	}
	public String toString() {
		StringBuilder b = new StringBuilder("{ ");
		for (T item: this) {
			b.append(item.toString() + " ");
		}
		b.append("}");
		return b.toString();
	}
	
	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		for(int i=0; i < items.length; i++) {
			if(items[i] == item) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Set300<Integer> set = new ArraySet<Integer>(5);
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
