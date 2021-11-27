package kiosk;

import javax.swing.JFrame;
import javax.swing.JPanel;

import drink.Drink;

public class addlistPopupFrame extends JFrame {

	public static int log = -1;// 관리자 일반사용자 구분
	public static JPanel popupPanel;

	public addlistPopupFrame(int i, Drink drink,String path) {
		setLayout(null);
		setBounds(150, 150, 400, 650);
		this.popupPanel = new addlistPopupPanel(i, drink,path);
		add(popupPanel);
		setVisible(true);
		revalidate();
	}

}
