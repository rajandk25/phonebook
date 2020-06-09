package com.claim.academy;

public class Person {
	private String firstName;
	private String middleName = "";
	private String lastName;
	private Address address;
	private String phoneNumber;

	public Person() {

	}

	public Person(String firstName, String middleName, String lastName, Address adddress, String phoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = adddress;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		String formattedPhone = "";
		
		if(phoneNumber != null && phoneNumber.length() == 10) {
			formattedPhone = "(" + phoneNumber.substring(0, 3) + ")-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 10);
		} else {
			formattedPhone = phoneNumber;
		}
		
		return "Person: FirstName: " + firstName + ", middleName: " + middleName + ", LastName: " + lastName + ", address: "
				+ address + ", phoneNumber: " + formattedPhone;
	}

}
