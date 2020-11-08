package pack1;

import java.sql.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class DbTest2 {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private Properties properites = new Properties();    //다른 곳에 중요 정보를 저장해놓음
	
	public DbTest2() {  //secure coding - 연결 정보를 별도 파일로 작성 후 읽기
		String sql ="";
		try {
			properites.load(new FileInputStream("C:\\work\\jsou\\javapro4_normal\\src\\pack1\\userpass.properties"));  //절대 경로
			//System.out.println(properites.getProperty("driver"));
			
			Class.forName(properites.getProperty("driver"));
			conn = DriverManager.getConnection(properites.getProperty("url"),
					properites.getProperty("user"),
					properites.getProperty("passwd"));   //연결 정보를 여기서 보여주지 않음
			
			
			stmt = conn.createStatement();
			
			//CRUD
			
			//자료 추가 - auto commit
			//sql = "insert into sangdata values(5, '새우깡', 5, '1000')";
			//stmt.executeUpdate(sql);
			
			//transaction --------------------(꼭 기억해 두었으면 함...)
			/*
			conn.setAutoCommit(false);
			sql = "insert into sangdata values(6, '감자깡', 15, '1200')";
			stmt.executeUpdate(sql);   //rollback안해주면 deadlock 생김
			//conn.rollback();
			conn.commit();
			conn.setAutoCommit(true);
			*/
			//--------------------------------
			
			//자료 수정
			sql = "update sangdata set sang = '꼬깔콘', dan=1300 where code=5";
			int re = stmt.executeUpdate(sql);
			if(re > 0)
				System.out.println("수정 성공");
			else
				System.out.println("수정 실패");  //return값을 받음
			
			//자료 삭제
			sql = "delete from sangdata where code=6";
			int re2 = stmt.executeUpdate(sql);
			if(re2 > 0)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");  //return값을 받음
			
			//모든 자료 읽기
			sql = "select * from sangdata order by code desc";
			int cou = 0;
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("code") + " " +
						rs.getString("sang") + " " +
						rs.getString("su") + " " +
						rs.getString("dan") + " ");
				cou++;
			}
			System.out.println("건수: " + cou);
		} catch (Exception e) {
			System.out.println("err: " + e);
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
		new DbTest2();

	}

}
