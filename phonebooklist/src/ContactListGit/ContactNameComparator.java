package ContactListGit;
import java.util.*;

// Implements the interface comparator by Strategy Design Pattern
public class ContactNameComparator implements Comparator<ContactNode> {

	// Override compare to compare between two Contact by their name 
	@Override
	public int compare(ContactNode c1, ContactNode c2) {
		 
		if (c1.getContact().getName().equals(c2.getContact().getName()) == true) {
			
			// If they have the same name, compare by Bigger numeric Phone number
			Integer c1PhoneInt = Integer.parseInt(c1.getContact().getPhoneNumber());
			Integer c2PhoneInt = Integer.parseInt(c2.getContact().getPhoneNumber());
			return c2PhoneInt.compareTo(c1PhoneInt);
		}
		else {
			// Else - compare by Alphabetic order
			return c1.getContact().getName().compareTo(c2.getContact().getName());
		}
	}

}


