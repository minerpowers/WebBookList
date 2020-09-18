import java.util.List;
import java.util.Scanner;

import Controller.BookEntityHelper;
import Model.BookEntity;
public class runProgram {
	static Scanner in = new Scanner(System.in);
	static BookEntityHelper beHelper = new BookEntityHelper();
	
	public static void main(String[] args) {
		System.out.println("    -- Welcome to the book list --");
		runMenu();
	}
	/****************************
	 * 	runMenu
	 ****************************/
	public static void runMenu() {
		boolean again = true;
		while (again) {
			System.out.println("\t----- Main Menu -----");
			System.out.println("\tSelect an item number:");
			System.out.println("\t  1 - Add a book");
			System.out.println("\t  2 - Delete a book");
			System.out.println("\t  3 - Update a book");
			System.out.println("\t  4 - View all books");
			System.out.println("\t  5 - Exit program");
			System.out.print("\tEnter selection:  ");
			int select = in.nextInt();
			in.nextLine();
			
			if(select==1) {
				addBook();
			} else if (select==2) {
				deleteBook();
			} else if (select==3) {
				updateBook();
			} else if (select==4) {
				printBooks();
			} else {
				beHelper.cleanUp();
				System.out.println("\tExit program\n\tGoodbye");
				again = false;
			}
		}
	}
	/****************************
	 * 	printBooks
	 ****************************/
	private static void printBooks() {
		List<BookEntity> allBooks = beHelper.showAllBooks();
		for(BookEntity it : allBooks) {
			int number = allBooks.indexOf(it)+1;
			System.out.println("  "+number+": "+it.print());
		}
	}
	/****************************
	 * 	addBook
	 ****************************/
	private static void addBook() {
		System.out.println("\t---- Add Book -----");
		System.out.print("\tEnter book title:   ");
		String title = in.nextLine();
		System.out.print("\tEnter Author's first name:  ");
		String firstName = in.nextLine();
		System.out.print("\tEnter Author's last name:   ");
		String lastName = in.nextLine();
		System.out.print("\tEnter 10 digit ISBN number: ");
		String isbn = in.nextLine();
		BookEntity addBook = new BookEntity(title, firstName,lastName, isbn);
		beHelper.insertBook(addBook);
	}
	/****************************
	 * 	deleteBook
	 ****************************/
	private static void deleteBook() {
		System.out.println("\t---- delete Book -----");
		List <BookEntity> bookList = selectBy();
		if (!bookList.isEmpty()) {
			for(BookEntity it : bookList) {
				int number = bookList.indexOf(it)+1;
				System.out.println("   "+number+": "+it.print());
			}
			System.out.print("\tSelect book to delete: ");
			int deleteNum = in.nextInt();
			in.nextLine();
			beHelper.deleteBook(bookList.get(deleteNum-1));
		} else {
			return;
		}
	}
	/****************************
	 * 	updateBook
	 ****************************/
	private static void updateBook() {
		System.out.println("\t---- update Book -----");
		List <BookEntity> bookList = selectBy();
		if (!bookList.isEmpty()) {
			for(BookEntity it : bookList) {
				int number = bookList.indexOf(it)+1;
				System.out.println("   "+number+": "+it.print());
			}
			System.out.print("\tSelect book to update: ");
			int updateNum = in.nextInt();
			in.nextLine();
			BookEntity toEdit = beHelper.findIsbn(bookList.get(updateNum-1).getIsbn10());
			boolean moreEdits = true;
			while(moreEdits) {
				System.out.println("\t---- updating -----");
				System.out.println(toEdit.print());
				System.out.println("\t  1 - Update first name");
				System.out.println("\t  2 - Update last name");
				System.out.println("\t  3 - Update title");
				System.out.println("\t  4 - Update isbn");
				System.out.println("\t  5 - Exit update");
				System.out.print("\tSelect update:  ");
				int select = in.nextInt();
				in.nextLine();
				if (select == 1) {
					System.out.print("\tEnter new first name:  ");
					String firstName = in.nextLine();
					toEdit.setFirstName(firstName);
				} else if (select == 2) {
					System.out.print("\tEnter new last name:  ");
					String lastName = in.nextLine();
					toEdit.setLastName(lastName);
				} else if (select == 3) {
					System.out.print("\tEnter new title:  ");
					String title = in.nextLine();
					toEdit.setTitle(title);
				} else if (select == 4) {
					System.out.print("\tEnter new 10 digit isbn:  ");
					String isbn = in.nextLine();
					toEdit.setIsbn10(isbn);
				}else {
					moreEdits = false;
				}
				beHelper.updateBook(toEdit);
			}
		} else {
			return;
		}
	}
	/****************************
	 * 	selectBy
	 ****************************/
	private static List<BookEntity> selectBy(){
		System.out.println("\tHow would you like to search?");
		System.out.println("\t  1 - Search by last name");
		System.out.println("\t  2 - Search by title");
		System.out.print("\tEnter search selection:  ");
		int searchBy = in.nextInt();
		in.nextLine();
		List<BookEntity> bookList;
		if(searchBy==1) {
			System.out.print("\tEnter author's last name:  ");
			String lastName = in.nextLine();
			bookList = beHelper.searchByLastName(lastName);
		}else {
			System.out.print("\tEnter title:  ");
			String title = in.nextLine();
			bookList = beHelper.searchByTitle(title);
		}
		if(!bookList.isEmpty()) {
			System.out.println("\t--- Found "+bookList.size()+" Results ---");
		} else {
			System.out.println("\t-- No results found --");
		}
		return bookList;
	}
}
