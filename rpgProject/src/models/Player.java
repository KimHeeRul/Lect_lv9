package models;

import java.util.ArrayList;

import controller.Guild;
import controller.Inven;

public class Player {
	public static int money;
	public static Guild guild = new Guild();
	public static Inven inven=new Inven();
	public Player() {
		this.money = 100000;
		guild.setting();
	}

}
