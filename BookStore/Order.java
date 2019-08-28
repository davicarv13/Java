package BookStore;

public class Order implements TaxCalc{

	private Date orderDate;
	private Book book;
	private int quantity;
	private double price;
	private User user;

	public Order(Date orderDate, Book book, int quantity, User user){
		this.orderDate = orderDate;
		this.book = book;
		this.quantity = quantity;
		this.price = (book.getPrice() * quantity);
		this.price += this.calcTax(this.price);
		this.user = user;
	}

	public Date getOrderDate(){
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

	public User getUser(){
		return this.user;
	}

	public double calcTax(double price){
		return price * 0.1;
	}
}