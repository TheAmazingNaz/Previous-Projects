package proj3.c;

/**
* File:    Money.java
* Project: CMSC 202 Project 3, Spring 2009
* Author: Yakubu Wanka
* Date:    4/12/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
* Class Invariant
*	1. None of its instance variables can be negative.
*/
public class Money {

	private int nbrnickels;
	private int nbrdimes;
	private int nbrquarts;
	
	public Money(int nickels,int dimes,int quarts){
		this.nbrdimes = dimes;
		this.nbrnickels = nickels;
		this.nbrquarts = quarts;
	}
	
	/**
	 * Name: TotalValue
	 * Pre-Condition: None
	 * Post-Condition: Returns the total value of the money in Dollars.
	 */
	public double TotalValue(){
		double n = this.nbrdimes*10;
		double m = this.nbrnickels*5;
		double o = this.nbrquarts*25;
		
		return (n + m + o)/100;
	}
	
	/**
	 * Name: toString
	 * Pre-Condition: None
	 * Post-Condition: Returns the value of the money in string format including the number of coins
	 */
	public String toString(){
		String out = "";
		out += this.nbrnickels + " nickels\n" +this.nbrdimes + " dimes\n" +this.nbrquarts + " quarters\n";
		out += "$" + this.TotalValue() + " in total";
		return out;
	}
	
	/**
	 * Name: getNbrnickels
	 * Pre-Condition: None
	 * Post-Condition: return the nbrnickels
	 */
	public int getNbrnickels() {
		return nbrnickels;
	}

	/**
	 * Name: setNbrnickels
	 * Pre-Condition: nbrnickels is not negative
	 * Post-Condition: sets the nbrnickels in the calling object to the param nbrnickels
	 * @param nbrnickels
	 */
	public void setNbrnickels(int nbrnickels) {
		this.nbrnickels = nbrnickels;
	}

	/**
	 * Name: getNbrdimes
	 * Pre-Condition: None
	 * Post-Condition: return the nbrdimes
	 */
	public int getNbrdimes() {
		return nbrdimes;
	}

	/**
	 * Name: setNbrdimes
	 * Pre-Condition: nbrdimes is not negative
	 * Post-Condition: sets the nbrdimes in the calling object to the param nbrdimes
	 * @param nbrdimes
	 */
	public void setNbrdimes(int nbrdimes) {
		this.nbrdimes = nbrdimes;
	}

	/**
	 * Name: getNbrqaurts
	 * Pre-Condition: None
	 * Post-Condition: return the nbrquarts
	 */
	public int getNbrquarts() {
		return nbrquarts;
	}

	/**
	 * Name: setNbrquarts
	 * Pre-Condition: nbrquarts is not negative
	 * Post-Condition: sets the nbrquarts in the calling object to the param nbrquarts
	 * @param nbrquarts
	 */
	public void setNbrquarts(int nbrquarts) {
		this.nbrquarts = nbrquarts;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
