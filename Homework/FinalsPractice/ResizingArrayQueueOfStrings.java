package FinalsPractice;

public class ResizingArrayQueueOfStrings<Item> {
	private Node first;
	private Node last;
	private int n; //increment whenever u add a node
	
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void Enqueue(Item i) { //returns true if item is added to the node; add to beginning
		
		Node temp= first;
		first= new Node();
		temp.item= i;
		
		if (isEmpty()) first= last;
		else temp.next= last;
		n++;
		
	}
	
	public Item dequeue() { //remove first item in the list
		Item i= first.item;
		first= first.next;
		n--;
		
		if (isEmpty()) last= null;
		return i;
	}
	
	public int size() {
		return n;
	}
	
	public boolean isEmpty() {
		return first== null; //check if the first node is null
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
