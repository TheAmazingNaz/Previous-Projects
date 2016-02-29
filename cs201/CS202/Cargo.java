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

	public Cargo(int width, int height, int length, int weight, String label) 
	{
		super();
		this.width = width;
		this.height = height;
		this.length = length;
		this.weight = weight;
		this.label = label;
	}
	
	public String toString( )
	{
		String s = label + "\t" + length + " x " + width + " x " + height + "\t" + weight;
		return s;
	}
}
