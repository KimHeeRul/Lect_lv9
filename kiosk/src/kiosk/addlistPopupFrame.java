package kiosk;

import javax.swing.JFrame;
import javax.swing.JPanel;

import drink.Drink;

public class addlistPopupFrame extends JFrame {

	public static int log = -1;// ������ �Ϲݻ���� ����
	public static JPanel popupPanel;

	public addlistPopupFrame(int i, Drink drink) {
		setLayout(null);
		setBounds(150, 150, 400, 650);
		this.popupPanel = new addlistPopupPanel(i, drink);
		add(popupPanel);
		setVisible(true);
		revalidate();
	}

}
