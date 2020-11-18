package pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbTest6execute {

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public DbTest6execute() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");

			process();
		} catch (Exception e) {
			System.out.println("err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	private void process() {
		try {
			stmt = conn.createStatement();

			// execute update
			boolean b = false;
			b = stmt.execute("update sangdata set sang = '종이컵' where code = 5");
			System.out.println("update 수행 후: " + b); // false 반환
			
			int re = stmt.getUpdateCount();   // insert, update, delete 수행 후 결과 수 반환
			if(re >= 1) {
				System.out.println("작업 성공");
			}else {
				System.out.println("작업 실패");
			}
			
			
			// execute select
			b = stmt.execute("select * from sangdata");
			System.out.println("select 수행 후: " + b); // true 반환
			
			if (b) {
				rs = stmt.getResultSet();
				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2));
				}
			}   //b가 select일때만 실행(true가 됨)
		} catch (Exception e) {
			System.out.println("process err: " + e);
		}
	}

	public static void main(String[] args) {
		new DbTest6execute();

	}

}
