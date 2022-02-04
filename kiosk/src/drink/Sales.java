package drink;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Sales {
	private String price;
	private String name;
	private String num;

	public Sales(String price, String name, String num) {
		this.name = name;
		this.price = price;
		this.num = num;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
	
	
}
