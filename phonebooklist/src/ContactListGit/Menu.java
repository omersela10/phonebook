package ContactListGit;


import java.util.*;
import java.io.*;

// Group Serial Number: 1

// Ahigad Genish  316228022
// Omer Sela      316539535	
// Shir Cohen     314624040
// Almog Sharoni  208611764 
// Yakov Avitan   205517089

public class Menu {

	public static void main(String[] args) {
		
		// Hello message
		System.out.println("Welcome to our Phone Book application!");
		
		// Create ContactList instance
		ContactList ourList = new ContactList();
		
		// Start application
		startApp(ourList);
		
		return;
	}
	
	
		
	// Print the menu and choose options.
	public static void startApp (ContactList ourList) {

		Scanner scanner = new Scanner(System.in);
		
		boolean exit = false;

	
	    while (exit == false) {
	    	 
	    	printOptions();
	    	
		    String option = scanner.next();
		    scanner.nextLine(); 

		    switch (option) {

			    case "1":
				// Add Contact
				System.out.println("Enter name:");
				String name = scanner.nextLine();
				System.out.println("Enter phone number:");
				String phone = scanner.nextLine();
				
				Contact newContact = new Contact(name, phone);
				ourList.addContact(newContact);
				break;

			    case "2":
				// Remove contact
				System.out.println("Enter name:");
				name = scanner.nextLine();
				ourList.removeContact(name);
				break;

			    case "3":
				// Print Phone Book
				ourList.printList();
				break;

			    case "4":
				// Search contact in the list.
				System.out.println("Enter name:");
				name = scanner.nextLine();
				ourList.searchByName(name);
				break;

			    case "5":
				// Sort list by name
				ourList.sortListByName();
				break;

			    case "6":
				// Sort list by phone number
				ourList.sortListByPhoneNumber();
				break;

			    case "7":
				// Remove duplicates
				ourList.removeDuplicate();
				break;

			    case "8":
				// Reverse list.
				ourList.reverse();
				break;

			    case "9":
				// Save Phone book to file
				System.out.println("Enter file name:");
				String filename = scanner.nextLine();
				ourList.exportPhoneBook(filename);
				break;

			    case "10":
				// Load and append from file.
				System.out.println("Enter file name:");
				filename = scanner.nextLine();
				ourList.importAndAppendPhoneBook(filename);
				break;

			    case "11":
				// Exit.
				System.out.println("Exiting...");
				exit = true;
				break;

			    default:
				System.out.println("Invalid option. Try again.");
			}

		}
	       
	}
	
	// Print Options
	public static void printOptions() {
		
		 // Print options
		System.out.println("Enter an option:");
		System.out.println("1. Add a contact");
		System.out.println("2. Delete a contact");
		System.out.println("3. Print all contacts");
		System.out.println("4. Search for a contact");
		System.out.println("5. Sort phone book by name");
		System.out.println("6. Sort phone book by phone");
		System.out.println("7. Remove duplicates");
		System.out.println("8. Reverse order");
		System.out.println("9. Save to file");
		System.out.println("10. Load from file");
		System.out.println("11. Exit");

	}

}
