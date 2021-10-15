package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import models.Player;
import models.Unit;

public class Guild {
	final int partySize = 4;// 파티인원수 고정
	static ArrayList<Unit> guildList = new ArrayList<Unit>();
	Scanner scan = new Scanner(System.in);
	public static Guild guild = new Guild();
	

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

	public void printStatus(int i) {
		System.out.print("[이름:" + guildList.get(i).getName() + "]\t");
		System.out.print("[레벨:" + guildList.get(i).getLevel() + "]\t");
		System.out.print("[체력:" + guildList.get(i).getMaxHp() + " / " + guildList.get(i).getHp() + "]\t");
		System.out.print("[공격력:" + guildList.get(i).getAtt() + "]\t");
		System.out.print("[방어력:" + guildList.get(i).getDef() + "]\t");
		System.out.println("[파티중:" + guildList.get(i).isParty() + "]\t");
		if (guildList.get(i).getWeapon()==null) {
			System.out.print("[무기 : 없음 ]\t");
		}else {
			System.out.print("[무기:" + guildList.get(i).getWeapon().getName() + "]\t");
		}
		if (guildList.get(i).getArmor()==null) {
			System.out.print("[방어구 : 없음 ]\t");
		}else {
			System.out.print("[방어구:" + guildList.get(i).getArmor().getName() + "]\t");
		}
		if (guildList.get(i).getRing()==null) {
			System.out.println("[반지 : 없음 ]\t");
		}else {
			System.out.println("[반지:" + guildList.get(i).getRing().getName() + "]\t");
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
		int sel = scan.nextInt() - 1;
		// 여기서부터
		if (!guildList.get(sel).isParty()) {
			System.out.println("=================");
			System.out.println("[이름:" + guildList.get(sel).getName() + "]길드원을 방출 합니다.");
			System.out.println("=================");
			//여기서부터 해서 방출시 가진아이템 인벤토리에 전부 넣기
			Player.inven.recoveryItem(sel);
			guildList.remove(sel);
			
		} else {
			System.out.println("파티중인 멤버는 방출이 불가능합니다.");
		}
	}

//파티원목록
	public void partyList(boolean party) {
		if (party) {
			System.out.println("========[파티원]===========");
			int cnt = 0;
			for (int i = 0; i < Guild.guildList.size(); i++) {
				if (Guild.guildList.get(i).isParty()) {
					System.out.print("[" + (cnt + 1) + "번]\t");
					System.out.print("[이름:" + Guild.guildList.get(i).getName() + "]\t");
					System.out.print("[레벨:" + Guild.guildList.get(i).getLevel() + "]\t");
					System.out.print("[체력:" + Guild.guildList.get(i).getMaxHp() + " / " + Guild.guildList.get(i).getHp()
							+ "]\t");
					System.out.print("[공격력:" + Guild.guildList.get(i).getAtt() + "]\t");
					System.out.print("[방어력:" + Guild.guildList.get(i).getDef() + "]\t");
					System.out.println("[파티중:" + Guild.guildList.get(i).isParty() + "]\t");
					cnt++;
				}
			}
		} else {
			System.out.println("=========[길드원]===============");
			int cnt = 0;
			for (int i = 0; i < Guild.guildList.size(); i++) {
				if (!Guild.guildList.get(i).isParty()) {
					System.out.print("[" + (cnt + 1) + "번]\t");
					System.out.print("[이름:" + Guild.guildList.get(i).getName() + "]\t");
					System.out.print("[레벨:" + Guild.guildList.get(i).getLevel() + "]\t");
					System.out.print("[체력:" + Guild.guildList.get(i).getMaxHp() + " / " + Guild.guildList.get(i).getHp()
							+ "]\t");
					System.out.print("[공격력:" + Guild.guildList.get(i).getAtt() + "]\t");
					System.out.print("[방어력:" + Guild.guildList.get(i).getDef() + "]\t");
					System.out.println("[파티중:" + Guild.guildList.get(i).isParty() + "]\t");
					cnt++;
				}
			}
		}
	}

	public int partyList(boolean party, int idx) {
		if (party) {
			System.out.println("========[파티원]===========");
			int cnt = 0;
			for (int i = 0; i < Guild.guildList.size(); i++) {
				if (Guild.guildList.get(i).isParty()) {
					if (idx == cnt) {
						return i;
					}
					cnt++;
				}

			}
		} else {
			System.out.println("=========[길드원]===============");
			int cnt = 0;
			for (int i = 0; i < Guild.guildList.size(); i++) {
				if (!Guild.guildList.get(i).isParty()) {
					if (idx == cnt) {
						return i;
					}
					cnt++;
				}

			}

		}
		return -1;
	}

	public void change() {
		partyList(true);
		System.out.print("교체할 번호를 입력하세요:");
		int sel = scan.nextInt() - 1;
		int idx = partyList(true, sel);
		partyList(false);
		System.out.print("참가할 번호를 입력하세요:");
		int sel2 = scan.nextInt() - 1;
		int idx2 = partyList(false, sel2);
		Guild.guildList.get(idx).setParty(false);
		guildList.get(idx2).setParty(true);
		System.out.println("==============");
		System.out.println("[이름:" + Guild.guildList.get(idx).getName() + "]에서 " + "이름:"
				+ Guild.guildList.get(idx2).getName() + "]으로 교체 합니다.");
		System.out.println("==============");
	}

	public void sort() {
		String arr[] = new String[guildList.size()];
		for (int i = 0; i < guildList.size(); i++) {
			arr[i] = guildList.get(i).getName();
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i].equals(guildList.get(j).getName())) {
					Unit temp = guildList.get(i);
					guildList.set(i, guildList.get(j));
					guildList.set(j, temp);
				}
			}
		}
	}

}
