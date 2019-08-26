package BookStore;

public class Book implements TaxCalc{
	private String title;
	private String isbn;
	private double price;
	private int quantity;

	public Book(String title, String isbn, double price, int quantity){
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.quantity = quantity;
	}

	public String getTitle(){
		return this.title;
	}

	public String getIsbn(){
		return this.isbn;
	}

	public double getPrice(){
		return this.price;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public int getQuantity(){
		return this.quantity;
	}

	public double calcTax(){
		return this.price * 0.075;
	}
}