package car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;

import util.DBManager;

public class CarDAO {

	// Data Access Object
	// ㄴ데이터베이스에 대한 접근 처리

	private CarDAO() {
	}

	private static CarDAO instance = new CarDAO();

	public static CarDAO getInstance() {
		return instance;

	}

	// 2.데이터 베이스 연동 준비
	private Connection conn = null; // DB에 연결
	private PreparedStatement pstmt = null; // sql쿼리를 excute해
	private ResultSet rs = null; // 쿼리실행 결과물을 받는 역할

	private ArrayList<CarDTO> cars = null;
	ArrayList<CarReserve> reserveList = new ArrayList<>();

	// 3.DB연동하기
//	public Connection getConnection() {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost:3306/loginServer?serverTimeZone=UTC";
//			String user = "root";
//			String password = "root";
//			conn = DriverManager.getConnection(url, user, password);
//			if (conn != null) {
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}

	public ArrayList<CarDTO> getNewCars() {
		getCars();
		ArrayList<CarDTO> list = new ArrayList<CarDTO>();
		int size = cars.size();
		if (size > 2) {
			for (int i = size - 1; i >= size - 3; i--) {
				list.add(cars.get(i));
				System.out.println(cars.get(i).getName() + "최신카 등록");
			}
		}
		return list;
	}

	// 4.연동된 DB에서 데이터 불러오기
	public ArrayList<CarDTO> getCars() {
		cars = new ArrayList<CarDTO>();

		try {
			conn = DBManager.getConnection();
			String sql = "select* from car";
			pstmt = conn.prepareStatement(sql);// 연동된 DB에 쿼리를 날릴준비
			rs = pstmt.executeQuery();// 쿼리를 날려서 ResultSet을 반환 받음
			while (rs.next()) {
				int no = rs.getInt(1);// rs는 1부터 시작함
				String name = rs.getString(2);
				String company = rs.getString(3);
				String price = rs.getString(4);
				int category = rs.getInt(5);
				int rentalfee = rs.getInt(6);
				String fuel = rs.getString(7);
				String info = rs.getString(8);
				String img = rs.getString(9);
				CarDTO car = new CarDTO(no, name, company, price, category, rentalfee, fuel, info, img);
				cars.add(car);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return cars;
	}

	public ArrayList<CarDTO> getSearch(String text) {
		ArrayList<CarDTO> list = new ArrayList<CarDTO>();
		String sql = "select* from car where name ";
		try {
			conn = DBManager.getConnection();
			if (!(text == null)) {
				sql += "LIKE '%" + text.trim() + "%'";
			} else {
				return list;
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt(1);// rs는 1부터 시작함
				String name = rs.getString(2);
				String company = rs.getString(3);
				String price = rs.getString(4);
				int category = rs.getInt(5);
				int rentalfee = rs.getInt(6);
				String fuel = rs.getString(7);
				String info = rs.getString(8);
				String img = rs.getString(9);
				CarDTO car = new CarDTO(no, name, company, price, category, rentalfee, fuel, info, img);
				list.add(car);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<CarReserve> getReservelist(String selectId) {
		ArrayList<CarReserve> list = new ArrayList<>();
		try {
			String sql = "select* from CarReserve";
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(3).equals(selectId)) {
					int seq = rs.getInt(1);
					int no = rs.getInt(2);
					String id = rs.getString(3);
					int qty = rs.getInt(4);
					int dday = rs.getInt(5);
					String rday = rs.getString(6);
					int usein = rs.getInt(7);
					int usewifi = rs.getInt(8);
					int usenavi = rs.getInt(9);
					int price = rs.getInt(10);
					String img = rs.getString(11);
					String name = rs.getString(12);
					
					CarReserve car = new CarReserve(seq, no, id, qty, dday, rday, usein, usewifi, usenavi,price,img,name);
					list.add(car);
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public CarDTO getCarInfo(int no) {
		getCars();
		return cars.get(no - 1);

	}

	public void setReserveCar(CarReserve bean) {
		String img=getCarInfo(bean.getNo()).getImg();
		int price=getCarInfo(bean.getNo()).getRentalfee();
		int usein = 0;
		// 선택 시(1), 10,000원 추가
		if(bean.getUsein() == 1){ usein = 10000; }
		int usewifi = 0;
		if(bean.getUsewifi() == 1){ usewifi = 10000; }
		
		int rantalfee=(price*bean.getQty()*bean.getDday())+(bean.getDday()*bean.getQty()*(usein + usewifi));
		String name=getCarInfo(bean.getNo()).getName();
		
		try {
			conn = DBManager.getConnection();
			String sql = "insert into CarReserve(no,id,qty,dday,rday,usein,usewifi,usenavi,price,img,name) values(?,?,?,?,?,?,?,?,?,?,?)";// sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bean.getNo());
			pstmt.setString(2, bean.getId());
			pstmt.setInt(3, bean.getQty());
			pstmt.setInt(4, bean.getDday());
			pstmt.setString(5, bean.getRday());
			pstmt.setInt(6, bean.getUsein());
			pstmt.setInt(7, bean.getUsewifi());
			pstmt.setInt(8, bean.getUsenavi());
			pstmt.setInt(9, rantalfee);
			pstmt.setString(10, img);
			pstmt.setString(11, name);
			pstmt.executeUpdate();
			System.out.println("추가성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void removeReserve(String seq) {
		try {
			String sql = "delete from CarReserve where reserve_seq='"+seq+"';"; 
			//rday가 varchar유형이라 ''로 묶어줌
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
