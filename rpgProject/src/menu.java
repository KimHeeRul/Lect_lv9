import java.util.Scanner;

import models.Guild;
import models.Player;

public class menu {
	static Scanner scan = new Scanner(System.in);
	Guild guild = new Guild();

	Player player = new Player();
	public menu() {
		while (true) {
			System.out.println("=============== [���θ޴�] ================");
			System.out.println("[1.������] [2.����] [3.�κ��丮]");
			System.out.println("[4.����] [5.�ε�] [0.����]");
			System.out.print(">>>");
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
			System.out.print(">>>");
			int sel = scan.nextInt();
			if (sel == 1) {
				guild.Glist();
			} else if (sel == 2) {
				guild.addColleague();
			} else if (sel == 3) {
				guild.removeColleague();
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
