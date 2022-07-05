package kr.fit.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import net.utility.DBClose;
import net.utility.DBOpen;
import net.utility.MyAuthenticator;

public class UserDAO {

	private DBOpen dbopen = null;
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private StringBuilder sql = null;

	public UserDAO() {
		dbopen = new DBOpen();
	}

	public String loginProc(UserDTO dto) {

		String rating = null;

		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT rating ");
			sql.append(" FROM ft_user ");
			sql.append(" WHERE id = ? AND password = ? ");
			sql.append(" AND rating in ('A', 'B', 'C', 'M', 'T') ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			rs = pstmt.executeQuery();

			if (rs.next()) {

				rating = rs.getString("rating");

			}
		} catch (Exception e) {
			System.out.println("login failed" + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}

		return rating;
	}

	public int create(UserDTO dto) {
		int cnt = 0;
		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();

			sql.append(
					" INSERT INTO ft_user(u_code,id, password, u_name, postal, addr, addr2, email, gender, birth, img, inform, pnum, rating, jdate ) ");
			sql.append(" VALUES(user_codeseq.nextval, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ? ,'C', sysdate)");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getU_name());
			pstmt.setString(4, dto.getPostal());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getAddr2());
			pstmt.setString(7, dto.getEmail());
			pstmt.setString(8, dto.getGender());
			pstmt.setInt(9, dto.getBirth());
			pstmt.setString(10, dto.getImg());
			pstmt.setString(11, dto.getInform());
			pstmt.setString(12, dto.getPnum());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원 등록 실패:" + e);
		} finally {
			DBClose.close(con, pstmt);
		}
		return cnt;
	}// create() end*/

	public int duplecateID(String id) {
		int cnt = 0;

		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT COUNT(id) as cnt ");
			sql.append(" FROM ft_user ");
			sql.append(" WHERE id = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (Exception e) {
			System.out.println("아이디 중복확인 실패 " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return cnt;
	}
	
	public int duplecateEmail(String Email) {
		int cnt = 0;

		try {
			con = dbopen.getConnection();

			sql = new StringBuilder();
			sql.append(" SELECT COUNT(email) as cnt ");
			sql.append(" FROM ft_user ");
			sql.append(" WHERE email = ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, Email);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (Exception e) {
			System.out.println("이메일 중복확인 실패 " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		}
		return cnt;
	}
	
	public UserDTO read(String id) {
		UserDTO dto = null;
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();

			sql.append(" SELECT id, password, postal, addr, addr2, email, pnum, gender, u_name, birth, u_code, rating, jdate");
			sql.append(" FROM ft_user ");
			sql.append(" WHERE id=? ");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new UserDTO();
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setPostal(rs.getString("postal"));
				dto.setAddr(rs.getString("addr"));
				dto.setAddr2(rs.getString("addr2"));
				dto.setPnum(rs.getString("pnum"));
				dto.setGender(rs.getString("gender"));
				dto.setU_name(rs.getString("u_name"));
				dto.setBirth(rs.getInt("birth"));
				dto.setU_code(rs.getString("u_code"));
				dto.setRating(rs.getString("rating"));
				dto.setJdate(rs.getString("jdate"));
				dto.setId(rs.getString("id"));
				
			} else {
				dto = null;
			}
		} catch (Exception e) {
			System.out.println("회원정보 가져오기 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} 

		return dto;
	}
	
	public int updateProc(UserDTO dto) {
		int cnt = 0;
		
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			sql.append(" UPDATE ft_user ");
			sql.append(" SET password=?, u_name=?, pnum=?, email=?, postal=?, addr=?, addr2=?, birth=?, u_code=?, rating=?, img=?, inform=? ");
			sql.append(" WHERE id=?");
			
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getU_name());
			pstmt.setString(3, dto.getPnum());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPostal());
			pstmt.setString(6, dto.getAddr());
			pstmt.setString(7, dto.getAddr2());
			pstmt.setInt(8, dto.getBirth());
			pstmt.setString(9, dto.getU_code());
			pstmt.setString(10, dto.getRating());
			pstmt.setString(11, dto.getImg());
			pstmt.setString(12, dto.getInform());
			pstmt.setString(13, dto.getId());
//			pstmt.setString(14, dto.getGender());
//			pstmt.setString(15, dto.getJdate());
			System.out.println("------UserDAO update");
			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
			
		} catch(Exception e) {
			System.out.println("회원 정보 수정 실패 " + e);
		} finally {
			DBClose.close(con, pstmt);
		}		
		return cnt;
}
	

	public boolean findID(UserDTO dto) {
		boolean flag = false;
		
		try {
			con = dbopen.getConnection();
			sql = new StringBuilder();
			
			// 이름과 이메일이 일치하는 id 가져오기
			sql.append(" SELECT id");
			sql.append(" FROM ft_user");
			sql.append(" WHERE u_name = ? AND email = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getU_name());
			pstmt.setString(2, dto.getEmail());
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 이름과 이메일이 일치시
				String id = rs.getString("id");
				
				
				// 임시 비밀번호 발급 - 대문자 소문자 숫자를 사용한 랜덤 10글자
				
				String[] ch = {
                        "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                        "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                        "0","1","2","3","4","5","6","7","8","9"		
				};
				
				// ch 배열에서 랜덤하게 10글자 발생
				// 임시 비밀번호
				StringBuilder imsiPW = new StringBuilder();
				for(int i=0; i<10; i++) {
					// ch[0] ~ ch[61]까지 존재한다
					int num = (int)(Math.random()*ch.length);
					imsiPW.append(ch[num]);
				}
				
				
				// 임시 비밀번호로 업데이트 하기
				
				sql = new StringBuilder();
				sql.append(" UPDATE ft_user ");
				sql.append(" SET password=? ");
				sql.append(" WHERE u_name=? AND email=? ");
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, imsiPW.toString());
				pstmt.setString(2, dto.getU_name());
				pstmt.setString(3, dto.getEmail());
				
				int cnt = pstmt.executeUpdate();
				if(cnt==1) {
					// 임시 비밀번호로 업데이트가 됬을 시
					String content = "";
					
					content+="<hr>";
					content+="<table border='1'>";
					content+="<tr>";
					content+="	<th>아이디</th>";
					content+="	<th>" + id + "</th>";
					content+="</tr>";
					content+="<tr>";
					content+="	<th>임시비밀번호</th>";
					content+="	<td> "+ imsiPW.toString() + "</td>";
					content+="</tr>";
					content+="</table>";
					
					String mailServer = "mw-002.cafe24.com";
					Properties props = new Properties();
					props.put("mail.smtp.host", mailServer);
					props.put("mail.smtp.auth", true);
					Authenticator myAuth = new MyAuthenticator();
					Session sess = Session.getInstance(props, myAuth);
					
					InternetAddress[] address = { new InternetAddress(dto.getEmail()) };
					Message msg = new MimeMessage(sess);
					msg.setRecipients(Message.RecipientType.TO, address);
					msg.setFrom(new InternetAddress("limbboy@nate.com"));
					msg.setSubject("Fitness ID/PASSWORD 입니다.");
					msg.setContent(content, "text/html; charset=UTF-8");
					msg.setSentDate(new Date());
					
					Transport.send(msg);
					
					flag = true;
					
				} else {
					flag = false;
				}
				
						
			}
			
		} catch (Exception e) {
			System.out.println("아이디 비밀번호 찾기 실패 : " + e);
		} finally {
			DBClose.close(con, pstmt, rs);
		} 
		return flag;
		
	}
	
}
