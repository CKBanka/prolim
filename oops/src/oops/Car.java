package oops;

public class Car {
	int wheel;
	String colour;
	double price;
	public Car(int w,String c, double p) {
		wheel =w;
		colour=c;
		price= p;
	}
	public Car() {
		wheel=0;
		colour="yellow";
		price=5.0;
	}
	String getColour() {
		return colour;
	}
	void start() {
		System.out.println("Car started");
	}
	void appliedGear() {
		System.out.println("gear applied");
		
	}
	void moving() {
		System.out.println("Car is mvoing");
	}
	void stop() {
		System.out.println("Car stopped");
	}
	
}
