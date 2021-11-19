package join;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class panel1 extends MyUtill {
	JButton login = new JButton();
	JButton signIn = new JButton();
	JButton load = new JButton();
	JLabel log = new JLabel();

	// 줄바꿈 불가
	JTextField jf = new JTextField();

	// 줄바꿈 가능
//	JTextArea ja = new JTextArea();
	public panel1() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLogin();
		setsignIn();
		setload();
		serLabel();
//		setTextField();
		revalidate();
//		setTextArea();

	}

	private void setload() {
		load.setLayout(null);
		load.setBounds(200 - 100 / 2, 350, 100, 50);
		load.setText("로드");
		load.addActionListener(this);
		add(load);
	}

	private void serLabel() {
		log.setBounds(20, 20, 100, 30);

		add(log);
	}

	private void setsignIn() {
		signIn.setLayout(null);
		signIn.setBounds(200 - 100 / 2, 250, 100, 50);
		signIn.setText("가입");
		signIn.addActionListener(this);
		add(signIn);
	}

	private void setLogin() {
		login.setLayout(null);
		login.setBounds(200 - 100 / 2, 150, 100, 50);
		login.setText("로그인");
		login.addActionListener(this);
		add(login);
	}

	private void setTextField() {
		jf.setBounds(100, 100, 100, 30);
		add(jf);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == login) {
			new loginFrame();
		} else if (e.getSource() == signIn) {
			new signUpFrame();
		} else if (e.getSource() == load) {
			file.load();
			frame1.log = -1;
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		System.out.println(frame1.log);
		if (frame1.log != -1) {
			String temp = file.users.get(frame1.log).get(0) + " 님";
			log.setText(temp);
		} else {
			String temp = "";
			log.setText(temp);
		}
		repaint();
	}
}
