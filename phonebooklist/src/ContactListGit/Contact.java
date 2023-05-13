package ContactListGit;
import java.util.*;

public class Contact {
	
	// Data members
	private String name;
	
	private String phoneNumber;
	
	// Constructor
	public Contact (String newName,String newPhoneNumber){
		
		this.name = newName;
		this.phoneNumber = newPhoneNumber;
	}
	
	// Getters
	public String getName () {
		
		return this.name;
	}
	
	public String getPhoneNumber () {
		
		return this.phoneNumber;
	}
	
	//Setters
	public void setName(String otherName){
		this.name = otherName;
	}
	
	public void setPhoneNumber(String otherPhoneNumber){
		this.phoneNumber = otherPhoneNumber;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		// Check if obj is Contact
		if(obj instanceof Contact) {
			// Casting
			Contact other = (Contact) obj;
			return this.name.equals(other.getName()) && this.phoneNumber.equals(other.getPhoneNumber());
		}
		
		return false;
	}
	
	
	@Override
	public String toString () {
		
		return "Name: " + this.getName() + " Phone: " + this.getPhoneNumber() + "\n";
	}
	
	@Override
    public int hashCode() {
	
    	return Objects.hash(this.getName(), this.getPhoneNumber());
	}
}
