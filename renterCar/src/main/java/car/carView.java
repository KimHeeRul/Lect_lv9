package car;

public class carView {
	private int reserve_seq;	
	private int no;				
	private String id;
	private int qty;			
	private int dday;			
	private String rday;		
	private int usein;			
	private int usewifi;			
	private int usenavi;
	private int price;
	private String img;
	public carView() {}
	public carView(int price, int no, String id, int qty, int dday, String rday, int usein, int usewifi,
			int usenavi,String img) {
		super();
		this.price=price; 
		this.no = no;
		this.id = id;
		this.qty = qty; //수량
		this.dday = dday;//빌린일수
		this.rday = rday;//빌린날 
		this.usein = usein;
		this.usewifi = usewifi;
		this.usenavi = usenavi;
		this.img=img;
	}
	public int getReserve_seq() {
		return reserve_seq;
	}
	public void setReserve_seq(int reserve_seq) {
		this.reserve_seq = reserve_seq;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getDday() {
		return dday;
	}
	public void setDday(int dday) {
		this.dday = dday;
	}
	public String getRday() {
		return rday;
	}
	public void setRday(String rday) {
		this.rday = rday;
	}
	public int getUsein() {
		return usein;
	}
	public void setUsein(int usein) {
		this.usein = usein;
	}
	public int getUsewifi() {
		return usewifi;
	}
	public void setUsewifi(int usewifi) {
		this.usewifi = usewifi;
	}
	public int getUsenavi() {
		return usenavi;
	}
	public void setUsenavi(int usenavi) {
		this.usenavi = usenavi;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
