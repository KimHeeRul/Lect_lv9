package kiosk;

import javax.swing.JFrame;
import javax.swing.JPanel;

import drink.Drink;

public class SalesFrame extends JFrame {

	public static int log = -1;// ������ �Ϲݻ���� ����
	public static JPanel salesPanel;

	public SalesFrame() {
		setLayout(null);
		setBounds(150, 150, 400, 650);
		this.salesPanel = new SalesPanel(mainPanel.result);
		add(salesPanel);
		setVisible(true);
		revalidate();
	}

}
