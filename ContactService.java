/*
 * @author Valerie J. Smith
 * Date: June 10, 2022
 * Course: CS-320-T5615 Software Test Automation& QA 22EW5 - Project One
 * Description: This is the ContactService.java class. It contains the items necessary to instantiate a 
 * Contact Service that will perform update by contact ID and delete by contact ID methods on an Array of Contacts. 
 * 
 * 
 */

package Contact;

import java.util.ArrayList;

public class ContactService {
	// create an array list of Contact
	public ArrayList<Contact> contactList = new ArrayList<Contact>();
	
   // method to display the contact list
	public void displayContactList() {
		//iterate over each item in the contact list and print it to the console
		for (int counter = 0; counter < contactList.size(); counter++) {
			System.out.println("\t Contact ID: " + contactList.get(counter).getContactID());
			System.out.println("\t First Name: " + contactList.get(counter).getFirstName());
			System.out.println("\t Last Name: " + contactList.get(counter).getLastName());
			System.out.println("\t Phone Number: " + contactList.get(counter).getNumber());
			System.out.println("\t Address: " + contactList.get(counter).getAddress() + "\n");
		}
	}

    // method to add a contact to the list, method accepts a contact object
	public void addContact(Contact newContact) {
		this.contactList.add(newContact);
	}
    // method to delete a contact from the contact list by contact ID
	public void deleteContact(String contactID) {
		System.out.println(contactID);
		for (Contact contact : contactList) {

			if (contact.getContactID().equals(contactID)) {

				contactList.remove(contact);

			} else {
				// alert that the contact ID is not in the list
				throw new IllegalArgumentException("Contact ID is not in the list");
			}

		}

	}

	// method to update the contact's first name. Method accepts a contact ID string and a new first name string
	public void updateContactFirstName(String contactID, String newFirstName) {
		for (Contact contact : contactList) {
           // use equals method to compare the contact ID in the list to the contactID passed in. If matches, 
			// set the first name to the new first name
			if (contact.getContactID().equals(contactID)) {


				contact.setFirstName(newFirstName);


			}
		}

	}
    // method to update the contact's last name by contact ID. Method accepts a contactID and newLastName string.
	public void updateContactLastName(String contactID, String newLastName) {
		for (Contact contact : contactList) {
            // use the equals method to compare the ContactID to the contactID string passed in. If matches,
			// set the last name to the new last name.
			if (contact.getContactID().equals(contactID)) {


				contact.setLastName(newLastName);

				
			}
		}

	}
    // method to update the contact's phone number by contactID in the list. Method accepts a contactID and a new Phone string
	public void updateContactPhoneNumber(String contactID, String newPhone) {
		for (Contact contact : contactList) {
			
            // use the equals method to compare the contactID in the list to the contactID passed in. If matches,
			// set the phone number to the new phone number
			if (contact.getContactID().equals(contactID)) {


				contact.setNumber(newPhone);

			}
		}

	}
    // method to update the contact's address by contact ID in the list. Method accepts a contactID and a new address string.
	public void updateContactAddress(String contactID, String newAddress) {
		for (Contact contact : contactList) {
            // use the equals method to compare if the contact ID in the list to the contact ID passed in. If matches,
			// set the address to the new address
			if (contact.getContactID().equals(contactID)) {


				contact.setAddress(newAddress);

			

			}
		}

	}

}