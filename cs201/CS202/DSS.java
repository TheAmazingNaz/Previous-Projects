package proj4;
import java.util.ArrayList;

/**
 * File:  DSS.java
 * Project: CMSC 202 Project 4, Spring 2009
 * Author: Yakubu Nazif Wanka
 * Date:    4/03/09
 * Section: 0301
 * E-mail:  yakubu1@umbc.edu
 * Class Invariant
 *	1. idnumber always starts with 10001
 */

public class DSS {
	private ArrayList<Document> docstorage = new ArrayList<Document>();
	private int idnumber;

	public DSS()
	{
		this.idnumber = 10001;
	}

	/**
	 * Name: addDoc
	 * Pre-Condition: the document is not null
	 * Post-Condition: Adds the document to the list
	 */
	public void adddoc(Document d)
	{
		d.setID(idnumber);
		docstorage.add(d);
		this.idnumber++;
	}

	/**
	 * Name: findword
	 * Pre-Condition: None
	 * Post-Condition: Returns the ids of the documents in which the string appears in
	 */
	public String findword(String searchstr)
	{
		String out =  "\"" + searchstr +  "\"" + " was found in the following documents: ";
		for(int i = 0; i < docstorage.size(); i++)
		{
			if(docstorage.get(i).stringindoc(searchstr))
			{
				out += "\n" + docstorage.get(i).getId();
			}
		}
		return out;
	}

	/**
	 * Name: getId
	 * Pre-Condition: None
	 * Post-Condition: Returns the base id.
	 */
	public int getIdnumber() {
		return idnumber;
	}

	/**
	 * Name: getSize
	 * Pre-Condition: None
	 * Post-Condition: Returns the number of documents in the storage system.
	 */
	public int getSize()
	{
		return docstorage.size();
	}

	/**
	 * Name: PrintAllDocInfo
	 * Pre-Condition: None
	 * Post-Condition: Returns the document info for all the documents in the database.
	 */
	public String PrintAlldocInfo() {
		String out = "";

		for(int i = 0; i < docstorage.size(); i++)
		{
			if(docstorage.get(i) != null) {
					out += docstorage.get(i).PrintDocInfo() + "\n";
				}
		}
		return out;
	}

	/**
	 * Name: PrintDoc
	 * Pre-Condition: the id refers to a document within the database
	 * Post-Condition: Returns the body of the document.
	 */
	public String Printdoc(int idn) {
		String out = null;

		for(int i = 0; i < docstorage.size(); i++)
		{
			if(docstorage.get(i).compareID(idn))
			{
				out = docstorage.get(i).PrintDoc();
			}
		}
		return out;
	}

	/**
	 * Name: addDoc
	 * Pre-Condition: None
	 * Post-Condition: Removes the document from the list
	 */
	public String removedoc(int id)
	{
		for(int i = 0; i < docstorage.size(); i++)
		{
			if(docstorage.get(i).compareID(id))
			{
				docstorage.remove(i);
			}
		}
		return "\nDocument " + id + " was removed\n";
	}
}
