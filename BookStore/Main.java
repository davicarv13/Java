package BookStore;

import javax.swing.*;

public class Main{

	public static int indexMenu(){
		int op;

		op = Integer.parseInt(JOptionPane.showInputDialog("-----Index Menu-----\n1 - Client\n2 - Employee\n3 - Manager\n0 - Close\n"));

		return op;
	}

	public static int loginMenu(){
		int op;
		
		op = Integer.parseInt(JOptionPane.showInputDialog("1 - Signin\n2 - Login\n-1 - Go back"));			

		return op;	
	}

	public static int managerMenu(){

		int op;

		op = Integer.parseInt(JOptionPane.showInputDialog("1 - Sign book\n2 - Remove book\n3 - List books\n-1 - Go back"));

		return op;
	}

	public static int employeeMenu(){
		int op;

		op = Integer.parseInt(JOptionPane.showInputDialog("1 - Sign book\n2 - Remove book\n3 - List books\n-1 - Go back"));

		return op;	
	}

	public static int clientMenu(){
		int op;

		op = Integer.parseInt(JOptionPane.showInputDialog("1 - List books\n2 - Buy book\n\n-1 - Go back"));

		return op;
	}

	public static User clientLogin(UserList userList, String accountType){

		String cpf, pass, message;

		if(userList.getSize() == 0){

			JOptionPane.showMessageDialog(null, "There's no one signed in system now");
			return null;
		}
		else{

			cpf = JOptionPane.showInputDialog("Enter your CPF:");

			pass = JOptionPane.showInputDialog("Enter your pass:");

			for(int j = 0; j < userList.getSize(); j++){

				if(cpf.equals(userList.getUser(j).getCpf())){

					if(accountType.equals(userList.getUser(j).getAccountType())){

						if(pass.equals(userList.getUser(j).getPass())){

							return userList.getUser(j);	
						}	
						else{

							JOptionPane.showMessageDialog(null, "Password is wrong");
							return null;
						}
					}
					else{

						message = String.format("You are not a " + accountType);
						JOptionPane.showMessageDialog(null, message);
						return null;
					}
				}
			}
		}

		return null;
	}

	public static boolean clientSignin(UserList userList, String accountType){

		String name, cpf, pass, shipName, shipAddress;

		name = JOptionPane.showInputDialog("Enter your name");
		cpf = JOptionPane.showInputDialog("Enter your CPF");


		for(int j = 0; j < userList.getSize(); j++){

			if(cpf.equals(userList.getUser(j).getCpf())){

				JOptionPane.showMessageDialog(null, "This CPF is already signed in\n");
				return false;
			}
		}

		shipName = JOptionPane.showInputDialog("Enter the ship name");
		shipAddress = JOptionPane.showInputDialog("Enter the ship address");
		pass = JOptionPane.showInputDialog("Enter the password");

		Client newClient = new Client(name, cpf, pass, shipName, shipAddress, accountType);
		userList.addUser(newClient);
		return true;
	}

	public static User employeeLogin(UserList userList, String accountType){

		String cpf, pass, message;

		if(userList.getSize() == 0){

			JOptionPane.showMessageDialog(null, "There's no one signed in system now");
			return null;
		}
		else{

			cpf = JOptionPane.showInputDialog("Enter your CPF:");

			pass = JOptionPane.showInputDialog("Enter your pass:");

			for(int j = 0; j < userList.getSize(); j++){

				if(cpf.equals(userList.getUser(j).getCpf())){

					if(accountType.equals(userList.getUser(j).getAccountType())){

						if(pass.equals(userList.getUser(j).getPass())){

							return userList.getUser(j);	

						}	
						else{

							JOptionPane.showMessageDialog(null, "Password is wrong");
							return null;
						}
					}
					else{

						message = String.format("You are not a " + accountType);
						JOptionPane.showMessageDialog(null, message);
						return null;
					}
				}
			}
		}

		return null;
	}

	public static boolean employeeSignin(UserList userList, String accountType, String systemPass){

		for(int j = 0; j < userList.getSize(); j++){

			if(accountType.equals("Manager")){

				JOptionPane.showMessageDialog(null, "There's already a manager signed in\n");
				return false;
			}
		}

		String pass = JOptionPane.showInputDialog("Enter the system's pass");

		if(systemPass.equals(pass)){

			String name = JOptionPane.showInputDialog("Enter the name");
			String cpf = JOptionPane.showInputDialog("Enter the CPF");

			for(int j = 0; j < userList.getSize(); j++){

				if(cpf.equals(userList.getUser(j))){

					JOptionPane.showMessageDialog(null, "This CPF is already signed in\n");
					
					return false;
				}
			}	

			pass = JOptionPane.showInputDialog("Enter the password");
			double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter the salary"));

			Employee newEmployee = new Employee(name, cpf, pass, salary, accountType);
			userList.addUser(newEmployee);

			return true;

		}
		else{

			JOptionPane.showMessageDialog(null, "Password is wrong\n");
			return false;

		}

	}

	public static Book addNewBook(){

		String title = JOptionPane.showInputDialog("Enter book's title:");

		String isbn = JOptionPane.showInputDialog("Enter book's isbn:");

		double price = Double.parseDouble(JOptionPane.showInputDialog("Enter book's price:"));

		int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter book's quantity:"));

		Book newBook = new Book(title, isbn, price, quantity);

		return newBook;
	}

	public static void main(String[] args){

		int op;

		String systemPass = "Lover23";

		BookList bookList = new BookList();
		Book book;
		UserList userList = new UserList();
		User user;
		OrderList orderList = new OrderList();

		do{
			op = indexMenu();

			switch(op){

				case 1:

					op = loginMenu();

					switch(op){
						case 1:
							if(clientSignin(userList, "Client") == true){

							 	JOptionPane.showMessageDialog(null, "Client has been added");

							 }
							 else{

							 	JOptionPane.showMessageDialog(null, "Client has not been added");
							}
						break;

						case 2:

							User client = clientLogin(userList, "Client");

							if(client != null){
								do{
									op = clientMenu();

									switch(op){

										case 1: //List Books

											String bookInfo = bookList.listBooks();

											JOptionPane.showMessageDialog(null, bookInfo);

										break;

										case 2: //Buy book

											String isbn = JOptionPane.showInputDialog("Enter the ISBN");

											int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter the quantity"));

											int day = Integer.parseInt(JOptionPane.showInputDialog("Enter the day"));

											int month = Integer.parseInt(JOptionPane.showInputDialog("Enter the month"));

											int year = Integer.parseInt(JOptionPane.showInputDialog("Enter the year"));

											Date orderDate = new Date(day, month, year);

											Order newOrder = client.buyBook(bookList, isbn, quantity, client, orderDate);

											String message;

											if(newOrder != null){
												message = String.format("Order price" + newOrder.getPrice() + "\nDate :" + newOrder.getOrderDate().getDay() + "/" + newOrder.getOrderDate().getMonth() +  "/" + newOrder.getOrderDate().getYear());
												JOptionPane.showMessageDialog(null, message);												
											}
											else{
												message = "Error. ISBN not found or book's quantity is not enough\n";
												JOptionPane.showMessageDialog(null, message);												
											}

										break;
									}

								}while(op != -1);

							}							
						break;
					}

				break;

				case 2:

					op = loginMenu();

					switch(op){
						case 1:

							if(employeeSignin(userList, "Employee", systemPass) == true){

							 	JOptionPane.showMessageDialog(null, "Employee has been added");

							 }
							 else{

							 	JOptionPane.showMessageDialog(null, "Employee has not been added");
							 }

						break;

						case 2:

							User employee = employeeLogin(userList, "Employee");

							if(employee != null){
								do{
									op = employeeMenu();

									switch(op){
										case 1: //Add Book

											Book newBook = addNewBook();
											bookList.addBook(newBook);

										break;

										case 2: //Remove Book

											if(bookList.removeBook(JOptionPane.showInputDialog("Enter ISBN:")) == true){
												JOptionPane.showMessageDialog(null, "Book has been deleted");
											}
											else{
												JOptionPane.showMessageDialog(null, "This ISBN is not signed in");
											}
										break;
										case 3: //List Books

											String bookInfo = bookList.listBooks();

											JOptionPane.showMessageDialog(null, bookInfo);

										break;
										case 4:
											
										break;
									}

								}while(op != -1);
							}
						break;
					}
				break;

				case 3:

					op = loginMenu();

					switch(op){
						case 1:

							 if(employeeSignin(userList, "Manager", systemPass) == true){

							 	JOptionPane.showMessageDialog(null, "Manager has been added");

							 }
							 else{

							 	JOptionPane.showMessageDialog(null, "Manager has not been added");

							 }

						break;

						case 2:

							User manager = employeeLogin(userList, "Manager");	

							if(manager != null){
								do{
									op = managerMenu();

									switch(op){
										case 1: //Add Book

											Book newBook = addNewBook();
											bookList.addBook(newBook);

										break;

										case 2: //Remove Book

											if(bookList.removeBook(JOptionPane.showInputDialog("Enter ISBN:")) == true){
												JOptionPane.showMessageDialog(null, "Book has been deleted");
											}
											else{
												JOptionPane.showMessageDialog(null, "This ISBN is not signed in");
											}
										break;

										case 3: //List Books

											String bookInfo = bookList.listBooks();

											JOptionPane.showMessageDialog(null, bookInfo);

										break;

										case 4:
											
										break;
									}
								}while(op != -1);
							}

						break;
					}
				break;
			}
		}while(op != 0);
	}
}
