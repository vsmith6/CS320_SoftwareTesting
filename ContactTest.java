/*
 * @author Valerie J. Smith
 * Date: June 10, 2022
 * Course: CS-320-T5615 Software Test Automation& QA 22EW5 - Project One
 * Description: This is the Test class for the Contact.java class. It contains the tests necessary to assure that the methods
 * available on the class will get and set the variables of the Contact class. This test also tests the validations
 * provided in the Contact class. 
 * 
 * 
 */
package Test;


import Contact.Contact;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


@TestMethodOrder(OrderAnnotation.class)
class ContactTest{
@Test
@DisplayName("Test to Get and Set Contact Information.")
@Order(7)
void testContactClass() {


    Contact contact = new Contact("Valerie", "Smith", "1123456789", "my address, usa"); 
   
       
        assertEquals(true,contact.getFirstName().equals("Valerie"), "Contact first name should be Valerie");
        assertEquals(true,contact.getLastName().equals("Smith"), "Contact last name should be Smith");
        assertEquals(true,contact.getNumber().equals("1123456789"), "Contact phone number should be 1123456789");
        assertEquals(true, contact.getAddress().equals("my address, usa"), "Contact address should be my address, usa");
        // test toString method
        String myContact = contact.toString();
        assertEquals(true, contact.toString().equals(myContact));
        
        contact.setFirstName("Ben");
        assertEquals(true,contact.getFirstName().equals("Ben"), "Contact name should be now set to Ben");
        contact.setLastName("Miller");
        assertTrue(contact.getLastName().equals("Miller"), "Contact name should now be set to Miller");
        contact.setNumber("2222222222");
        assertTrue(contact.getNumber().equals("2222222222"), "Contact phone number should now be set to 2222222222");
        contact.setAddress("Bens address");
        assertTrue(contact.getAddress().equals("Bens address"), "Contact address should now be set to Bens address");
        contact.getContactID();
       
        assertEquals(true, contact.getContactID().contentEquals("0"), "The contact ID should still be 0");
        assertEquals(false, contact.getContactID().contentEquals("1"), "The contact ID should not be 1");
             
       
}
@Test
@DisplayName("Test NULL checks.")
@Order(8)
void testContactNullValidations() {
	Contact contact2 = new Contact(null, null, null, null); 
	assertEquals(true, contact2.getFirstName().equals("NULL"), "Contact Name Is Null");
	assertEquals(false, contact2.getFirstName().contentEquals("Valerie"), "Contact FirstName should be NULL");
	assertEquals(true, contact2.getLastName().equals("NULL"), "Contact Last Name Is Null");
	assertEquals(true, contact2.getNumber().equals("5555555555"), "Contact Phone was entered as Null");
	assertEquals(true, contact2.getAddress().equals("NULL"), "Contact Address should be NULL");
	assertEquals(true, contact2.getContactID().contentEquals("1"), "All contact information is NULL");

}
@Test
@DisplayName("Test Empty String checks.")
@Order(9)
void testContactEmptyStringValidations() {
	Contact contact2 = new Contact("", "", "", ""); 
	assertEquals(true, contact2.getFirstName().equals(""), "Contact Name Is Null");
	assertEquals(false, contact2.getFirstName().contentEquals("Valerie"), "Contact FirstName should be empty string");
	assertEquals(true, contact2.getLastName().equals(""), "Contact Last Name Is an emtpy string");
	assertEquals(true, contact2.getNumber().equals("5555555555"), "Contact Phone was entered as empty string");
	assertEquals(true, contact2.getAddress().equals(""), "Contact Address is an empty string");
	assertEquals(true, contact2.getContactID().contentEquals("2"), "All contact information is empty strings");

}

@SuppressWarnings("static-access")
@Test
@DisplayName("Test Contact Validations and Atomic Integer.")
@Order(10)
void testCharacterValidations() {


    Contact contact3 = new Contact("ValerieJeanSmith", "SmithMillerValo", "11234567899999", "myextremely long address greaterthan 30 characters, usa"); 
 
       
        assertEquals(true,contact3.getFirstName().equals("ValerieJea"));
        assertEquals(true,contact3.getLastName().equals("SmithMille"));
        assertEquals(true,contact3.getNumber().equals("5555555555"));
        assertEquals(true, contact3.getAddress().equals("myextremely long address great"));
        
   
        String myContact = contact3.toString();
        assertEquals(true, contact3.toString().equals(myContact), "Two string method should now refect the validation values");

 
        // call getIdGenerator to test atomic integer incrementation
        contact3.getIdGenerator();
       
        assertTrue(contact3.getIdGenerator().intValue() ==4, "Atomic integer should be incremented to 4");
             
       
}

}
