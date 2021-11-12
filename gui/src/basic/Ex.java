package basic;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Gui
//awt&&swing(�ڹ� ��ü, ������)

//UI������Ʈ�� ��� �����̳�

//�ֻ��� �����̳�:JFrame
//�����̳�::JPanel
//������Ʈ:JButton,JLabel,JTextField,...

//class MyPanel2 extends JPanel {
//	public MyPanel2() {
//		setBounds(250, 0, 250, 400);
//		setBackground(Color.white);
//	}
//
//}

class MyPanel extends JPanel {
	public MyPanel(int x, int y, int w, int h, Color bg) {
		setBounds(x, y, w, h);
		setBackground(bg);
	}

}

class Contents extends JPanel implements ActionListener, MouseMotionListener {

	private JButton bt = new JButton();
	boolean check;

	public Contents() {
		setLayout(null);
		setBounds(0, 0, 500, 400);
		// ��ư �Ӽ� ����
		System.out.println(this.bt);
		bt.setBounds(100, 100, 100, 100);
		bt.setText("Button");// �ؽ�Ʈ
		bt.setBackground(Color.gray);// ��ư ���
		bt.addActionListener(this);// �׼Ǹ�����
		addMouseMotionListener(this);
		add(bt);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getSource());
		if (e.getSource() == this.bt && !this.check) {
			this.bt.setBackground(Color.red);
			this.check = true;
		} else {
			this.bt.setBackground(Color.gray);
			this.check = false;
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("dragged");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("move");
	}

}

class MyFrame extends JFrame {

	public MyFrame() {
		// JFame ����

		// 0.
		// �⺻ ���̾ƿ� ������ ����->������γ���
		setLayout(null);// null�� �����ؼ� ������γ����ΰ� �����Ҽ��ֵ��� ����

		// Ÿ��Ʋ
		// super("title");
		// setTitle("title")
		setTitle("MyFrame");

		// ũ��
		// setBounds(x,y,width,,height);
		setBounds(50, 50, 500, 400);

		// ���� ����
		// Gui������ �ڹ� ����
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new Contents());

		// add
		add(new MyPanel(0, 0, 250, 400, Color.black));
		add(new MyPanel(250, 0, 250, 400, Color.white));
		// add(new MyPanel2());

		// ���̱�
		// setVisible(ture)//������ ������
		setVisible(true);

		// ȭ�鰻��
		revalidate();
	}
}

public class Ex {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();

	}
}
