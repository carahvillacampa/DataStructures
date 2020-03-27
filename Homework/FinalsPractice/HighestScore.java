package FinalsPractice;

import java.util.Scanner;

public class HighestScore {
	static int [] scoreArray;
	int max=0;
	Scanner input;
	static String uInput;
	
	HighestScore(int length){
		scoreArray= new int[length];
		
	}
	
	public int findMax(int[] scoreArray) {
		int testValue=scoreArray[0];
		for (int i: scoreArray) {
			if (i > testValue) max= i;
			else max= testValue;
		}
		return max;
	}
	
	public void userInput() {
		System.out.print("Enter a name and number: ");
		input= new Scanner(System.in);
		for (int i= 0; i < scoreArray.length; i++) {
			String uInput= input.next();
			int something= input.nextInt();
			scoreArray[i]= something;
			
		}
		for (int j=0; j < scoreArray.length; j++) {
			if (max == scoreArray[j]) {
				System.out.print("Highest scorer: "+ uInput+"With score of: "+ max);
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HighestScore person1= new HighestScore(3);
		person1.userInput();
		System.out.println(person1.findMax(scoreArray));
		
		

	}

}
