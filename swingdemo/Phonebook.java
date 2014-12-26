package swingdemo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Phonebook  {
	JTextField jtfName;
	JTextField jtfNumber;
	
	JRadioButton jrbExact;
	JRadioButton jrbStartWith;
	JRadioButton jrbEndsWith;
	
	JCheckBox jcbIgnoreCase;
	
	String[][] phonelist = {
			{"John", "555-8765"},
			{"Jessica", "555-1212"},
			{"Adam", "555-5643"},
			{"Rachel", "555-3435"},
			{"Tom & Jerry", "555-1001"}
	};
	
	Phonebook() {
		JFrame jfrm = new JFrame("A Simple Phone List");
		
		jfrm.setLayout(new GridLayout(0,1));
		jfrm.setSize(240, 220);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jlabName = new JLabel("Name");
		JLabel jlabNumber = new JLabel("Number");
		JLabel jlabOptions = new JLabel("Search Options");
		
		jtfName = new JTextField(10);
		jtfNumber = new JTextField(10);
		
		jcbIgnoreCase = new JCheckBox("Ignore Case");
		
		jrbExact = new JRadioButton("Exact Match", true);
		jrbStartWith = new JRadioButton("Start With");
		jrbEndsWith = new JRadioButton("Ends With");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrbExact);
		bg.add(jrbStartWith);
		bg.add(jrbEndsWith);
		
		jtfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jtfNumber.setText(lookupName(jtfName.getText()));
			}
		});
		
		jtfNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jtfName.setText(lookupNumber(jtfNumber.getText()));
			}
		});
		
		jfrm.add(jlabName);
		jfrm.add(jtfName);
		jfrm.add(jlabNumber);
		jfrm.add(jtfNumber);
		jfrm.add(new JLabel());
		jfrm.add(jlabOptions);
		jfrm.add(jcbIgnoreCase);
		jfrm.add(new JLabel());
		jfrm.add(jrbExact);
		jfrm.add(jrbStartWith);
		jfrm.add(jrbEndsWith);
		
		jfrm.setVisible(true);	
		
		
	}
	
	String lookupName(String n) {
		for (int i = 0; i < phonelist.length; i++){
			if(jrbStartWith.isSelected()) {
				if(jcbIgnoreCase.isSelected()) {
					if(phonelist[i][0].toLowerCase().startsWith(n.toLowerCase()))
				return phonelist[i][1];
				} else {
					if(phonelist[i][0].startsWith(n))
				return phonelist[i][1];
				}
				
			}
			else if(jrbEndsWith.isSelected()) {
				if(jcbIgnoreCase.isSelected()) {
					if(phonelist[i][0].toLowerCase().endsWith(n.toLowerCase()))
				return phonelist[i][1];
				} else {
					if(phonelist[i][0].endsWith(n))
				  return phonelist[i][1];
				} 
			}
			else {
				if(jcbIgnoreCase.isSelected()) {
					if(phonelist[i][0].toLowerCase().equals(n.toLowerCase()))
				return phonelist[i][1];
				}else {
					if(phonelist[i][0].equals(n))
						return phonelist[i][1];
				}
			}
		}
		return "Not Found";
	}
	
	String lookupNumber(String n) {
		for(int i=0; i < phonelist.length; i++) {
			if(phonelist[i][1].equals(n))
				return phonelist[i][0];
		}
		return "Not Found";
	}

	

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Phonebook();
			}
		});

	}

}
