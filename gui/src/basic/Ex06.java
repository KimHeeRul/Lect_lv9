package basic;

//gui 예제
//tic tac toe 만들기
//버튼9개를 가진 배열활용
//마킹용 int[[] 배열활용
//턴에따라 버튼색이 다르게 지정됨

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ResultFrame extends JFrame {
	private JLabel text = new JLabel();

	public ResultFrame(String winText) {
		setTitle("Game Clear");
		setLayout(null);
		setBounds(MyFrame2.width / 2 - 300 / 2, MyFrame2.height / 2 - 200 / 2, 300, 200);
		text.setBounds(0, 0, 300, 200);
		text.setText(winText);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		setVisible(true);
		revalidate();
	}

}

class MyPanel2 extends JPanel implements ActionListener {

	public JButton[] button = new JButton[9];
	public JButton reset = new JButton();
	public int[] mark = new int[9];
	private int turn = 1;
	private int win = 0;

	public MyPanel2() {
		setLayout(null);
		setBounds(0, 0, MyFrame2.SIZE, MyFrame2.SIZE);
		reset.addActionListener(this);
		int x2 = MyFrame2.SIZE / 2 - 100 / 2;
		int y2 = 410;
		reset.setText("리셋");
		reset.setBounds(x2, y2, 100, 30);
		add(reset);
		reset.setVisible(false);

		setMap();
	}

	public void setMap() {
		int x = MyFrame2.SIZE / 2 - 100 * 3 / 2;
		int y = MyFrame2.SIZE / 2 - 100 * 3 / 2;
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].addActionListener(this);// 액션리스너
			button[i].setBounds(x, y, 100, 100);
			add(button[i]);
			x += 103;
			if (i % 3 == 2) {
				x = MyFrame2.SIZE / 2 - 100 * 3 / 2;
				y += 103;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < button.length; i++) {
			if (target == this.button[i] && this.mark[i] == 0) {
				if (this.turn == 1) {
					this.button[i].setBackground(Color.black);
				} else {
					this.button[i].setBackground(Color.red);
				}
				this.mark[i] = this.turn;
				checkWin();
				this.turn = this.turn == 1 ? 2 : 1;
			}
		}
		if (target == this.reset) {
			for (int i = 0; i < button.length; i++) {
//				button[i].setVisible(false);
//				remove(button[i]);
				this.button[i].setBackground(new Color(223,216,202));
			}
			mark = new int[9];
			turn = 1;
			win = 0;
//			setMap();
			revalidate();
			reset.setVisible(false);
		}

	}

	public void checkWin() {
		this.win = this.win == 0 ? checkHori() : this.win;
		this.win = this.win == 0 ? checkVerti() : this.win;
		this.win = this.win == 0 ? checDia() : this.win;
		this.win = this.win == 0 ? checReverse() : this.win;
		if (this.win != 0) {
			System.out.printf("p%d의 승!\n", this.win);
			new ResultFrame(String.format("p%d의 승!\n", this.turn));
//			new reset();
			reset.setVisible(true);
		}

	}

	private int checReverse() {
		int cnt = 0;
		for (int i = 1; i <= 3; i++) {
			if (this.mark[i * 2] == this.turn) {
				cnt++;
			}
			if (cnt == 3) {
				return this.turn;
			}
		}
		return 0;

	}

	private int checDia() {
		int cnt = 0;
		for (int i = 0; i < 3; i++) {
			if (this.mark[i * 4] == this.turn) {
				cnt++;
			}
			if (cnt == 3) {
				return this.turn;
			}
		}
		return 0;
	}

	private int checkVerti() {
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (this.mark[i + j * 3] == this.turn) {
					cnt++;
				}
			}
			if (cnt == 3) {
				return this.turn;
			}

		}

		return 0;
	}

	private int checkHori() {
		for (int i = 0; i < this.mark.length; i += 3) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (this.mark[i + j] == this.turn) {
					cnt++;
				}
				if (cnt == 3) {
					return this.turn;
				}
			}
		}
		return 0;
	}
}

class MyFrame2 extends JFrame {

	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;

	public static final int SIZE = 500;

	public MyFrame2() {
		JLabel text = new JLabel();
		setLayout(null);// null로 변경해서 순서대로나열인걸 변경할수있도록 변경
		setTitle("tic tac toe");

		setBounds(width / 2 - SIZE / 2, height / 2 - SIZE / 2, SIZE, SIZE);
		text.setLayout(null);
		text.setText("Tic Tac toe");
		text.setFont(new Font("Arial", Font.PLAIN, 50));

		text.setBounds(0, 0, SIZE, 100);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel2());
		setVisible(true);
		revalidate();

	}

}

public class Ex06 {
	public static void main(String[] args) {
		MyFrame2 frame = new MyFrame2();

	}
}
