package proj4;
/**
* File:    InputWrongException.java
* Project: CMSC 202 Project 4, Spring 2009
* Author: Yakubu Nazif Wanka
* Date:    4/03/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
*/

public class InputWrongException extends Exception {

	public InputWrongException() {
		super("Input an integer n00b!");	}

	public InputWrongException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	public InputWrongException(int choice) {
		super(choice + " Is not a valid choice");
	}

	public InputWrongException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InputWrongException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
