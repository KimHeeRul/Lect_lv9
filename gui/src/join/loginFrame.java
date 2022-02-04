package join;

import javax.swing.JFrame;

public class loginFrame extends JFrame{
	public loginFrame() {
		setLayout(null);
		setBounds(100, 200, 400, 300);
		add(new loginPanel());
		setVisible(true);
		revalidate();
	}
}
