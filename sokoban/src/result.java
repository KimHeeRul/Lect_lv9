import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


class result extends JFrame {
	private JLabel text = new JLabel();
	public JButton reset = new JButton();

	public result() {
		setTitle("Game Clear");
		setLayout(null);
		int x = game.SIZEX / 2 - 300 / 2;
		int y = game.SIZEY / 2 - 200 / 2;
		setBounds(x, y, 300, 200);
		text.setBounds(0, 0, 300, 200);
		text.setText("게임클리어" );
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		setVisible(true);
	}




}