package lab;

public class Date {
	private int date;
	private int month;
	private int year;
	public Date(int date,int month,int year) {
		setdate(date);
		setmonth(month);
		setyear(year);
	}
	public void setdate(int date) {
		if(date>0)
		this.date=date;
	}
	public void setmonth(int month) {
		if(month<=12 && month>0)
		if((month==2 && date<=29) || (month%7%2==1 && date<=31) || (month%7%2==0 && date<=30))
		this.month=month;
	}
	public void setyear(int year) {
		if(!(year%400==0 || year%100!=0 && year%4==0))
			if(month==2 && date<=28)
		       this.year=year;
	}
	public int getdate() {
		return date;
	}
	public int getmonth() {
		return month;
	}
	public int getyear() {
		return year;
	}
	public void date() {
		if(month==0 || date==0|| year==0) System.out.println("the given date is not a valid date");
		else System.out.println(date+"/"+month+"/"+year);
	}
}
