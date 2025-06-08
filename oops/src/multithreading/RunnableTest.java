package multithreading;


class A implements Runnable{
	public void run() {
		for(int i=1;i<10;i++) {
			System.out.println(i);
		}
	}
}
class B implements Runnable{
	public void run() {
		for(int j=1;j<10;j++) {
			System.out.println(j);
		}
	}
}
public class RunnableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable obj1=new A();
		Runnable obj2=new B();
		Thread t1=new Thread(obj1);
		Thread t2=new Thread(obj2);
//		t1.start();
//		t2.start();
		t1.run();
		t2.run();

	}

}
