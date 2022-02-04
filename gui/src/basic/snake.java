package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Rect {
	private int x, y, w, h;
	private Color c;

	public void SnakeRect(int x, int y, int w, int h, Color c) {

	}
}

class Game extends JPanel implements KeyListener {

	public Game() {
		setLayout(null);
		setBounds(0, 0, 700, 500);
		setFocusable(true);
		addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == e.VK_RIGHT) {
			System.out.println("r");
		}
		if (e.getKeyCode()==e.VK_LEFT) {
			
		}else if (e.getKeyCode()==e.VK_RIGHT) {
			
		}else if (e.getKeyCode()==e.VK_UP) {
			
		}else if (e.getKeyCode()==e.VK_DOWN) {
			System.out.println("1");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		requestFocusInWindow();//<키 리스너를 위한 포커스를 재요청
		repaint();
	}
}

public class snake extends JFrame {
	public snake() {
		super("snake");
		setLayout(null);
		setBounds(100, 100, 700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Game());
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		snake snake = new snake();

	}
}
