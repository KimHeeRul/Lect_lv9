package snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

class MyPanel5 extends JPanel implements MouseListener ,KeyListener{
	public static JButton[] key = new JButton[4];
	private static draw[][] map = new draw[10][10];// 1move
	public static ArrayList<draw> snake = new ArrayList();
	public ArrayList<draw> tempsnake = new ArrayList();
	boolean left, up, down, right;
	boolean move;
	int xx = 0;
	int yy = 0;

	public MyPanel5() {
		setLayout(null);
		setBounds(0, 0, MyFrame5.SIZE, MyFrame5.SIZE);
		setBackground(new Color(251, 209, 72));
		setMap();
		setSnake();
//		setRect();
		setKey();
		setFocusable(true);
		addKeyListener(this);
	}

	private void setSnake() {
		for (int i = 0; i < 5; i++) {
			int x = map[0][i].getX();
			int y = map[0][i].getY();
			snake.add(new draw(x, y, 50, 50));
		}

	}

	private void setMap() {
		int x = (MyFrame5.SIZE / 2 - 50 * 10 / 2);
		int y = (MyFrame5.SIZE / 2 - 50 * 10 / 2);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new draw(x, y, 50, 50);
				x += 50;
				if (j % 10 == 9) {
					x = (MyFrame5.SIZE / 2 - 50 * 10 / 2);
					y += 50;
				}
			}
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				draw temp = map[i][j];
				g.setColor(Color.red);
				g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());

			}
		}
		for (int i = 0; i < snake.size(); i++) {
			draw temp = snake.get(i);
			g.setColor(Color.black);
			g.drawRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
			if (i == 0) {
				g.setColor(Color.blue);
			} else {
				g.setColor(Color.green);
			}
			g.fillRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight());
		}
		requestFocusInWindow();
		try {
			repaint();
			Thread.sleep(5);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void setKey() {
		String text[] = { "◀", "▼", "▲", "▶" };
		int x = 500;
		int y = 720;
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
				y = 720;
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
		moveCheck();
		if (move) {
			moveRect();
		}
	}

	private void moveRect() {
		for (int i = tempsnake.size() - 1; i > 0; i--) {
			int x = tempsnake.get(i - 1).getX();
			int y = tempsnake.get(i - 1).getY();
			snake.set(i, new draw(x, y, 50, 50));
		}
		tempsnake.clear();
	}

	public void check2() {
		for (int i = 0; i < snake.size(); i++) {
			tempsnake.add(i, snake.get(i));
		}
	}

	private void moveCheck() {
		boolean check = true;
		if (left) {
			int x = snake.get(0).getX();
			int y = snake.get(0).getY();
			if (x != map[0][0].getX()) {
				for (int i = 0; i < snake.size(); i++) {
					if (x - 50 == snake.get(i).getX() && y == snake.get(i).getY()) {
						check = false;
					}
				}
				if (check) {
					check2();
					snake.set(0, new draw(x - 50, y, 50, 50));
					move = true;
				}

			} else {
				move = false;
			}
		} else if (down) {
			int x = snake.get(0).getX();
			int y = snake.get(0).getY();

			if (y != map[map.length - 1][map.length - 1].getY()) {
				for (int i = 1; i < snake.size(); i++) {
					if (x == snake.get(i).getX() && y + 50 == snake.get(i).getY()) {
						check = false;
					}
				}
				if (check) {
					check2();
					snake.set(0, new draw(x, y + 50, 50, 50));
					move = true;
				}
			} else {
				move = false;
			}
		} else if (up) {

			int x = snake.get(0).getX();
			int y = snake.get(0).getY();
			if (y != map[0][0].getY()) {
				for (int i = 1; i < snake.size(); i++) {
					if (x == snake.get(i).getX() && y - 50 == snake.get(i).getY()) {
						check = false;
					}
				}
				if (check) {
					check2();
					snake.set(0, new draw(x, y - 50, 50, 50));
					move = true;
				}

			} else {
				move = false;

			}
		} else if (right) {
			int x = snake.get(0).getX();
			int y = snake.get(0).getY();
			if (x != map[map.length - 1][map.length - 1].getX()) {
				for (int i = 1; i < snake.size(); i++) {
					if (x + 50 == snake.get(i).getX() && y == snake.get(i).getY()) {
						check = false;
					}
				}
				if (check) {
					check2();
					snake.set(0, new draw(x + 50, y, 50, 50));
					move = true;
				}

			} else {
				move = false;
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

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == e.VK_RIGHT) {
			this.right = true;
		}
		if (e.getKeyCode()==e.VK_LEFT) {
			this.left = true;
		}else if (e.getKeyCode()==e.VK_UP) {
			this.up = true;
		}else if (e.getKeyCode()==e.VK_DOWN) {
			this.down = true;
		}
		moveCheck();
		if (move) {
			moveRect();
		}		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == e.VK_RIGHT) {
			this.right = true;
		}
		if (e.getKeyCode()==e.VK_LEFT) {
			this.left = true;
		}else if (e.getKeyCode()==e.VK_UP) {
			this.up = true;
		}else if (e.getKeyCode()==e.VK_DOWN) {
			this.down = true;
		}
		moveCheck();
		if (move) {
			moveRect();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == e.VK_RIGHT) {
			this.right = false;
		}
		if (e.getKeyCode()==e.VK_LEFT) {
			this.left = false;
		}else if (e.getKeyCode()==e.VK_UP) {
			this.up = false;
		}else if (e.getKeyCode()==e.VK_DOWN) {
			this.down = false;
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
		setTitle("snake");
		setBounds(width / 2 - SIZE / 2, height / 2 - SIZE / 2, SIZE + 10, SIZE + 40);
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
