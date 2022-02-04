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
//awt&&swing(자바 자체, 가벼움)

//UI엘리먼트를 담는 컨테이너

//최상위 컨테이너:JFrame
//컨테이너::JPanel
//컴포넌트:JButton,JLabel,JTextField,...

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
		// 버튼 속성 설정
		System.out.println(this.bt);
		bt.setBounds(100, 100, 100, 100);
		bt.setText("Button");// 텍스트
		bt.setBackground(Color.gray);// 버튼 배경
		bt.addActionListener(this);// 액션리스너
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
		// JFame 설정

		// 0.
		// 기본 레이아웃 구성의 설정->순서대로나열
		setLayout(null);// null로 변경해서 순서대로나열인걸 변경할수있도록 변경

		// 타이틀
		// super("title");
		// setTitle("title")
		setTitle("MyFrame");

		// 크기
		// setBounds(x,y,width,,height);
		setBounds(50, 50, 500, 400);

		// 종료 조건
		// Gui닫으면 자바 종료
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		add(new Contents());

		// add
		add(new MyPanel(0, 0, 250, 400, Color.black));
		add(new MyPanel(250, 0, 250, 400, Color.white));
		// add(new MyPanel2());

		// 보이기
		// setVisible(ture)//프레임 비지블
		setVisible(true);

		// 화면갱신
		revalidate();
	}
}

public class Ex {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();

	}
}
