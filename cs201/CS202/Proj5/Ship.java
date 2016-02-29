/**
 * Ship.java
 * This file models the generic ship class
 *
 * The student is responsible for fully implementing this class
 * The class definition cannot be changed
 * 
 * When appropriate, methods of Ship should throw TransportException 
 * 
 */
package proj5;

import java.util.*;

public class Ship<T extends Transportable<T>> {
	private int currentSpeed, maxItems, maxSpeed, minSpeed;
	private String origin, destination, state;
	private ArrayList<T> occupants;
	//The status code shows where the ship is at any given time.
	//1 is in port, 2 is at sea.
	private int statusCode;

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public Ship(String origin, int maxItems, int minSpeed, int maxSpeed) {
		occupants = new ArrayList<T>(maxItems);
		this.origin = origin;
		this.minSpeed = minSpeed;
		this.maxSpeed = maxSpeed;
		this.maxItems = maxItems;
		this.currentSpeed = minSpeed;
		this.statusCode = 1;
		this.state = "In port at " + origin;
	}

	/**
	 *  Name: AddElements
	 *	Pre-Conditions: element is not null.
	 * 	Post-Condition: Adds the element to the ship.
	 */
	public void AddElements(T element) {
		occupants.add(element);
	}

	/**
	 *  Name: ListAll
	 *	Pre-Conditions: there are elements in the ship
	 * 	Post-Condition: returns a list of all the ships elements.
	 */
	private String ListAll() {
		String out = "";
		for (int n = 0; n < this.occupants.size(); n++) {
			out += "\t" + this.occupants.get(n).toString();
		}
		return out;
	}

	/**
	 *  Name: RemoveElement
	 *	Pre-Conditions: None
	 * 	Post-Condition: Removes the matching element in the ship. Rerturns false if no such element 
	 */
	public boolean RemoveElement(T element) {
		boolean found = false;
		
		//Searches the elements of the ship to find an element with a matching identifier
		//removes it if found and returns true. But returns false if not found
		for (int i = 0; i < occupants.size(); i++) {
			if (occupants.get(i).compareTo(element) == 0) {
				occupants.remove(i);
				found = true;
			}
		}
		return found;
	}

	/**
	 * Name: setcurrentSpeed
	 * Pre-Condtions: The object is not null.
	 * Post-Condition:Sets the currentSpeed to currentSpeed
	 */
	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	/**
	 * Name: setdestination
	 * Pre-Condtions: The object is not null.
	 * Post-Condition:Sets the destination to destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
	}

	/**
	 * Name: setorigin
	 * Pre-Condtions: The object is not null.
	 * Post-Condition:Sets the origin to origin
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	/**
	 * Name: setstate 
	 * Pre-Condtions: The object is not null. 
	 * Post-Condition:Sets the state to state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Name: setstatusCode 
	 * Pre-Condtions: The object is not null.
	 * Post-Condition:Sets the statusCode to statusCode
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Name: getcurrentSpeed 
	 * Pre-Conditions: None 
	 * Post-Condition: returns the currentSpeed
	 */
	public int getCurrentSpeed() {
		return currentSpeed;
	}

	/**
	 * Name: getdestination 
	 * Pre-Conditions: None 
	 * Post-Condition: returns the destination
	 */
	public String getDestination() {
		return destination;
	}


	/**
	 * Name: getorigin 
	 * Pre-Conditions: None 
	 * Post-Condition: returns the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * Name: getstatusCode 
	 * Pre-Conditions: None 
	 * Post-Condition: returns the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 *  Name: getMaxItems
	 *	Pre-Conditions: None
	 * 	Post-Condition: returns the maximum number of Items
	 */
	public int getMaxItems() {
		return maxItems;
	}

	/**
	 *  Name: getNumberitems
	 *	Pre-Conditions: None
	 * 	Post-Condition: returns the number of items
	 */
	public int getNumberitems() {
		return occupants.size();
	}

	/**
	 * Name: toString 
	 * Pre-Conditions: None 
	 * Post-Condition: prints the ships information and lists its elements
	 */
	public String toString() {
		Collections.sort(this.occupants);	//Sorts the elements in the ship
		
		String s = "\r\nMinSpeed: " + minSpeed + "\r\n" + "MaxSpeed: "
				+ maxSpeed + "\r\nCurrent Speed: " + currentSpeed
				+ "\r\nMax Items: " + maxItems + "\r\n" + state + "\r\n"
				+ this.ListAll();
		return s;
	}

	/**
	 *  Name: getMaxSpeed
	 *	Pre-Conditions: None
	 * 	Post-Condition: returns the Maximum Speed
	 */
	public int getMaxSpeed() {
		return maxSpeed;
	}
}
