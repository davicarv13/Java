package BookStore;

import java.util.ArrayList;

public class OrderList{

	ArrayList <Order> orderList = new ArrayList <Order>();

	public Order getOrder(int i){
		return this.orderList.get(i);
	}

	public void addOrder(Order newOrder){
		this.orderList.add(newOrder);
	}
}