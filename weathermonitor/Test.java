package weathermonitor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
	
	JFrame frame;
	public static void main(String[] args){
		Test example = new Test();
		example.go();
	}
	
	public void go() {
		frame = new JFrame();
		JButton button = new JButton("Text 1");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.add(BorderLayout.CENTER, button);
		frame.setSize(640,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class AngelListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Don't do it, you might regret it!");
		}
	}
	
	class DevilListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("Come on, do it!");
		}

		
	}

}
