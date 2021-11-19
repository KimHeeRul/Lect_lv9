package join;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
class result2 extends JFrame {
	private JLabel text = new JLabel();
	public JButton reset = new JButton();

	public result2(boolean result) {
		setTitle("Result");
		setLayout(null);
		setBounds(150, 250, 300, 200);
		text.setBounds(0, 0, 300, 200);
		if (result) {
		}else {
			text.setText("로그인 실패");
		} 
			
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		setVisible(true);
	}





}