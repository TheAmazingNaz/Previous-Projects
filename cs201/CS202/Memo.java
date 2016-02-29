package proj4;

/**
 * File:  Memo.java
 * Project: CMSC 202 Project 4, Spring 2009
 * Author: Yakubu Nazif Wanka
 * Date:    4/03/09
 * Section: 0301
 * E-mail:  yakubu1@umbc.edu
 */
public class Memo extends Correspondence {
	private String distributionlist;

	public Memo(String name, int idn, String input, String recipent,
			String subject, String distributionlist) {
		super(name, idn, input, recipent, subject);
		this.distributionlist = distributionlist;
	}

	/**
	 * Name: PrintDocInfo
	 * Pre-Condition: None
	 * Post-Condition: Returns the details of the document, including; date created, name, title, etc.
	 */
	public String PrintDocInfo() {
		String out = "";
		out += "\nDocument ID: " + this.getId() + "\n" + "Author: " + this.getAuthor1() + "\nCreation Date/Time: " + this.getDatecreate().toLocaleString() +
		"\nRecipent: " + this.getRecipent() + "\nSubject: " + this.getSubject() + "\nDistribution List: \n" + this.distributionlist;
		return out;
	}

}
