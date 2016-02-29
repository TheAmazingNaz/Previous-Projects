/**
 * TransportException.java
 * 
 * This file defines the only exception thrown by methods of the Ship class
 * Each method that throws it should provide a meaningful message which will
 * be written to the logfile by main( )
 * 
 * D. Frey, April 2009
 */
package proj5;

@SuppressWarnings("serial")
public class TransportException extends Exception {

	public TransportException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransportException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public TransportException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public TransportException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	// student -- implement required methods of this class

}
