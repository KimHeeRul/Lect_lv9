package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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

	public ResultFrame2(int ms) {
		setTitle("Game Clear");
		setLayout(null);
		setBounds(MyFrame3.width / 2 - 300 / 2, MyFrame3.height / 2 - 200 / 2, 300, 200);
		text.setBounds(0, 0, 300, 200);
		text.setText("게임 클리어\n" + String.format("성적: %5d.%3d 소요", ms / 1000, ms % 1000));
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		setVisible(true);

	}

}

class MyPanel3 extends JPanel implements ActionListener, Runnable {
	JLabel text2 = new JLabel();
	public int cnt = 1;
	public JLabel timer = new JLabel("0");
	JLabel text = new JLabel("");
	int ms;
	boolean isRun;

	public JButton[] button = new JButton[25];
	public JButton reset = new JButton();
	public int[] mark = new int[25];
	public int[] mark2 = new int[25];

	static int init = 0;

	public MyPanel3() {
		if (init == 0) {
			setLayout(null);
			setBounds(0, 0, MyFrame3.SIZE, MyFrame3.SIZE);
			init();
			init++;

		}
	}

	public void init() {
		Label2();
		time();
		setBackground(Color.white);
		Label();
		reset.addActionListener(this);
		setting();
		resetB();
		setMap();
	}

	public void time() {
		timer.setBounds(MyFrame3.SIZE - 100, 0, 100, 100);
		timer.setVerticalAlignment(JLabel.TOP);
		timer.setFont(new Font("Arial", Font.PLAIN, 20));
		timer.setText("0");
		add(timer);
	}

	public void Label2() {
		text.setText("1 to 50");
		text.setLayout(null);
		text.setBounds(0, 0, MyFrame3.SIZE, 100);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setVerticalAlignment(JLabel.TOP);
		text.setFont(new Font("Arial", Font.BOLD, 40));
		text.setVisible(true);
		add(text);
		revalidate();
	}

	public void Label() {
		text2.setLayout(null);
		text2.setBounds(10, 0, 100, 100);
		text2.setText(cnt + "");
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
		reset.setVisible(true);
	}

	public void setting() {
		Random rand = new Random();
		reset.setVisible(true);
		for (int i = 0; i < mark.length; i++) {
			mark[i] = i + 1;
			mark2[i] = i + 1 + mark.length;
		}
		int j = 0;
//		while (j < 1000) {// 셔플
//			int r = rand.nextInt(25);
//			int temp = mark[0];
//			mark[0] = mark[r];
//			mark[r] = temp;
//			j++;
//			r = rand.nextInt(25);
//			temp = mark2[0];
//			mark2[0] = mark2[r];
//			mark2[r] = temp;
//		}
	}

	public void setMap() {
		int x = MyFrame3.SIZE / 2 - 50 * 5 / 2;
		int y = MyFrame3.SIZE / 2 - 50 * 5 / 2;
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].addActionListener(this);// 액션리스너
			button[i].setText(mark[i] + "");
			button[i].setBounds(x, y, 50, 50);
			button[i].setVisible(true);
			button[i].setBackground(Color.gray);
			revalidate();
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
				if (!isRun) {
					isRun = true;
				}

				this.button[i].setText(mark2[i] + "");
				button[i].setBackground(Color.red);
				mark2[i] = 0;
				this.cnt++;
				if (cnt <= 50) {
					text2.setText(cnt + "");
				}
				checkWin();
				revalidate();
				if (this.button[i].getText().equals("0")) {
					this.button[i].setVisible(false);
				}
			}

		}
		if (target == this.reset) {
			isRun = false;
			for (int i = 0; i < button.length; i++) {
				this.button[i].setText(mark[i] + "");
				this.button[i].setVisible(false);
				button[i].setBackground(Color.gray);
			}
			this.cnt = 1;
			text2.setText(cnt + "");
			reset.setVisible(false);
			init();
//			setting();
//			setMap();
			ms = 0;
			this.timer.setText("0");
			revalidate();
		}

	}

	public void checkWin() {
		if (this.cnt == 51) {
			isRun = false;
			new ResultFrame2(ms);
			reset.setVisible(true);
		}

	}

	@Override
	public void run() {
		while (true) {
			if (isRun) {
				ms++;
				this.timer.setText(String.format("%5d.%3d", this.ms / 1000, this.ms % 1000));
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {

			}
		}
	}

}

class MyFrame3 extends JFrame {

	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;

	public static final int SIZE = 500;

	MyPanel3 panel = new MyPanel3();

	public MyFrame3() {
		setLayout(null);// null로 변경해서 순서대로나열인걸 변경할수있도록 변경
		setTitle("1 to 50 ");
		setBounds(width / 2 - SIZE / 2, height / 2 - SIZE / 2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
		revalidate();
		panel.run();
	}
}

public class Ex07 {
	public static void main(String[] args) {
		MyFrame3 frame = new MyFrame3();
	}
}
