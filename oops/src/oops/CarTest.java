package oops;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c=new Car();
		Car c2=new Car(5,"Pink",2.0);
		c.start();
		System.out.println(c.colour);
		System.out.println(c.price);
		System.out.println(c.wheel);
		c.stop();
		System.out.println(c.getColour());
		System.out.println(c2.getColour());
	}
}
