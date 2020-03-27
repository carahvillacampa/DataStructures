package homework1;

import java.util.Scanner;

public class TestPrimes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,y;
		System.out.println("Type 2 positive integers.  The second integer should be greater then the first\n");
		x = sc.nextInt();
		y = sc.nextInt();
		Primes p = new Primes(x, y);
		System.out.println("The prime numbers between " + x + " and " + y + " are");
		for (Integer i : p)
			System.out.print(i + " ");
		System.out.println();
	}
}





