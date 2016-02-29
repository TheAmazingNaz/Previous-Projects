package proj1;
import java.util.Scanner;

/**
* File:    Proj1.java
* Project: CMSC 202 Project 1, Spring 2009
* Author:  Yakubu Nazif Wanka
* Date:    2/21/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
*/

public class proj1
 {

	//Declares a new Scanner object
	static Scanner keyboard = new Scanner(System.in);

	public static void main(String[] args)
	{
	        // TODO Auto-generated method stub
	      	//Creates the account asks the user to
	        // create their account and then opens up the menu
		 account myaccount;
		 myaccount = CreateAccount();
		 Choice(myaccount);
	}
	
	/**
	* Name: Choice
	* PreCondition:  It assumes the account object has been initialized
	* PostCondition: The menu interface is opened for the user.
	* @param myaccount - The users account   
	*/
	private static void Choice(account myaccount)
	{
		String choice;
		char letter = 0;
		//Keeps the menu open until the user chooses to quit
		while(letter != 'Q' || letter != 'q')
		{
			PrintMenu();
			//Takes in the users menu choice
			choice = keyboard.next();
			letter = choice.charAt(0);

			//Depending on the users choice several
			//actions could be taken
			switch (letter)
			{
				case 'D':
				   double deposit;
				     System.out.println("How much would you like to deposit?");
					deposit = keyboard.nextDouble();
					//If the user enters a valid amount, it is deposited. If not the user is returned
					//to the menu
					if(myaccount.DepositMoney(deposit))
					{
						System.out.println("Your New Balance Is: ");
						myaccount.PrintAccount();
					}
					else
					{
						System.out.println("Invalid Input. Return to menu");
						Choice(myaccount);
					}
					break;
				case 'W':
					double withdraw;
					System.out.println("How much would you like to withdraw?");
					withdraw = keyboard.nextDouble();
					if(myaccount.WithdrawMoney(withdraw))
					{
						System.out.println("Your New Balance Is: ");
						myaccount.PrintAccount();
					}
					else
					{
						System.out.println("Invalid Input. Return to menu");
						Choice(myaccount);
					}	
					break;
				case 'I':
					//The account info is printed.
					myaccount.PrintAccount();
					break;
				case 'R':
					float newinterest;
					System.out.println("What would you like to Change The Rate to?");
					newinterest = keyboard.nextFloat();
					if(myaccount.ChangeInterest(newinterest))
					{
						System.out.println("Your New Rate Is: ");
						myaccount.PrintAccount();
					}	
					else
					{
						System.out.println("Invalid Input. Return to menu");
						Choice(myaccount);
					}
					break;
				case 'A':
					myaccount.AccrueInterest();
					System.out.println("Your New Balance Is: ");
					myaccount.PrintAccount();
					break;
				case 'Q':
					System.out.println("Have a nice day!");
					System.exit(0);
					
				//the same choices if the user enters their menu options in lower case letters
				case 'd':
					double deposit1;
					System.out.println("How much would you like to deposit?");
					deposit1 = keyboard.nextDouble();
					if(myaccount.DepositMoney(deposit1))
					{
						System.out.println("Your New Balance Is: ");
						myaccount.PrintAccount();
					}
					else
					{
						System.out.println("Invalid Input. Return to menu");
						Choice(myaccount);
					}
					break;
				case 'w':
					double withdraw1;
					System.out.println("How much would you like to withdraw?");
					withdraw1 = keyboard.nextDouble();
					if(myaccount.WithdrawMoney(withdraw1))
					{
						System.out.println("Your New Balance Is: ");
						myaccount.PrintAccount();
					}
					else
					{
						System.out.println("Invalid Input. Return to menu");
						Choice(myaccount);
					}
					break;
				case 'i':
					myaccount.PrintAccount();
					break;
				case 'r':
					float newinterest1;
					System.out.println("What would you like to Change The Rate to?");
					newinterest1 = keyboard.nextFloat();
					if(myaccount.ChangeInterest(newinterest1))
					{
						System.out.println("Your New Rate Is: ");
						myaccount.PrintAccount();
					}
					else
					{
						System.out.println("Invalid Input. Return to menu");
						Choice(myaccount);
					}
					break;
				case 'a':
					myaccount.AccrueInterest();
					System.out.println("Your New Balance Is: ");
					myaccount.PrintAccount();
					break;
				case 'q':
					System.out.println("Have a nice day!");
					System.exit(0);
				default:
					break;
			}
		}
	}
	/**
	* Name: PrintMenu
	* PreCondition:  None really.
	* PostCondition: Prints out the menu for the user
	* @param void - None   
	*/
	private static void PrintMenu()
	{
		System.out.println("\nWhat would you like to do?");
		System.out.println("D - Deposit Money");
		System.out.println("W - Withdraw Money");
		System.out.println("I - Account Inquiry");
		System.out.println("R - Change Interest Rate");
		System.out.println("A - Accrue Interest");
		System.out.println("Q - Quit");
	}
	
	/**
	* Name: CreateAccount
	* PreCondition: The only the it assumes is that it is called when a user wants to create a new account
	* PostCondition: Creates an account object with the users name, and pin with $0.00 
	* 				 balance and a 2.5 %interest rate
	* @param void - None   
	*/
	private static account CreateAccount()
	{
		account myaccount = new account();
		String entername;
		
		int enteredpin;
			
		System.out.println("Welcome to Yakubu Nazif Wanka International Bank!");
		System.out.println("Please Create Your Account");
		
		System.out.println("Name: ");
		entername = keyboard.nextLine();
			
		System.out.println("Pin: ");
		enteredpin = keyboard.nextInt();
		myaccount.SetAccount(entername, enteredpin);
		return myaccount;
	}

}
