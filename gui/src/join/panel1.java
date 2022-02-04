package join;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class panel1 extends MyUtill {
	JButton login = new JButton();
	JButton signUp = new JButton();
	JButton load = new JButton();
	JLabel log = new JLabel();
	JTextField jf = new JTextField();
	static JFrame signUpFrame = new signUpFrame();
	JTable table = null;
	Vector<String> colName = null;

	private void setTable() {
		this.colName = new Vector();
		this.colName.add("id");
		this.colName.add("pw");
		this.colName.add("name");
		table = new JTable(file.users, colName);
		table.setBounds(50, 50, 300, 300);
		table.setBorder(new LineBorder(Color.red));
		table.setGridColor(Color.blue);
		add(table);

		JScrollPane js = new JScrollPane(table);
		js.setBounds(50, 50, 300, 300);
		js.setAutoscrolls(true);
		add(js);

	}

	private void init() {
		Random rand = new Random();
		String[] front = { "김", "이", "박", "정" };
		String[] back = { "성", "지", "우", "아" };
		String[] back2 = { "언", "무", "언", "후" };

		for (int i = 0; i < file.users.size(); i++) {
			Vector<String> user = new Vector<>();
			String name = front[rand.nextInt(front.length)] + back[rand.nextInt(front.length)]
					+ back2[rand.nextInt(front.length)];
			System.out.println("1");
			user.add(name);
			user.add(i + "");
			user.add(i + "");
			file.users.add(user);
		}
	}

	public panel1() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setLogin();
		setsignIn();
		setload();
		serLabel();
		setTable();
//		init();
		revalidate();
	}

	private void setload() {
		load.setLayout(null);
		load.setBounds(50, 400, 100, 50);
		load.setText("로드");
		load.addActionListener(this);
		add(load);
	}

	private void serLabel() {
		log.setBounds(20, 20, 100, 30);

		add(log);
	}

	private void setsignIn() {
		signUp.setLayout(null);
		signUp.setBounds(200 - 100 / 2, 400, 100, 50);
		signUp.setText("가입");
		signUp.addActionListener(this);
		add(signUp);
	}

	private void setLogin() {
		login.setLayout(null);
		login.setBounds(250, 400, 100, 50);
		login.setText("로그인");
		login.addActionListener(this);
		add(login);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == login) {
			new loginFrame();
		}
		if (e.getSource() == signUp) {
			signUpFrame= new signUpFrame();
		}
		if (e.getSource() == load)

		{
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

		table.repaint();
		table.revalidate();
	}
}
