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

	int x, y, x2, y2;
	boolean draw;
	draw rect = new draw();

	public MyPanel() {
		setLayout(null);
		setBounds(0, 0, MyFrame.SIZE, MyFrame.SIZE);
		setBackground(new Color(251, 209, 72));
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (draw) {
			g.setColor(Color.red);
			g.drawRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
		}

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		draw=false;
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
		draw = true;
		rect.setX(pressX);
		rect.setY(pressY);
		
		
		this.x = pressX;
		this.y = pressY;

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();// 좌표
		int y = e.getY();
		rect.setWidth(x-this.x);
		rect.setHeight(y-this.y);
//		if (this.x > 0 && this.x <= 100 && this.y > 0 && this.y <= 100) {
//			rect.setX(x - this.x);
//			rect.setY(y - this.y);
//		}
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
