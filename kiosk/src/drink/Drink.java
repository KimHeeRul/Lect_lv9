package drink;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Drink {
	private int price;
	private String name;
	private String fileName;
	private String fileName2;
	private ImageIcon image;
	private ImageIcon image2;
	private int num;

	public Drink(int price, String name, int num) {
		this.name = name;
		this.price = price;
		this.fileName = String.format("images/coffee_sub%02d.png", num+1);
//		this.fileName2 = String.format("images/coffee%02d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(140, 140,Image.SCALE_SMOOTH));
//		this.image2 = new ImageIcon(new ImageIcon(this.fileName2).getImage());
	}

	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getFileName2() {
		return fileName2;
	}

	public void setFileName2(String fileName2) {
		this.fileName2 = fileName2;
	}

	public ImageIcon getImage2() {
		return image2;
	}

	public void setImage2(ImageIcon image2) {
		this.image2 = image2;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}


}
