package car;

public class CarDTO {

//Data Transfer Object =Bean =VO(read only)=Entity Object=POJO

//캡슐화 
	private int no;
	private String name, company, img, info, fuel,price;
	private int  category, rentalfee;

	public CarDTO(int no, String name, String company, String price, int category, int rentalfee, String fuel, String info,
			String img) {
		this.no = no;
		this.name = name;
		this.company = company;
		this.price = price;
		this.category = category;
		this.rentalfee = rentalfee;
		this.fuel = fuel;
		this.info = info;
		this.img = img;
	}

	
	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public int getRentalfee() {
		return rentalfee;
	}

	public void setRentalfee(int rentalfee) {
		this.rentalfee = rentalfee;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public int getCategory() {
		return category;
	}


	public void setCategory(int category) {
		this.category = category;
	}




	

}
