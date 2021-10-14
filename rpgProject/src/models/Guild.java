package models;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Guild {
	final int partySize = 4;// ��Ƽ�ο��� ����
	static ArrayList<Unit> guildList = new ArrayList<Unit>();
	Scanner scan = new Scanner(System.in);

	public void setting() {
		guildList.add(new Unit("ȣ����", 1, 100, 10, 5, 0));
		guildList.add(new Unit("������", 1, 80, 7, 3, 0));
		guildList.add(new Unit("�罿", 1, 50, 3, 1, 0));
		guildList.add(new Unit("�δ���", 1, 70, 5, 2, 0));
		guildList.add(new Unit("����", 1, 200, 4, 8, 0));
		guildList.add(new Unit("����", 1, 120, 11, 7, 0));
		System.out.println(guildList.size());

		for (int i = 0; i < partySize; i++) {// ��Ƽ4���߰�
			guildList.get(i).setParty(true);
		}

	}

	public void Glist() {
		System.out.println("=========================");
		System.out.println("���:" + Player.money);
		System.out.println("========[����]===========");

		for (int i = 0; i < Guild.guildList.size(); i++) {
			System.out.print("[" + (i + 1) + "��]\t");
			System.out.print("[�̸�:" + Guild.guildList.get(i).getName() + "]\t");
			System.out.print("[����:" + Guild.guildList.get(i).getLevel() + "]\t");
			System.out
					.print("[ü��:" + Guild.guildList.get(i).getMaxHp() + " / " + Guild.guildList.get(i).getHp() + "]\t");
			System.out.print("[���ݷ�:" + Guild.guildList.get(i).getAtt() + "]\t");
			System.out.print("[����:" + Guild.guildList.get(i).getDef() + "]\t");
			System.out.println("[��Ƽ��:" + Guild.guildList.get(i).isParty() + "]\t");

		}
	}

	public void addColleague() {
		Random rand = new Random();
		if (Player.money >= 5000) {
			String[] n1 = { "��", "��", "��", "��", "��", "��", "��" };
			String[] n2 = { "��", "��", "��", "��", "��", "��", "��" };
			String[] n3 = { "��", "��", "��", "��", "��", "��", "ö" };

			String name = n1[rand.nextInt(n1.length)];
			name += n2[rand.nextInt(n2.length)];
			name += n3[rand.nextInt(n3.length)];
			int st = rand.nextInt(8) + 2;
			int hp = st * 11;
			int att = st + 1;
			int def = st / 2 + 1;
			guildList.add(new Unit(name, 1, hp, att, def, 0));
			System.out.println("===============[���ο� ���� ����]======================");
			System.out.print("[�̸� : " + name + "]");
			System.out.print(" [���� : " + 1 + "]");
			System.out.print(" [ü�� : " + hp);
			System.out.println(" / " + hp + "]");
			System.out.print("[���ݷ� : " + att + "]");
			System.out.println(" [���� : " + def + "]");
			System.out.println("������ �߰��մϴ�.");
			System.out.println("=====================================");
			Player.money -= 5000;
		} else {
			System.out.println("������ ��尡 �����մϴ�.");
		}

	}

	public void removeColleague() {
		Glist();
		System.out.print("������ ���� ��ȣ:");
		int sel = scan.nextInt()-1;
		//���⼭���� 
	}
}
