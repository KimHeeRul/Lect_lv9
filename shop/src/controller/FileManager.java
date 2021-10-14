package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import models.Basket;
import models.Item;
import models.User;

public class FileManager {
	private String text = "";
	public static FileManager instance = new FileManager();
	private UserManager um = UserManager.instance;
	private ItemManager im = ItemManager.instance;

	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;

	File user = new File("user.txt");
	File basket = new File("basket.txt");
	File item = new File("item.txt");
	File saless = new File("sale.txt");

	public void save() {

		String data = makeUsersData();
		try {
			fw = new FileWriter(user);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}

		data = makeBasketsData();
		try {
			fw = new FileWriter(basket);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}

		data = makeItemData();
		try {
			fw = new FileWriter(item);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}

		data = makeSalesData();
		try {
			fw = new FileWriter(saless);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}

	}

	public void load() {
		this.um.getUsers().clear();
		this.im.getBasket().clear();
		this.im.getItems().clear();
		this.im.getSale().setSales(0);
		this.im.getSale().getItemSales().clear();
		// 초기화
		try {// 유저
			fr = new FileReader(user);
			br = new BufferedReader(fr);

			String data = br.readLine();
			int size = Integer.parseInt(data);
			data = br.readLine();
			while (data != null) {
				String temp[] = data.split("/");
				String id = temp[0];
				String pw = temp[1];
				um.getUsers().add(new User(id, pw));
				data = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {

		}
		try {// 장바구니
			fr = new FileReader(basket);
			br = new BufferedReader(fr);

			String data = br.readLine();
			int size = Integer.parseInt(data);
			data = br.readLine();
			while (data != null) {
				String temp[] = data.split("/");
				String id = temp[0];
				String item = temp[1];
				im.getBasket().add(new Basket(id, item));
				data = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {

		}
		try {// 아이템
			fr = new FileReader(item);
			br = new BufferedReader(fr);

			String data = br.readLine();
			int size = Integer.parseInt(data);
			data = br.readLine();
			while (data != null) {
				String temp[] = data.split("/");
				String name = temp[0];
				int price = Integer.parseInt(temp[1]);
				String category = temp[2];
				im.getItems().add(new Item(name, price, category));
				data = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {

		}
		try {// 매출
			fr = new FileReader(saless);
			br = new BufferedReader(fr);
			String data = br.readLine();
			int money = Integer.parseInt(data);
			im.getSale().setSales(money);
			data = br.readLine();
			int size = Integer.parseInt(data);
			data = br.readLine();
			while (data != null) {
				String temp[] = data.split("/");
				String items = temp[0];
				im.getSale().getItemSales().add(items);
				data = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {

		}
	}

	public String makeUsersData() {
		String text = "";
		text += this.um.getUsers().size() + "\n";
		for (int i = 0; i < this.um.getUsers().size(); i++) {
			text += this.um.getUsers().get(i).getId() + "/";
			text += this.um.getUsers().get(i).getPw() + "/";
			text += "\n";
		}
		return text;
	}

	public String makeBasketsData() {
		String text = "";

		text += this.im.getBasket().size() + "\n";
		for (int i = 0; i < im.getBasket().size(); i++) {
			text += this.im.getBasket().get(i).getId() + "/";
			text += this.im.getBasket().get(i).getItem() + "/";
			text += "\n";
		}
		return text;
	}

	public String makeItemData() {
		String text = "";
		text += this.im.getItems().size() + "\n";
		for (int i = 0; i < im.getItems().size(); i++) {
			text += this.im.getItems().get(i).getName() + "/";
			text += this.im.getItems().get(i).getPrice() + "/";
			text += this.im.getItems().get(i).getCategory() + "/";
			text += "\n";
		}
		return text;
	}

	public String makeSalesData() {
		String text = "";
		text += this.im.getSale().getSales() + "\n";
		text += this.im.getSale().getItemSales().size() + "\n";
		for (int i = 0; i < this.im.getSale().getItemSales().size(); i++) {
			text += this.im.getSale().getItemSales().get(i) + "/";
			text += "\n";
		}
		return text;
	}

}
