package homework3;

import java.util.Iterator;

//import homework3.NodeSet.Node;

public class OrderedNodeSetv1<T extends Comparable<T>> implements Set300<T> {
	
	private Node<T> firstNode= null;
	
	private class Node<T>{
		Node head;
		
		T item;
		private Node next;
		
		
		public Node(T item, Node<T> next) { //constructor of inner class
			this.item= item; // init data in inner class Node
			this.next=next;
		}
	}

	@Override
	public boolean add(T item) {
		
		OrderedNodeSetv1<T>.Node<T> currentNode= firstNode;
		Node previousNode= null;
		
		if (firstNode== null) {
			Node<T> newNode= new Node<T>(item, null);
			firstNode= newNode;
			return true;
		}
		
		if(contains(item)) return false;
		
		while (currentNode != null) {
			if(item.compareTo(currentNode.item) < 0) {
				Node<T>nodeOne= new Node<T>(item, currentNode);
				nodeOne.next= firstNode;
				
				
				Node<T> newNode= new Node<T>(item, currentNode);
				
				if (previousNode != null) {
					previousNode.next= newNode;
				}
				else {
					firstNode= newNode;
				}
				
				return true;
			}
			
			previousNode= currentNode;
			currentNode=currentNode.next;
		}
		Node <T> newNode= new Node(item, null);
		previousNode.next= newNode;
		return true;
		
	}

	@Override
	public boolean remove(T item) {
		// TODO Auto-generated method stub
			//Node curr= first;
			//Node tempNode= firstNode; 
			while(firstNode != null && firstNode.item == item) {
				firstNode= firstNode.next; //skip over to remove the node
				
				}
			Node tempNode= firstNode; 
			
			while(tempNode != null && tempNode.next!= null) {
				while(tempNode.next.item==item) {
					tempNode= tempNode.next;
				}
				tempNode.next= tempNode.next.next;
					
			}
			return true;
			}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub
		Node<T> newNode= firstNode;
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
			private Node<T> currentNode= firstNode;

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
	
	
	public String toString() {
		StringBuilder s = new StringBuilder("{ ");
		for (T item : this)
			if (item != null)
				s.append(item.toString() + " ");
		s.append("}");
		return s.toString();
	}
	

	public static void main(String[] args) {
		Set300<Integer> set = new OrderedNodeSetv1<Integer>();
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
