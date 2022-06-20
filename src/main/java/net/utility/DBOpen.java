package net.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOpen {

	// oracle DB 연결 메소드
	public Connection getConnection() {
		Connection con = null;
		try {
			String url 		= "jdbc:oracle:thin:@db2022atp_high?TNS_ADMIN=/Users/hyeon/Downloads/Wallet_DB2022atp";
			String user		= "admin";
			String password	= "WJDwhdgus00@!";
			String driver	= "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			System.out.println("오라클 DB 연결실패 : " + e);
		}

		return con;
	}

}
