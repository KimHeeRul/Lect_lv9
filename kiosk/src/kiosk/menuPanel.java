package kiosk;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;

public class menuPanel extends MyUtill {
	JLabel amount = new JLabel();
	public menuPanel() {
		setLayout(null);
		setBounds(0, 0, 500, 800);
		setVisible(true);
		revalidate();
		setBackground(Color.black);
		setMenuButton();
	}

	private void setMenuButton() {
		amount.setLayout(null);
		amount.setBounds(0, 690, 50, 50);
		amount.setText("주문수량");
		add(amount);
	}
}
