package BookStore;

public class Order implements TaxCalc{

	private Date orderDate;
	private Book book;
	private int quantity;
	private double price;
	private Client client;

	public Order(Date orderDate, Book book, int quantity, double price, Client client){
		this.orderDate = orderDate;
		this.book = book;
		this.quantity = quantity;
		this.price = (book.getPrice() * price) + this.calcTax(price);
		this.client = client;
	}

	public Date getDate(){
		return this.orderDate;
	}

	public Book getBook(){
		return this.book;
	}

	public int getQuantity(){
		return this.quantity;
	}

	public double getPrice(){
		return this.price;
	}

	public Client getClient(){
		return this.client;
	}

	public double calcTax(double price){
		return price * 0.1;
	}
}