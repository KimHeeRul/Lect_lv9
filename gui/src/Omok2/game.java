package Omok2;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class draw {
	private int x,y,width,height;
	private Color c;
	public draw(int x,int y,int width,int height, Color c) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.c=c;
	}
}
class MyPanel5 extends JPanel implements MouseListener{
	private draw[][] map=new draw[10][10]; 
	private int[][] mark=new int[10][10];
	public MyPanel5() {
		setLayout(null);
		setBounds(0,0,500,400);
		addMouseListener(this);
	}
	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
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
}


class MyFrame5 extends JFrame{
	public MyFrame5() {
		setLayout(null);
		setTitle("MyFrame");
		setBounds(50,50,500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel5());
		
		setVisible(true);
		revalidate();
	}
}

public class game {
	public static void main(String[] args) {
		MyFrame5 frame =new MyFrame5();
	}
}
