package swingdemo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SwingTest {
	
	SwingTest() {
		
		JFrame jfrm = new JFrame("A Simple Swing Program");
		
		jfrm.setSize(275, 100);
		
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jlab = new JLabel("Swing powers the modern Java Gui");
		
		jfrm.getContentPane().add(jlab);
		
		jfrm.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingTest();
			}

	});
}

}
