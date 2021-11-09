package push;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class draw {
	private int x, y, width, height;
	private Color c;

	public draw(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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

class MyPanel5 extends JPanel implements MouseListener {
	public static JButton[] key = new JButton[4];
	private static draw[] rect = new draw[2];// 1move
	boolean left, up, down, right;

	public MyPanel5() {
		setLayout(null);
		setBounds(0, 0, MyFrame5.SIZE, MyFrame5.SIZE);
		setBackground(new Color(251, 209, 72));
		setRect();
		setKey();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < rect.length; i++) {// 그리기
			draw temp = rect[i];
			g.setColor(temp.getC()); // 조건?1.서로 닿았을때 색변한다
			g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
		}
		if (left) {
			int x = rect[0].getX();
			rect[0].setX(x -= 1);
		} else if (down) {
			int y = rect[0].getY();
			rect[0].setY(y += 1);
		} else if (up) {
			int y = rect[0].getY();
			rect[0].setY(y -= 1);
		} else if (right) {
			int x = rect[0].getX();
			rect[0].setX(x += 1);
		}

		if (rect[1].getX() == rect[0].getX() + rect[0].getWidth()
				&& rect[1].getY() < rect[0].getY() + rect[0].getHeight()
				&& rect[1].getY() + rect[1].getHeight() > rect[0].getY()) {
			int x = rect[1].getX();
			rect[1].setX(x += 1);
			rect[1].setC(Color.blue);
		} else if (rect[1].getX() + rect[1].getWidth() == rect[0].getX()
				&& rect[1].getY() < rect[0].getY() + rect[0].getHeight()
				&& rect[1].getY() + rect[1].getHeight() > rect[0].getY()) {
			int x = rect[1].getX();
			rect[1].setX(x -= 1);
			rect[1].setC(Color.blue);
		} else if (rect[1].getY() + rect[1].getHeight() == rect[0].getY()
				&& rect[1].getX() < rect[0].getX() + rect[0].getWidth()
				&& rect[1].getX() + rect[1].getWidth() > rect[0].getX()) {
			int y = rect[1].getY();
			rect[1].setY(y -= 1);
			rect[1].setC(Color.blue);
		} else if (rect[1].getY() == rect[0].getY() + rect[0].getHeight()
				&& rect[1].getX() < rect[0].getX() + rect[0].getWidth()
				&& rect[1].getX() + rect[1].getWidth() > rect[0].getX()) {
			int y = rect[1].getY();
			rect[1].setY(y += 1);
			rect[1].setC(Color.blue);
		} else {
			rect[1].setC(Color.red);
		}

		try {
			repaint();
			Thread.sleep(5);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void setRect() {
		int x = 200;
		int y = 200;
		for (int i = 0; i < rect.length; i++) {
			rect[i] = new draw(x, y, 150, 150);
			x += 250;
			y += 100;
		}
		rect[1].setC(Color.red);
	}

	private void setKey() {
		String text[] = { "◀", "▼", "▲", "▶" };
		int x = 500;
		int y = 650;
		for (int i = 0; i < key.length; i++) {
			key[i] = new JButton();
			key[i].setBounds(x, y, 50, 50);
			key[i].setVisible(true);
			key[i].addMouseListener(this);
			key[i].setText(text[i]);
			add(key[i]);
			if (i == 1) {
				y -= 50;
			} else {
				y = 650;
				x += 50;
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < key.length; i++) {
			if (target == key[i]) {
				if (i == 0) {
					this.left = true;
				} else if (i == 1) {
					this.down = true;
				} else if (i == 2) {
					this.up = true;
				} else if (i == 3) {
					this.right = true;
				}
			}
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < key.length; i++) {
			if (target == key[i]) {
				if (i == 0) {
					this.left = false;
				} else if (i == 1) {
					this.down = false;
				} else if (i == 2) {
					this.up = false;
				} else if (i == 3) {
					this.right = false;
				}
			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}

class MyFrame5 extends JFrame {
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;

	public static int SIZE = 800;

	public MyFrame5() {
		setLayout(null);
		setTitle("push");
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
