package join;

import javax.swing.JFrame;

public class frame1 extends JFrame{
	
	public static int log=-1;
	public frame1() {
		setLayout(null);
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new panel1());
		setVisible(true);
		revalidate();
		
	}
}
