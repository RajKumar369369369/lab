package lab;

public class Invoice {
	public static void main(String[] args) {
		InvoiceTest invoice1=new InvoiceTest("A123","Hammer",5,20.99);
		System.out.println("Part Number : "+invoice1.getpartno());
		System.out.println("Description : "+invoice1.getdescription());
		System.out.println("quantity : "+invoice1.getquantity());
		System.out.println("Price per item $"+invoice1.getprice());
		System.out.println("Invoice Amount $"+invoice1.getinvoiceamount());
		System.out.println();
		InvoiceTest invoice2=new InvoiceTest("B456","screwdriver",-3,-10.5);
		System.out.println("Part Number : "+invoice2.getpartno());
		System.out.println("Description : "+invoice2.getdescription());
		System.out.println("quantity : "+invoice2.getquantity());
		System.out.println("Price per item $"+invoice2.getprice());
		System.out.println("Invoice Amount $"+invoice2.getinvoiceamount());
		System.out.println();
	}

}
