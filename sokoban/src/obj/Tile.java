package obj;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tile { //상속으로 변경예정
	private int x;
	private int y;
	private boolean check;
	String fileName;
	ImageIcon image;

	public Tile(int x, int y, String fileName) {
		this.x = x;
		this.y = y;
		this.fileName=String.format("images/%s.png", fileName);
		this.image =  new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
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

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

}
