package mywish;

public class overloading {
	public static int area(int a) {
		return a*a; //rectange
	}
	public static int area(int b,int h) {
		return b*h;
	}
	public static double area(double b, double h) {
		return (Double)b*h;
	}
	public static double area(float b, float h) {
		return b*h;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Area of int rectange "+area(5,4));
		System.out.println("Area of double rectange "+area(5.4,4.6));
		System.out.println("Area of float rectange "+area(5.1f,4.0f));
		System.out.println("Area of int square "+area(5));

	}

}
