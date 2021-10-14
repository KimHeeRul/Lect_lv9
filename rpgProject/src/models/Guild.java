package models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Guild {
	final int partySize = 4;// 파티인원수 고정
	static ArrayList<Unit> guildList = new ArrayList<Unit>();
	Scanner scan = new Scanner(System.in);

	public void setting() {
		guildList.add(new Unit("호랑이", 1, 100, 10, 5, 0));
		guildList.add(new Unit("강아지", 1, 80, 7, 3, 0));
		guildList.add(new Unit("사슴", 1, 50, 3, 1, 0));
		guildList.add(new Unit("두더지", 1, 70, 5, 2, 0));
		guildList.add(new Unit("돼지", 1, 200, 4, 8, 0));
		guildList.add(new Unit("사자", 1, 120, 11, 7, 0));
		System.out.println(guildList.size());

		for (int i = 0; i < partySize; i++) {// 파티4명추가
			guildList.get(i).setParty(true);
		}

	}

	public void Glist() {
		System.out.println("=========================");
		System.out.println("골드:" + Player.money);
		System.out.println("========[길드원]===========");

		for (int i = 0; i < Guild.guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "번]\t");
			System.out.print("[이름:" + Guild.guildList.get(i).getName() + "]\t");
			System.out.print("[레벨:" + Guild.guildList.get(i).getLevel() + "]\t");
			System.out
					.print("[체력:" + Guild.guildList.get(i).getMaxHp() + " / " + Guild.guildList.get(i).getHp() + "]\t");
			System.out.print("[공격력:" + Guild.guildList.get(i).getAtt() + "]\t");
			System.out.print("[방어력:" + Guild.guildList.get(i).getDef() + "]\t");
			System.out.println("[파티중:" + Guild.guildList.get(i).isParty() + "]\t");

		}
	}

	public void addColleague() {
		Random rand = new Random();
		if (Player.money >= 5000) {
			String[] n1 = { "박", "이", "김", "최", "유", "지", "오" };
			String[] n2 = { "명", "기", "종", "민", "재", "석", "광" };
			String[] n3 = { "수", "자", "민", "수", "석", "민", "철" };

			String name = n1[rand.nextInt(n1.length)];
			name += n2[rand.nextInt(n2.length)];
			name += n3[rand.nextInt(n3.length)];
			int st = rand.nextInt(8) + 2;
			int hp = st * 11;
			int att = st + 1;
			int def = st / 2 + 1;
			guildList.add(new Unit(name, 1, hp, att, def, 0));
			System.out.println("===============[새로운 동료 영입]======================");
			System.out.print("[이름 : " + name + "]");
			System.out.print(" [레벨 : " + 1 + "]");
			System.out.print(" [체력 : " + hp);
			System.out.println(" / " + hp + "]");
			System.out.print("[공격력 : " + att + "]");
			System.out.println(" [방어력 : " + def + "]");
			System.out.println("길드원을 추가합니다.");
			System.out.println("=====================================");
			Player.money -= 5000;
		} else {
			System.out.println("소지한 골드가 부족합니다.");
		}

	}

	public void removeColleague() {
		Glist();
		System.out.print("방출할 길드원 번호:");
		int sel = scan.nextInt()-1;
		//여기서부터 
	}
}
