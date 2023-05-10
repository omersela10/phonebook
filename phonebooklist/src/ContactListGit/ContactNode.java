package ContactListGit;

public class ContactNode {
	
	// Data members
	private Contact contact;
	
	private ContactNode next;
	
	// Constructors
	public ContactNode(Contact newContact, ContactNode newContactNode) {
		
		this.contact = newContact;
		this.next = newContactNode;
	}
	
	public ContactNode(Contact newContact) {
		
		this.contact = newContact;
		this.next = null;
	}
	
	// Getters
	public Contact getContact() {
		
		return this.contact;
	}
	
	public ContactNode getNext() {
		
		return this.next;
	}
	
	// Setters
	public void setNext(ContactNode nextNode) {
		
		this.next = nextNode;
	}
	
	public void setContact(Contact newContact) {
		
		this.contact = newContact;
	}
	
	// Methods
	public boolean hasNext() {
		
		return this.getNext() != null;
	}
	


	
}
