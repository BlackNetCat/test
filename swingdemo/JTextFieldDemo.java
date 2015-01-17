package swingdemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JTextFieldDemo implements ActionListener {

	JTextField jtf;
	JLabel jlab;
	
	JTextFieldDemo() {
		JFrame jfrm = new JFrame("A Text Field Example");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(240,90);
		jtf = new JTextField(10);
		jtf.addActionListener(this);		
		jfrm.add(jtf);
		jlab = new JLabel("");
		jfrm.add(jlab);
		jfrm.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		jlab.setText("Current contents : " + jtf.getText());

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JTextFieldDemo();
			}
		});

	}

}
