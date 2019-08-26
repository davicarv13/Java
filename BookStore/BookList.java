package BookStore;

import java.util.ArrayList;

public class BookList{
	private ArrayList <Book> bookList = new ArrayList <Book>();

	public boolean addBook(Book newBook){
		for(int i = 0; i < this.bookList.size(); i++){
			if(newBook.getIsbn().equals(this.bookList.get(i).getIsbn())){
				return false;
			}
		}

		this.bookList.add(newBook);

		return true;
	}

	public boolean removeBook(String isbn){
		for(int i = 0; i  < bookList.size(); i++){
			if(isbn.equals(this.bookList.get(i).getIsbn())){
				this.bookList.remove(i);
				return true;
			}
		}

		return false;	
	}

	public int getSize(){
		return this.bookList.size();
	}

	public Book getBook(int i){
		return this.bookList.get(i);
	}

	public String listBooks(){
		String bookInfo = "";

		if(this.bookList.size() == 0){
			bookInfo = "There's no books signed in";
		}
		else{
			for(int j = 0; j < this.bookList.size(); j++){

				bookInfo += String.format("Title:" + this.bookList.get(j).getTitle() + "\nISBN: " + this.bookList.get(j).getIsbn() + "\nPrice: " + Double.toString(this.bookList.get(j).getPrice()) + "\nQuantity: " + Integer.toString(this.bookList.get(j).getQuantity()) + "\n\n");	
			}	
		}

		return bookInfo;
		
	}
	

}