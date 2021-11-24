package kiosk;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class subPanel extends mainPanel {
	JButton payment = new JButton();
	public subPanel() {
		setLayout(null);
		setBounds(0, 200, 500, 800);
		setBackground(Color.white);
		setVisible(true);
		setMenuButton();
	}

	private void setMenuButton() {
		int x = 30;
		int y = 150;
		for (int i = 0; i < 9; i++) {
			if (i + menuPage < menu.length) {
				menu[i + menuPage] = new JButton();
				menu[i + menuPage].setLayout(null);
				menu[i + menuPage].setBounds(x, y, 140, 140);
				if (menuPage == 0) {
					menu[i + menuPage].setText("메뉴이미지");
				} else {
					menu[i + menuPage].setText("메뉴이미지2");
				}
				x += 150;
				if (i % 3 == 2) {
					x = 30;
					y += 150;
				}
				menu[i + menuPage].addActionListener(this);
				add(menu[i + menuPage]);
			}
			if (menuPage != 0) {
				for (int j = 0; j < 9; j++) {
					remove(menu[j]);
				}
			}
		}
	}
	
	
}
