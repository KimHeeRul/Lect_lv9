import java.util.Scanner;

import models.Player;

public class menu {
	static Scanner scan = new Scanner(System.in);

	public menu() {
		Player player = new Player();
		while (true) {
			System.out.println("=============== [���θ޴�] ================");
			System.out.println("[1.������] [2.����] [3.�κ��丮]");
			System.out.println("[4.����] [5.�ε�] [0.����]");
			int sel = scan.nextInt();
			if (sel == 1) {
				guildMenu();
			} else if (sel == 2) {
				shop();
			} else if (sel == 3) {
//				player.inventoryMenu();
			} else if (sel == 4) {
			} else if (sel == 5) {
			} else {
				System.out.println("������ ���� �մϴ�.");
				break;
			}
		}
	}

	public void guildMenu() {
		while (true) {
			System.out.println("=============== [������] ================");
			System.out.println("[1.�����] [2.���� �߰�] [3.���� ����]");
			System.out.println("[4.��Ƽ�� ��ü] [5.����] [0.�ڷΰ���]");
			int sel = scan.nextInt();
			if (sel == 1) {
//			player.guildMenu();
			} else if (sel == 2) {
//			shop.shopMng();
			} else if (sel == 3) {
//			player.inventoryMenu();
			} else if (sel == 4) {
			} else if (sel == 5) {
			} else {
				break;
			}
		}
	}
	public void shop() {
		
	}
}
