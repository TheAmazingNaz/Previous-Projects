package proj3.c;

/**
* File:    SnackHolder.java
* Project: CMSC 202 Project 3, Spring 2009
* Author: Yakubu Wanka
* Date:    4/12/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
* Class Invariant
*	1. The size is never negative and neither is the newestindex
*/
public class SnackHolder {
	private Object [] Snacks;
	
	//To know the index of the oldest snack in the holder
	private int oldestindex;
	
	//To know the newest member of the holder.
	private int newestindex;
	
	//To keep track of the number of snacks.
	private int size;

	
	/**
	 * Pre-Condition: The number n is not 0, or negative. Bad things will happen if it is either.
	 * Post-Condition: The instance variables of the Snack holder are initialized.
	 * @param n
	 */
	public SnackHolder(int n)
	{
		this.Snacks = new Object[n];
		this.oldestindex = 0;
		this.newestindex = 0;
		this.size = 0;
	}
	
	
	/**
	 * Name: addSnack
	 * Pre-Condition: The number num is not 0 or negative, the Object is not null and the holder has enough space for the new additions.
	 * Post-Condition: A certain number of a certain type of snack are added to the holder.
	 * @param num
	 * @param snacks
	 */
	public void addSnack(int num, Object snacks){
		for(int n = 0; n < num; n++)
			{
				//Add snacks after the newest snack already inside.
				Snacks[newestindex] = snacks;
				newestindex++;
			}
		size += num;
	}
	
	/**
	 * Name: BuySnack
	 * Pre-Condition: The snackholder is not empty. 
	 * Post-Condition: The oldest snack in the holder is returned.
	 * @return
	 */
	public Object BuySnack(){
		size--;
		return Snacks[oldestindex++];
	}
	
	/**
	 * Name: getsize
	 * Pre-Condition: None
	 * Post-Condition: returns number of snacks in the holder
	 */
	public int getsize() {
		// TODO Auto-generated method stub
		return size;
	}
	
	
	/**
	 * Name: isEmpty
	 * Pre-Condition: None
	 * Post-Condition: Checks to see if the snack holder is empty or not
	 */
	public boolean isEmpty()
	{
		if(this.newestindex == 0)
			return true;
		else
			return false;
	}
}