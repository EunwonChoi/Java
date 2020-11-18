package pack1;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//윈도우 창에서 테이블 만들기

public class DbTest9Table extends JFrame{
	String [][] datas = new String[0][4];
	String [] title = {"코드", "상품명", "수량", "단가"};
	DefaultTableModel model;
	JTable table;
	JLabel lblCount;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest9Table() {
		super("테이블 연습");
		
		layInit();
		accDb();
		setBounds(300, 300, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void layInit() {
		model = new DefaultTableModel(datas, title);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		lblCount = new JLabel("건수: 0");
		
		add("Center", scrollPane);
		add("South", lblCount);
	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123");
			pstmt = conn.prepareStatement("select * from sangdata");
			rs = pstmt.executeQuery();
			int count = 0;
			
			while(rs.next()) {
				String code = rs.getString("code");
				String sang = rs.getString("sang");
				String su = rs.getString("su");
				String dan = rs.getString("dan");
				String []imsi = {code, sang, su, dan};
				model.addRow(imsi);
				
				count++;
			}
			lblCount.setText("건수: " + count);
		} catch (Exception e) {
			System.out.println("accDb err: " + e);
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
		new DbTest9Table();

	}

}
