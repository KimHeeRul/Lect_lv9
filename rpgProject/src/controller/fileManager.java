package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import models.Item;
import models.Player;
import models.Unit;

public class fileManager {
	private String text = "";
	private FileWriter fw = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	private Guild guild = new Guild();
	private Inven inven = new Inven();
	Shop shop = new Shop();

	File Guild = new File("Guild.txt");// +돈
	File Inven = new File("inven.txt");
//	File = new File("Guild.txt");

	// 길드원들의 스텟
	// 돈
	// 인벤토리
	// 길드리스트

	public void save() {
		String data = GuildData();
		try {
			fw = new FileWriter(Guild);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}
		data = inven();
		try {
			fw = new FileWriter(Inven);
			fw.write(data);
			fw.close();
		} catch (Exception e) {
		}

	}

	public void load() {
//		inven.itemList.set(index, element) //add 하면될듯
		// 착용한 무기는 set
		this.guild.guildList.clear();
		this.inven.itemList.clear();
		// 돈은 초기화 안하고 set시킬예정
		text = "";
		// 초기화
		try {// 유저
			fr = new FileReader(Guild);
			br = new BufferedReader(fr);

			String data = br.readLine();
			int cnt = 0;
			while (data != null) {
				text += data+"\n";
				data = br.readLine();
			}
			fr.close();
			br.close();
			String temp3[] = text.split("\n");
			String[] money=temp3[0].split("/");
			Player.money=Integer.parseInt(money[0]);
			for (int i = 1; i < temp3.length; i++) {
				String[] temp = temp3[i].split("/");
				String name = temp[0];
				int level = Integer.parseInt(temp[1]);
				int hp = Integer.parseInt(temp[2]);
				int Maxhp = Integer.parseInt(temp[3]);
				int att = Integer.parseInt(temp[4]);
				int def = Integer.parseInt(temp[5]);
				int exp = Integer.parseInt(temp[6]);
				boolean party = Boolean.parseBoolean(temp[7]);
				guild.guildList.add(new Unit(name, level,hp, Maxhp, att, def, exp, party));
				if (!temp[8].equals(null)) {
					weapon(temp[8], cnt);
				}
				if (!temp[9].equals(null)) {
					armor(temp[9], cnt);
				}
				if (!temp[10].equals(null)) {
					ring(temp[10], cnt);
				}
				
				cnt++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {// 유저
			fr = new FileReader(Inven);
			br = new BufferedReader(fr);

			String data = br.readLine();
			int cnt = 0;
			while (data != null) {
				String item = data;
				for (int i = 0; i < shop.items.size(); i++) {
					if (item.equals(shop.items.get(i).getName())) {
						inven.itemList.add(shop.items.get(i));
						break;
					}
				}
				data = br.readLine();
			}
			fr.close();
			br.close();
		} catch (Exception e) {

		}

	}

	public void ring(String temp, int cnt) {
		Item temp2 = null;
		for (int i = 0; i < shop.items.size(); i++) {
			if (temp.equals(shop.items.get(i).getName())) {
				temp2 = shop.items.get(i);
				guild.guildList.get(cnt).setRing(temp2);
				break;
			}
		}

	}

	public void armor(String temp, int cnt) {
		Item temp2 = null;
		for (int i = 0; i < shop.items.size(); i++) {
			if (temp.equals(shop.items.get(i).getName())) {
				temp2 = shop.items.get(i);
				guild.guildList.get(cnt).setArmor(temp2);
				break;
			}
		}

	}

	public void weapon(String temp, int cnt) {
		Item temp2 = null;
		for (int i = 0; i < shop.items.size(); i++) {
			if (temp.equals(shop.items.get(i).getName())) {
				temp2 = shop.items.get(i);
				guild.guildList.get(cnt).setWeapon(temp2);
				break;
			}
		}

	}

	public String GuildData() {
		String text = "";
		text += Player.money + "/\n";// 0번은 머니
		for (int i = 0; i < guild.guildList.size(); i++) {
			text += guild.guildList.get(i).getName() + "/";
			text += guild.guildList.get(i).getLevel() + "/";
			text += guild.guildList.get(i).getHp() + "/";
			text += guild.guildList.get(i).getMaxHp() + "/";
			text += guild.guildList.get(i).getAtt() + "/";
			text += guild.guildList.get(i).getDef() + "/";
			text += guild.guildList.get(i).getExp() + "/";
			text += guild.guildList.get(i).isParty() + "/";
			if (guild.guildList.get(i).getWeapon() != null) {
				text += guild.guildList.get(i).getWeapon().getName() + "/";
			} else {
				text += guild.guildList.get(i).getWeapon() + "/";
			}
			if (guild.guildList.get(i).getArmor() != null) {
				text += guild.guildList.get(i).getArmor().getName() + "/";
			} else {
				text += guild.guildList.get(i).getArmor() + "/";
			}
			if (guild.guildList.get(i).getRing() != null) {
				text += guild.guildList.get(i).getRing().getName() + "/";
			} else {
				text += guild.guildList.get(i).getRing() + "/";
			}
			text += "\n";
		}
		return text;
	}

	public String inven() {
		String text = "";
		for (int i = 0; i < inven.itemList.size(); i++) {
			text += inven.itemList.get(i).getName() + "\n";
		}
		return text;
	}
}
