package lab;

import java.util.Scanner;
public class DateTest {
	public static void main(String[] args) {
		Scanner myobj=new Scanner(System.in);
		System.out.println("enter the date");
		Date d1=new Date(myobj.nextInt(),myobj.nextInt(),myobj.nextInt());
		d1.date();
	}
}
