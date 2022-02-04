import java.awt.Panel;

import javax.swing.JFrame;

public class game extends JFrame {
	 static int SIZEX = 550;
	 static int SIZEY = 500;

	public game() {
		setLayout(null);
		setTitle("Sokoban");
		setBounds(50, 50, SIZEX, SIZEY);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
		revalidate();
	}
}
