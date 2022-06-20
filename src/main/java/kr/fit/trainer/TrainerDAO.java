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
			sql.append(" SELECT id ");
			sql.append(" FROM ft_user ");
			

			pstmt = con.prepareStatement(sql.toString());

			rs = pstmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList<TrainerDTO>();
				do {
					TrainerDTO dto = new TrainerDTO();
					dto.setId(rs.getString("id"));

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
}
