import java.util.Scanner;

import controller.Guild;
import controller.Inven;
import controller.Shop;
import models.Player;

public class menu {
	static Scanner scan = new Scanner(System.in);
	private Guild guild = Guild.guild;
	Shop shop = new Shop();
	Player player = new Player();
	Inven inven =new Inven();
	
	public menu() {
		while (true) {
			System.out.println("=============== [메인메뉴] ================");
			System.out.println("[1.길드관리] [2.상점] [3.인벤토리]");
			System.out.println("[4.저장] [5.로드] [0.종료]");
			System.out.print(">>>");
			int sel = scan.nextInt();
			if (sel == 1) {
				guildMenu();
			} else if (sel == 2) {
				shop.shopMenu();
			} else if (sel == 3) {
				inventMenu();
			} else if (sel == 4) {
			} else if (sel == 5) {
			} else {
				System.out.println("게임을 종료 합니다.");
				break;
			}
		}
	}

	public void guildMenu() {
		while (true) {
			System.out.println("=============== [길드관리] ================");
			System.out.println("[1.길드목록] [2.길드원 추가] [3.길드원 삭제]");
			System.out.println("[4.파티원 교체] [5.정렬] [0.뒤로가기]");
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
			System.out.println("=============== [인벤 메뉴] ================");
			System.out.println("[1.착용] [2.판매] [0.뒤로가기]");
			System.out.print(">>>");
			int sel = scan.nextInt();
			if (sel == 1) {
				inven.equip();
			} else if (sel == 2) {
				guild.addColleague();
			} else {
				break;
			}
		}
	}

}
