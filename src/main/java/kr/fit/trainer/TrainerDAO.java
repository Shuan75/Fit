package kr.fit.trainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import net.utility.DBClose;
import net.utility.DBOpen;

public class TrainerDAO {

	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	TrainerDAO() {
		dbopen = new DBOpen();
	}

	public ArrayList<TrainerDTO> list() {
		ArrayList<TrainerDTO> list = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT id, u_name, img, inform ");
			sql.append(" FROM ft_user ");
//			sql.append(" WHERE u_code = 't' ");

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList<TrainerDTO>();
				do {
					TrainerDTO dto = new TrainerDTO();
					dto.setId(rs.getString("id"));
					dto.setU_name(rs.getString("u_name"));
					
					dto.setImg(rs.getString("img"));
					dto.setInform(rs.getString("inform"));
//					dto.setU_code(rs.getString("u_code"));
					list.add(dto);
				} while (rs.next());
			} // if end

		} catch (Exception e) {
			System.out.println("목록 실패:" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} // end
		return list;
	}// end

	public TrainerDTO read(TrainerDTO dto) {
		dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" SELECT id, u_name, img, inform, u_code ");
			sql.append(" FROM ft_user ");
			sql.append(" WHERE u_code='t001' ");

			pstmt = con.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new TrainerDTO();
				dto.setId(rs.getString("id"));
				dto.setU_name(rs.getString("u_name"));
				dto.setImg(rs.getString("img"));
				dto.setInform(rs.getString("inform"));
				dto.setRating(rs.getString("u_code"));

			} else {
				dto = null;
			}

		} catch (Exception e) {
			System.out.println("트레이너 리스트 불러오기 실패 " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return dto;
	}// read() end

	
}
