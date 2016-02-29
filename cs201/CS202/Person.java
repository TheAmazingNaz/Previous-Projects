/**
 * Person.java
 * 
 * This file models one Person who will be loaded onto a cruise ship
 * 
 * The student is responsible for implementing the methods defined
 * in the Transportable interface
 */
package proj5;

public class Person implements Transportable<Person>{
	
	private String id;
	private int age;
	private String name;

	public Person(String id, int age, String name) 
	{
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	
	public String toString( )
	{
		String s = name + ";\t" + age + " years old;" + "\tID: " + id;
		return s;
	}
}
