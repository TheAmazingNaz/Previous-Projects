package proj3;

/**
* File:    BagOfChips.java
* Project: CMSC 202 Project 3, Spring 2009
* Author: Yakubu Wanka
* Date:    4/12/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
* Class Invariant
*	1. Every BagofChips has a price that is greater than 0
*   2. Every BagofChips has a flavor that is eithr BBQ, PLAIN, OR SALT_AND_VINEGAR
*/
public class BagOfChips{
	private static final int BBQ = 1;
	private static final int PLAIN = 2;
	private static final int SALT_AND_VINEGAR= 3;
	public enum Flavor {BBQ, PLAIN, SALT_AND_VINEGAR};
	public final static double price = 0.65;
	private Flavor f1;
	
	/**
	 * Pre-Condition: None
	 * Post-Condition: Creates a Bag of Chips with the flavor, myflav
	 * @param flavaflave
	 */
	public BagOfChips(Flavor flavaflave){
		this.f1 = flavaflave;
	}
	
	/**
	 * Name: getFlavor
	 * Pre-Condition: f1 has been initialized
	 * Post-Condition: return the flavor
	 */
	public Flavor getFlavor() {
		return f1;
	}


	/**
	 * Name: toString
	 * Pre-Condition: f1 has been initialized
	 * Post-Condition: return the flavor as a string
	 */
	public String toString(){
		String out = "";
		if(this.f1 == Flavor.BBQ){
			out = "Barbeque Flavored";
		}
		else if(this.f1 == Flavor.PLAIN){
			out = "Plain flavored";
		}
		else{
			out = "Salt and Vinegar flavored";
		}
		
		return out;
	}

}