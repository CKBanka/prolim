package polymorphism;

public class Square extends Shape {
	private int side;
	public int area() {
		return side*side;
	}
	void tellShape() {
		System.out.println("This is a square");
	}
}
