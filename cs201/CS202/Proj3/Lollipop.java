package proj3.c;
import java.awt.Color;

/**
* File:    Lollipop.java
* Project: CMSC 202 Project 3, Spring 2009
* Author: Yakubu Wanka
* Date:    4/12/09
* Section: 0301
* E-mail:  yakubu1@umbc.edu 
* Class Invariant
*	1. Every Lollipop has a price that is greater than 0
*   2. Every Lollipop has a color that can be expressed as an RGB value.
*/
public class Lollipop{
	private Color color;	
	public final static double price = 0.35;
	
	/**
	 * Pre-Conditions: color1 is not null
	 * Post-Conditions: Copys the RGB of the color1 to that of the Lollipops color
	 * @param color1
	 */
	public Lollipop(Color color1){
		int b = color1.getBlue();
		int r = color1.getRed();
		int g = color1.getGreen();
		this.color = new Color(r, g, b);
	}
	
	/**
	 * Name: getColor
	 * Pre-Condition: None
	 * Post-Condition: Returns the color of the calling Lollipop
	 * @return
	 */
	public Color getColor() {
		return color;
	}
	
}



