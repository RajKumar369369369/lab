package FigPackage;
import java.lang.Math;
public class cone extends figure{
	private double s;
	private double h;
	public cone(double r,double s) {
		this.r=r;
		this.s=s;
		h=s*s-r*r;
		h=Math.pow(h,0.5);
	}
	public void calcArea() {
		a=(pi*r*s)+(pi*r*r);
	}
	public void calcVolume() {
		v=(pi*r*r*s)/3;
	}
	public void dispArea() {
		calcArea();
	System.out.println("Area of the cone is : "+a+" units");
	}
	public void dispVolume() {
		calcVolume();
	System.out.println("Volume of the cone is : "+v+" units");
	}
}
