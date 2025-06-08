package polymorphism;

public class Rectange extends Shape {
	private int length;
	private int breadth;
	public int area() {
		return length*breadth;
	}
	void tellShape() {
		System.out.println("This is a rectange");
	}
}
