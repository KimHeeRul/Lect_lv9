package drawing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class draw {
	private int x, y, width, height;
	private Color c;

//	public draw(int x, int y, int width, int height) {
//		this.x = x;
//		this.y = y;
//		this.width = width;
//		this.height = height;
//	}

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

class MyPanel extends JPanel implements MouseMotionListener, MouseListener {
	public  JButton reset = new JButton();
	int x, y, x2, y2;
	boolean draw;

	draw rect = new draw();

	public MyPanel() {
		setLayout(null);
		setBounds(0, 0, MyFrame.SIZE, MyFrame.SIZE);
		setBackground(new Color(251, 209, 72));
		setButton();
		addMouseListener(this);
		addMouseMotionListener(this);
		
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
		g.setColor(Color.red);
		g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());

		repaint();
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

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int pressX = e.getX();// 좌표
		int pressY = e.getY();
		rect.setWidth(0);
		rect.setHeight(0);

		rect.setX(pressX);
		rect.setY(pressY);

		this.x = pressX;
		this.y = pressY;

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();// 좌표
		int y = e.getY();
		if (x < this.x && y < this.y) {
			rect.setX(x);
			rect.setWidth(this.x - x);
			rect.setY(y);
			rect.setHeight(this.y - y);
		}
		if (x > this.x && y < this.y) {
			rect.setY(y);
			rect.setHeight(this.y - y);
			System.out.println("1");
			rect.setWidth(x - this.x);
			System.out.println("2");
		}
		if (x > this.x && y > this.y) {
			rect.setWidth(x - this.x);
			rect.setHeight(y - this.y);
		}
		if (x < this.x && y > this.y) {
			rect.setX(x);
			rect.setWidth(this.x - x);
			rect.setHeight(y - this.y);
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
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
