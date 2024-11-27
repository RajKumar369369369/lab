package lab;
import java.util.Scanner;

public class Daily_driving_cost {
	private double totalmilesperday;
	private double costpergallon;
	private double milespergallon;
	private double averagefees;
	private double tolls;
	public Daily_driving_cost(double totalmilesperday,double costpergallon,double milespergallon,double averagefees,double tolls){
		this.totalmilesperday=totalmilesperday;
		this.costpergallon=costpergallon;
		this.milespergallon=milespergallon;
		this.averagefees=averagefees;
		this.tolls=tolls;
	}
	public double daily_cost() {
		double fuelcost=(totalmilesperday/milespergallon)*costpergallon;
		return fuelcost+averagefees+tolls;
	}
	public void displaycost() {
		System.out.println("Total daily driving cost is $"+daily_cost());
	}
	public static void main(String[] args) {
		Scanner myObj=new Scanner(System.in);
		System.out.println("enetr the totalmilesperday");
		double totalmilesperday=myObj.nextDouble();
		System.out.println("enetr the costpergallon");
		double costpergallon=myObj.nextDouble();
		System.out.println("enetr the milespergallon");
		double milespergallon=myObj.nextDouble();
		System.out.println("enetr the averagefees");
		double averagefees=myObj.nextDouble();
		System.out.println("enetr the tolls");
		double tolls=myObj.nextDouble();
		Daily_driving_cost day1=new Daily_driving_cost(totalmilesperday,costpergallon,milespergallon,averagefees,tolls);
		day1.displaycost();
	}
}
