package hw2;

import java.util.*;

public class TestHw {
	int num1;
	int num2;
	
	int [] array1= new int[num2+1];
	
	TestHw(int x, int y) {
		this.num1= x;
		this.num2= y;
	}
	public void iterateNum(int y) {
		this.num2= y;
		//if (num1 >=0 && num2 >=0) {
			for (int i=0; i < array1.length; i++) {
				this.array1[i]= i;
				System.out.println(array1[i]);
			}	
		}
		//else {
			//System.out.println("it didn't work");
		//}
		
	//}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,y;
		System.out.println("Type 2 positive integers.  The second integer should be greater then the first\n");
		x = sc.nextInt();
		y = sc.nextInt();
		TestHw p = new TestHw(x, y);
		p.iterateNum(y);

	}

}
