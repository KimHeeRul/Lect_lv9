package join;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
class result extends JFrame {
	private JLabel text = new JLabel();
	public JButton reset = new JButton();

	public result(boolean result) {
		setTitle("Result");
		setLayout(null);
		setBounds(150, 250, 300, 200);
		text.setBounds(0, 0, 300, 200);
		if (result) {
			text.setText("ȸ�����Լ���!" );
		}else {
			text.setText("ȸ�����Խ���!�ߺ��� ���̵��Դϴ�.");
		} 
			
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		setVisible(true);
	}





}