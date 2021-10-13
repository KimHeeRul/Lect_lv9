package models;

import java.util.ArrayList;

public class sale {
	private int sales;
	private ArrayList<String> itemSales = new ArrayList<>();
	
	public ArrayList<String> getItemSales() {
		return itemSales;
	}

	public void setItemSales(ArrayList<String> itemSales) {
		this.itemSales = itemSales;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}
	
}
