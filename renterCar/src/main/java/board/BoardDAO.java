package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import user.UserDTO;
import util.DBManager;

public class BoardDAO {

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private ArrayList<BoardDTO> boards = null;

	public ArrayList<BoardDTO> getBoard() {
		boards = new ArrayList<BoardDTO>();

		try {
			conn = DBManager.getConnection();
			String sql = "select * from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String id = rs.getString(4);
				String pw = rs.getString(5);
				int view = rs.getInt(6);
				int likes = rs.getInt(7);
				Timestamp date = rs.getTimestamp("date");
				BoardDTO board = new BoardDTO(code, title, content, id, pw, view, likes, date);
				boards.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boards;
	}

	public BoardDTO getBoard(int no) {
		try {
			conn = DBManager.getConnection();
			String sql = "select * from board where code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no); // 첫번째 물음표 값의 지정
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int code = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String id = rs.getString(4);
				String pw = rs.getString(5);
				int view = rs.getInt(6);
				int likes = rs.getInt(7);
				Timestamp date = rs.getTimestamp("date");
				BoardDTO board = new BoardDTO(code, title, content, id, pw, view, likes, date);
				return board;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int selectCnt() {
		int result = 0;
		conn = DBManager.getConnection();
		String sql = "select count(0) from board";// 행개수 읽기
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);//
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<BoardDTO> selectPage(int start, int pageCnt) { //페이지 보류
		boards = new ArrayList<BoardDTO>();
		try {
			conn = DBManager.getConnection();
			String sql = "select * from board limit ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, pageCnt);
			rs = pstmt.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return boards;
	}

	public void write(BoardDTO board) {
		try {
			conn = DBManager.getConnection();
			String sql = "insert into board(title,content,id,password,view,likes,date) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getId());
			pstmt.setString(4, board.getPassword());
			pstmt.setInt(5, board.getView());
			pstmt.setInt(6, board.getLike());
			pstmt.setTimestamp(7, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			pstmt.executeUpdate();
			System.out.println("글작성 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update(BoardDTO board, int no) {
		try {
			conn = DBManager.getConnection();
			String sql = "update board set title =? ,content=?,id=?,password=?,view=?,likes=?,date=? where code=" + no;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getId());
			pstmt.setString(4, board.getPassword());
			pstmt.setInt(5, board.getView());
			pstmt.setInt(6, board.getLike());
			pstmt.setTimestamp(7, new Timestamp(Calendar.getInstance().getTimeInMillis()));

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void viewupdate(int cnt, int no) {
		try {
			conn = DBManager.getConnection();
			String sql = "update board set view=? where code=" + no;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnt + 1);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void like(int cnt, int no) {
		try {
			conn = DBManager.getConnection();
			String sql = "update board set likes=? where code=" + no;
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cnt + 1);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(int no) {
		try {
			conn = DBManager.getConnection();
			String sql = "delete from board where code=" + no;
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
