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
import java.util.Random;

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

class MyPanel5 extends JPanel implements MouseListener, KeyListener {
	public static JButton[] key = new JButton[4];
	public static JButton reset = new JButton();
	private static draw[][] map = new draw[10][10];// 1move
	public static ArrayList<draw> snake = new ArrayList<>();
	public ArrayList<draw> tempsnake = new ArrayList<>();
	public ArrayList<draw> item = new ArrayList<>();
	boolean left, up, down, right;
	boolean move;
	boolean mouseMove;
	boolean death;

	public MyPanel5() {
		setLayout(null);
		setBounds(0, 0, MyFrame5.SIZE, MyFrame5.SIZE);
		setBackground(new Color(251, 209, 72));
		setMap();
		setSnake();
		setKey();
		reset();
		setFocusable(true);
		addKeyListener(this);
	}

	private void reset() {
		reset.setBounds(300, 720, 100, 50);
		reset.setVisible(true);
		reset.addMouseListener(this);
		reset.setText("reset");
		add(reset);
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
			if (death) {
				g.setColor(Color.red);
			}
			g.fillRect(temp.getX() + 1, temp.getY() + 1, temp.getWidth() - 1, temp.getHeight() - 1);
		}
		for (int i = 0; i < item.size(); i++) {
			draw temp = item.get(i);
			g.setColor(Color.red);
			g.drawRoundRect(temp.getX() + 25 / 2, temp.getY() + 25 / 2, temp.getWidth() - 25, temp.getHeight() - 25,
					temp.getWidth() - 25, temp.getHeight() - 25);
			g.fillRoundRect(temp.getX() + 25 / 2, temp.getY() + 25 / 2, temp.getWidth() - 25, temp.getHeight() - 25,
					temp.getWidth() - 25, temp.getHeight() - 25);
		}

		if (mouseMove) {// 마우스 전용

			moveCheck();
			if (move) {
				moveRect();
			}
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		requestFocusInWindow();
		repaint();
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
	}

	@Override
	public void mousePressed(MouseEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < key.length; i++) {
			if (target == key[i]) {
				if (i == 0) {
					this.left = true;
					mouseMove = true;
				} else if (i == 1) {
					this.down = true;
					mouseMove = true;
				} else if (i == 2) {
					this.up = true;
					mouseMove = true;
				} else if (i == 3) {
					this.right = true;
					mouseMove = true;
				}
			}
		}
		if (target == reset) {
			death = false;
			snake.clear();
			tempsnake.clear();
			item.clear();
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = null;
				}
			}
			setMap();
//			move = true;
			left = false;
			right = false;
			up = false;
			down = false;
			setSnake();
			move = true;
		}

	}

	private void item() {
		Random ran = new Random();
		int rand3 = ran.nextInt(10);
		if (rand3 > 8) {
			boolean check = false;
			boolean check2 = true;
			int rand = ran.nextInt(10);
			int rand2 = ran.nextInt(10);
			for (int i = 0; i < snake.size(); i++) {
				if (snake.get(i).getX() == map[rand][rand2].getX() && snake.get(i).getY() == map[rand][rand2].getY()) {
					check = false;
					break;
				} else {
					check = true;
				}
			}
			for (int i = 0; i < item.size(); i++) {
				if (item.get(i).getX() == map[rand][rand2].getX() && item.get(i).getY() == map[rand][rand2].getY()) {
					check2 = false;
					break;
				} else {
					check2 = true;
				}
			}
			if (check && check2) {
				item.add(new draw(map[rand][rand2].getX(), map[rand][rand2].getY(), 50, 50));
			}

		}

	}

	private void moveRect() {
		itemcheck();
		for (int i = tempsnake.size() - 1; i > 0; i--) {
			int x = tempsnake.get(i - 1).getX();
			int y = tempsnake.get(i - 1).getY();
			snake.set(i, new draw(x, y, 50, 50));
		}

		tempsnake.clear();
		item();

	}

	private void itemcheck() {
		int x = snake.get(0).getX();
		int y = snake.get(0).getY();
		int lx = snake.get(snake.size() - 1).getX();
		int ly = snake.get(snake.size() - 1).getY();

		for (int i = 0; i < item.size(); i++) {
			if (x == item.get(i).getX() && y == item.get(i).getY()) {
				item.remove(i);

				snake.add(snake.size(), new draw(lx, ly, 50, 50));
			}

		}
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
				int x2 = x - 50;
				int y2 = y;
				check = xy(x2, y2, check);
				checkset(check, x2, y2);

			} else {
				move = false;
			}
		} else if (down) {
			int x = snake.get(0).getX();
			int y = snake.get(0).getY();
			if (y != map[map.length - 1][map.length - 1].getY()) {
				int x2 = x;
				int y2 = y + 50;
				check = xy(x2, y2, check);

				checkset(check, x2, y2);
			} else {
				move = false;
			}
		} else if (up) {
			int x = snake.get(0).getX();
			int y = snake.get(0).getY();
			if (y != map[0][0].getY()) {
//				
				int x2 = x;
				int y2 = y - 50;
				check = xy(x2, y2, check);

				checkset(check, x2, y2);

			} else {
				move = false;
			}
		} else if (right) {
			int x = snake.get(0).getX();
			int y = snake.get(0).getY();
			if (x != map[map.length - 1][map.length - 1].getX()) {
				int x2 = x + 50;
				int y2 = y;
				check = xy(x2, y2, check);
				checkset(check, x2, y2);

			} else {
				move = false;
			}
		}

	}

	private void checkset(boolean check, int x, int y) {
		if (check) {
			check2();
			snake.set(0, new draw(x, y, 50, 50));
			move = true;
		}
	}

	private boolean xy(int x, int y, boolean check) {
		for (int i = 1; i < snake.size(); i++) {
			if (x == snake.get(i).getX() && y == snake.get(i).getY()) {
				check = false;
				move = false;
				death = true;
			}
		}
		return check;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		JButton target = (JButton) e.getSource();
		for (int i = 0; i < key.length; i++) {
			if (target == key[i]) {
				if (i == 0) {
					mouseMove = false;
					this.left = false;
				} else if (i == 1) {
					mouseMove = false;
					this.down = false;
				} else if (i == 2) {
					mouseMove = false;
					this.up = false;
				} else if (i == 3) {
					mouseMove = false;
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

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!death) {
			if (e.getKeyCode() == e.VK_RIGHT) {
				this.right = true;
			}
			if (e.getKeyCode() == e.VK_LEFT) {
				this.left = true;
			} else if (e.getKeyCode() == e.VK_UP) {
				this.up = true;
			} else if (e.getKeyCode() == e.VK_DOWN) {
				this.down = true;
			}

			moveCheck();
			if (death) {
				System.out.println("game over");
			}
			if (move) {
				moveRect();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!death) {
			if (e.getKeyCode() == e.VK_RIGHT) {
				this.right = false;
			}
			if (e.getKeyCode() == e.VK_LEFT) {
				this.left = false;
			} else if (e.getKeyCode() == e.VK_UP) {
				this.up = false;
			} else if(e.getKeyCode() == e.VK_DOWN) {
				this.down = false; 
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
