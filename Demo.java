package FigPackage;

public class Demo {
	public static void main(String[] args) {
		cone c1=new cone(10,5);
		c1.dispArea();
		c1.dispVolume();
		Sphere c2=new Sphere(10);
		c2.dispArea();
		c2.dispVolume();
		cylinder c3=new cylinder(10,5);
		c3.dispArea();
		c3.dispVolume();
	}
}
