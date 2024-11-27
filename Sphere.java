package FigPackage;

public class Sphere extends figure{
	public Sphere(double r) {
		this.r=r;
	}
	public void calcArea() {
		a=(4*pi*r*r);
	}
	public void calcVolume() {
		v=(4*pi*r*r*r);
	}
	public void dispArea() {
		calcArea();
	System.out.println("Area of the Sphere is : "+a+" units");
	}
	public void dispVolume() {
		calcVolume();
	System.out.println("Volume of the Sphere is : "+v+" units");
	}
}
