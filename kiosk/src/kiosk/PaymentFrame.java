package kiosk;

import javax.swing.JFrame;
import javax.swing.JPanel;

import drink.Drink;

public class PaymentFrame extends JFrame {

	public static int log = -1;// ������ �Ϲݻ���� ����
	public static JPanel paymentPanel;

	public PaymentFrame() {
		setLayout(null);
		setBounds(150, 150, 400, 650);
		this.paymentPanel = new paymentPanel(mainPanel.result);
		add(paymentPanel);
		setVisible(true);
		revalidate();
	}

}
