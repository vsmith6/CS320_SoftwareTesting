/*
 * @author Valerie J. Smith
 * Date: June 10, 2022
 * Course: CS-320-T5615 Software Test Automation& QA 22EW5 - Project One
 * Description: This is the Test class for the ContactService.java class. It contains the tests necessary to assure
 * that the Contact Service is instantiated and that the service can perform the necessary update and delete methods.
 * 
 * 
 */
package Test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;


import Contact.Contact;
import Contact.ContactService;


@TestMethodOrder(OrderAnnotation.class)

class ContactServiceTest {

	// Testing general ContactService class
	@Test
	@DisplayName("Test to Test Contact Service.")
	@Order(11)
		void testContactServiceClass() {
			Contact contact = new Contact("Valerie", "TestName", "8145455545", "123 Test Lane");
			Contact contact2 = new Contact("GamoraStarlord", "TestName", "8145455545", "123 Test Lane");
			ContactService service = new ContactService();
			
			service.addContact(contact);
			service.addContact(contact2);
			
			assertEquals(true,service.contactList.get(0).getFirstName() == "Valerie", "Contact First Name should be Valerie");
			assertEquals(true,service.contactList.get(0).getLastName() == "TestName", "Contact Last Name should be TestName");
			assertEquals(true,service.contactList.get(0).getNumber() == "8145455545", "Contact phone number should be 8145455545");
			assertEquals(true,service.contactList.get(0).getAddress() == "123 Test Lane", "Contact address should be 123 Test Lane");
		
			assertEquals(true, service.contactList.size() == 2);
		
			
		}
	@Test
	@DisplayName("Test to Test Update First Name.")
	@Order(12)
	void testUpdateFirstName(){

	Contact contact3 = new Contact("Val", "TestName", "8145455545", "123 Test Lane");
	Contact contact4 = new Contact("GamoraSta", "TestName", "8145455545", "123 Test Lane");
	ContactService service2 = new ContactService();
	
	service2.addContact(contact3);
	service2.addContact(contact4);
	assertEquals(true, service2.contactList.size() == 2, "Contact list should contain 2 elements");


	service2.displayContactList();

	service2.updateContactFirstName("7", "Philamena");

	assertEquals(true, service2.contactList.get(1).getFirstName() == "Philamena", "Contact First Name should be Philamena");

	}
	
	@Test
	@DisplayName("Test to Test Update Last Name.")
	@Order(13)
	void testUpdateLastName(){

	Contact contact5 = new Contact("Benjamin", "Miller", "8148144444", "12345 Test Lane");
	Contact contact6 = new Contact("Shadow", "Puppy", "8148145555", "123456 Test Lane");
	ContactService service3 = new ContactService();
	
	service3.addContact(contact5);
	service3.addContact(contact6);
	assertEquals(true, service3.contactList.size() == 2, "Contact List should contain 2 elements");


	service3.updateContactLastName("9", "Houston");

	assertEquals(true, service3.contactList.get(1).getLastName() == "Houston", "The contact last name should be Houston");

	}

	
	@Test
	@DisplayName("Test to Test Address.")
	@Order(14)
	void testUpdateAddress(){

	Contact contact7 = new Contact("Loki", "Mischief", "8148146666", "123456 Test Lane");
	Contact contact8 = new Contact("Thor", "Hammer", "8148147777", "1234567 Test Lane");
	ContactService service4 = new ContactService();
	
	service4.addContact(contact7);
	service4.addContact(contact8);
	assertEquals(true, service4.contactList.size() == 2, "Contact list size should be 2");


	service4.updateContactAddress("10", "10101 Galaxy Lane");

	assertEquals(true, service4.contactList.get(0).getAddress() == "10101 Galaxy Lane", "Contact address should be 10101 Galaxy Lane");
	service4.updateContactAddress("7", "");
	assertEquals(false, service4.contactList.get(1).getAddress() == "", "Contact ID is not in the list");

	}

	@Test
	@DisplayName("Test to Test Phone Number.")
	@Order(15)
	void testUpdatePhoneNumber(){

	Contact contact8 = new Contact("Loki", "Mischief", "8148146666", "123456 Test Lane");
	Contact contact9 = new Contact("Thor", "Hammer", "8148147777", "1234567 Test Lane");
	ContactService service5 = new ContactService();
	
	service5.addContact(contact8);
	service5.addContact(contact9);
	assertEquals(true, service5.contactList.size() == 2);
	
	service5.updateContactPhoneNumber("12", "1010101099");

	assertEquals(true, service5.contactList.get(0).getNumber() == "1010101099", "The phone number should be 1010101099");

	}
	
	@Test
	@DisplayName("Test to Delete Contact.")
	@Order(16)
	void testDeleteContact(){
		Assertions.assertThrows(IllegalArgumentException.class,() ->{
		Contact contact10 = new Contact("Maleficent", "Majestic", "8148146667", "1234567 Test Lane");
		Contact contact11 = new Contact("Anglina", "Joli", "8148147778", "12345678 Test Lane");
		ContactService service6 = new ContactService();
		 
		service6.addContact(contact10);
		service6.addContact(contact11);
		assertEquals(true, service6.contactList.size() == 2, "Contact list should contain 2 elements");
	
	
	   service6.deleteContact("14");
	   assertEquals(true,service6.contactList.size() == 1, "Contact list size should be 2");
	   
	   service6.deleteContact("20");
	   assertEquals(false,service6.contactList.size() ==2, "Contact ID did not match the list");
	
		});
	}
}

