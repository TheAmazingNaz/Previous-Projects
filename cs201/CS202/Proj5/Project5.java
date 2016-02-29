/**
 * Project5.java for Spring 2009
 * 
 * This file contains most of main( ) for project 5
 * Students must complete this file as part of the project 5 assignment
 * 
 * D. L. Frey, April 2009
 */
package proj5;

import java.util.*;
import java.io.*;

public class Project5 {

	// Variables used in multiple methods
	private static Scanner cmdFile; // file to be read that contains commands
	private static PrintWriter logFile; // log file for all project output
	private static String shipType; // "cargo" or "cruise"

	/**
	 * Name: ChangeSpeed
	 * Pre-Conditions: None 
	 * Post-Condition: Changes the speed according to user specifications
	 * 			  	   then prints the results to the log
	 * @throws SpeedIncreaseException
	 * @throws TransportException
	 */
	private static <T extends Transportable<T>> void ChangeSpeed(Ship<T> ship)
			throws SpeedIncreaseException, TransportException {
		logFile.print("\r\nSPEED: ");
		int newSpeed = cmdFile.nextInt();
		logFile.print(newSpeed);
		if (ship.getStatusCode() == 2) {		//If the ship is at sea
			if (ship.getMaxSpeed() > newSpeed) {//If the specified speed is less than the maximum speed
				ship.setCurrentSpeed(newSpeed);
				ship.setState("Under way from " + ship.getOrigin() + " to "
						+ ship.getDestination() + " at "
						+ ship.getCurrentSpeed() + " knots");
				logFile.print("\r\n      Speed Change complete");
			} else
				throw new SpeedIncreaseException(
						"The inputed speed is too fast");
		} else
			throw new TransportException("INCREASE speed request while in port");

	}

	/**
	 *  Name: LoadCargo
	 *	Pre-Conditions: None
	 * 	Post-Condition: Loads items unto the ship according to user specs then logs results
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Transportable<T>> void LoadCargo(Ship<T> ship)
			throws FullyLoadedShipException {
		logFile.print("\r\nLOAD");
		String label = cmdFile.nextLine();
		int weight = cmdFile.nextInt();
		int height = cmdFile.nextInt();
		int width = cmdFile.nextInt();
		int length = cmdFile.nextInt();
		logFile.print(" " + label + " " + weight + " " + height + " " + width
				+ " " + length);
		if (ship.getMaxItems() > ship.getNumberitems()) {
		    Object cargo = new Cargo(width, height, length, weight, label);
		    ship.AddElements((T) cargo);
		} else
			throw new FullyLoadedShipException("The ship is already full");
		logFile.print("\r\n       Item Loaded");
	}

	@SuppressWarnings("unchecked")
	/**
	 *  Name: LoadPeople
	 *	Pre-Conditions: None
	 * 	Post-Condition: Loads items unto the ship according to user specs then logs results
	 */
	private static <T extends Transportable<T>> void LoadPeople(Ship<T> ship)
			throws FullyLoadedShipException {
		logFile.print("\r\nLOAD");
		String name = cmdFile.nextLine();
		name = cmdFile.nextLine();
		int age = cmdFile.nextInt();
		String id = cmdFile.nextLine();
		logFile.print(" " + name + " " + age + " " + id);
		if (ship.getMaxItems() > ship.getNumberitems()) {
		    Obejct person = new Person(id, age, name);
		    ship.AddElements((T) person);
		} else
			throw new FullyLoadedShipException("The ship is already full");
		logFile.print("\r\n       Item Loaded");
	}

	public static void main(String[] args) {
		// read the command line arguments -- see project description
		// to reduce code, assume command line args are valid per project
		// description
		shipType = args[0];
		String origin = args[1];
		int minSpeed = Integer.parseInt(args[2]);
		int maxSpeed = Integer.parseInt(args[3]);
		int maxItems = Integer.parseInt(args[4]);

		// try to open the command file and log file
		try {
			cmdFile = new Scanner(new FileInputStream(args[5]));
			logFile = new PrintWriter(new FileOutputStream(args[6]), true);

			// create the appropriate kind of Ship and pass it to
			// ProcessCommands
			if (shipType.equalsIgnoreCase("cargo")) {
				ProcessCommands(new Ship<Cargo>(origin, maxItems, minSpeed,
						maxSpeed));
			} else if (shipType.equalsIgnoreCase("cruise")) {
				ProcessCommands(new Ship<Person>(origin, maxItems, minSpeed,
						maxSpeed));
			} else {
				System.out.print("Invalid ship type");
			}

			// close the files
			logFile.close();
			cmdFile.close();
		}

		catch (FileNotFoundException e) {
			// one of the files could not be opened, exit gracefully
			System.err.print("Can't open one of" + args[5] + " or " + args[6]);
			System.exit(-6);
		}
	}

	// ProcessCommands
	// Reads the command file, calls appropriate methods of the Ship
	// and outputs the results to the logfile
	// Each command and command parameter is on a separate line in the file
	//
	// All commands and their parameters are echoed to the log file
	//
	// Some methods of the ship throw a TransportException object. Each method
	// that throws
	// this exception should include a meaningful message to be written to the
	// logfile
	//
	// Note -- when passing a Cargo object or Person object to your Ship's load(
	// ) method
	// it will be necessary to cast it to type T as in
	// ship.load( (T)cargo );
	//
	private static <T extends Transportable<T>> void ProcessCommands(
			Ship<T> ship) {
		String command;
		boolean endOfFile = false;
		while (!endOfFile) {
			try {
				command = cmdFile.next();
				if (command.equalsIgnoreCase("PRINT")) {
					logFile.print("\r\nPRINT");
					logFile.print(ship.toString());
				}

				else if (command.equalsIgnoreCase("LOAD")) {
					if (ship.getStatusCode() == 1) {
						if (shipType.equalsIgnoreCase("cargo")) {
							cmdFile.nextLine();
							LoadCargo(ship);
						} else if (shipType.equalsIgnoreCase("cruise")) {
							cmdFile.nextLine();
							LoadPeople(ship);
						}
					} else
						throw new TransportException(
								"Load request while at sea");
				}

				else if (command.equalsIgnoreCase("DOCK")) {
					logFile.print("DOCK    ");
					if (ship.getStatusCode() == 2) {
						ship.setOrigin(ship.getDestination());
						ship.setStatusCode(1);
						ship.setState("In port at " + ship.getOrigin());
						ship.setCurrentSpeed(0);
					} else
						throw new TransportException(
								"Launch request while at sea");
				}

				else if (command.equalsIgnoreCase("UNLOAD")) {
					Unload(ship);
				}

				else if (command.equalsIgnoreCase("QUIT")) {
					logFile.print("\r\nQUIT");
					endOfFile = true;
				}

				else if (command.equalsIgnoreCase("SPEED")) {
					ChangeSpeed(ship);
				}

				else if (command.equalsIgnoreCase("LAUNCH")) {
					logFile.print("\r\nLAUNCH: ");
					String destination = cmdFile.nextLine();
					destination = cmdFile.nextLine();
					ship.setDestination(destination);
					logFile.print(destination);
					if (ship.getStatusCode() == 1) {
						ship.setStatusCode(2);
						ship.setState("Under way from " + ship.getOrigin()
								+ " to " + destination + " at "
								+ ship.getCurrentSpeed() + " knots");
					} else
						throw new TransportException(
								"Launch request while at sea");
				}
			}

			// This is the only exception class thrown by Ship methods
			catch (TransportException te) {
				logFile.print("   CMD ERROR: " + te.getMessage());
			} catch (SpeedIncreaseException te) {
				logFile.print("   CMD ERROR: " + te.getMessage());
			} catch (FullyLoadedShipException e) {
				logFile.print("   CMD ERROR: " + e.getMessage());
			} catch (ItemNotLoadedException e) {
				logFile.print("   CMD ERROR: " + e.getMessage());
			}
		}
	}

	/**
	 * Name: Unload
	 * Pre-Conditions: None 
	 * Post-Condition: Unloads what the user specifies from the ship
	 * 				   and logs the results
	 * @throws ItemNotLoadedException
	 * @throws TransportException
	 */
	@SuppressWarnings("unchecked")
	private static <T extends Transportable<T>> void Unload(Ship<T> ship)
			throws ItemNotLoadedException, TransportException {
		logFile.print("\r\nUNLOAD   ");
		String label = cmdFile.nextLine();
		label = cmdFile.nextLine();
		logFile.print(label);
		if (ship.getStatusCode() == 1) {
			if (shipType.equalsIgnoreCase("cargo")) {
				//makes a dummy Cargo object with the specified label then looks for a matching
				//person to remove
			    Object cargo = new Cargo(0, 0, 0, 0, label);
			    boolean removed = ship.RemoveElement((T) cargo);
				if (removed) {
					logFile.print("\r\n       Item Unloaded");
				} else {
					logFile.print("\r\n       Item not found");
				}
			} else if (shipType.equalsIgnoreCase("cruise")) {
				
				//makes a dummy Person with the specified id then looks for a matching
				//person to remove
			    Object person = new Person(label, 0, "dummy");
			    boolean removed = ship.RemoveElement((T) person);
				if (removed) {
					logFile.print("\r\n       Item Unloaded");
				} else
					throw new ItemNotLoadedException(
							"\r\n       Item not found");
			}
		} else
			throw new TransportException("Unload request while at sea");
	}
}
