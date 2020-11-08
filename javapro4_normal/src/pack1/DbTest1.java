package pack1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DbTest1 {
	private Connection conn;  //DB와 연결
	private Statement stmt;   //SQL 실행
	private ResultSet rs;     //select 결과 접근
	
	public DbTest1() {
		// Driver Loading 방법 1 : Driver file을 구해서 build path
		try {
			Class.forName("org.mariadb.jdbc.Driver");  //MariaDb 기준
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패: " + e);
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123");
		} catch (Exception e) {
			System.out.println("연결 실패: " + e);
		}
		
		try {
			stmt = conn.createStatement();
			
			/*
			rs = stmt.executeQuery("select * from sangdata");  //sangdata 전체 읽어옴(바람직하지 않음)
			rs.next();   //포인트를 찍어줌(기본임)
			System.out.println(rs.getString("code") + " " + rs.getString("sang") + " " + rs.getInt("su") +
					" " + rs.getInt("dan"));   //table 칼럼명들을 읽어옴
			*/
			
			/*
			rs = stmt.executeQuery("select code as 코드, sang as 품명, su as 수량, dan as 단가 from sangdata"); //sangdata 전체를 읽어오면서 별명을 지어줌
			rs.next();
			System.out.println(rs.getString("코드") + " " + rs.getString("sang") + " " + rs.getInt(3) +
					" " + rs.getInt("dan"));   //table 칼럼명들을 읽어옴
			*/
			
			//while로 내용 한번에 불러옴
			rs = stmt.executeQuery("select code, sang, su, dan from sangdata");
			while(rs.next()) {
				String code = rs.getString("code");
				String sangpum = rs.getString(2);
				int su = rs.getInt("su");
				String dan = rs.getString("dan");
				System.out.println(code + " " + sangpum + " " + su + " " + dan);
			}
			
			String sql = "select count(*) from sangdata";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("건수: " + rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println("처리 실패: " + e);
		}finally {
			try {
				if(rs != null) rs.close();	
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	public static void main(String[] args) {
		new DbTest1();
	}

}
