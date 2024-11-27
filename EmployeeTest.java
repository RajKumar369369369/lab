package lab;

import java.util.Scanner;
public class EmployeeTest {
	public static void main(String[] args) {
		Scanner myobj=new Scanner(System.in);
		Employee emp1=new Employee(myobj.nextLine(),myobj.nextLine(),myobj.nextDouble());
		 myobj.nextLine(); 
		System.out.println("First Name"+emp1.getfirstname());
		System.out.println("Last Name"+emp1.getlastname());
		System.out.println("Salary"+emp1.getsalary());
		emp1.increment(10);
		System.out.println("First Name"+emp1.getfirstname());
		System.out.println("Last Name"+emp1.getlastname());
		System.out.println("Salary"+emp1.getsalary());
		System.out.println();
		Employee emp2=new Employee(myobj.nextLine(),myobj.nextLine(),myobj.nextDouble());
		myobj.nextLine(); 
		System.out.println("First Name"+emp2.getfirstname());
		System.out.println("Last Name"+emp2.getlastname());
		System.out.println("Salary"+emp2.getsalary());
		emp2.increment(10);
		System.out.println("First Name"+emp2.getfirstname());
		System.out.println("Last Name"+emp2.getlastname());
		System.out.println("Salary"+emp2.getsalary());
		System.out.println();
	}
}
