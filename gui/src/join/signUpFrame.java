package join;

import javax.swing.JFrame;

public class signUpFrame extends JFrame {
	public signUpFrame() {
		setLayout(null);
		setBounds(100, 200, 400, 300);
		add(new signUpPanel());
		setVisible(true);
		revalidate();
	}
}
