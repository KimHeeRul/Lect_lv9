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
		System.out.println("�������� ������ ������ �����ϼ���.");
		System.out.print(">>>");
		int input = scan.nextInt() - 1;
		if (input >= 0 && input < guild.guildList.size()) {
			guild.printStatus(input);
			if (itemList.size() > 0) {
				printItemList();
				System.out.println("������ ������ ��ȣ�� �Է��ϼ���[0.�ڷΰ���]");
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
						itemList.add(temp);// ������ �ٽ� ����ֱ�
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
						// ���߿� �޼ҵ� ���� �������ҵ�
					}

				}
			} else {
				System.out.println("��밡���� �������� �����ϴ�.");
			}
		} else {
			System.out.println("�߸��� �Է�");
		}

	}

	public void printItemList() {
		System.out.println("=====������ ����Ʈ===s=======");
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + (i + 1) + "]��\t");
			System.out.print("[�̸� : " + itemList.get(i).getName() + "]\t");
			System.out.print("[�ɷ� : " + itemList.get(i).getPower() + "]\t");
			System.out.println("[���� : " + itemList.get(i).getPrice() + "]\t");
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
		System.out.print("�Ǹ��� ������ ��ȣ:");
		int sel=scan.nextInt()-1;
		Player.money+=(itemList.get(sel).getPrice()*0.5);
		itemList.remove(sel);
		
	}
}