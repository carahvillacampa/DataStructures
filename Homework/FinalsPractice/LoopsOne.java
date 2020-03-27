package FinalsPractice;

import java.util.Scanner;
public class LoopsOne {
	static Scanner one;
	static int [] randomArray;
	int length;
	
	LoopsOne(int length){
		this.one= new Scanner(System.in);
		randomArray= new int[length];
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int posi=0;
		int neg=0;
		LoopsOne testing1= new LoopsOne(5);
		
		System.out.println("Enter 5 numbers: ");
		for (int i=0; i < randomArray.length; i++) {
			randomArray[i]= one.nextInt();
		}
		for (int i: randomArray) {
			if (i > 0 && i != 0) posi++;
			else if( i < 0) neg++;
			else continue;
		}
		System.out.println("positive numbers:"+posi);
		System.out.println("negative numbers:"+neg);
		

	}

}
