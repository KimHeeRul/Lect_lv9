package kiosk;

public class mainFrame extends MyUtill
{

	public static int log = -1;// ������ �Ϲݻ���� ����

	public mainFrame() {
		setLayout(null);
		setBounds(100, 100, 400, 500);
		add(new mainPanel());
		setVisible(true);
		revalidate();
	}

}
