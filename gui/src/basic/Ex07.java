package basic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//paintCommonent() �޼ҵ带 Ȱ���� �簢�� �׸���
class Nemo{
	private int x,y,width,height;
	private Color c;
	public Nemo(int x,int y,int width,int height, Color c) {
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.c=c;
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

class MyPanel4 extends JPanel implements MouseListener{
//	private Nemo nemo = new Nemo();
	private Nemo[][] map=new Nemo[3][3]; 
	public MyPanel4() {
		setLayout(null);
		setBounds(0,0,500,400);
//		nemo.setX(100);
//		nemo.setY(100);
//		nemo.setWidth(200);
//		nemo.setHeight(200);
//		nemo.setC(Color.yellow);
		setMap();
		addMouseListener(this);//this=MyPanel
		//�гο� Ȥ�� Ư���ϴ� ������Ʈ��-->���콺 �����ʸ� �޼��ִ�
		
		
	}
	private void setMap() {
		int x=50;
		int y=50;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				this.map[i][j]=new Nemo(x, y, 50, 50, Color.white);
				x+=50;
			}
			x=50;
			y+=50;
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {//������
		super.paintComponent(g);//�׷����� ����-����
//		g.setColor(Color.blue);
//		g.drawRect(100, 100, 100, 100);
//		g.fillRect(100, 100, 100,100);
		
		
		
//		g.setColor(this.nemo.getC());
//		g.drawRect(this.nemo.getX(), this.nemo.getY(), this.nemo.getWidth(), this.nemo.getHeight());
		
		//draw Map
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				Nemo temp=this.map[i][j];
				g.setColor(Color.black);
				g.drawRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(),temp.getWidth(),temp.getHeight());
				g.setColor(Color.white);
				g.fillRoundRect(temp.getX(), temp.getY(), temp.getWidth(), temp.getHeight(),temp.getWidth(),temp.getHeight());
			}
		}
		
		repaint();
	
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("�������ִ»���");
		int x=e.getX();//��ǥ
		int y=e.getY();
		System.out.println(x+"/"+y);
//		System.out.println(this.nemo.getX());
//		if (x>=this.nemo.getX()&& x<this.nemo.getX()+this.nemo.getWidth()&& 
//			y>=this.nemo.getY()&& y<this.nemo.getY()+this.nemo.getHeight()) {//Ŭ���� �׸� �ȿ�������
//			this.nemo.setC(Color.red);
//		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("����������");
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("���콺 ����");
	}
	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("���콺 �����");
	}
	
}


class MyFrame4 extends JFrame{
	public MyFrame4() {
		setLayout(null);
		setTitle("MyFrame");
		setBounds(50,50,500,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new MyPanel4());
		
		setVisible(true);
		revalidate();
	}
}

public class Ex07 {
	public static void main(String[] args) {
		MyFrame4 frame =new MyFrame4();
	}
}
