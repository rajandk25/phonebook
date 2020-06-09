package com.claim.academy;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		String first1 = p1.getFirstName();
		String last1 = p1.getLastName();
		String first2 = p2.getFirstName();
		String last2 = p2.getLastName();
		String mid1 = p1.getMiddleName();
		String mid2 = p2.getMiddleName();

		// compare first name
		if (first1.compareTo(first2) == 0) {
			// compare last names if first are same
			if (last1.compareTo(last2) == 0) {
				// compare middles if both first and last are same
				return mid1.compareTo(mid2);
			}
			return last1.compareTo(last2);
		}

		return first1.compareTo(first2);
	}

}
