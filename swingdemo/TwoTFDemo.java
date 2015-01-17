package swingdemo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TwoTFDemo implements ActionListener {
	JTextField jtf1;
	JTextField jtf2;
	JLabel jlab;
	
	TwoTFDemo() {
		JFrame jfrm = new JFrame("Use two Text Fields");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(340, 190);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jtf1 = new JTextField(10);
		jtf2 = new JTextField(10);
		
		jtf1.setActionCommand("One");
		jtf2.setActionCommand("Two");
		
		jtf1.addActionListener(this);
		jtf2.addActionListener(this);
		
		jfrm.add(jtf1);
		jfrm.add(jtf2);
		
		jlab = new JLabel("test");
		
		jfrm.add(jlab);
		jfrm.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("One"))
			jlab.setText("ENTER pressed in jtf1 : " + jtf1.getText());
		else
			jlab.setText("ENTER pressed in jtf2 : " + jtf2.getText());

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TwoTFDemo();
			}
		});

	}

}
