package Omok;

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

class ResultFrame2 extends JFrame implements ActionListener {
	private JLabel text = new JLabel();
	public JButton reset = new JButton();

	public ResultFrame2(int turn ) {
		setTitle("Game Clear");
		setLayout(null);
		int x = MyFrame3.width / 2 - 300 / 2;
		int y = MyFrame3.height / 2 - 200 / 2;
		setBounds(x, y, 300, 200);
		text.setBounds(0, 0, 300, 200);
		text.setText("????:P" + turn);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		resetB(x, y);
		setVisible(true);
	}

	public void resetB(int x, int y) {
		int x2 = 300 / 2 - 100 / 2;
		int y2 = 200 / 2 - 30 * 2;
		reset.setText("????");
		reset.setBounds(x2, y2, 100, 30);
		add(reset);
		reset.setVisible(true);
		reset.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		if (target == this.reset) {
			MyPanel3.resetB2();
			dispose();
		}

	}

}

class MyPanel3 extends JPanel implements ActionListener {
	JLabel text = new JLabel("");
	int turn = 1;
	public static int win = 0;
	public static JButton[][] button = new JButton[10][10];
	public static JButton reset = new JButton();
	public static int[][] mark = new int[10][10];
	public MyPanel3() {
		setLayout(null);
		setBounds(0, 0, MyFrame3.SIZE, MyFrame3.SIZE);
		Label2();
		setBackground(new Color(229, 137, 10));
		resetB();
		setMap();
	}

	public void Label2() {
		text.setText("Omok");
		text.setLayout(null);
		text.setBounds(0, 0, MyFrame3.SIZE, 100);
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setFont(new Font("Arial", Font.BOLD, 40));
		text.setVisible(true);
		add(text);
	}

	public void resetB() {
		int x2 = MyFrame3.SIZE / 2 - 100 / 2;
		int y2 = MyFrame3.SIZE / 2 + 300;
		reset.setText("????");
		reset.setBounds(x2, y2, 100, 30);
		add(reset,0);//?켱???? 0 ?ֿ켱????
		reset.setVisible(true);
		reset.addActionListener(this);

	}

	public void setMap() {// ?ѹ??? ????
		int x = MyFrame3.SIZE / 2 - 50 * 10 / 2;
		int y = MyFrame3.SIZE / 2 - 50 * 10 / 2;
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				button[i][j] = new JButton();
				button[i][j].addActionListener(this);// ?׼Ǹ?????
				button[i][j].setBounds(x, y, 50, 50);
				button[i][j].setVisible(true);
				button[i][j].setBackground(new Color(157, 92, 13));
				add(button[i][j]);
				x += 53;
				if (j % 10 == 9) {
					x = MyFrame3.SIZE / 2 - 50 * 10 / 2;
					y += 53;
				}
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button.length; j++) {
				if (target == this.button[i][j] && win == 0 && mark[i][j] == 0) {
					if (turn == 1) {
						button[i][j].setBackground(Color.black);

					} else if (turn == 2) {
						button[i][j].setBackground(Color.white);
					}
					mark[i][j] = this.turn;
					checkWin();
					revalidate();
					this.turn = this.turn == 1 ? 2 : 1;
				}
			}

		}
		if (target == this.reset) {
			resetB2();
//			remove(reset);//???¹?ư ????
//			revalidate();//???????? ?ʼ?
//			repaint();//???????? ?ʼ?
		}

	}

	public void checkWin() {
		win =win == 0 ? checkHori() : win;
		win = win == 0 ? checkVerti() : win;
		win = win == 0 ? checDia() : win;
		win = win == 0 ? checReverse() : win;
		if (win != 0) {
			new ResultFrame2(this.turn);
		}
	}

	public static void resetB2() {
		for (int i = 0; i < mark.length; i++) {
			for (int j = 0; j < mark[i].length; j++) {
				mark[i][j] = 0;
				button[i][j].setBackground(new Color(157, 92, 13));
				win = 0;
			}
		}
		
	}

	
	private int checReverse() {
		for (int i = 0; i <= 5; i++) {
			int cnt = 0;
			for (int j = mark.length - 1; j >= 4; j--) {
				if (this.mark[i][j] == this.turn) {
					for (int j2 = 0; j2 < 5; j2++) {
						if (this.mark[i + j2][j - j2] == this.turn) {
							cnt++;
						} else {
							cnt = 0;
						}
					}
					if (cnt == 5) {
						return this.turn;
					}
				}

			}
		}
		return 0;
	}

	private int checDia() {
		for (int i = 0; i <= 5; i++) {
			int cnt = 0;
			for (int j = 0; j <= 5; j++) {
				if (this.mark[i][j] == this.turn) {
					for (int j2 = 0; j2 < 5; j2++) {
						if (this.mark[i + j2][j + j2] == this.turn) {
							cnt++;
						} else {
							cnt = 0;
						}
					}
					if (cnt == 5) {
						return this.turn;
					}
				}

			}
		}
		return 0;
	}

	private int checkVerti() {
		for (int i = 0; i < mark.length; i++) {
			int cnt = 0;
			for (int j = 0; j < mark[i].length; j++) {
				if (mark[j][i] == this.turn) {
					cnt++;
				} else {
					cnt = 0;
				}
				if (cnt == 5) {
					return this.turn;
				}
			}

		}

		return 0;
	}

	private int checkHori() {
		for (int i = 0; i < mark.length; i++) {
			int cnt = 0;
			for (int j = 0; j < mark[i].length; j++) {
				if (mark[i][j] == this.turn) {
					cnt++;
				} else {
					cnt = 0;
				}
				if (cnt == 5) {
					return this.turn;
				}
			}

		}

		return 0;
	}

}

class MyFrame3 extends JFrame {

	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;

	public static final int SIZE = 800;

	MyPanel3 panel = new MyPanel3();

	public MyFrame3() {
		setLayout(null);
		setTitle("Omok");
		setBounds(width / 2 - SIZE / 2, height / 2 - SIZE / 2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(panel);
		setVisible(true);
	}
}

public class Ex07 {
	public static void main(String[] args) {
		MyFrame3 frame = new MyFrame3();
	}
}
