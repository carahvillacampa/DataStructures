 /* CSC 300 Sections Fall 2019 -- Lytinen
 * Homework assignment 2, part a
 * The Primes class
 */
package homework1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.*;

// generate a sequence of prime numbers that are greater than or equal to
// smallest, and less than or equal to largest.
// m > s > 0

public class Primes implements Iterable<Integer> {
	private int smallest, largest;

	// fill this in
	public Primes(int x, int y) {
		this.smallest= Math.abs(x);
		this.largest= Math.abs(y); //ensures that both integers are positive

	}
	
	// fill this in; to be used in one of more of the iterator methods below
	public static boolean isPrime(int p) { 
		int z=2;
		
			if (p <= 1) 
				return false;
		     if (p<= 3)
		    	 return true;
		     
		 while (z*z <=p) {
			 if ( p % z == 0) {
				 return false;
			 }
			 z =z+1;
		}
		return true;
	}
	
	public Iterator<Integer> iterator() { 
	
		return new Iterator<Integer>() {
			private int p = smallest;
			
			public boolean hasNext() { 
					return p < largest;
			}
			
			public Integer next() {
			
				int before= p;
				p++;
				for ( int i=2; i < p; i++) {
					if (p % i==0) {
						p++;
					}
					else {
						continue;
					}
				}
				return (isPrime(p)? p: p++); //isPrime(before)? before: p++
			}
		};
	}
	

}
			
