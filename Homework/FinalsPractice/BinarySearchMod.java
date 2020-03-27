package FinalsPractice;

import java.util.Arrays;


public class BinarySearchMod {
	int counter=0;
	
	public static int indexOf(int[] a, int key) {
		int low=0;
		int high= a.length-1;
		
		while(low <= high) {
			int mid= (low + (high- low)/2);
			
			if (key < a[mid]) high= mid-1; //look at the left half
			else if(key > a[mid]) low= mid+1; //look at the right half
			else return mid;  //if it's not on both halves, the index of the key is the middle index
		}
		return -1; 
	}
	
	public int removeDuplicates(int [] a, int n) {
		int [] c= new int[n];
		
		for(int i=0; i < n-1; i++) {
			if(a[i] != a[i+1]) {
				c[i]= a[i];
				counter++;
			}
		}
		
		for (int i=0; i < counter; i++) {
			a[i]= c[i];
		}
		return counter;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] b = {5,2,3,4,4};
		
		Arrays.parallelSort(b);
	
		BinarySearchMod testing1= new BinarySearchMod();
		int result= testing1.indexOf(b, 4);

		if(result == -1) {
			System.out.println("Element not present"); 
		}
		else {
			System.out.println("The array is: ");
			for(int i: b) {
				System.out.print(i+" ");
			}
			System.out.println();
			System.out.println("Element found at index "+ result);
		}
		
		 

	}

}
