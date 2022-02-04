package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import util.DBManager;

public class UserDAO {

	// Data Access Object
	// ㄴ데이터베이스에 대한 접근 처리

	private UserDAO() {
	}

	private static UserDAO instance = new UserDAO();

	public static UserDAO getInstance() {
		return instance;

	}

	// 2.데이터 베이스 연동 준비
	private Connection conn = null; // DB에 연결
	private PreparedStatement pstmt = null; // sql쿼리를 excute해
	private ResultSet rs = null; // 쿼리실행 결과물을 받는 역할

	private ArrayList<UserDTO> users = null;

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

	
	// 4.연동된 DB에서 데이터 불러오기
	public ArrayList<UserDTO> getUsers() {
		users = new ArrayList<UserDTO>();

		try {
			conn = DBManager.getConnection();
			String sql = "select* from users";
			pstmt = conn.prepareStatement(sql);// 연동된 DB에 쿼리를 날릴준비
			rs = pstmt.executeQuery();// 쿼리를 날려서 ResultSet을 반환 받음
			while (rs.next()) {
				int code = rs.getInt(1);// rs는 1부터 시작함
				String id = rs.getString(2);
				String pw = rs.getString(3);
				String name = rs.getString(4);
				Timestamp regDate = rs.getTimestamp("regDate"); //테이블컬럼명 으로도 가능
				UserDTO user = new UserDTO(code, id, pw,name,regDate);
				users.add(user);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return users;
	}
	
	
	
	// 5.CRUD
	// ㄴ Create Read Update Delete
	public void addUser(UserDTO user) {
			try {
				conn = DBManager.getConnection();
				String sql = "insert into users(id,pw,name,regDate) values(?,?,?,?)";// sql 쿼리의 포맷 : ?
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.getId());
				pstmt.setString(2, user.getPw());
				pstmt.setString(3, user.getName());
				pstmt.setTimestamp(4, new Timestamp(Calendar.getInstance().getTimeInMillis()));
				pstmt.executeUpdate();
				System.out.println("회원가입성공");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	public void update(UserDTO user) {
		try {
			conn = DBManager.getConnection();
			String sql = "update users set pw=? where id="+user.getId();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getPw());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	
	private boolean checkDuplID(String id) { //중복체크 코드 jsp처리로 굳이없어됨 
		users = getUsers();
		for (UserDTO user : users) {
			if (id.equals(user.getId()))
			return false;
		}
		return true;
	}

}
