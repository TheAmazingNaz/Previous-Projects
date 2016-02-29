package proj4;
import java.util.*;


public class Project4 {
	static Scanner keyboard;
	static DSS docing;
	/**
	 * Name: DisplayEmailMenu
	 * Pre-Condition: None
	 * Post-Condition: Prompts the user for information to create an EMAIL.
	 */
	public static void DisplayEmailMenu()
	{
		String c = "";
		System.out.println("Enter EMAIL Information	: ");
		System.out.println("Enter author's name: ");
		String name = keyboard.nextLine();
		name = keyboard.nextLine();
		System.out.println("Enter recipient's name: ");
		String recname = keyboard.nextLine();
		System.out.println("Enter subject: ");
		String subject = keyboard.nextLine();
		System.out.println("Enter email address: ");
		String email = keyboard.nextLine();
		System.out.println("Enter Text (terminate with END on a separate line): : ");
		while(keyboard.findInLine("end") == null)
		{
			c +=  keyboard.nextLine() + "\n";
		}
		Email doc = new Email(name, docing.getIdnumber(), c, recname, subject, email);
		docing.adddoc(doc);
		System.out.println("Your EMAIL was assigned document ID " + doc.getId());
	}

	/**
	 * Name: DisplayMemoMenu
	 * Pre-Condition: None
	 * Post-Condition: Prompts the user for information to create a MEMO.
	 */
	public static void DisplayMemoMenu()
	{
		String distributionlist = "";
		String c = "";
		System.out.println("Enter MEMO Information	: ");
		System.out.println("Enter author's name: ");
		String name = keyboard.nextLine();
		name = keyboard.nextLine();
		System.out.println("Enter recipient's name: ");
		String recname = keyboard.nextLine();
		System.out.println("Enter subject: ");
		String subject = keyboard.nextLine();
		System.out.println("Enter Distribution List: ");
		while(keyboard.findInLine("end") == null)
		{
			distributionlist +=  keyboard.nextLine() + "\n";
		}
		System.out.println("Enter Text (terminate with END on a separate line): : ");
		while(keyboard.findInLine("end") == null)
		{
			c +=  keyboard.nextLine() + "\n";
		}
		Memo doc = new Memo(name, docing.getIdnumber(), c, recname, subject, distributionlist);
		docing.adddoc(doc);
		System.out.println("Your MEMO was assigned document ID " + doc.getId());
	}

	/**
	 * Name: DisplayMenu
	 * Pre-Condition: None
	 * Post-Condition: Displays the Menu for the user.
	 */
	public static void DisplayMenu()
	{
		System.out.println("Document Storage System Menu\n 1. Add an Email\n 2. Add a Memo\n 3. Add a Report");
		System.out.println(" 4. Print a Document\n 5. List all Documents\n 6. Find Word/Phrase\n 7. Remove a Document\n 99. Quit\n Enter Choice: ");
	}

	/**
	 * Name: DisplayReportMenu
	 * Pre-Condition: None
	 * Post-Condition: Prompts the user for information to create a REPORT.
	 */
	public static void DisplayReportMenu()
	{
		String c = "";
		System.out.println("Enter MEMO Information	: ");
		System.out.println("Enter author's name: ");
		String name = keyboard.nextLine();
		name = keyboard.nextLine();
		System.out.println("Enter Title: ");
		String title = keyboard.nextLine();
		System.out.println("Enter Text (terminate with END on a separate line): : ");
		while(keyboard.findInLine("end") == null)
		{
			c +=  keyboard.nextLine() + "\n";
		}
		Reports doc = new Reports(name, docing.getIdnumber(), c, title);
		docing.adddoc(doc);
		System.out.println("Your REPORT was assigned document ID " + doc.getId());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		docing = new DSS();
		UserInterface();
	}

	/**
	 * Name: UserInterface
	 * Pre-Condition: None
	 * Post-Condition: Launches the user interface for the program.
	 */
	public static void UserInterface()
	{
		int choice = 0;
		try {
			while(choice != 99)
			{
				DisplayMenu();
				choice = keyboard.nextInt();
				if(choice == 1)
				{
					DisplayEmailMenu();
				}
				else if(choice == 2)
				{
					DisplayMemoMenu();
				}
				else if(choice == 3)
				{
					DisplayReportMenu();
				}
				else if(choice == 4)
				{
				    System.out.println("Enter Document ID: ");
				    int idn = keyboard.nextInt();
				    if(docing.Printdoc(idn) != null)
					System.out.println(docing.Printdoc(idn));
				    else
					throw new InputWrongException("No such document");
				}
				else if(choice == 5)
				{
					System.out.println("All Document Info: ");
					System.out.println(docing.PrintAlldocInfo());
				}
				else if(choice == 6)
				{
					System.out.println("Enter search term: ");
					String search = keyboard.nextLine();
					search += keyboard.nextLine();
					System.out.println(docing.findword(search));
				}
				else if(choice == 7)
				{
				    System.out.println("Enter Document ID: ");
				    int idn = keyboard.nextInt();
				    if(docing.Printdoc(idn) != null)
					System.out.println(docing.removedoc(idn));
				    else
					throw new InputWrongException("No such document");
				}
				else if(choice != 99)
					throw new InputWrongException("Wrong Input");
			}
		}

		catch (InputWrongException e) {
			System.out.println(e.getMessage());
			UserInterface();
		}

		catch(InputMismatchException e)
		{
			System.out.println("Wrong Input");
			UserInterface();
		}

		catch(Exception e)
		{
			e.getCause();
		}

		finally
		{
			keyboard.close();
		}
	}
}
