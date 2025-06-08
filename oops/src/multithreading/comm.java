package multithreading;

class Task implements Runnable{
	public synchronized void run() {
		String name =Thread.currentThread().getName();
		for(int i=0;i<10;i++) {
			try{
				Thread.sleep(5);
				System.out.println(name+""+i);
				if(name.equals("Raj") && i==4){
					wait();
				}
				if(name.equals("Ramesh") && i==6)
					notify();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}

public class comm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task t=new Task();
		new Thread(t,"Raj").start();;
		new Thread(t,"Ravi").start();
		new Thread(t,"Ramesh").start();

	}

}
