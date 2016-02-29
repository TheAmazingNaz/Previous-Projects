package proj4;

/**
 * File:    Document.java
 * Project: CMSC 202 Project 4, Spring 2009
 * Author: Yakubu Nazif Wanka
 * Date:    4/03/09
 * Section: 0301
 * E-mail:  yakubu1@umbc.edu
 */
import java.util.Date;


public class Document {
	private String author1;
	private Date datecreate;
	private int id;
	private String body;

	public Document(String name, String input)
	{
		this.author1 = name;
		this.datecreate = new Date();
		this.body = input;
	}

	/**
	 * Name: CompareID
	 * Pre-Condition: None
	 * Post-Condition: Checks to see if the two documents have the same id.
	 */
	public boolean compareID(int id)
	{
		if(this.id == id)
			return true;
		else
			return false;
	}

	/**
	 * Name: getAuthor1
	 * Pre-Condition: None
	 * Post-Condition: Returns the author
	 */
	public String getAuthor1() {
		return author1;
	}

	/**
	 * Name: getDateCreate
	 * Pre-Condition: None
	 * Post-Condition: Returns the date of creation.
	 */
	public Date getDatecreate() {
		return datecreate;
	}

	/**
	 * Name: getId
	 * Pre-Condition: None
	 * Post-Condition: Returns the document id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Name: PrintDoc
	 * Pre-Condition: None
	 * Post-Condition: Returns the body of the document.
	 */
	public String PrintDoc() {
		String out = "";
		out += this.PrintDocInfo() + "\nText: \n" + this.body;
		return out;
	}

	/**
	 * Name: PrintDocInfo
	 * Pre-Condition: None
	 * Post-Condition: Returns the details of the document, including; date created, name, title, etc.
	 */
	public String PrintDocInfo() {
		String out = "";
		out += "Document ID: " + this.id + "\n" + "Author: " + this.author1 + "\nCreation Date/Time: " + this.datecreate.toLocaleString();
		return out;
	}

	/**
	 * Name: setID
	 * Pre-Condition: None
	 * Post-Condition: Changes the id.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Name: Stringindoc
	 * Pre-Condition: None
	 * Post-Condition: Returns the true or false depending on if the string is within the document or not.
	 */
	public boolean stringindoc(String str)
	{

		if(body.indexOf(str) != -1)
			return true;
		else
			return false;
	}
}
