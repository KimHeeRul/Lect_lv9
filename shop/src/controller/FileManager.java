package controller;

import java.io.File;
import java.io.FileWriter;

import models.Basket;

public class FileManager {
	private String text = "";
	public static FileManager instance = new FileManager();
	private UserManager um = UserManager.instance;
	private ItemManager im = ItemManager.instance;

	public void save() {
		File file = new File("test.txt");
		this.text = "";
		this.text += this.um.getUsers().size() + "/";
		for (int i = 0; i < this.um.getUsers().size(); i++) {
			this.text += this.um.getUsers().get(i).getId() + "/";
			this.text += this.um.getUsers().get(i).getPw() + "/";
			this.text += "\n";
		}
		this.text += this.im.getBasket().size() + "/";
		for (int i = 0; i < im.getBasket().size(); i++) {
			this.text += this.im.getBasket().get(i).getId() + "/";
			this.text += this.im.getBasket().get(i).getItem() + "/";
			this.text += "\n";
		}
		
		for (int i = 0; i < im.getItems().size(); i++) {
			this.text += this.im.getItems().get(i).getName() + "/";
			this.text += this.im.getItems().get(i).getPrice() + "/";
			this.text += this.im.getItems().get(i).getCategory() + "/";
			this.text += "\n";
		}
		
		
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(this.text);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
