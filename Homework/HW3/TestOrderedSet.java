package homework3;

public class TestOrderedSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedSet<Integer> intg1= new OrderedSet<Integer>(10);
		for (int i=0; i<10; i++) {
			int x = (int) (20 * Math.random());
			System.out.print("Add " + i + ":");
			System.out.println(intg1.add(x));
			System.out.println(intg1); 
		}
		
		
	}//ledger is 773 instead of half of the rent which is 725 

}
