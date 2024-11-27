package lab;

public class InvoiceTest {
	private String part_no;
	private String description;
	private int quantity;
	private double price;
	public InvoiceTest(String part_no,String description,int quantity,double price) {
		setpartno(part_no);
		setdescription(description);
		setquantity(quantity);
		setprice(price);
	}
	public void setpartno(String part_no) {
		this.part_no=part_no;
	}
	public void setdescription(String description) {
		this.description=description;
	}
	public void setquantity(int quantity) {
		if(quantity>0) this.quantity=quantity;
		else this.quantity=0;
	}
	public void setprice(double price) {
		if(price>0) this.price=price;
		else this.price=0;
	}
    public String getpartno() {
    	return part_no;
    }
    public String getdescription() {
    	return description;
    }
    public int getquantity() {
    	return quantity;
    }
    public double getprice() {
    	return price;
    }
    public double getinvoiceamount() {
    	return quantity*price;
    }
}
