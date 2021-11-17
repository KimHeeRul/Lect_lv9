package basic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class ImagePanel extends JPanel{
	ImageIcon icon=null;;
	
	public ImagePanel(ImageIcon icon) {
		setLayout(null);
		setBounds(0,0,400,500);
		this.icon=icon;
	}
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
		
		//drawImgae(Image,x,y,null);
		g.drawImage(icon.getImage(),0,0,null);
		
		repaint();
	}
	
}

public class Ex08 extends JFrame {
	ImageIcon icon = new ImageIcon(new ImageIcon("images/ĸó.PNG").getImage().getScaledInstance(400, 500, 
			Image.SCALE_SMOOTH));
	JLabel image = null;

	public Ex08() {
		super("image");
		setLayout(null);
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new ImagePanel(icon));
		setImageLabel();
		setVisible(true);
		revalidate();

	}

	private void setImageLabel() {
		// ImageIcon
		this.image = new JLabel(icon);
		this.image.setBounds(0,0,400,500);
		add(this.image);

	}

	public static void main(String[] args) {
		new Ex08();
	}
}
