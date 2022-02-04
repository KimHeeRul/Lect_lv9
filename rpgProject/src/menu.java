import java.util.Scanner;

import controller.BattleMode;
import controller.Guild;
import controller.Inven;
import controller.Shop;
import controller.fileManager;
import models.Player;

public class menu extends Guild{
	static Scanner scan = new Scanner(System.in);
//	private Guild guild = Guild.guild;
	Shop shop = new Shop();
	Player player = new Player();
	private fileManager fm = new fileManager();
	Inven inven = new Inven();

	public menu() {
		while (true) {
			System.out.println("=============== [���θ޴�] ================");
			System.out.println("[1.������] [2.����] [3.�κ��丮]");
			System.out.println("[4.����] [5.�ε�] [6.��������] [0.����]");
			System.out.print(">>>");
			int sel = scan.nextInt();
			if (sel == 1) {
				guildMenu();
			} else if (sel == 2) {
				shop.shopMenu();
			} else if (sel == 3) {
				inventMenu();
			} else if (sel == 4) {
				fm.save();
			} else if (sel == 5) {
				fm.load();
			} else if (sel == 6) {
				int cnt = 0;
				for (int i = 0; i < guild.getGuildList().size(); i++) {
					if (guild.getGuildList().get(i).isParty()) {
						cnt++;
					}
				}
				if (cnt == 4) {
					 BattleMode bt = new BattleMode();
					bt.battle();
				} else {
					System.out.println("4�� �̸� ��Ƽ�� ������ �Ҽ������ϴ�. ��Ƽ���� ��Ƽ� �ٽ� �����ϼ���");
				}
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
				guild.change();
			} else if (sel == 5) {
				guild.sort();
			} else {
				break;
			}
		}
	}

	public void inventMenu() {
		while (true) {
			System.out.println("=============== [�κ� �޴�] ================");
			System.out.println("[1.����] [2.�Ǹ�] [0.�ڷΰ���]");
			System.out.print(">>>");
			int sel = scan.nextInt();
			if (sel == 1) {
				inven.equip();
			} else if (sel == 2) {
				inven.sell();
			} else {
				break;
			}
		}
	}
//	�������� �� ��Ƽ���� ������ �������� �� ������ ������ ���� hp �� ���϶�����
//	1.���� 2.�� �� ������ ����� ���� ó�� (��Ƽ�ѱ� �� ���������� �κ��丮�� ��������)

}
