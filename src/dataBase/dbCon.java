package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbCon {
	static Connection con;
	
	private dbCon() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String pass = "123456";
		Class.forName("oracle.jdbc.driver.OracleDriver");

		con = DriverManager.getConnection(url, user, pass);
		System.out.println("접속중");
	}
	
	public static Connection getConnection() throws Exception {
		if(con == null) {// db에 접속이 안되어 있으면
			new dbCon();
		}
		
		return con;
	}
}
