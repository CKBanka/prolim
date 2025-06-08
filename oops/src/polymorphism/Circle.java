package polymorphism;

public class Circle extends Shape {
	private double radius;
	public double area() {
		return (int)Math.PI*radius*radius;
	}
	void tellShape() {
		System.out.println("This is a Circle");
	}
}
