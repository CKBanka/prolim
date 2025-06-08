package ExceptionHandling;

public class ThorwsExample  extends Exception{
	static void display1() {
		System.out.println("Display method 1");
	}
	static void display2() {
		display1();
		System.out.println("Display 2 method");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		display2();
		System.out.println("Main method");

	}

}
