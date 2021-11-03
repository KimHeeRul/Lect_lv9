package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ResultFrame2 extends JFrame {
	private JLabel text = new JLabel();

	public ResultFrame2(String winText) {
	}

}

class MyPanel3 extends JPanel implements ActionListener {
	JLabel text2 = new JLabel();
	public JButton[] button = new JButton[25];
	public JButton reset = new JButton();
	public int[] mark = new int[25];
	public int[] mark2 = new int[25];
	private int win = 0;
	public int cnt = 1;

	public MyPanel3() {
		setLayout(null);
		setBounds(0, 0, MyFrame3.SIZE, MyFrame3.SIZE);
		reset.addActionListener(this);
		Label();
		setting();
		resetB();
		setMap();
	}
	public void Label() {
		text2.setLayout(null);
		text2.setBounds(10, 0, 100, 100);
		text2.setText(cnt+"");
		text2.setHorizontalAlignment(JLabel.LEFT);
		text2.setFont(new Font("Arial", Font.PLAIN, 40));
		add(text2);
		
	}

	public void resetB() {
		int x2 = MyFrame3.SIZE / 2 - 100 / 2;
		int y2 = 410;
		reset.setText("리셋");
		reset.setBounds(x2, y2, 100, 30);
		add(reset);
		reset.setVisible(false);
	}

	public void setting() {
		Random rand = new Random();
		for (int i = 0; i < mark.length; i++) {
			mark[i] = i + 1;
			mark2[i] = i + 1 + mark.length;
			System.out.println(mark[i]);
			System.out.println(mark2[i]);
		}
		int j = 0;
		while (j < 1000) {// 마크셮
			int r = rand.nextInt(25);
			int temp = mark[0];
			mark[0] = mark[r];
			mark[r] = temp;
			j++;
			r = rand.nextInt(25);
			temp = mark2[0];
			mark2[0] = mark2[r];
			mark2[r] = temp;
		}

	}

	public void setMap() {
		int x = MyFrame3.SIZE / 2 - 50 * 5 / 2;
		int y = MyFrame3.SIZE / 2 - 50 * 5 / 2;
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].addActionListener(this);// 액션리스너
			button[i].setText(mark[i] + "");
			button[i].setBounds(x, y, 50, 50);
			add(button[i]);
			x += 53;
			if (i % 5 == 4) {
				x = MyFrame3.SIZE / 2 - 50 * 5 / 2;
				y += 53;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < button.length; i++) {
			if (target == this.button[i] && this.button[i].getText().equals(cnt + "")) {
				// 마크2에 있는거랑 체인지
				this.button[i].setText(mark2[i]+"");
				mark2[i]=0;
				this.cnt++;
				text2.setText(cnt+"");
				break;
			}
		}
		if (target == this.reset) {
			for (int i = 0; i < button.length; i++) {
				this.button[i].setBackground(new Color(223, 216, 202));
			}
			mark = new int[9];
			win = 0;
//			setMap();
			revalidate();
			reset.setVisible(false);
		}

	}

	public void checkWin() {
		if (this.win != 0) {
			System.out.printf("p%d의 승!\n", this.win);
//			new ResultFrame(String.format("p%d의 승!\n", this.turn));
//			new reset();
			reset.setVisible(true);
		}

	}

}

class MyFrame3 extends JFrame {

	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;

	public static final int SIZE = 500;

	public MyFrame3() {

		setLayout(null);// null로 변경해서 순서대로나열인걸 변경할수있도록 변경
		setTitle("1 to 50 ");
		setBounds(width / 2 - SIZE / 2, height / 2 - SIZE / 2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		revalidate();

		Label();

		add(new MyPanel3());

	}

	public void Label() {
		JLabel text = new JLabel("1 to 50");
		text.setLayout(null);
		text.setBounds(0, 0, SIZE, 100);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setFont(new Font("Arial", Font.BOLD, 50));
		add(text);
		text.setVisible(true);
	}
}

public class Ex07 {
	public static void main(String[] args) {
		MyFrame3 frame = new MyFrame3();

	}
}
