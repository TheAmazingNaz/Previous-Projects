/**
* File:    ItemNotLoadedException.java
* Project: CMSC 202 Project 5, Spring 09
* Author:  Yakubu Nazif Wanka
* Date:    May 10, 2009
* Section: 0304
* E-mail:  yakubu1@umbc.edu
*/

package proj5;

@SuppressWarnings("serial")
public class ItemNotLoadedException extends Exception {

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public ItemNotLoadedException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public ItemNotLoadedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public ItemNotLoadedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public ItemNotLoadedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
