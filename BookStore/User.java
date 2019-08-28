package BookStore;

public abstract class User{
	protected String name;
	protected String cpf;
	protected String pass;
	protected String accountType;

	public String getName(){
		return this.name;
	}

	public String getCpf(){
		return this.cpf;
	}

	public String getPass(){
		return this.pass;
	}

	public String getAccountType(){
		return this.accountType;
	}

	public boolean setPass(String oldPass, String newPass){
		if(oldPass.equals(this.pass)){
			this.pass = newPass;
			return true;
		}
		else{
			return false;
		}
	}

	public Order buyBook(BookList bookList, String isbn, int quantity, User user, Date orderDate){

		if(bookList.getSize() == 0){
			return null;
		}
		else{
			for(int j = 0; j < bookList.getSize(); j++){

				if(isbn.equals(bookList.getBook(j).getIsbn())){

					if(quantity <= bookList.getBook(j).getQuantity()){

						Order newOrder = new Order(orderDate, bookList.getBook(j), quantity, user);
						bookList.getBook(j).setQuantity(bookList.getBook(j).getQuantity() - quantity);
						return newOrder;
					}
					else{

						return null;
					}
				}
			}
		}

		return null;
	}
}