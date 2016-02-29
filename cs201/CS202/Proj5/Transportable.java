
/**
 * Transportable.java
 * 
 * Defines the Transportable interface for project 5
 * getTransportID( ) returns the unique String that identifies the
 * object that implements it
 * 
 * Note that Transportable extends Comparable
 * 
 * This interface is required so that the Ship can access an item's unique
 * ID when searching for an item to unload
 * 
 * D. Frey, April 2009
 * 
 */
package proj5;

public interface Transportable<T> extends Comparable<T>{
	String getTransportID( );
}
