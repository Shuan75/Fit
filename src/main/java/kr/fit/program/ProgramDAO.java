package kr.fit.program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.fit.program.ProgramDTO;
import net.utility.DBClose;
import net.utility.DBOpen;

public class ProgramDAO {
	
	private DBOpen dbopen=null;
	private Connection con=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private StringBuilder sql=null;
	
	public ProgramDAO() {
		dbopen=new DBOpen();
	}//end
	
	public ArrayList<ProgramDTO> list(){
		ArrayList<ProgramDTO> list=null;
		try {
			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" SELECT c_code, c_name, c_price, c_level, c_period, c_day, c_time,c_id,u_name,c_total,c_content " );
			sql.append(" FROM ft_class ");
			sql.append(" ORDER BY c_code DESC ");
			
			pstmt=con.prepareStatement(sql.toString());
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				list=new ArrayList<ProgramDTO>();
				do {
					ProgramDTO dto=new ProgramDTO();
					
					dto.setC_code(rs.getString("c_code"));
					dto.setC_name(rs.getString("c_name"));
					dto.setC_price(rs.getString("c_price"));
					dto.setC_level(rs.getString("c_level"));
					dto.setC_period(rs.getString("c_period"));
					dto.setC_day(rs.getString("c_day"));
					dto.setC_time(rs.getString("c_time"));
					dto.setC_id(rs.getString("c_id"));
					dto.setU_name(rs.getString("u_name"));
					dto.setC_total(rs.getInt("c_total"));
					dto.setC_content(rs.getString("c_content"));
					list.add(dto);
				}while(rs.next());
			}//if end
			
		}catch(Exception e) {
			System.out.println("프로그램 목록 실패:" + e);
		}finally {
			DBClose.close(con,pstmt,rs);
		}//end
		return list;
	}//list() end
	
	
	
	public ProgramDTO read(String c_code) {
		ProgramDTO dto=null;
		try {
			con=dbopen.getConnection();
			sql=new StringBuilder();
			sql.append(" SELECT c_code,c_name, c_content, c_level, c_period, c_day, c_time, c_total, u_name, c_price");
			sql.append(" FROM ft_class ");
			sql.append(" WHERE c_code=? ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, c_code);

			rs=pstmt.executeQuery(); //->select문 실행할 때
		
			if(rs.next()) { //행이 존재하나요?
				dto=new ProgramDTO();
				
				dto.setC_code(rs.getString("c_code"));
				dto.setC_name(rs.getString("c_name"));
				dto.setC_content(rs.getString("c_content"));
				dto.setC_level(rs.getString("c_level"));
				dto.setC_period(rs.getString("c_period"));
				dto.setC_day(rs.getString("c_day"));
				dto.setC_time(rs.getString("c_time"));
				dto.setC_total(rs.getInt("c_total"));
				dto.setU_name(rs.getString("u_name"));
				dto.setC_price(rs.getString("c_price"));
				
			}//if end
			
		}catch(Exception e) {
			System.out.println("강의 상세보기 실패:" + e);
		}finally {
			DBClose.close(con,pstmt,rs);
		}
		return dto;
	}//read() end

	
	
	
	
	
	
}//class end

