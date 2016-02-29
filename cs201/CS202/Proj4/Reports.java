package proj4;

/**
 * File:  Reports.java
 * Project: CMSC 202 Project 4, Spring 2009
 * Author: Yakubu Nazif Wanka
 * Date:    4/03/09
 * Section: 0301
 * E-mail:  yakubu1@umbc.edu
 */
public class Reports extends Document {
	private String title;

	public Reports(String name, int idn, String input, String title) {
		super(name, input);
		this.title = title;
	}

	/**
	 * Name: PrintDocInfo
	 * Pre-Condition: None
	 * Post-Condition: Returns the details of the document, including; date created, name, title, etc.
	 */
	public String PrintDocInfo() {
		String out = "";
		out += "\nDocument ID: " + this.getId() + "\n" + "Author: " + this.getAuthor1() + "\nCreation Date/Time: " + this.getDatecreate().toLocaleString() +
		"\nTitle: " + this.title;
		return out;
	}

}
