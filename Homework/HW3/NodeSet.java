package homework3;

import java.util.Iterator;

public class NodeSet<T> implements Set300<T>{
	private Node<T> head, tail;
	private int size=0;
	
	
	@Override
	public boolean add(T item) {
		// TODO Auto-generated method stub
		Node<T> nodeOne= new Node<T>(item);
		nodeOne.next= head;
		head= nodeOne;
		size++;
		
		if (tail== null) {
			tail=head;
		}
		return true;
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
		if (this.size==0) {
			return (Boolean) null;
		}
		else {
			Node<T> tempNode= head;
			head= head.next;
			size--;
			if(head== null) {
				tail=null;
			}
			return true;
		}
		
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		Node<T> newNode= head;
		while (newNode != null) {
			if (newNode.item == item) {
				return true;
			}
			newNode= newNode.next;
		}
		
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			private Node<T> currentNode= head;

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				
				return (currentNode != null);
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				T data= currentNode.item;
				currentNode= currentNode.next;
				return data;
			}
			
		};
			
	}
	
	private class Node<T>{
		T item;
		Node<T> next;
		
		public Node(T item) { //constructor of inner class
			this.item= item; // init data in inner class Node
			
			
		}
	}
	public String toString() {
		StringBuilder b = new StringBuilder("{ ");
		for (T item: this) {
			b.append(item.toString() + " ");
		}
		b.append("}");
		return b.toString();
	}
	
	public static void main(String[] args) {
		Set300<Integer> set = new NodeSet<Integer>();
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
