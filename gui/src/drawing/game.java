package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
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

class MyPanel extends MyUtill {
	public JButton reset = new JButton();
	int x, y, x2, y2;
	boolean draw;
	boolean shift;
	ArrayList<draw> rect = new ArrayList<draw>();
	draw rect2 = null;

	public MyPanel() {
		setLayout(null);
		setBounds(0, 0, MyFrame.SIZE, MyFrame.SIZE);
		setBackground(new Color(251, 209, 72));
		setButton();
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		setFocusable(true);

	}

	private void setButton() {
		reset.setBounds(300, 720, 100, 50);
		reset.setVisible(true);
		reset.addMouseListener(this);
		reset.setText("reset");
		add(reset);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < rect.size(); i++) {
			if (this.rect.get(i) != null) {
				g.setColor(Color.red);
				g.drawRect(rect.get(i).getX(), rect.get(i).getY(), rect.get(i).getWidth(), rect.get(i).getHeight());
			}
		}
		if (rect2 != null) {

			g.setColor(Color.red);
			g.drawRect(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight());
		}

		requestFocusInWindow();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (rect2 != null) {
			rect.add(new draw(rect2.getX(), rect2.getY(), rect2.getWidth(), rect2.getHeight()));

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
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() == reset) {
			for (int i = 0; i < rect.size(); i++) {
				rect.clear();
			}
			rect2 = null;

		} else {
			int pressX = e.getX();// 좌표
			int pressY = e.getY();

			this.x = pressX;
			this.y = pressY;
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();// 좌표
		int y = e.getY();
		int w = Math.abs(x - this.x);
		int h = Math.abs(y - this.y);

		if (shift) {
			w = h;
		}
		int rX = this.x;
		int rY = this.y;
		if (x < this.x) {
			rX = this.x - w;
		}
		if (y < this.y) {
			rY = this.y - h;
		}
		this.rect2 = new draw(rX, rY, w, h);

//		int pressX=this.x;
//		int pressY=this.y;
//		
//		
//		if (x < pressX && y < pressY) {
//			if (shift) {
//				rect.setX(x);
//				rect.setWidth(pressX - x);
//				rect.setY(y);
//				rect.setHeight(pressX - x);
//			} else {
//				rect.setX(x);
//				rect.setWidth(pressX - x);
//				rect.setY(y);
//				rect.setHeight(pressY - y);
//			}
//
//		}
//		if (x > pressX && y < pressY) {
//			if (shift) {
//				int cha = (x - pressX) - (pressY - y);
//				rect.setY(y - cha);
//				rect.setHeight(pressY - y + cha);
//				rect.setWidth(x - pressX);
//			} else {
//				rect.setY(y);
//				rect.setHeight(pressY - y);
//				rect.setWidth(x - pressX);
//			}
//
//		}
//		if (x > pressX && y > this.y) {
//			if (shift) {
//				rect.setWidth(x - pressX);
//				rect.setHeight(x - pressX);
//			} else {
//				rect.setWidth(x - pressX);
//				rect.setHeight(y -pressY);
//			}
//		}
//		if (x < this.x && y > pressY) {
//			if (shift) {
//				int cha = (y - pressY) - (this.x - x);
//				rect.setX(x-cha);
//				rect.setWidth(this.x - x+cha);
//				rect.setHeight(y - this.y);
//			} else {
//				rect.setX(x);
//				rect.setWidth(this.x - x);
//				rect.setHeight(y -pressY);
//			}
//
//		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == e.VK_SHIFT) {
			shift = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == e.VK_SHIFT) {
			shift = false;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

class MyFrame extends JFrame {
	private static Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();
	public static int width = dm.width;
	public static int height = dm.height;

	public static int SIZE = 800;

	public MyFrame() {
		setLayout(null);
		setTitle("move");
		setBounds(width / 2 - SIZE / 2, height / 2 - SIZE / 2, SIZE + 10, SIZE + 40);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
		revalidate();
	}
}

public class game {
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}
}
