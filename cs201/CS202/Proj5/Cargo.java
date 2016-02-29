/**
 * Cargo.java
 * 
 * This file models one piece of Cargo that will be loaded onto a Ship
 * 
 * The student is responsible for implementing the methods defined
 * in the Transportable interface
 * 
 */
package proj5;

public class Cargo implements Transportable<Cargo> {

	private int width, height, length, weight;
	private String label;

	/**
	 * Pre-Conditions: Assumes inputs are not null 
	 * Post-Condition: Initiates all instance variables
	 */
	public Cargo(int width, int height, int length, int weight, String label) {
		super();
		this.width = width;
		this.height = height;
		this.length = length;
		this.weight = weight;
		this.label = label;
	}

	/**
	 * Name: compareID 
	 * Pre-Conditions: None 
	 * Post-Condition: checks if the label matches that of the calling cargo
	 */
	public boolean compareID(String id) {
		if (this.label.equalsIgnoreCase(id))
			return true;
		else
			return false;
	}

	/**
	 * Name: compareTo 
	 * Pre-Conditions: the inputed cargo is not null
	 * Post-Condition: checks if the label matches that of the calling person
	 */
	public int compareTo(Cargo arg0) {
		if (this.label.compareTo(arg0.label) > 0)
			return 1;
		else if (this.label.equalsIgnoreCase(arg0.label))
			return 0;
		else
			return -1;
	}

	/**
	 * Name: getTransportID 
	 * Pre-Conditions: None 
	 * Post-Condition: returns the cargos label
	 */
	public String getTransportID() {
		return label;
	}

	/**
	 * Name: toString 
	 * Pre-Conditions: None 
	 * Post-Condition: returns the Cargo information as a string
	 */
	public String toString() {
		String s = label + "\t" + length + " x " + width + " x " + height
				+ " x " + weight + "\r\n";
		return s;
	}
}
