package swingdemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ButtonDemo implements ActionListener {
	
	JLabel jlab;
	
	ButtonDemo() {
		JFrame jfrm = new JFrame("A Button Example");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(220, 90);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		JButton jbtnFirst = new JButton("First");
		JButton jbtnSecond = new JButton("Second");
		jbtnFirst.addActionListener(this);
		jbtnSecond.addActionListener(this);
			
		jfrm.add(jbtnFirst);
		jfrm.add(jbtnSecond);
			
		jlab = new JLabel("Press a button");
			
		jfrm.getContentPane().add(jlab);
			
		jfrm.setVisible(true);
	}
	
			
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("First"))
			jlab.setText("First button was pressed.");
		else
			jlab.setText("Second button was pressed. ");

	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new ButtonDemo();
			}
		});

	}

}
