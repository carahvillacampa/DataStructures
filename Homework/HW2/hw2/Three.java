package hw2;


/*
 * create a class that asks users to enter 3 numbers
 * 1. 3 data fields for int
 * 2. method to add the three numbers
 * 3. method to return the added numbers
 */
import java.util.Scanner;

public class Three {
	int num1;
	int num2;
	int num3;
	int sub;
	
	public Three () {
		System.out.println("Enter first num: ");
		Scanner first= new Scanner(System.in);
		this.num1= first.nextInt();
		
		System.out.println("Enter second num: ");
		Scanner second= new Scanner(System.in);
		this.num2= second.nextInt();
		
		System.out.println("Enter the third num: ");
		Scanner third= new Scanner(System.in);
		this.num3= third.nextInt();
		
		}
	public String printAns() {
		if (num1 > num2) {
			int temp= num1;
			num1=num2;
			num2=temp;
		}
		else if (num2 > num3) {
			int temp= num2;
			num2=num3;
			num3=temp;
		}
		
		this.sub= num1-num2-num3;
		return "correct answer is "+ sub;
	}
	public void userAns() {
		System.out.println("enter answer for "+num1+"-"+num2+"-"+num3+": ");
		Scanner num_ans= new Scanner(System.in);
		int answer= num_ans.nextInt();
		if (answer== sub) {
			System.out.println("True");
			
		}
		else {
			System.out.println("False");
		}
		num_ans.close();
	}
	

	public static void main(String[] args) {
		Three child1= new Three();
		child1.userAns();
		
		System.out.println(child1.printAns());
		
		

	}

}
