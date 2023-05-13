package ContactListGit;

import java.util.*;
import java.io.*;

public class ContactList {

	// Data Members
	private ContactNode headList;
	
	// Constructor
	public ContactList() {
		
		this.headList = null;
	}
	
	// Getter
	public ContactNode getHead() {
		
		return this.headList;
	}
	
	// Setter
	public void setHead(ContactNode newHead) {
		
		this.headList = newHead;
	}
	
	// Methods : 
	
	// Add contact 
	public void addContact(Contact anyContact) {
		
		ContactNode newNode = new ContactNode(anyContact);
		
		// If the list is empty
		if(this.getHead() == null) {
			
			this.setHead(newNode);
			return;
		}
		
		// Else, there is at least one on the list, so the newNode will be first with reference to the current head.
		newNode.setNext(this.getHead());
		this.setHead(newNode);
		
	}
	
	// Iterator
	public ContactNode getIterator() {
		
		ContactNode temp = this.getHead();
		return temp;		
	}
	
	
	// Remove contact
	public void removeContact (String name) {
		
		boolean anyName = false;
		
		ContactNode iterator = this.getIterator();
		ContactNode prev = null;
		
		while(iterator != null) {
			
			if(iterator.getContact().getName().equals(name) == true) {
				
				// Found

				if(iterator.getContact().equals(this.getHead().getContact())) {
					// It is the first in the list
					this.setHead(iterator.getNext());
				}
				else {
					// This is not the first, so previous is not null
					prev.setNext(iterator.getNext());
				}
				
				anyName = true;
				break;
			}
			// Update references
			prev = iterator;
			iterator = iterator.getNext();
		}
		
		// Print result
		if (anyName == false) {
			System.out.println(name + " does not exist in the contact list.");
		}
		else {
			System.out.println(name + " removed from contact list.");
		}
		
	}
	
	// Print list
	public void printList () {
		
		System.out.println("The Phone Book: ");
		
		if(this.getHead() == null) {
			
			System.out.println("Phone Book is empty");
			return;
		}
		ContactNode iterator = this.getIterator();
		
		while(iterator != null) {
			
			System.out.println(iterator.getContact());
			// Update references.
			iterator = iterator.getNext();
		}
		
	}
	
	// Search for name in the Phone Book
	public void searchByName (String name) {
		
		boolean exist = false;

		ContactNode iterator = this.getIterator();
		
		while(iterator != null) {
			
			if(iterator.getContact().getName().equals(name) == true) {
				
				// Found.
				System.out.println(iterator.getContact());
				exist = true;
			}
			// Update references.
			iterator = iterator.getNext();
		}
		
		if (exist == false) {
			System.out.println( name + " does not in the contact list.");
		}
		
	}
	
	// Sort List By name. Heap Sort
	public void sortListByName () {
		
		// Initialize the comparator 
		ContactNameComparator sortByName = new ContactNameComparator();
		// Sort By name
		this.sort(sortByName);
	}
	
	// Sort List By Phone Number. Heap Sort
	public void sortListByPhoneNumber () {
		
		// Initialize the comparator
		ContactPhoneComparator sortByPhone = new ContactPhoneComparator();
		// Sort By phone number
		this.sort(sortByPhone);
	}
	
	// Generic HeapSort function O(nlogn), get the comparator object and sort - Strategy Design Pattern.
	private void sort(Comparator<ContactNode> anyCompare) {
		
		// If the list empty, no need to sort.
		if(this.getHead() == null) {
			return;
		}
		
		// Initialize the heap by the comparator.
		PriorityQueue<ContactNode> heap = new PriorityQueue<ContactNode>(anyCompare);
		
		// Initialize the iterator
		ContactNode iterator = this.getIterator();
		
		// Insert the contact to a priority queue.
		while(iterator != null) {
			
			heap.add(iterator);
			iterator = iterator.getNext();
		}
		
		this.setHead(heap.poll());
		iterator = this.getIterator();
		
		// Pop the contacts by name order and build the new sorted list.
		while(heap.isEmpty() == false) {
			
			// Retrieve the top
			ContactNode top = heap.poll();
			
			// Update list
			iterator.setNext(top);
			
			// Update references.
			iterator = iterator.getNext();
		}
		
		// Set the last next to null;
		iterator.setNext(null);
	}
	
	// Remove duplicates in the list.
	public void removeDuplicate () {
		
		// Initialize hash table to store which contact we already seen.
		Map<Contact, Boolean> seen = new HashMap<Contact, Boolean>();
		
		// Initialize iterator and previous to scan the list.
		ContactNode iterator = this.getIterator();
		ContactNode prev = null;
		
		while(iterator != null) {
			
			ContactNode anyContactNode = iterator;
			
			if (seen.containsKey(anyContactNode.getContact()) == true) {
				// Previous not null because at first time we didn't see any duplicate so remove
				prev.setNext(anyContactNode.getNext());
			}
			else {
				// Insert to the hash if not seen already.
				seen.put(anyContactNode.getContact(), true);
				
				// When no remove, Update previous reference
				prev = iterator;
			}
			
			// Update references.
			iterator = iterator.getNext();
		}
	}

	// Reverse list by recursion
	private ContactNode reverse(ContactNode head) {
		
		// Initialize the new head reference.
		ContactNode newHead = null;
		
		// Stopping condition
		if(head == null || head.getNext() == null) {
			return head;
		}
		
		// Reach the last one and update recursively their next.
		newHead = reverse(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		
		// The newHead reach the last one, so return it as new head.
		return newHead;
		
	}
	
	// Reverse list function
	public void reverse() {
		
		ContactNode iterator = this.getIterator();
		this.setHead(this.reverse(iterator));
	}
	
	//Import phoneBook from txt file
	public void importAndAppendPhoneBook(String filePath) {
		
		try {
		// Initialize File Object and Scanner Object
	        File file = new File(filePath);
	        Scanner scanner = new Scanner(file);
	        
	        // Initialize iterator to scan the list.
	        ContactNode iter = this.getIterator();
	        
	        while (iter != null) {
	        	
	        	// Get the current line in the file
	            String line = scanner.nextLine();
	            
	            // Split by spaces
	            String[] fields = line.split(" ");
	            // The format is : (Name: name Phone: phone) So retrieve the 1 and 3 places.
	            String name = fields[1];
	            String phone = fields[3];
	            
	            // Build new Contact and add to the list.
	            Contact newContact = new Contact(name,phone);
	            this.addContact(newContact);
	            
	            // Update reference.
	            iter = iter.getNext();
	        }
	        // Close file stream
	        scanner.close();
	        
        
		} 
		catch (Exception e) {
			
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	
	}
		
	//Export phoneBook to txt file
	public void exportPhoneBook(String filePath) {
		
	    try {
	    // Initialize File Object and Writer Object
            File file = new File(filePath);
            FileWriter writer = new FileWriter(file);
            
            // Initialize iterator to scan the list.
            ContactNode iter = this.getIterator();
            
            while(iter != null) {
            	
            	// Write the Contact to file.
                writer.write(iter.getContact().toString());
                // Update reference.
                iter = iter.getNext();
            }
            // Close writer
            writer.close();
             
           } 
	   catch (Exception e) {
			
            System.out.println("An error occurred.");
            e.printStackTrace();
           } 
	
	}

	
	
}
