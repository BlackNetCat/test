package homeSW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Root {

	private JFrame frame;
	String tempB = "beverage";
	String tempT = "with topping ";
	double cost = 0;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Root window = new Root();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
				
	}

	/**
	 * Create the application.
	 */
	public Root() {
		initialize();
				
	}

	
	private void initialize() {
				
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frame.setBounds(100, 100, 673, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(299, 11, 96, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSelectDrink = new JLabel("Select Drink");
		lblSelectDrink.setBounds(10, 65, 125, 14);
		frame.getContentPane().add(lblSelectDrink);
		
		JLabel lblNewLabel_2 = new JLabel("Select Size");
		lblNewLabel_2.setBounds(10, 99, 125, 14);
		frame.getContentPane().add(lblNewLabel_2);		
		
		final JLabel toPay = new JLabel("");
		toPay.setBounds(48, 411, 538, 39);
		frame.getContentPane().add(toPay);
		
		final JLabel log = new JLabel("");
		log.setBounds(48, 440, 538, 39);
		frame.getContentPane().add(log);
		
		final JLabel log2 = new JLabel("");
		log2.setBounds(148, 440, 538, 39);
		frame.getContentPane().add(log2);
		
		final JLabel log3 = new JLabel("");
		log3.setBounds(248, 440, 538, 39);
		frame.getContentPane().add(log3);
		
		JLabel lblToPay = new JLabel("To Pay :");
		lblToPay.setBounds(48, 386, 46, 14);
		frame.getContentPane().add(lblToPay);
		
		final JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(420, 65, 155, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		final JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(420, 99, 220, 14);
		frame.getContentPane().add(lblNewLabel_4);		
		

		JLabel lblNewLabel_5 = new JLabel("Select Topping");
		lblNewLabel_5.setBounds(10, 133, 125, 14);
		frame.getContentPane().add(lblNewLabel_5);		
		
		final JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(420, 133, 155, 14);
		frame.getContentPane().add(lblNewLabel_6);		
	
	
		
		final JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBox) {
			       
			        	String msg = (String)comboBox.getSelectedItem();
			        	switch (msg) {			        	
			        	case "Espresso": 
			        
			        		lblNewLabel_3.setText("Espresso 2,00 $");
			        		tempB = "Espresso"; 			        		
			        		break;
			        	case "HouseBlend": 
			        	
			        		lblNewLabel_3.setText("HouseBlend 0,90 $");
			        		tempB = "HouseBlend"; 
		        			break;
			        	case "DarkRoast": 
			        	
			        		lblNewLabel_3.setText("DarkRoast 1,00 $");
			        		tempB = "DarkRoast"; 
		        			break;
			        	default: lblNewLabel_3.setText("Espresso");
			        		tempB = "Espresso"; 
			        	}
				}
			}
			           	
			
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Espresso", "HouseBlend", "DarkRoast"}));
		comboBox.setBounds(183, 62, 155, 20);
		frame.getContentPane().add(comboBox);
		
		
		/*final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBox_1) {
			      //  	JComboBox cb = (JComboBox)e.getSource();
			        	String msg = (String)comboBox_1.getSelectedItem();
			        	switch (msg) {
			        	case "None": 			        		
			        		
			        		if (tempB.equals("Espresso")) {
				        		Beverage ess = new Espresso();				        		
				        		tempT = " no toppings ";
				        		lblNewLabel_4.setText("None");
				        		cost = ess.cost();
				        		} 
				        		else if(tempB == "HouseBlend") {
				        			Beverage hb = new HouseBlend();					        	
				        			tempT = " no toppings ";
					        		cost = hb.cost();
				        		}
				        		else if(tempB == "DarkRoast") {
				        			Beverage dr = new DarkRoast();					        		
				        			tempT = " no toppings ";
					        		cost = dr.cost();
				        		}
				        		else
				        			lblNewLabel_4.setText("Error");
			        			break;			        		
			        		
			        	case "Mocha": 
			        		if (tempB.equals("Espresso")) {
			        		Beverage ess = new Espresso();
			        		ess  = new Mocha(ess);
			        		lblNewLabel_4.setText(ess.getDescription() + " " + ess.cost() + " $");
			        		tempT = " with Mocha ";
			        		cost = ess.cost();
			        		} 
			        		else if(tempB == "HouseBlend") {
			        			Beverage hb = new HouseBlend();
				        		hb  = new Mocha(hb);
				        		lblNewLabel_4.setText(hb.getDescription() + " " + hb.cost() + " $");
				        		tempT = " with Mocha ";
				        		cost = hb.cost();
			        		}
			        		else if(tempB == "DarkRoast") {
			        			Beverage dr = new DarkRoast();
				        		dr  = new Mocha(dr);
				        		lblNewLabel_4.setText(dr.getDescription() + " " + dr.cost() + " $");
				        		tempT = " with Mocha ";
				        		cost = dr.cost();
			        		}
			        		else
			        			lblNewLabel_4.setText("Error");
		        			break;
		        			
			        	case "Milk": 
			        		if (tempB.equals("Espresso")) {
				        		Beverage ess = new Espresso();
				        		ess  = new Milk(ess);
				        		lblNewLabel_4.setText(ess.getDescription() + " " + ess.cost() + " $");
				        		tempT = " with Milk ";
				        		cost = ess.cost();
				        		} 
				        		else if(tempB == "HouseBlend") {
				        			Beverage hb = new HouseBlend();
					        		hb  = new Milk(hb);
					        		lblNewLabel_4.setText(hb.getDescription() + " " + hb.cost() + " $");
					        		tempT = " with Milk ";
					        		cost = hb.cost();
				        		}		
		
				        		else if(tempB == "DarkRoast") {
				        			Beverage dr = new DarkRoast();
					        		dr  = new Milk(dr);
					        		lblNewLabel_4.setText(dr.getDescription() + " " + dr.cost() + " $");
					        		tempT = " with Milk ";
					        		cost = dr.cost();
				        		}
				        		else
				        			lblNewLabel_4.setText("Error");			        				        		
			        		
		        			break;
		        			
			        		case "Whip": 
			        		if (tempB.equals("Espresso")) {
				        		Beverage ess = new Espresso();
				        		ess  = new Whip(ess);
				        		lblNewLabel_4.setText(ess.getDescription() + " " + ess.cost() + " $");
				        		tempT = " with Whip ";
				        		cost = ess.cost();
				        		} 
				        		else if(tempB == "HouseBlend") {
				        			Beverage hb = new HouseBlend();
					        		hb  = new Whip(hb);
					        		lblNewLabel_4.setText(hb.getDescription() + " " + hb.cost() + " $");
					        		tempT = " with Whip ";
					        		cost = hb.cost();
				        		}
				        		else if(tempB == "DarkRoast") {
				        			Beverage dr = new DarkRoast();
					        		dr  = new Whip(dr);
					        		lblNewLabel_4.setText(dr.getDescription() + " " + dr.cost() + " $");
					        		tempT = " with Whip ";
					        		cost = dr.cost();
				        		}
				        		else
				        			lblNewLabel_4.setText("Error");			        				        		
			        		
		        			break;
			        	default: lblNewLabel_4.setText("None");
			        	}
				}
			}
			           	
			
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Standart", "Small", "Big"}));
		comboBox_1.setBounds(183, 96, 155, 20);
		frame.getContentPane().add(comboBox_1);*/
		
		
		
		final JCheckBox chboxMilk = new JCheckBox("Milk");
		chboxMilk.setBounds(183, 140, 155, 23);       
		chboxMilk.setSelected(false);
		frame.getContentPane().add(chboxMilk);
		

		final JCheckBox chboxMocha = new JCheckBox("Mocha");
		chboxMocha.setBounds(183, 160, 155, 23);       
		chboxMocha.setSelected(false);
		frame.getContentPane().add(chboxMocha);
		
		final JCheckBox chboxWhip = new JCheckBox("Whip");
		chboxWhip.setBounds(183, 180, 155, 23);       
		chboxWhip.setSelected(false);
		frame.getContentPane().add(chboxWhip);
	
				
		JButton btnCreateDrink = new JButton("Create Drink");
		btnCreateDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Beverage ess = new Espresso();
				Beverage hb = new HouseBlend();
				Beverage dr = new DarkRoast();				
				
				if (chboxMilk.getSelectedObjects() != null) {      // Milk Active
					log2.setText("milk (0.10)");
					
						if (tempB.equals("Espresso")) {
		        		
		        		ess  = new Milk(ess);
		        		lblNewLabel_4.setText(ess.getDescription() + " " + ess.cost() + " $");
		        		tempT = " with Milk ";
		        		cost = ess.cost();
		        		} 
		        		else if(tempB.equals("HouseBlend")) {
		        			
			        		hb  = new Milk(hb);
			        		lblNewLabel_4.setText(hb.getDescription() + " " + hb.cost() + " $");
			        		tempT = " with Milk ";
			        		cost = hb.cost();
		        		}
		        		else if(tempB.equals("DarkRoast")) {
		        			
			        		dr  = new Milk(dr);
			        		lblNewLabel_4.setText(dr.getDescription() + " " + dr.cost() + " $");
			        		tempT = " with Milk ";
			        		cost = dr.cost();
		        		}
		        		else
		        			lblNewLabel_4.setText("Error");
					
					
				}
				if (chboxMilk.getSelectedObjects() == null) {       // Milk not Active
					
					if (tempB.equals("Espresso")) {
			        	  
		        		cost = ess.cost();
		        		} 
		        		else if(tempB.equals("HouseBlend")) {
		        			
			        		cost = hb.cost();
		        		}
		        		else if(tempB.equals("DarkRoast")) {
		        			
			        		cost = dr.cost();
		        		}
		        		else
		        			lblNewLabel_4.setText("Error");					
				
					
					log2.setText("");
				}
				
				if (chboxMocha.getSelectedObjects() != null) {      // Mocha  active 
					log.setText("mocha (0.20)");
					
					if (tempB.equals("Espresso")) {
		        		
		        		ess = new Mocha(ess);
		        		lblNewLabel_4.setText(ess.getDescription() + " " + ess.cost() + " $");
		        		tempT = " with Mocha ";
		        		cost = ess.cost();
		        		} 
		        	else if(tempB.equals("HouseBlend")) {
		        			
			        		hb = new Mocha(hb);
			        		lblNewLabel_4.setText(hb.getDescription() + " " + hb.cost() + " $");
			        		tempT = " with Mocha ";
			        		cost = hb.cost();
		        		}
		        	else if(tempB.equals("DarkRoast")) {
		        			
			        		dr = new Mocha(dr);
			        		lblNewLabel_4.setText(dr.getDescription() + " " + dr.cost() + " $");
			        		tempT = " with Mocha ";
			        		cost = dr.cost();
		        		}
		        	else
		        			lblNewLabel_4.setText("Error");
					
					
				}
				if (chboxMocha.getSelectedObjects() == null) {    // Mocha not active
					
					if (tempB.equals("Espresso")) {
			        	  
		        		cost = ess.cost();
		        		} 
		        		else if(tempB.equals("HouseBlend")) {
		        			
			        		cost = hb.cost();
		        		}
		        		else if(tempB.equals("DarkRoast")) {
		        			
			        		cost = dr.cost();
		        		}
		        		else
		        			lblNewLabel_4.setText("Error");
					
					log.setText("");
				}
				
				
				if (chboxWhip.getSelectedObjects() != null) {            // Whip active
					
						if (tempB.equals("Espresso")) {
		        		
		        		ess = new Whip(ess);
		        		lblNewLabel_4.setText(ess.getDescription() + " " + ess.cost() + " $");
		        		tempT = " with Whip ";
		        		cost = ess.cost();
		        		} 
		        		else if(tempB.equals("HouseBlend")) {
		        			
			        		hb = new Whip(hb);
			        		lblNewLabel_4.setText(hb.getDescription() + " " + hb.cost() + " $");
			        		tempT = " with Whip ";
			        		cost = hb.cost();
		        		}
		        		else if(tempB.equals("DarkRoast")) {
		        			
			        		dr = new Whip(dr);
			        		lblNewLabel_4.setText(dr.getDescription() + " " + dr.cost() + " $");
			        		tempT = " with Whip ";
			        		cost = dr.cost();
		        		}
		        		else
		        			lblNewLabel_4.setText("Error");
					
					log3.setText("whip (0.15)");
				}
				if (chboxWhip.getSelectedObjects() == null) {       // Whip not active
					
					if (tempB.equals("Espresso")) {
			        	  
		        		cost = ess.cost();
		        		} 
		        		else if(tempB.equals("HouseBlend")) {
		        			
			        		cost = hb.cost();
		        		}
		        		else if(tempB.equals("DarkRoast")) {
		        			
			        		cost = dr.cost();
		        		}
		        		else
		        			lblNewLabel_4.setText("Error");					
				
					
					log3.setText("");
				}
				
				else {
					tempT = "not toppings";
				}
				
				
				toPay.setText(tempB + " " + tempT + (float)cost + " $");
				
			}
		});
		btnCreateDrink.setBounds(274, 255, 134, 23);
		frame.getContentPane().add(btnCreateDrink);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toPay.setText("");
				log.setText("");
				log2.setText("");
				log3.setText("");
			}
		});
		btnNewButton.setBounds(274, 300, 134, 23);
		frame.getContentPane().add(btnNewButton);		
		
		
	}
}
