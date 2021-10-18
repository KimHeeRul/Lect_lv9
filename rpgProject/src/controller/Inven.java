package controller;

import java.util.ArrayList;
import java.util.Scanner;

import models.Item;
import models.Player;

public class Inven {
	private Guild guild = Guild.guild;
	public static ArrayList<Item> itemList = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public void equip() {
		guild.Glist();
		System.out.println("아이템을 착용할 길드원을 선택하세요.");
		System.out.print(">>>");
		int input = scan.nextInt() - 1;
		if (input >= 0 && input < guild.guildList.size()) {
			guild.printStatus(input);
			if (itemList.size() > 0) {
				printItemList();
				System.out.println("착용할 아이템 번호를 입력하세요[0.뒤로가기]");
				int sel = scan.nextInt() - 1;
				if (sel >= 0) {
					Item temp = null;
					if (itemList.get(sel).getKind() == Item.Weapon) {
						temp = Guild.guildList.get(input).getWeapon();
						Guild.guildList.get(input).setWeapon(itemList.get(sel));
						int plus = itemList.get(sel).getPower();
						int before = Guild.guildList.get(input).getAtt();
						Guild.guildList.get(input).setAtt(before + plus);

					} else if (itemList.get(sel).getKind() == Item.Armor) {
						temp = Guild.guildList.get(input).getArmor();
						Guild.guildList.get(input).setArmor(itemList.get(sel));
						int plus = itemList.get(sel).getPower();
						int before = Guild.guildList.get(input).getDef();
						Guild.guildList.get(input).setDef(before + plus);

					} else if (itemList.get(sel).getKind() == Item.Ring) {
						temp = Guild.guildList.get(input).getRing();
						Guild.guildList.get(input).setRing(itemList.get(sel));
						int plus = itemList.get(sel).getPower();
						int before = Guild.guildList.get(input).getMaxHp();
						int before2 = Guild.guildList.get(input).getHp();
						Guild.guildList.get(input).setMaxHp(before + plus);
						Guild.guildList.get(input).setHp(before + plus);

					}
					itemList.remove(sel);
					if (temp != null) {
						itemList.add(temp);// 아이템 다시 집어넣기
						if (temp.getKind() == Item.Weapon) {
							int minus = itemList.get(sel).getPower();
							int before = Guild.guildList.get(input).getAtt();
							Guild.guildList.get(input).setAtt(before - minus);
						} else if (temp.getKind() == Item.Armor) {
							int minus = itemList.get(sel).getPower();
							int before = Guild.guildList.get(input).getDef();
							Guild.guildList.get(input).setDef(before - minus);
						} else if (temp.getKind() == Item.Ring) {
							int minus = itemList.get(sel).getPower();
							int before = Guild.guildList.get(input).getMaxHp();
							Guild.guildList.get(input).setHp(before - minus);
						}
						// 나중에 메소드 따로 만들어야할듯
					}

				}
			} else {
				System.out.println("사용가능한 아이템이 없습니다.");
			}
		} else {
			System.out.println("잘못된 입력");
		}

	}

	public void printItemList() {
		System.out.println("=====아이템 리스트===s=======");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "]번\t");
			System.out.print("[이름 : " + itemList.get(i).getName() + "]\t");
			System.out.print("[능력 : " + itemList.get(i).getPower() + "]\t");
			System.out.println("[가격 : " + itemList.get(i).getPrice() + "]\t");
		}

	}

	public void recoveryItem(int sel) {
		Item weapon = Guild.guildList.get(sel).getWeapon();
		Item armor = Guild.guildList.get(sel).getArmor();
		Item ring = Guild.guildList.get(sel).getRing();
		if (weapon != null) {
			itemList.add(weapon);
		}
		if (armor != null) {
			itemList.add(armor);
		}
		if (ring != null) {
			itemList.add(ring);
		}
	}
	public void sell() {
		printItemList();
		System.out.print("판매할 아이템 번호:");
		int sel=scan.nextInt()-1;
		Player.money+=(itemList.get(sel).getPrice()*0.5);
		itemList.remove(sel);
		
	}
}