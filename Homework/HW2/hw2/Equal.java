package hw2;

public class Equal {
	int width;
	int height;
	
	Equal (int w, int h){ //constructor with parameters h and w
		width= w;
		height=h;
	}
	
	Equal(Equal b){
		this.width= b.width;
		this.height= b.height;
	}
	
	public boolean isEqualTo(Equal a) { //has an object as a parameter
		if (this.width== a.width && this.height== a.height) {
			return true; //compares one object to another
		}
		else {
			return false;
		}
	}
	/*
	 * also note that in java, and is equivalent to &&, or
	 * is equivalent to ||.
	 */

	public static void main(String[] args) { //tester class
		Equal box1= new Equal(12,32); //default constructor that 
									  // a pair of int that represents h and w
		Equal box2= new Equal(54,12);
		Equal box3= new Equal(box2); //using the other constructor 
									// that accepts an object as a parameter
		
		System.out.println(box3.isEqualTo(box2)); 
	}

}
