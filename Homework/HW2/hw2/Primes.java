 /* CSC 300 Sections Fall 2019 -- Lytinen
 * Homework assignment 2, part a
 * The Primes class
 */
package hw2;

import java.util.Iterator;
import java.util.Scanner;
import java.util.*;


public class Primes implements Iterable<Integer> {
	private int smallest, largest;

	// fill this in
	public Primes(int x, int y) {
		this.smallest= Math.abs(x);
		this.largest= Math.abs(y); //ensures that both integers are positive

	}
	
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
			 z = z+1;
		}
		return true;
	}

	// I have supplied the iterator method, which is required by the Iterable<T>
	// interface.  It returns an object which implements Iterator<T>.  You
	// must write hasNext and next methods for this object.
	public Iterator<Integer> iterator() { //returns an iteration of ints
		// this is an "anonymous inner class"
		return new Iterator<Integer>() {
			private int p = smallest;
			
			public boolean hasNext() { 
					return p < largest;
			}
			
			public Integer next() {
				// loop: every number from one point to the next 
				// and return if it's prime
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
				return (isPrime(before)? before: p++); //before; before
			}
		};
	}
	

}
			
