package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import models.Account;
import models.User;

public class FileManager {
	private String text = "";
	public static FileManager instance = new FileManager();
	private UserManager um = UserManager.instance;
	
	public void save() {
		File file = new File("test.txt");
		this.text = "";
		for (int i = 0; i < this.um.getUsers().size(); i++) {
			this.text += this.um.getUsers().get(i).getUserCode() + "/";
			this.text += this.um.getUsers().get(i).getId() + "/";
			this.text += this.um.getUsers().get(i).getPw() + "/";
			this.text += this.um.getUsers().get(i).getName() + "/";
			this.text += this.um.getUsers().get(i).getAccCnt() + "/";
			for (int j = 0; j < this.um.getUsers().get(i).getAccCnt(); j++) {
				this.text += this.um.getUsers().get(i).getAcc().get(j).getAccNum() + "/";
				this.text += this.um.getUsers().get(i).getAcc().get(j).getMoney() + "/";
			}
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

	public void load() {
		text = "";
		this.um.setUsers(new ArrayList<>());//초기화
		FileReader fr = null;
		BufferedReader br = null;
		try {
			File file = new File("test.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String data = "";
			while (data != null) {
				data = br.readLine();
				if (data != null) {
					this.text += data;
					this.text += "\n";
				}
			}

			String arr[] = this.text.split("\n");
			for (int i = 0; i < arr.length; i++) {
				String arr2[] = arr[i].split("/");
				int code = Integer.parseInt(arr2[0]);
				String id = arr2[1];
				String pw = arr2[2];
				String name = arr2[3];
				User newUser = new User(code, id, pw, name);
				this.um.getUsers().add(newUser);
				this.um.getUsers().get(i).setAccCnt(Integer.parseInt(arr2[4]));
				for (int j = 0; j < this.um.getUsers().get(i).getAccCnt(); j++) {
					this.um.getUsers().get(i).getAcc().add(new Account());
					this.um.getUsers().get(i).getAcc().get(j).setAccNum(arr2[5 + j]);
					this.um.getUsers().get(i).getAcc().get(j).setMoney(Integer.parseInt(arr2[6 + j]));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
