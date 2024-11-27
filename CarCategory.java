package lab;

public class CarCategory {
	private String category;
	public CarCategory(String category) {
		this.category=category.toUpperCase();
	}
	public String determine() {
		if(category.equals("SUV")) return "TATA SAFARI";
		else if(category.equals("SEDAN"))	return "TATA INDIGO";
		else if(category.equals("ECONOMY"))	return "TATA INDICA";
		else if(category.equals("MINI"))	return "TATA NANO";
		return "no valid category";
	}
	public static void main(String[] args) {
		CarCategory c1=new CarCategory("sedan");
		System.out.println(c1.determine());
		CarCategory c2=new CarCategory("suv");
		System.out.println(c2.determine());
		CarCategory c3=new CarCategory("economy");
		System.out.println(c3.determine());
		CarCategory c4=new CarCategory("mini");
		System.out.println(c4.determine());
		CarCategory c5=new CarCategory("sedankwyuefdglqu");
		System.out.println(c5.determine());
	}
}
