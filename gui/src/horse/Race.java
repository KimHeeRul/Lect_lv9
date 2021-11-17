package horse;

import javax.swing.JFrame;

public class Race extends JFrame {
	panel con = new panel();
	static final int SIZE = 700;
	public Race() {
	
			setTitle("horse");
			setLayout(null);
			setBounds(100, 100, SIZE, SIZE);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			add(con);
//			setImage();
//			for (int i = 1; i <= 5; i++) {
//				ImageIcon icon = new ImageIcon(String.format("images/horse%d.png", i));

//			}
			
//			add(new MyPanel());
//			setImageLabel();
			setVisible(true);
			con.run();
			revalidate();
			
			

		
	}

}
