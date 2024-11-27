package lab;

public class Employee {
	private String firstname;
	private String lastname;
	private double salary;
	public Employee(String firstname,String lastname,double salary) {
		setfirstname(firstname);
		setlastname(lastname);
		setsalary(salary);
	}
	public void setfirstname(String firstname) {
		this.firstname=firstname;
	}
	public void setlastname(String lastname) {
		this.lastname=lastname;
	}
	public void setsalary(double salary) {
		this.salary=salary;
	}
	public String getfirstname() {
		return firstname;
	}
	public String getlastname(){
		return lastname;
	}
	public double getsalary(){
		return salary;
	}
	public void increment(double per) {
		setsalary(salary*((100+per)/100));
	}
}
