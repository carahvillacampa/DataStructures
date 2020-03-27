package FinalsPractice;
import java.util.Arrays;

public class BinarySearchv2 {
	/*
	 * binary search only has one method
	 * 1. indexOf() method
	 * - 2 parameters: sorted array, key and returns the index of the key
	 * What it does:
	 * lo, hi and mid
	 * loops through and checks if the middle key value is the same as int key.
	 * - if it's on the left, 
	 */
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] b = {5,2,3,4};
		Arrays.parallelSort(b);
	
		BinarySearchv2 testing1= new BinarySearchv2();
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
