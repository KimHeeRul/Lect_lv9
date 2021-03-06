package Omok2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ResultFrame extends JFrame implements ActionListener {
	private JLabel text = new JLabel();
	public JButton reset = new JButton();

	public ResultFrame(int turn) {
		setTitle("Game Clear");
		setLayout(null);
		int x = MyFrame5.width / 2 - 300 / 2;
		int y = MyFrame5.height / 2 - 200 / 2;
		setBounds(x, y, 300, 200);
		text.setBounds(0, 0, 300, 200);
		text.setText("승자:P" + turn);
		text.setHorizontalAlignment(JLabel.CENTER);
		add(text);
		resetB(x, y);
		setVisible(true);
	}

	public void resetB(int x, int y) {
		int x2 = 300 / 2 - 100 / 2;
		int y2 = 200 / 2 - 30 * 2;
		reset.setText("리셋");
		reset.setBounds(x2, y2, 100, 30);
		add(reset);
		reset.setVisible(true);
		reset.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		if (target == this.reset) {
			MyPanel5.resetButton();
			dispose();
		}
	}

}

class draw {
	private int x, y, width, height;
	private Color c;
	private boolean set;

	public draw(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public boolean isSet() {
		return set;
	}

	public void setSet(boolean set) {
		this.set = set;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}

}

class MyPanel5 extends JPanel implements MouseListener, ActionListener {
	JLabel title = new JLabel();
	JLabel turnText = new JLabel();
	public static JButton reset = new JButton();
	public static JButton view = new JButton();
	private static draw[][] map = new draw[10][10];// 실제값
	private draw[][] map2 = new draw[9][9];// 겉값
	private static int[][] mark = new int[10][10];
	static int turn = 1;
	public static int win = 0;
	public boolean guide;

	public MyPanel5() {
		setLayout(null);
		setBounds(0, 0, MyFrame5.SIZE, MyFrame5.SIZE);
		setBackground(new Color(251, 209, 72));
		addMouseListener(this);
		Label();
		resetB();
		view();
		setMap();
		setMap2();
	}

	private void setMap() {
		int x = (MyFrame5.SIZE / 2 - 50 * 10 / 2) + 100;
		int y = (MyFrame5.SIZE / 2 - 50 * 10 / 2) - 50;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new draw(x, y, 50, 50);// 실제값
				x += 50;
				if (j % 10 == 9) {
					x = (MyFrame5.SIZE / 2 - 50 * 10 / 2) + 100;
					y += 50;
				}
			}

		}

	}

	private void setMap2() {
		int x = (MyFrame5.SIZE / 2 - 50 * 9 / 2) - 25 + 100;
		int y = (MyFrame5.SIZE / 2 - 50 * 9 / 2) - 25 - 50;
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2[i].length; j++) {
				map2[i][j] = new draw(x + 25, y + 25, 50, 50);// 겉값
				x += 50;
				if (j % 9 == 8) {
					x = (MyFrame5.SIZE / 2 - 50 * 9 / 2) - 25 + 100;
					y += 50;
				}
			}

		}

	}

	public void Label() {
		title.setText("재미있는 오목게임");
		title.setLayout(null);
		title.setBounds(0, 50, 300, 100);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("nanumBunyuk", Font.BOLD, 25));
		title.setVisible(true);
		add(title);
	}

	public void Label2() {
		turnText.setText("Player" + turn + "차례▶");
		turnText.setLayout(null);
		turnText.setBounds(5, 100, 200, 100);
		turnText.setHorizontalAlignment(JLabel.CENTER);
		turnText.setFont(new Font("nanumBunyuk", Font.ITALIC, 20));
		turnText.setForeground(Color.blue);
		turnText.setVisible(true);
		add(turnText);
	}

	public void resetB() {
		reset.setText("리셋");
		reset.setBounds(50, 200, 150, 50);
		reset.setBackground(Color.LIGHT_GRAY);
		add(reset, 0);// 우선순위 0 최우선순위
		reset.setVisible(true);
		reset.addActionListener(this);

	}

	public void view() {
		view.setText("VIEW GUIDE ");
		view.setBounds(50, 300, 150, 50);
		view.setBackground(Color.LIGHT_GRAY);
		add(view);// 우선순위 0 최우선순위
		view.setVisible(true);
		view.addActionListener(this);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Label2();
		for (int i = 0; i < map2.length; i++) {
			for (int j = 0; j < map2.length; j++) {
				draw temp2 = this.map2[i][j];
				g.setColor(Color.black);
				g.drawRect(temp2.getX(), temp2.getY(), temp2.getWidth(), temp2.getHeight());
			}
		}
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				draw temp = this.map[i][j];
				if (guide) {
					g.setColor(Color.gray);
					g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
					// 실제 그려지는맵

				}

				if (map[i][j].isSet()) {
					g.setColor(Color.black);
					g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), temp.getWidth(),
							temp.getHeight());
					g.setColor(temp.getC());
					g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(), temp.getWidth(),
							temp.getHeight());
				}
			}
		}

		repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if (x > this.map[i][j].getX() && x < this.map[i][j].getX() + this.map[i][j].getWidth()
						&& y > this.map[i][j].getY() && y < this.map[i][j].getY() + this.map[i][j].getHeight()) {

					if (!map[i][j].isSet()) {
						if (this.turn == 1) {
							map[i][j].setC(Color.black);
						} else {
							map[i][j].setC(Color.white);
						}
						mark[i][j] = this.turn;
						map[i][j].setSet(true);// 공그리기
						checkWin();
						this.turn = this.turn == 1 ? 2 : 1;
					}

				}
			}
		}
		repaint();
	}

	private void checkWin() {
		win = win == 0 ? checkHori() : win;
		win = win == 0 ? checkVerti() : win;
		win = win == 0 ? checDia() : win;
		win = win == 0 ? checReverse() : win;
		if (win != 0) {
			new ResultFrame(this.turn);
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

	// ---------------
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

//-------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton target = (JButton) e.getSource();
		if (target == reset) {
			resetButton();
		}
		if (target == view) {
			if (!guide) {
				guide = true;
			} else {
				guide = false;
			}
		}
	}

	public static void resetButton() {
		for (int i = 0; i < mark.length; i++) {
			for (int j = 0; j < mark[i].length; j++) {
				mark[i][j] = 0;
				map[i][j].setSet(false);
				win = 0;
				turn = 1;
			}
		}
	}
}

class MyFrame5 extends JFrame {
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;

	public static int SIZE = 800;

	public MyFrame5() {
		setLayout(null);
		setTitle("Omok");
		setBounds(width / 2 - SIZE / 2, height / 2 - SIZE / 2, SIZE, SIZE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel5());

		setVisible(true);
		revalidate();
	}
}

public class game {
	public static void main(String[] args) {
		MyFrame5 frame = new MyFrame5();
	}
}
