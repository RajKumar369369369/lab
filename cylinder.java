package FigPackage;

public class cylinder extends figure{
	private double h;
	public cylinder(double r,double h) {
		this.h=h;
		this.r=r;
	}
	public void calcArea() {
		a=(2*pi*r*r)+(2*pi*r*h);
	}
	public void calcVolume() {
		v=(pi*r*r*h);
	}
	public void dispArea() {
		calcArea();
	System.out.println("Area of the Cylinder is : "+a+" units");
	}
	public void dispVolume() {
		calcVolume();
	System.out.println("Volume of the Cylinder is : "+v+" units");
	}
}

