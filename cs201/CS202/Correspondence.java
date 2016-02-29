package proj4;

/**
 * File:  Correspondence.java
 * Project: CMSC 202 Project 4, Spring 2009
 * Author: Yakubu Nazif Wanka
 * Date:    4/03/09
 * Section: 0301
 * E-mail:  yakubu1@umbc.edu
 */
public class Correspondence extends Document {
	private String recipent;
	private String subject;

	public Correspondence(String name, int idn, String input, String recipent, String subject) {
		super(name, input);
		this.recipent = recipent;
		this.subject = subject;
	}


	/**
	 * Name: getRecipent
	 * Pre-Condition: None
	 * Post-Condition: Returns the recipent
	 */
	public String getRecipent() {
		return recipent;
	}

	/**
	 * Name: getSubject
	 * Pre-Condition: None
	 * Post-Condition: Returns the subject;
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * Name: PrintDocInfo
	 * Pre-Condition: None
	 * Post-Condition: Returns the details of the document, including; date created, name, title, etc.
	 */
	public String PrintDocInfo() {
		String out = "";
		out += "\nDocument ID: " + this.getId() + "\n" + "Author: " + this.getAuthor1() + "\nCreation Date/Time: " + this.getDatecreate().toLocaleString() +
		"\nRecipent: " + this.recipent + "\nSubject: " + this.subject;
		return out;
	}

}
