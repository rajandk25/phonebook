package com.claim.academy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * This is the main class that runs the project.
 */
public class PhoneApplication {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int selection = 0;
		PhoneBook phoneBook = new PhoneBook();
		
		do {
			System.out.println("Please Make a selection below:");
			System.out.println("1 - Add a new record");
			System.out.println("2 - Search by First Name");
			System.out.println("3 - Search by Last Name");
			System.out.println("4 - Search by Full Name");
			System.out.println("5 - Search by Phone Number");
			System.out.println("6 - Search by City or State");
			System.out.println("7 - Delete a Record ");
			System.out.println("8 - Update a Record ");
			System.out.println("9 - Sort Records ");
			System.out.println("10 - Print all records");
			System.out.println("11 - Exit");
			selection = scanner.nextInt();

			switch (selection) {
			case 1:
				addNewRecord(phoneBook);
				break;
			case 2:
				searchByFirstName(phoneBook);
				break;
			case 3:
				searchByLastName(phoneBook);
				break;
			case 4:
				searchByFullName(phoneBook);
				break;
			case 5:
				searchByPhoneNumber(phoneBook);
				break;
			case 6:
				searchByCityOrState(phoneBook);
				break;
			case 7:
				deleteContact(phoneBook);
				break;
			case 8:
				updateARecord(phoneBook);
				break;
			case 9:
				sortRecords(phoneBook);
				break;
			case 10:
				printAllRecords(phoneBook);
				break;
			case 11:
				System.out.println("\nGoodBye!!");
				break;
			default:
				System.out.println("Invalid option provided. Please retry.\n");
			}

		} while (selection != 11);
	}

	private static void printAllRecords(PhoneBook phoneBook) {
		for(Person p: phoneBook.allPersons()) {
			System.out.println(p);
		}
		
		System.out.println("\n");
	}

	private static void sortRecords(PhoneBook phoneBook) {
		phoneBook.sortPersons(phoneBook.allPersons());
		System.out.println("Sorted Persons: \n");
		for(Person p: phoneBook.allPersons()) {
			System.out.println(p);
		}
	}

	private static void updateARecord(PhoneBook phoneBook) {
		System.out.println("Which contact do you wish to update?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String currentPhone = null;
		String newPhoneNumber = null;
		try {
			 currentPhone =  br.readLine();
			 System.out.println("What is the new phone number: ");
			 newPhoneNumber = br.readLine();
		} catch (IOException e) {
			System.out.println("Number not added as expected");
			e.printStackTrace();
		}
		Person person = phoneBook.updateContact(currentPhone, newPhoneNumber);
		if(person != null) {
			System.out.println("Updated Person: " + person);
		}
		else {
			System.out.println("No record found with this phone number.");
		}
		
	}

	private static void deleteContact(PhoneBook phoneBook) {
		System.out.println("Which contact do you wish to remove? Please enter the phone number with no space.");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		try {
			entry = br.readLine();
		} catch (IOException e) {
			System.out.println("Number not added as expected");
			e.printStackTrace();
		}
		boolean removed = phoneBook.removeContact(entry);
		if(removed) {
			System.out.println("Your contact has been deleted.\n");
		}
		else {
			System.out.println("No contact was deleted.\n");
		}
		
		
	}

	private static void searchByCityOrState(PhoneBook phoneBook) {
		System.out.println("Please enter the city or state \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		try {
			entry = br.readLine();
		} catch (IOException e) {
			System.out.println("City and State not entered as expected");
			e.printStackTrace();
		}
		Person[] persons = phoneBook.findByCityOrState(entry);
		if (persons.length > 0) {
			for (Person p : persons)
				System.out.println(p + "\n");
		}
	}

	private static void searchByPhoneNumber(PhoneBook phoneBook) {
		System.out.println("Please enter the phone number with no space \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		try {
			entry = br.readLine();
		} catch (IOException e) {
			System.out.println("Phone Number not entered as expected");
			e.printStackTrace();
		}
		Person[] persons = phoneBook.findByPhoneNumber(entry);
		if (persons.length > 0) {
			for (Person p : persons)//(int i = 0; i < persons.length; i++) Person p = persons[i]
				System.out.println(p + "\n");
		}

	}

	private static void searchByFullName(PhoneBook phoneBook) {
		System.out.println("Please enter the full name \n");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		try {
			entry = br.readLine();
		} catch (IOException e) {
			System.out.println("Full Name not entered as expected");
			e.printStackTrace();
		}
		Person[] persons = phoneBook.findByFullName(entry);
		if (persons.length > 0) {
			for (Person p : persons)
				System.out.println(p + "\n");
		}

	}

	private static void searchByLastName(PhoneBook phoneBook) {
		System.out.println("Please enter last name");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;
		try {
			entry = br.readLine();
		} catch (IOException e) {
			System.out.println("Last name not entered as expected");
			e.printStackTrace();
		}
		Person[] persons = phoneBook.findByLastName(entry);
		if (persons.length > 0) {
			for (Person p : persons)
				System.out.println(p + "\n");
		} else {
			System.out.println("No record found with this last name.\n");
		}
	}

	private static void searchByFirstName(PhoneBook phoneBook) {
		System.out.println("Please enter first name");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;

		try {
			entry = br.readLine();
			Person[] persons = phoneBook.findByFirstName(entry);
			if (persons.length > 0) {
				for (Person p : persons)
					System.out.println(p + "\n");
			} else {
				System.out.println("No record found with this first name.\n");
			}
		} catch (IOException e) {
			System.out.println("First Name not entered as expected.\n");
		}

	}

	private static void addNewRecord(PhoneBook phoneBook) {
		System.out.println(
				"Please enter in this format: John Michael West Doe, 574 Pole ave, St. Peters, MO, 63333, 5628592375");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String entry = null;

		try {
			entry = br.readLine();
			// Start adding the record
			if (entry != null && entry.length() > 0) {
				String[] parts = entry.split(",");

				if (parts.length == 6) {
					String fullName = parts[0].trim();
					String street = parts[1].trim();
					String city = parts[2].trim();
					String state = parts[3].trim();
					String zipCode = parts[4].trim();
					String phone = parts[5].trim();

					// Address
					Address address = new Address(street, city, state, zipCode);
					// Person
					String[] nameParts = fullName.split(" ");
					String first = "", middle = "", last = "";
					if (nameParts.length == 2) {
						first = nameParts[0].trim();
						last = nameParts[1].trim();
					} else if (nameParts.length == 3) {
						first = nameParts[0].trim();
						middle = nameParts[1].trim();
						last = nameParts[2].trim();
					} else if (nameParts.length > 3) {
						first = nameParts[0].trim();
						last = nameParts[nameParts.length - 1].trim();
						for (int i = 1; i < nameParts.length - 1; i++) {
							if(i==1)
								middle = middle + nameParts[i].trim();
							else
								middle = middle + " " + nameParts[i].trim();
						}
					}

					Person person = new Person(first, middle, last, address, phone);
					phoneBook.addPerson(person);
				} else {
					System.out.println("Wrong format. Please retry\n");
					return;
				}
			}
		} catch (IOException e) {
			System.out.println("Error while reading user input.\n");
		}
		System.out.println("Record was successfully added.\n");

	}
	
	

}
