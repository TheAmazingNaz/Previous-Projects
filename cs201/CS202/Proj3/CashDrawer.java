package proj3.c;

/**
* File:    CashDrawer.java
* Project: CMSC 202 Project 3, Spring 2009
* Author: Yakubu Wanka
* Date:    4/12/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
* Class Invariant
*	1. Every BagofChips has a price that is greater than 0
*   2. Every BagofChips has a flavor that is eithr BBQ, PLAIN, OR SALT_AND_VINEGAR
*/
public class CashDrawer{

private Money mycash = new Money(0, 0 , 0);

	public void boughtsnack(Money cash) {
		// TODO Auto-generated method stub
		int n = mycash.getNbrnickels()+ cash.getNbrnickels();
		int d = mycash.getNbrdimes() + cash.getNbrdimes();
		int q = mycash.getNbrquarts() + cash.getNbrquarts();
		mycash.setNbrdimes(d);
		mycash.setNbrnickels(n);
		mycash.setNbrquarts(q);	
	}

	/**
	 * Name: getCashonHand
	 * Pre-Condition: myCash is not null
	 * Post-Condition: Returns the money in the cash drawer.
	 */
	public Money getCashonHand(){
		return mycash;
	}

	public static void main(String[] args) {
		CashDrawer drawer = new CashDrawer();
		Money cash = new Money(3, 5, 7);
		drawer.boughtsnack(cash);
		System.out.println("getCashonHand: " + drawer.getCashonHand().toString());
	}
}