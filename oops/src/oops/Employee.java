package oops;

import java.util.Scanner;
public class Employee {
private int id;
private String name;
private float salary;
Scanner sc = new Scanner(System.in);

public void readEmployee() {
	System.out.println("enter the id");
	id = sc.nextInt();			// it is use to scan int value 
	System.out.println("enter the name");
	name = sc.next();
	System.out.println("enter the salary");
	salary = sc.nextFloat();
}
public void displayEmployee() {
	System.out.println("id is "+id);
	System.out.println("name is "+name);
	System.out.println("salary is "+salary);
}
}
