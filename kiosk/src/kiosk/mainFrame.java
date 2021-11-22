package kiosk;

public class mainFrame extends MyUtill
{

	public static int log = -1;// 관리자 일반사용자 구분

	public mainFrame() {
		setLayout(null);
		setBounds(100, 100, 400, 500);
		add(new mainPanel());
		setVisible(true);
		revalidate();
	}

}
