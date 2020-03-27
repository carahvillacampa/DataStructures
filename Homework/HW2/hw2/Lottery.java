package hw2;
/*
 * Program only generates a lottery lottery of a two-digit number
 *  prompts the user to enter a two-digit number, 
 *  and determines whether the user wins according to the following rules:
 *  
 *  1. If the user matches the lotter number in the exact order the award is 10,000
 *  2. If all digits in the user input match all digits in the lottery number,
 *  the awars is $3000
 *  3. If one digit in the user input matches a digit in the lottery number, the 
 *  award is $1000
 *  
 *  Note: if the number is less than 10, we assume that the number is preceeded by a 0
 *  to form a two-digit number.
 *  - Number 8 is treated as 08 and number 0 is treated as 00 in the program.
 */

import java.util.Scanner;

public class Lottery {
	int num1;
	double chance1;
	int first;
	int second;
	
	int lot1;
	int lot2;
	
	Lottery(){
		System.out.println("Enter your first number");
		Scanner roll1= new Scanner(System.in);
		this.chance1= roll1.nextInt();
		this.num1= (int)(Math.random()*100);
	}
	public double randomNum() {
		return num1;
	}
	
	public double getChance() {
		return chance1;
	}
	public void getResult() {
		this.first= (int) chance1/ 10;
		this.second= (int) chance1 % 10;
		
		this.lot1= (int) num1/10;
		this.lot2= (int) num1%10;
		
		if (num1 == chance1) {
			System.out.println("Congrats you won 10,000");
		}
		else if (second== lot1 && first== lot2) {
			System.out.println("Congrats you won 3,000");
		}
		else if(first==lot1|| second==lot1|| first== lot2||second==lot2) {
			System.out.println("Congrats you won 1,000");
		}
		else {
			System.out.println("Try again. you're out of luck");
		}
	}
	public static void main(String[] args) {
		Lottery gambler1= new Lottery();
		System.out.println("Lucky number: "+gambler1.randomNum());
		System.out.println("Your number: "+ gambler1.getChance());
		gambler1.getResult();

	}

}
