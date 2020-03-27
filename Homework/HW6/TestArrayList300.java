package hw6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// this tests the add method of the ArrayList300 class.
public class TestArrayList300 {

	public static void main(String[ ] args) {
		String letters = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("TestArrayList300");
		ArrayList<Character> list1 = new ArrayList<Character>();
		ArrayList300<Character> list2 = new ArrayList300<Character>();
		int indices[] = randomIndices(10000);
		for (int i=0; i<10; i++) {
			//System.out.println("add(" + indices[i] + "," +  letters.charAt(i%26) + ")");
			list1.add(indices[i], letters.charAt(i%26));
			list2.add(indices[i], letters.charAt(i%26));
			if (!list2.listEquals(list1)) {
				System.out.println("NOT EQUAL after add(" + indices[i] + "," + letters.charAt(i%26) + ")");
				System.out.println("LinkedList: " + list1);
				System.out.println("LinkedList300: " + list2);
			    System.exit(0);
			}
		}
		System.out.println("Java ArrayList: " + list1);
		System.out.println("CSC 300 ArrayList: " + list2);
			
		/*for (int i=0; i<list1.size(); i+=4) {
			list1.remove(indices[i]);
			list2.remove(indices[i]);
			if (!list2.listEquals(list1)) {
				System.out.println("NOT EQUAL after remove(" + indices[i] + ")");
				System.out.println("LinkedList: " + list1);
				System.out.println("LinkedList300: " + list2);
			    System.exit(0);
			}
		}*/
		char cs[] = {'a','z','b','y','c','x','d','w','e','v','f','u','g','t','h','s','i','r','j','q'};
		System.out.println("Testing contains");
		for (char c : cs)
			if (list1.contains(c) != list2.contains(c)) {
				System.out.println(c + " is wrong");
			}
		System.out.println("Testing get");
		for (int i=0; i<list1.size(); i++)
			if (list1.get(i) != list2.get(i))
				System.out.println("get(" + i + ") is wrong: " + list2.get(i));
		System.out.println("Testing set");
		int x=0;
		for (char c : cs) {
			if (x >= list1.size()) break;
			Character ans = list2.set(x, c);
			if (ans != list1.set(x, c) ||
			    (list1.get(x) != list2.get(x))) {
				System.out.println("set(" + x + ", c) is wrong: returns " + ans);
			}
			x++;
		}
	}
				
	private static int[] randomIndices(int max_n) {
		int indices[] = new int[max_n];
		for (int i=0; i<max_n; i++)
			indices[i] = (int) (Math.random() * (i+1));
		return indices;
	}
}
