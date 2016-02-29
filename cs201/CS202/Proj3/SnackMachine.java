package proj3.c;
import java.awt.Color;

/**
* File:    SnackMachine.java
* Project: CMSC 202 Project 3, Spring 2009
* Author: Yakubu Wanka
* Date:    4/12/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
* Class Invariant
*	1. The Snacks each have a maximum number that is not 0.
*   2. Every Snack Machine has a cash drawer and 2 snack holders which are all initially empty.
*/

public class SnackMachine {
	private CashDrawer cashdrawer = new CashDrawer();
	private static final int MAXLOLLYS = 75;
	private static final int MAXCHIPS = 60;
	private SnackHolder lollys = new SnackHolder(MAXLOLLYS);
	private SnackHolder chippys = new SnackHolder(MAXCHIPS);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Snack Machine constructor
		SnackMachine machine = new SnackMachine( );
		Money money = new Money( 1, 3, 0);
		Money money1 = new Money( 2, 3, 1);
		BagOfChips bag = new BagOfChips(BagOfChips.Flavor.BBQ);
		Lollipop pop = new Lollipop(Color.RED);

		// add "count" bags of chips to the snack machine
		machine.addChips(bag, 5);

		// add "count" lollipops to the snack machine 
		machine.addLollipops(pop, 5);
		
		// purchase a Lollipop
		Lollipop temp = machine.buyLollipop(money);

		// purchase a bag of chips
		BagOfChips temp1 = machine.buyChips(money1);

		// returns the number of lollipops in the snack machine
		int nrlols = machine.getNrLollipops( );

		// returns the number of bags of chips in the snack machine
		int nrchips = machine.getNrBagsOfChips( );

		// returns the contents of the cash drawer
		Money money2 = machine.getCashOnHand( );
		
		System.out.println("You bought a " + temp.getColor() +"ed colored Lollipop");
		System.out.println("You bought a " + temp1.toString() +" flavored Bag of Chips");
		System.out.println("There are " + nrlols + " lollipops in the machine" );
		System.out.println("There are " + nrchips + " Bags of Chips in the machine" );
		System.out.println("There are " + money2.toString() + " in the machine" );
	}
	
	/**
	 * Name: getCashOnHand
	 * Pre-Condition: The return value is not null
	 * Post-Condition: Returns the money in the cash drawer object.
	 */
	public Money getCashOnHand() {
		// TODO Auto-generated method stub
		return this.cashdrawer.getCashonHand();
	}

	/**
	 * Name: getNrBagsOfChips
	 * Pre-Condition: None
	 * Post-Condition: Returns the number of Bag Of Chips in the chips holder.
	 */
	public int getNrBagsOfChips() {
		// TODO Auto-generated method stub
		return this.chippys.getsize();
	}

	/**
	 * Name: getNrLollipops
	 * Pre-Condition: None
	 * Post-Condition: Returns the number of Lollipops in the lollipop holder.
	 */
	public int getNrLollipops() {
		// TODO Auto-generated method stub
		return this.lollys.getsize();
	}

	/**
	 * Name: addLollipops
	 * Pre-Condition: The number i is not 0 or negative, the Lollipop is not null and the holder has enough space for the new additions.
	 * Post-Condition: A certain number of Lollipops are added to the holder.
	 * @param i
	 * @param pop
	 */
	public void addLollipops(Lollipop pop, int i) {
		// TODO Auto-generated method stub
		this.lollys.addSnack(i, pop);
	}

	/**
	 * Name: addChips
	 * Pre-Condition: The number i is not 0 or negative, the BagOfChips is not null and the holder has enough space for the new additions.
	 * Post-Condition: A certain number of Bags of Chips are added to the holder.
	 * @param i
	 * @param bag
	 */
	public void addChips(BagOfChips bag, int i) {
		// TODO Auto-generated method stub
		this.chippys.addSnack(i, bag);
	}

	/**
	 * Name: buyLollipop
	 * Pre-Condition: None
	 * Post-Condition: The oldest Lollipop in the holder is returned.
	 * @param money
	 */
	public Lollipop buyLollipop(Money money){
		if(this.lollys.isEmpty() || money.TotalValue() != Lollipop.price)
			return null;
		else{
			this.cashdrawer.boughtsnack(money);
			return (Lollipop) lollys.BuySnack();
		}
	}
	
	/**
	 * Name: buyChips
	 * Pre-Condition: None
	 * Post-Condition: The oldest Bag of Chips in the holder is returned.
	 * @param money
	 */
	public BagOfChips buyChips(Money money){
		if(this.chippys.isEmpty() || money.TotalValue() != BagOfChips.price)
			return null;
		else{
			this.cashdrawer.boughtsnack(money);
			return (BagOfChips) chippys.BuySnack();
		}
	}
}
