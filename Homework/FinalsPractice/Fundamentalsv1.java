package FinalsPractice;

public class Fundamentalsv1 {
	
	public static int mystery(int a, int b) {
		if(b==0) return 0;
		if(b %2 ==0) return mystery(a+a, b/2);
		return mystery(a+a, b/2) +a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fundamentalsv1 scope1= new Fundamentalsv1();
		System.out.print(scope1.mystery(2,25)+"  ");
		System.out.print(scope1.mystery(3,11));

	}

}
