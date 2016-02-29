/**
 * Person.java
 * 
 * This file models one Person who will be loaded onto a cruise ship
 * 
 * The student is responsible for implementing the methods defined
 * in the Transportable interface
 */
package proj5;

public class Person implements Transportable<Person> {

	private String id, name;
	private int age;

	/**
	 * Pre-Conditions: Assumes inputs are not null 
	 * Post-Condition: Initiates all instance variables
	 */
	public Person(String id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}

	/**
	 * Name: compareID 
	 * Pre-Conditions: None 
	 * Post-Condition: checks if the id matches that of the calling person
	 */
	public boolean compareID(String id) {
		if (this.id.equalsIgnoreCase(id))
			return true;
		else
			return false;
	}

	/**
	 * Name: compareTo 
	 * Pre-Conditions: the inputed person is not null
	 * Post-Condition: checks if the id matches that of the calling person
	 */
	public int compareTo(Person arg0) {
		if (this.id.compareTo(arg0.id) > 0)
			return 1;
		else if (this.id.equalsIgnoreCase(arg0.id))
			return 0;
		else
			return -1;
	}

	/**
	 * Name: getTransportID 
	 * Pre-Conditions: None 
	 * Post-Condition: returns the persons id
	 */
	public String getTransportID() {
		return id;
	}

	/**
	 * Name: toString 
	 * Pre-Conditions: None 
	 * Post-Condition: returns the Persons information as a string
	 */
	public String toString() {
		String s = name + "    " + age + "     years old;" + "      ID: " + id;
		return s;
	}
}
