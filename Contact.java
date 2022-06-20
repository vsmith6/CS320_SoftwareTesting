/*
 * @author Valerie J. Smith
 * Date: June 10, 2022
 * Course: CS-320-T5615 Software Test Automation& QA 22EW5 - Project One
 * Description: This is the Contact.java class. It contains the items necessary to populate a contact
 * object.  This method contains public and private variables, a constructor, getters and setters,
 * and a to string method. The variables are also validated from this class. 
 * 
 * 
 */

package Contact;


import java.util.concurrent.atomic.AtomicLong;

public class Contact {
private final String contactID;
private String firstName;
private String lastName;
private String Number;
private String Address;
private static AtomicLong idGenerator = new AtomicLong();

//CONSTRUCTOR
/*
 * The constructor is set for the firstname,lastname, phone number, and address
 */
public Contact(String firstName, String lastName, String number, String address)  {

//CONTACTID
//The contact id is static and does not change. It is set when the constructor is called in 
//order to prevent duplicates when creating more than one contact. 
this.contactID = String.valueOf(idGenerator.getAndIncrement());

//FIRSTNAME



if (firstName == null ) {

this.firstName = "NULL";

//If first name is longer than 10 characters, just grab the first 10 characters
//I kept this reasoning for testing purposes
} else if(firstName.length() > 10) {
this.firstName = firstName.substring(0, 10);
}else {
 this.firstName = firstName;
}

//LASTNAME
//If the lastname is longer than 10 characters, just get the first 10 characters
if (lastName == null) {
this.lastName = "NULL";
} else if(lastName.length() > 10) {
this.lastName = lastName.substring(0,10);
} else {
this.lastName = lastName;
}
//NUMBER
// if the phone number is not 10 characters, add the default 5555555555 phone number
if (number == null || number.length() != 10) {
this.Number = "5555555555";
} else {
this.Number = number;
}
//ADDRESS
//If the address is more than 30 characters, get the first 30 characters only 
if (address == null) {
this.Address = "NULL";
} else if(address.length() > 30) {
this.Address = address.substring(0,30);
} else {
this.Address = address;
}
}
// GETTERS AND SETTERS
public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getNumber() {
	return Number;
}

public void setNumber(String number) {
	Number = number;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}

public static AtomicLong getIdGenerator() {
	return idGenerator;
}

public static void setIdGenerator(AtomicLong idGenerator) {
	Contact.idGenerator = idGenerator;
}

//GETTERS
public String getContactID() {
return contactID;
}

// adding toString method
@Override

public String toString() {

return "Contact [contactID=" + contactID + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + Number + ", address=" + Address + "]";
}
	
}
