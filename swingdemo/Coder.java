package swingdemo;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Coder implements ActionListener {
	JTextField jtfPlaintext;
	JTextField jtfCiphertext;
	
	Coder () {
		JFrame jfrm = new JFrame("A Simple Code Machine");
		jfrm.setLayout(new FlowLayout());
		jfrm.setSize(340, 120);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel jlabPlaintext = new JLabel(" Plain Text: ");
		jlabPlaintext.setBorder(BorderFactory.createLineBorder(Color.BLACK));  // рамка
		JLabel jlabCiphertext = new JLabel("Cipher Text : ");
		
		jtfPlaintext = new JTextField(20);
		jtfCiphertext = new JTextField(20);
		
		jtfPlaintext.setActionCommand("Encode");
		jtfCiphertext.setActionCommand("Decode");
		
		jtfPlaintext.addActionListener(this);
		jtfCiphertext.addActionListener(this);
		
		jfrm.add(jlabPlaintext);
		jfrm.add(jtfPlaintext);
		jfrm.add(jlabCiphertext);
		jfrm.add(jtfCiphertext);
		
		JButton jbtnEncode = new JButton("Encode");
		JButton jbtnDecode = new JButton("Decode");
		JButton jbtnReset = new JButton("Reset");
		
		jbtnEncode.addActionListener(this);
		jbtnDecode.addActionListener(this);
		jbtnReset.addActionListener(this);
		
		jfrm.add(jbtnEncode);
		jfrm.add(jbtnDecode);
		jfrm.add(jbtnReset);
		
		jfrm.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("Encode")) {
			StringBuilder str = new StringBuilder(jtfPlaintext.getText());   // получение текста и передача объекту StringBuilder
			for (int i = 0; i < str.length(); i++)                           // добавление единицы к коду каждого элемента
				str.setCharAt(i, (char)(str.charAt(i) + 1));
			jtfCiphertext.setText(str.toString());                   // помещение зашифрованного текста в Cipher Text
		}
		else if (ae.getActionCommand().equals("Decode")) {
			StringBuilder str = new StringBuilder(jtfCiphertext.getText());
			for (int i = 0; i < str.length(); i++)        
				str.setCharAt(i, (char)(str.charAt(i) - 1));
			jtfPlaintext.setText(str.toString());       
		}
		else {
			jtfPlaintext.setText("");
			jtfCiphertext.setText("");
		}

	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Coder();
			}
		});

	}

}
