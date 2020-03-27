package FinalsPractice;

//this is a generic arraylist
public class ArrayListv1<E>{
	int capacity;
	private E[]  data;
	
	ArrayListv1(int c){
		capacity= c;
		data= (E[]) new Object[c];
	}
	
	public boolean isFull() {
		return capacity== data.length;
	}
	
	public void resize() {//you have to copy the old to a new 
		if(isFull()) {
			E[] arrayCopy= (E[]) new Object[capacity*2];
			System.arraycopy(data, 0, arrayCopy, 0, capacity);
			data= arrayCopy;
			
		}
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
