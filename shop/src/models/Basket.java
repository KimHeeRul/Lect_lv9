package models;

public class Basket {
	private String id;
	private String item;

	public Basket(String id,String item) {
		this.id=id;
		this.item=item;
	}
	@Override
	public String toString() {
		String str="";
		str+=this.item;
		return str;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

	
	
}

