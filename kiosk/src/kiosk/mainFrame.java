package kiosk;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class mainFrame extends JFrame {

	public static int log = -1;// 관리자 일반사용자 구분

	public mainFrame() {
		setLayout(null);
		setBounds(100, 100, 515, 800);
		JPanel mainPanel=new mainPanel();
		add(mainPanel);
//		mainPanel.add(new subPanel());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		revalidate();
	}

}
