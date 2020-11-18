package pack1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbTest7 {
	private Connection conn;  //DB와 연결
	private PreparedStatement pstmt;  //선처리방식으로 SQL 실행
	private ResultSet rs;     //select 결과 접근
	
	//***preparedStatement는 create하면서 처음 한번만 compile하면 됨(권장함) + 보안에 강함
	//물음표와 함께 쓸 수 있음
	//그냥 Statement는 할때마다 compile해야 해서 불편함 + 보안에 약함
	
	public DbTest7() {
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
			//자료추가
			//String insSql = "insert into sangdata values(6, 'aa', 5, 1000)";
			//pstmt = conn.prepareStatement(insSql);
			
			/*
			String insSql = "insert into sangdata values(?, ?, ?, ?)";  //보안에 강함
			//물음표와 일대일 대응
			pstmt = conn.prepareStatement(insSql);
			pstmt.setString(1, "7");
			pstmt.setString(2, "아메리카노");
			pstmt.setInt(3, 10);
			pstmt.setInt(4, 5000);
			pstmt.executeUpdate();
			*/
			
			/*
			//자료수정
			String upSql = "update sangdata set sang=?, su=? where code =?";
			pstmt=conn.prepareStatement(upSql);
			pstmt.setString(1, "삼다수");
			pstmt.setString(2, "100");
			pstmt.setString(3, "6");
			*/
			
			/*
			//자료 삭제
			String insSql = "delete from sangdata where code=?";  //보안에 강함
			//물음표와 일대일 대응
			pstmt = conn.prepareStatement(insSql);
			pstmt.setString(1, "7");
			pstmt.executeUpdate();
			*/
			
			//자료 보기
			int re = pstmt.executeUpdate();
			if(re == 1) {
				System.out.println("추가 성공");
			}else {
				System.out.println("추가 실패");
			}
			
			
			String sql = "select code, sang, su, dan from sangdata";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String code = rs.getString("code");
				String sangpum = rs.getString(2);
				int su = rs.getInt("su");
				String dan = rs.getString("dan");
				System.out.println(code + " " + sangpum + " " + su + " " + dan);
			}
			
			sql = "select count(*) from sangdata";
			rs = pstmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("건수: " + rs.getInt(1));
			}
		} catch (Exception e) {
			System.out.println("처리 실패: " + e);
		}finally {
			try {
				if(rs != null) rs.close();	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	public static void main(String[] args) {
		new DbTest7();
	}

}
