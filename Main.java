package librarybookmanagement;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		menu();

	}

	private static void menu() {
		
		String choice;
		do {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("\n\n==========Library Management===========");
			System.out.println("1. Insert books.");
			System.out.println("2. View All Books.");
			System.out.println("3. Delete Book");
			System.out.println("4. Check Book.");
			System.out.println("5. Issue Book.");
			System.out.println("6. View Issued History");
			System.out.println("7. Exit.");
			
			System.out.println("\nEnter your option : ");
			int option = sc.nextInt();
			
			switch(option) {
			case 1:
				insertBook();
				break;
			case 2:
				viewAllBooks();
				break;
			case 3:
				deleteBook();
				break;
			case 4:
				checkBook();
				break;
			case 5:
				issueBook();
				break;
			case 6:
				viewIssuedHistory();
				break;
			case 7:
				System.out.println("\n\nGoodBye!!!");
				System.exit(0);
				break;
			default:
				System.out.println("\n\nEnter a valid Character!!!");
				menu();
				break;
			}
			
			System.out.println("\nDo you want to see menu again? Y/N");
			sc.nextLine();
			choice = sc.nextLine();
			
			if(!choice.equalsIgnoreCase("y")) {
				System.out.println("\nGoodBye!!!");
				System.exit(0);
			}
			
		}while(choice.equalsIgnoreCase("y"));
		
		
	}

	

	private static void insertBook() {
		
		System.out.println("\n\n=========Insert Books=========");
		Scanner sc = new Scanner(System.in);
		
		int bookNo;
		int quantity;
		String bookName, author, publisher;
		
		System.out.println("Enter Book No. : ");
		bookNo = sc.nextInt();
		System.out.println("Enter Book Name : ");
		sc.nextLine();
		bookName = sc.nextLine();
		System.out.println("Enter Book Author : ");
		author = sc.nextLine();
		System.out.println("Enter Book Publisher : ");
		publisher = sc.nextLine();
		System.out.println("Enter Book Quantity : ");
		quantity = sc.nextInt();
		
		int status = BookDB.save(bookNo, bookName, author, publisher, quantity);
		
		if (status == 1) {
			System.out.println("Book inserted Successfully!!!");
			
		} else {
			System.out.println("Book didn't inserted.");
		}
		
		
	}
	
	private static void viewAllBooks() {

		System.out.println("\n\n===========All Books========");
		BookDB.viewBooks();
		
	}
	

	private static void checkBook() {
		System.out.println("\n\n==========Check Book========");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book no. to find : ");
		int bookNo = sc.nextInt();
		IssueBookDB.checkBook(bookNo);
		
	}
	
	

	private static void issueBook() {
		
		System.out.println("\n\n=========Issue Books=========");
		Scanner sc = new Scanner(System.in);
		
		int bookNo;
		int studentID;
		String studentName, studentContact;
		
		System.out.println("Enter Book No. : ");
		bookNo = sc.nextInt();
		System.out.println("Enter Student ID : ");
		studentID = sc.nextInt();
		System.out.println("Enter Student Name : ");
		sc.nextLine();
		studentName = sc.nextLine();
		System.out.println("Enter Student contact : ");
		studentContact = sc.nextLine();
		
		int status = IssueBookDB.save(bookNo, studentID, studentName, studentContact);
//		System.out.println(status);
		
		if (status == 1) {
			System.out.println("Book issued Successfully!!!");
			
		} else {
			System.out.println("Book didn't issued.");
		}
		
	}
	
	private static void viewIssuedHistory() {
		
		System.out.println("\n\n==========View Issued History=========");
		IssueBookDB.viewIssuedHistory();
		
	}

	private static void deleteBook() {

		int status;
		System.out.println("\n\n==========Delete Book=========");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book no. to delete : ");
		int bookNo = sc.nextInt();
		status = BookDB.deleteBook(bookNo);
//		System.out.println(status);
		
		if (status == 1) {
			System.out.println("Book deleted Successfully!!!");
			
		} else {
			System.out.println("Book didn't delete.");
		}
	}

}
