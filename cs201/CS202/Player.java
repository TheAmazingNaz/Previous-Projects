/**
* File:    Game.java
* Project: CMSC 202 Project 2, Spring 2009
* Author: Yakubu Wanka
* Date:    3/20/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
*/
package proj2;
import p2Util.Card;

public class Player {
	private String name;
	 Card [] Hand = new Card[26];
	private	int topcardindex = 0;
	private int warwins = 0;
	private int cardwins = 0;
	
	/** Precondition: NULL
	 * Postcondition: A new Player object is initialized and given a name.
	 */
	public Player(String name)
	{
		this.name = name;
	}

	
	/* Name: addCard
	* PreCondition:  the Player is not null.
	* PostCondition: Initializes then shuffles a deck then deals the cards
	* 				 to the player depending on whether he/she is the
	* 				 first or second player.
	* @params seed, plyrnumber - the seed for deck shuffling and the players number.
	*/
	public void addCard(long seed, int plyrnumber)
	{
		int k = 0;
		int j = 0;
		//Initializes the deck
		Deck MainDeck = new Deck();
		MainDeck.Shuffle(seed);
		//The dealer starts dealing with player 2. Therefore, player 2 gets the first
		//card on the deck, and every other one after that. And player 1 gets the second, etc
		if(plyrnumber == 2)
		{
			for(int i = 0; i < 52; i++)
			{
				if(i % 2 == 0)
				{
					Card temp = MainDeck.getDeckTopCard(i);
					this.Hand[k] = temp;
					k++;
				}
			}
		}
		else
		{
			for(int i = 0; i < 52; i++)
			{
				if(i % 2 != 0)
				{
					Card temp1 = MainDeck.getDeckTopCard(i);
					this.Hand[j] = temp1;
					j++;
				}
			}
		}
	}
	
	/* Name: ChangeTopCard
	* PreCondition:  NONE.
	* PostCondition: Advances the index of the top card by one. Effectively dropping that card from the players hand.
	*/
	public void ChangeTopCard()
	{
		this.topcardindex += 1;
	}
	
	/* Name: WinRound
	* PreCondition:  NONE
	* PostCondition: adds the number of cards the player won to their total.
	* @param n - the number of cards the player wins.
	*/
	public void WinRound(int n)
	{
		this.cardwins += n;
	}
	
	/* Name: WinWar
	* PreCondition:  NONE
	* PostCondition: adds the number of cards the player wins per war and adds 1 to the players war wins
	* @param n - the number of cards the player wins.
	*/
	public void WinWar(int n)
	{
		this.cardwins += n;
		this.warwins += 1;
	}
	
	/* Name: getTopCard
	* PreCondition:  The player and his hand are not NULL.
	* PostCondition: Returns the Top card on the players hand.
	*/
	public Card getTopCard()
	{
		int n = this.getTopcardindex();
		return this.Hand[n];
	}
	
	/* Name: DropTopThree
	* PreCondition:  NONE.
	* PostCondition: Advances the index of the top card by three. Effectively dropping them in the event of a war.
	*/
	public void DropTopThree()
	{
		this.topcardindex += 4;
	}
	
	/* Name: getName
	* PreCondition:  The Player is not NULL.
	* PostCondition: Returns the players' name.
	*/
	public String getName() 
	{
		return name;
	}
	
	/* Name: getTopcardindex
	* PreCondition:  NONE.
	* PostCondition: Returns the index of the top card in the players hand.
	*/
	public int getTopcardindex() {
		return this.topcardindex;
	}
	
	/* Name: Results
	* PreCondition:  Player not NULL
	* PostCondition: Returns a string detailing all the player has done during the game.
	*/
	public String Results() {
		String out = this.name + " won " + this.cardwins + " cards " + " and " + this.warwins + " war(s)\n";
		return out;
	}

}
