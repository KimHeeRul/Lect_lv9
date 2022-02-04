package Omok.copy;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyPanel3 extends JPanel implements ActionListener{
	JLabel text =new JLabel();
	public MyPanel3() {
		setLayout(null);
		setBounds(0,0,MyFrame3.SIZE,MyFrame3.SIZE);
		Label();
	}
	
	public void Label() {
		text.setText("Omok");
		text.setLayout(null);
		text.setBounds(0, 0, MyFrame3.SIZE, 100);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setFont(new Font("Arial", Font.BOLD, 40));
		text.setVisible(true);
		add(text);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}

class MyFrame3 extends JFrame{
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;
	public static final int SIZE = 800;
	MyPanel3 panel = new MyPanel3();

	public MyFrame3() {
		setLayout(null);
		setTitle("Omok");
		setBounds(width/2-SIZE/2,height/2-SIZE/2,SIZE,SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		add(panel);
	}
}

public class Ex07 {
	public static void main(String[] args) {
		MyFrame3 frame = new MyFrame3();
	}
}
