package join;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class signUpPanel extends MyUtill {
	// 줄바꿈 불가
	private signUpFrame sg =signUpFrame.sg;
	JButton singUp = new JButton();
	JTextField id = new JTextField();
	JTextField pw = new JTextField();
	JTextField name = new JTextField();
	JTextField age = new JTextField();

	JTextField jf[] = new JTextField[4];
	// 나중에 줄이자
	JLabel l1 = new JLabel("ID");
	JLabel l2 = new JLabel("PW");
	JLabel l3 = new JLabel("NAME");
	JLabel l4 = new JLabel("AGE");

	JLabel lb[] = new JLabel[4];

	public signUpPanel() {
		setLayout(null);
		setBounds(0, 0, 400, 300);
		setTextField();
		setLabel();
		setButton();

	}

	private void setButton() {
		singUp.setLayout(null);
		singUp.setBounds(200 - 100 / 2, 220, 100, 30);
		singUp.setText("가입하기");
		singUp.addActionListener(this);
		add(singUp);
	}

	private void setLabel() {
//		int y = 20;
//		for (int i = 0; i < lb.length; i++) {
//			lb[i]=new JLabel();
//			lb[i].setBounds(10, y, 100, 30);
//			add(lb[i]);
//			System.out.println("1");
//			y += 50;
//		}

		l1.setBounds(200 - 100, 20, 100, 30);
		add(l1);
		l2.setBounds(200 - 100, 70, 100, 30);
		add(l2);
		l3.setBounds(200 - 100, 120, 100, 30);
		add(l3);
		l4.setBounds(200 - 100, 170, 100, 30);
		add(l4);
	}

	private void setTextField() {
		int y = 20;
		for (int i = 0; i < jf.length; i++) {
			jf[i] = new JTextField();
			jf[i].setBounds(200 - 100 / 2, y, 100, 30);
			add(jf[i]);
			y += 50;
		}
//	
//		pw.setBounds(200 - 100 / 2, 70, 100, 30);
//		add(pw);
//		name.setBounds(200 - 100 / 2, 120, 100, 30);
//		add(name);
//		age.setBounds(200 - 100 / 2, 170, 100, 30);
//		add(age);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == singUp) {
			if (signUp()) {
				JOptionPane.showMessageDialog(null, "회원가입성공!");
				file.save();
			} else {
				JOptionPane.showMessageDialog(null, "회원가입 실패 중복된 아이디입니다.");
//				new result(false);
			}
		}

	}

	private boolean signUp() {
		boolean check = false;
		for (int i = 0; i < file.users.size(); i++) {
			if (file.users.get(i).get(0).equals(jf[0].getText())) {
				System.out.println("중복");
				check = true;
			}
		}
		if (!check) {
			file.users.add(new Vector<String>());
			file.users.get(file.users.size() - 1).add(jf[0].getText());
			file.users.get(file.users.size() - 1).add(jf[1].getText());
			file.users.get(file.users.size() - 1).add(jf[2].getText());
			file.users.get(file.users.size() - 1).add(jf[3].getText());
			return true;
		} else {
			return false;
		}
	}

}
