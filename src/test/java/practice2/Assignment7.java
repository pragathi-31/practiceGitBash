package practice2;

public class Assignment7 {
	public static void main(String[] args) {
		final int a=10;
		System.out.println(a);
		//a=20;
		
		try {
		    int b=10;
		    int c=0;
		    System.out.println(b/c);
			
		} catch (Exception e) {
		  System.out.println("do not divide the number by zero");
		} finally {
		   System.out.println("welcome to your profile");
		}
	}
}
