package hw2;

public class Pass_arrays {
	private int[] age1; //declare variables on top and use it to pass to 
						// constructors
	public Pass_arrays(int [] age1){ //whatever you pass into the constructor, you have to declare it
									 //above right below the class
		this.age1= age1;
		
	}
	public static void ArrayAge(int [] age) { //does not accept/ have instance 
		for (int i=0; i < age.length; i++) {  // this method isn't dependent on instance vars
			if (age[i] == 3) {				  // static is accessible through classname.method(args)
				age[i]=0;
			}
			System.out.println(age[i]);
		
		}
	}
	public static void main(String[] args) { 
		int old []= {60,50,40,78};
		int young []= {1,2,3,4};
		ArrayAge(young);
		ArrayAge(old);

	}
	
	
	
	

}
