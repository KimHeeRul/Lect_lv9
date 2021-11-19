package join;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loginPanel extends MyUtill {
	JButton login = new JButton();
	JTextField id = new JTextField();
	JTextField pw = new JTextField();
	JLabel l1 = new JLabel("ID");
	JLabel l2 = new JLabel("PW");

	public loginPanel() {
		setLayout(null);
		setBounds(0, 0, 400, 500);
		setButton();
		setTextField();
		setLabel();

	}

	private void setButton() {
		login.setLayout(null);
		login.setBounds(200 - 100 / 2, 150, 100, 30);
		login.setText("로그인");
		login.addActionListener(this);
		add(login);
	}

	private void setLabel() {
		l1.setBounds(200 - 100, 50, 100, 30);
		add(l1);
		l2.setBounds(200 - 100, 100, 100, 30);
		add(l2);
	}

	private void setTextField() {
		id.setBounds(200 - 100 / 2, 50, 100, 30);
		add(id);
		pw.setBounds(200 - 100 / 2, 100, 100, 30);
		add(pw);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == login) {
			login();
		}
	}

	private void login() {
		int idx=-1;
		for (int i = 0; i < file.users.size(); i++) {
			if (file.users.get(i).get(0).equals(id.getText())) {
				idx=i;
			}
		}
		if (idx!=-1) {
			JOptionPane.showMessageDialog(null, "로그인성공!");
			frame1.log=idx;
		}else if(idx==-1) {
			JOptionPane.showMessageDialog(null, "로그인실패!");
		}
	}
}