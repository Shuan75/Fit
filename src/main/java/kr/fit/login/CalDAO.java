package kr.fit.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Repository;

import net.utility.DBClose;
import net.utility.DBOpen;

public class CalDAO {

	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	public CalDAO() {
		dbopen = new DBOpen();
	}

	public int create(CalDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();

			sql.append(
					" INSERT INTO ft_calendar(c_num, c_id, c_start, c_end, c_title, c_con, c_allday) ");
			sql.append(" VALUES(cal_num_seq.nextval, ?, ?, ?, ? ,?, ?)");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getC_id());
			pstmt.setString(2, dto.getC_start());
			pstmt.setString(3, dto.getC_end());
			pstmt.setString(4, dto.getC_title());
			pstmt.setString(5, dto.getC_con());
			pstmt.setString(6, dto.getC_allday());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("일정 추가 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}// create() end*/
	
	public int delete(CalDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" DELETE FROM ft_calendar ");
			sql.append(" WHERE c_title=? ");//			
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getC_title());
			
			
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("삭제실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		} // end
		return cnt;
	}
	public CalDTO read(String id) {
		CalDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();

			sql.append(" SELECT c_id, c_title, c_start, c_end, c_url, c_con, c_num, c_allday ");
			sql.append(" FROM FT_CALENDAR");
			sql.append(" WHERE c_id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new CalDTO();
				dto.setC_id(rs.getString("c_id"));
				dto.setC_title(rs.getString("c_title"));
				dto.setC_start(rs.getString("c_start"));
				dto.setC_end(rs.getString("c_end"));
				dto.setC_URL(rs.getString("c_url"));
				dto.setC_con(rs.getString("c_con"));
				dto.setC_num(rs.getInt("c_num"));
				dto.setC_allday(rs.getString("c_allday"));
				
			} else {
				dto = null;
			}
		} catch (Exception e) {
			System.out.println("달력 정보 " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} 

		return dto;
	}

	
	public ArrayList<CalDTO> list(String id) {
		ArrayList<CalDTO> list = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();

			sql.append(" SELECT c_id, c_title, c_start, c_end, c_url, c_con, c_num, c_allday ");
			sql.append(" FROM FT_CALENDAR");
			sql.append(" WHERE c_id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
//				for(int i = 0; i < list.size(); i++) {
//				}
				list = new ArrayList<>();
				do { 
				CalDTO dto = new CalDTO();
				dto.setC_id(rs.getString("c_id"));
				dto.setC_title(rs.getString("c_title"));
				dto.setC_start(rs.getString("c_start"));
				dto.setC_end(rs.getString("c_end"));
				dto.setC_URL(rs.getString("c_url"));
				dto.setC_con(rs.getString("c_con"));
				dto.setC_num(rs.getInt("c_num"));
				dto.setC_allday(rs.getString("c_allday"));
				list.add(dto);
				} while(rs.next());
				
			} else {
				CalDTO dto = null;
			}
		} catch (Exception e) {
			System.out.println("달력 정보 " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} 

		return list;
	}
	
}