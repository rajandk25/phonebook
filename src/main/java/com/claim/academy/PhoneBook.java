package com.claim.academy;

import java.util.Arrays;

public class PhoneBook {
	private Person[] person = new Person[0];
	private Address[] address = new Address[0];

	public PhoneBook() {

	}

	public Person[] expandPerson(Person[] persons) {
		Person[] target = new Person[persons.length + 1];

		if (persons.length > 0) {
			for (int i = 0; i < persons.length; i++) {
				target[i] = persons[i];
			}
		}

		return target;
	}

	public  Address[] expandAddress(Address[] address) {
		Address[] target = new Address[address.length + 1];
		if(address.length > 0) {
		for (int i = 0; i < address.length; i++) {
			target[i] = address[i];
		}
	}
		return target;
	}
	public void addPerson(Person person) {
		this.person = expandPerson(this.person);
		this.person[this.person.length - 1] = person;
	}

	public void addAddress(Address address) {
		this.address = expandAddress(this.address);
		this.address[this.address.length - 1] = address;
	}

	public Person[] findByFirstName(String firstName) {
		Person[] found = new Person[0];
		for (int i = 0; i < person.length; i++) {
			Person p = person[i];
			if (firstName.equalsIgnoreCase(p.getFirstName())) {
				found = expandPerson(found);
				found[found.length - 1] = p;
			}
		}
		return found;

	}

	public Person[] findByLastName(String lastName) {
		Person[] found = new Person[0];
		for (int i = 0; i < person.length; i++) {
			Person p = person[i];
			if (lastName.equalsIgnoreCase(p.getLastName())) {
				found = expandPerson(found);
				found[found.length - 1] = p;
			}
		}
		return found;
	}

	public Person[] findByPhoneNumber(String phoneNumber) {
		Person[] found = new Person[0];
		for (int i = 0; i < person.length; i++) {
			Person p = person[i];
			if (phoneNumber.equals(p.getPhoneNumber())) {
				found = expandPerson(found);
				found[found.length-1] = p;

			}
		}
		return found;
	}

	public Person[] findByFullName(String fullName) {
		Person[] found = new Person[0];
		for (int i = 0; i < person.length; i++) {
			Person p = person[i];
			String full = p.getFirstName() + " " + p.getMiddleName() +  p.getLastName();
			if(p.getMiddleName().length() > 0) {
				full = p.getFirstName() + " " + p.getMiddleName() + " " + p.getLastName();
			} else {
				full = p.getFirstName() + " " +  p.getLastName();
			}
			if (fullName.equalsIgnoreCase(full)) {
				found = expandPerson(found);
				found[found.length - 1] = p;
			}
		}
		return found;
	}

	public Person[] findByCityOrState(String entry) {
		Person[] found = new Person[0];
		for (int i = 0; i < person.length; i++) {
			Person p = person[i];
			Address address = p.getAddress();

			if (entry.equalsIgnoreCase(address.getCity()) || entry.equalsIgnoreCase(address.getState())) {
				found = expandPerson(found);
				found[found.length - 1] = p;
			}
		}
		return found;
	}

	public boolean removeContact(String phoneNumber) {
		boolean isFound = true;
		Person[] retained = new Person[0];
		for(int i = 0; i < person.length; i++) {
			Person p = person[i];
			if(!phoneNumber.equals(p.getPhoneNumber())){
				retained = expandPerson(retained);
				retained[i] = p;
			}
		}
		this.person = retained;
		return isFound;		
	}
	
	public Person updateContact(String phoneNumber, String newPhoneNumber) {
		
		for(int i = 0; i < person.length; i++) {
			Person p = person[i];
			if(phoneNumber.equals(p.getPhoneNumber())) {
				p.setPhoneNumber(newPhoneNumber);
				return p;
			}
		}
		return null;
	}
	
	public void sortPersons(Person[] persons) {
		Arrays.sort(persons, new PersonComparator());
	}

	public Person[] allPersons() {
		return this.person;
	}

}
