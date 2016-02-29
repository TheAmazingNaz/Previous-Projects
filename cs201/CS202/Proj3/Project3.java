/**
 * File: Project3. java
 * Author: D. Frey
 * Date: March 11, 2009
 * 
 * This file contains the GUI for the Snack Machine project
 *
 * DO NOT edit this file
 * DO NOT submit this file
 * 
 */
package proj3;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Project3
{

	public static void main (String [] args)
	{
		Project3 p3 = new Project3( );
	}

	private SnackMachine snackMachine;
	private JSpinner spinNickels, spinDimes, spinQrts;
	private JFrame mainFrame;
	
	public Project3 ( )
	{
		snackMachine = new SnackMachine( );
		
		// spinners for coins inserted

		
		mainFrame = new JFrame("CMSC 202 Project 3");
		mainFrame.setLayout(new BorderLayout());
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(1000, 500);
		mainFrame.setLocation(100, 50);

		// Maintenance Menus 
		JMenuBar jmb = new JMenuBar( );
		
		// Create the Snack Maintenance Menu System
		JMenu jmSnack = new JMenu("Snack Maintenance");
		JMenuItem jmiAddPlainChips = new JMenuItem("Add Plain Chips");
		JMenuItem jmiAddSandVChips = new JMenuItem("Add Salt & Vinegar Chips");
		JMenuItem jmiAddBBQChips = new JMenuItem("Add BBQ Chips");
		JMenuItem jmiAddLollipops = new JMenuItem("Add Lollipops");
		JMenuItem jmiNrLollipops = new JMenuItem("Lollipop Count");
		JMenuItem jmiNrBagsOfChips = new JMenuItem("Bag Count");
		
		// attach action listeners for each menu choice
		jmiAddPlainChips.addActionListener(new AddPlainChips());
		jmiAddSandVChips.addActionListener(new AddSVChips());
		jmiAddBBQChips.addActionListener(new AddBBQChips());
		jmiAddLollipops.addActionListener(new AddLollipops());
		jmiNrLollipops.addActionListener(new NrLollipops());
		jmiNrBagsOfChips.addActionListener(new NrBagsOfChips());
		
		// add menu items to SnackMaintenance Menu
		jmSnack.add( jmiAddPlainChips);
		jmSnack.add( jmiAddSandVChips);
		jmSnack.add( jmiAddBBQChips);
		jmSnack.add( jmiAddLollipops);
		jmSnack.add( jmiNrLollipops);
		jmSnack.add( jmiNrBagsOfChips);
		
		// Register Maintenance Menu
		JMenu jmRegister = new JMenu("Cash Register Maintenance");
		JMenuItem jmiCashOnHand = new JMenuItem("Report Cash on Hand");
		
		// add action listeners for menu items
		jmiCashOnHand.addActionListener( new CashOnHand());		
		jmRegister.add(jmiCashOnHand);
		
		// add menu lists to menu bar
		jmb.add(jmSnack);		
		jmb.add(jmRegister);
		
		// add menu bar to frame
		mainFrame.setJMenuBar(jmb);
		
		// Marquee in the NORTH
		JLabel jlMarquee = new JLabel( "CMSC 202 Mystery Snack Machine");
		jlMarquee.setFont(new Font("Times New Roman", Font.BOLD, 24));
		jlMarquee.setHorizontalAlignment(JTextField.CENTER);
		mainFrame.add(jlMarquee, BorderLayout.NORTH);
		
		// Buttons for purchases in the CENTER of the frame
		JPanel jpButtons = new JPanel( );
		jpButtons.setLayout(new GridLayout(1, 2));
		JButton jbLollipops = new JButton( "<html><center>Buy Lollipop<p>35 cents</center></html>");
		jbLollipops.setBackground(Color.ORANGE);
		jbLollipops.setFont( new Font("Times New Roman", Font.BOLD, 42));
		jbLollipops.setFocusPainted(false);
		jbLollipops.addActionListener(new BuyLollipop());
		
		JButton jbChips = new JButton( "<html><center>Buy Bag of Chips<p>65 cents</center></html>");
		jbChips.setBackground(Color.MAGENTA);
		jbChips.setFont( new Font("Times New Roman", Font.BOLD, 42));
		jbChips.setFocusPainted(false);
		jbChips.addActionListener(new BuyBagOfChips());
		jpButtons.add( jbLollipops);
		jpButtons.add( jbChips);
		
		// Spinners for coin insertion in the SOUTH
		JPanel jpCoins = new JPanel( ); // to encapsulate labels and spinners
		Dimension spinnerDim = new Dimension(50, 20);
		Font labelFont = new Font("Times New Roman", Font.BOLD, 24);

		SpinnerNumberModel spnmNickels = new SpinnerNumberModel(0, 0, 20, 1);
		spinNickels = new JSpinner( spnmNickels );
		spinNickels.setPreferredSize(spinnerDim);
		SpinnerNumberModel spnmDimess = new SpinnerNumberModel(0, 0, 10, 1);
		spinDimes = new JSpinner( spnmDimess );
		spinDimes.setPreferredSize(spinnerDim);
		SpinnerNumberModel spnmQtrs = new SpinnerNumberModel(0, 0, 4, 1);
		spinQrts = new JSpinner( spnmQtrs );
		spinQrts.setPreferredSize(spinnerDim);
		
		JLabel jlInsertCoins = new JLabel("Insert Coins Here              ");
		jlInsertCoins.setFont(new Font("Times New Roman", Font.BOLD, 24));
		jpCoins.add(jlInsertCoins);
		JLabel jlNickels = new JLabel("Nickels");
		jlNickels.setFont(labelFont);
		jlNickels.setHorizontalAlignment(JLabel.RIGHT);
		jpCoins.add(jlNickels);
		jpCoins.add(spinNickels);
		JLabel jlDimes = new JLabel("Dimes");
		jlDimes.setFont(labelFont);
		jlDimes.setHorizontalAlignment(JLabel.RIGHT);
		jpCoins.add(jlDimes);
		jpCoins.add(spinDimes);
		JLabel jlQrts = new JLabel("Quarters");
		jlQrts.setFont(labelFont);
		jlQrts.setHorizontalAlignment(JLabel.RIGHT);
		jpCoins.add(jlQrts);
		jpCoins.add(spinQrts);
		
		// populate the main frame
		mainFrame.add(jpButtons, BorderLayout.CENTER);
		mainFrame.add(jpCoins, BorderLayout.SOUTH);
		mainFrame.setVisible( true );
	}

	// -- helper methods
	private void resetSpinners( )
	{
		spinNickels.setValue(new Integer(0));
		spinDimes.setValue(new Integer(0));
		spinQrts.setValue( new Integer(0));
	}


	//----  event handlers ---  //
	
	// Buy Lollipop Button
	private class BuyLollipop implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// read the coins inserted
			int nrNickels, nrDimes, nrQrts;
			nrNickels = ( (Integer)spinNickels.getValue()).intValue();
			nrDimes = ( (Integer)spinDimes.getValue()).intValue();
			nrQrts = ( (Integer)spinQrts.getValue()).intValue();
			
			// buy the Lollipop, get Lollipop in return
			Lollipop pop = snackMachine.buyLollipop(new Money(nrNickels, nrDimes, nrQrts));
			if ( pop == null )	// sold out or not exact change			
				JOptionPane.showMessageDialog(mainFrame, "Lollipop purchase failed");
			
			else {
				// purchase successful
				RoundIcon lPop = new RoundIcon(pop.getColor(), 100);
				String msg = "Congratulation! You bought this Lollipop";
				JOptionPane.showMessageDialog(null, msg, 
						"Lollipop Purchase", JOptionPane.INFORMATION_MESSAGE, lPop);
			}
			
			// reset coin spinners
			resetSpinners( );
		}
	}

	// Buy Bag of Chips Button
	private class BuyBagOfChips implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// read the coins inserted
			int nrNickels, nrDimes, nrQrts;
			nrNickels = (Integer)spinNickels.getValue();
			nrDimes = (Integer)spinDimes.getValue();
			nrQrts = (Integer)spinQrts.getValue();
			
			// buy the bag of chips, get BagOfChips in return
			BagOfChips bag = snackMachine.buyChips(new Money(nrNickels, nrDimes, nrQrts));
			if ( bag == null )		// purchase failed
				JOptionPane.showMessageDialog(mainFrame, "bar purchase failed");
			else { 
				// purchase successful
				String msg = "Congratulations! You bought a" + bag.toString();
				JOptionPane.showMessageDialog(null, msg); 
			}
			
			// reset coin spinners
			resetSpinners( );
		}
	}
	
	// Snack Maintenance Menu -- add bags of plain chips
	private class AddPlainChips implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			addChips( BagOfChips.Flavor.PLAIN );
		}
	}

	//  Snack Maintenance Menu -- add salt and vinegar chips
	private class AddSVChips implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			addChips( BagOfChips.Flavor.SALT_AND_VINEGAR );
		}
	}

	//  Snack Maintenance Menu -- add salt and vinegar chips
	private class AddBBQChips implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			addChips( BagOfChips.Flavor.BBQ );
		}
	}

	// common method for adding bags of chips
	// some stuff marked "final" so they can be used within anonymous ActionListener
	private void addChips(final BagOfChips.Flavor flavor)
	{
		// pop a frame and ask how many
		final JFrame frame = new JFrame( );
		frame.setResizable(true);
		frame.setLocation(300, 300);
		frame.setSize(500, 250);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		SpinnerNumberModel spnmNrBags = new SpinnerNumberModel(1, 1, 50, 1);
		final JSpinner spinNrBags = new JSpinner( spnmNrBags );
		spinNrBags.setPreferredSize(new Dimension(50, 20));
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int nrBags = (Integer)spinNrBags.getValue();
				BagOfChips bag = new BagOfChips( flavor );
				snackMachine.addChips(bag, nrBags);
				JOptionPane.showMessageDialog(frame, nrBags + " bags of " + bag.toString() + " added to the machine");
			}
		});
	
		JPanel subPanel1 = new JPanel();
		subPanel1.add( new JLabel("Input Number of Bags of " + flavor + " Flavored Chips to Add"));
		subPanel1.add(spinNrBags);
		JPanel subPanel2 = new JPanel();
		subPanel2.add(ok);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add( subPanel1, BorderLayout.NORTH );
		panel.add( subPanel2, BorderLayout.CENTER);
		panel.setBackground(Color.MAGENTA);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);

	}
	
	//  Snack Maintenance Menu -- add Lollipops
	private class AddLollipops implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// pop a frame and ask how many
			final JFrame frame = new JFrame( );
			frame.setResizable(false);
			frame.setLocation(200, 200);
			frame.setSize(500, 500);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			
			// color chooser

			JPanel subPanel1 = new JPanel();
			JLabel jlCount =new JLabel("Input Number of Lollipops Add");
			jlCount.setFont(new Font("Times New Roman", Font.BOLD, 18));
			SpinnerNumberModel spnmNrPops = new SpinnerNumberModel(1, 1, 50, 1);
			final JSpinner spinNrPops = new JSpinner( spnmNrPops );
			spinNrPops.setPreferredSize(new Dimension(50, 20));
			subPanel1.add(jlCount);
			subPanel1.add(spinNrPops);
			
			JPanel subPanel2 = new JPanel();
			JLabel jlColor = new JLabel("Choose Lollipop color");
			jlColor.setFont(new Font("Times New Roman", Font.BOLD, 18));
			final JColorChooser jccLollipopColor = new JColorChooser( );
			subPanel2.add (jlColor);
			subPanel2.add(jccLollipopColor);

			JPanel subPanel3 = new JPanel();
			JButton ok = new JButton("OK");
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					int nrPops = (Integer)spinNrPops.getValue();
					Color popColor = jccLollipopColor.getColor();
					Lollipop pop = new Lollipop( popColor );
					snackMachine.addLollipops(pop, nrPops);
					JOptionPane.showMessageDialog(frame, nrPops + " lollipops added to the machine");
				}
			});
			subPanel3.add(ok);
			
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.add( subPanel1, BorderLayout.NORTH );
			panel.add( subPanel2, BorderLayout.CENTER);
			panel.add( subPanel3, BorderLayout.SOUTH);
			panel.setBackground(Color.MAGENTA);
			
			frame.add(panel, BorderLayout.CENTER);
			frame.setVisible(true);
		}
	}

	//  Snack Maintenance Menu -- how many Lollipops in the machine?
	private class NrLollipops implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// create a frame to display the number
			int nrPops = snackMachine.getNrLollipops();
			String info = "The snack machine currently contains " + nrPops + " Lollipops";
			JOptionPane.showMessageDialog(mainFrame, info);
		}
	}

	// Snack Maintenance Menu -- how many bags of chips in the machine?
	private class NrBagsOfChips implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// create a frame to display the number
			int nrBags = snackMachine.getNrBagsOfChips();
			String info = "The snack machine currently contains " + nrBags + " bags of chips";
			JOptionPane.showMessageDialog(mainFrame, info);
		}
	}
	
	// Cash Maintenance Menu -- report cash on hand
	private class CashOnHand implements ActionListener
	{
		public void actionPerformed(ActionEvent ae)
		{
			// call snack machine method
			// report coins in machine -- share with RemoveFunds
			Money cashOnHand = snackMachine.getCashOnHand();
			String info = "The Cash Register contains\n" + cashOnHand.toString();
			JOptionPane.showMessageDialog(mainFrame, info);
		}
	}

	/**
	 * a round Icon with transparent corners
	 * Used to draw a lollipop
	 */
	public static class RoundIcon implements Icon {
		private Color color;
		private int diameter;
 
		public RoundIcon(Color color, int diameter) {
			this.color = color;
			this.diameter = diameter;
		}
		public int getIconHeight() {
			return diameter;
		}
		public int getIconWidth() {
			return diameter;
		}
		public void paintIcon(Component c, Graphics g, int x, int y) {
			g.setColor(color);
			g.fillArc(x, y, diameter, diameter, 0, 360);
		}
	}
}
