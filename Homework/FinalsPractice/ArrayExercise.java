package FinalsPractice;

public class ArrayExercise {
	int[] a;
	int size;
	
	ArrayExercise(int N){
		size= N;
		a= new int[size];
	}
	
	public void evenIntegers(int key) {
		int high= a[a.length-1];
		int low= 0;
		
		for(int i= 0; i< a.length; i++) {
			int mid= low + (high- low)/2;
			if (key > 1 ) high= mid-1;
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayExercise ex1= new ArrayExercise(1000);
		int [] b= new int[ex1.size];
		int c= (int) (Math.random ()* b.length); //generates random integers in array b
		System.out.println(c); 
		
		
	}

}
