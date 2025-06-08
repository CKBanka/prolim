package multithreading;

public class DefaultThreadExample {
	public static void main(String args[]) {
		Thread t= Thread.currentThread();
		System.out.println(t);
		String name =t.getName();
		int i = t.getPriority();
		ThreadGroup tg=t.getThreadGroup();
		System.out.println(name);
		System.out.println(i);
		System.out.println(tg);
		System.out.println(tg.getName());
		t.setName("Chirag");
		name =t.getName();
		System.out.println(name);
	}
}
