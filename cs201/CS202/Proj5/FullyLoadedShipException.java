/**
* File:    FullyLoadedShipException.java
* Project: CMSC 202 Project 5, Spring 09
* Author:  Yakubu Nazif Wanka
* Date:    May 10, 2009
* Section: 0304
* E-mail:  yakubu1@umbc.edu
*/

package proj5;

/**
 * @author Naz
 *
 */
@SuppressWarnings("serial")
public class FullyLoadedShipException extends Exception {

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public FullyLoadedShipException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public FullyLoadedShipException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public FullyLoadedShipException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 *	Pre-Conditions: Assumes inputs are not null
	 * 	Post-Condition: Initiates all instance variables
	 */
	public FullyLoadedShipException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
