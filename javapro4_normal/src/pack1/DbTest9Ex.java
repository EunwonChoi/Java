package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Formatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//DbTest9Ex2에서 로그인 성공 시 일로 옴
//직원의 세금과 실수령액을 테이블로 표현

public class DbTest9Ex extends JFrame implements ActionListener {
	String [][] datas = new String[0][6];
	String [] title = {"사번", "이름", "성별", "연봉", "세금", "실수령액"};
	DefaultTableModel model;
	JTable table;
	JLabel lblCount;
	JButton btnOk, btnClose;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest9Ex() {
		super("세율표");
		
		setLayout();
		setBounds(300, 300, 500, 400);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {

				} catch (Exception e2) {
					// TODO: handle exception
				}
				System.exit(0);
			}
		});
		
	}
	
	private void setLayout(){
		JPanel panel = new JPanel();
		btnOk = new JButton("출력");
		btnClose = new JButton("종료");
		panel.add(btnOk);
		panel.add(btnClose);
		
		btnOk.addActionListener(this);
		btnClose.addActionListener(this);
		
		model = new DefaultTableModel(datas, title);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		add("North", panel);
		add("Center", scrollPane);

	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123");
			pstmt = conn.prepareStatement("select * from jikwon");
			rs = pstmt.executeQuery();
			int segum = 0;
			
			while(rs.next()) {
				String code = rs.getString("jikwon_no");
				String name = rs.getString("jikwon_name");
				String gen = rs.getString("jikwon_gen");
				int pay = rs.getInt("jikwon_pay") * 10000;
				if(pay >=50000000) {
					segum = (int) (pay* 0.03);
				}else {
					segum = (int) (pay * 0.02);
				}
				String sil = String.format("%,3d", pay - segum);
				
				String []imsi = {code, name, gen, Integer.toString(pay), Integer.toString(segum), sil};
				model.addRow(imsi);
			}
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

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnOk) {
			accDb();
		}if(e.getSource() == btnClose) {
			int re = JOptionPane.showConfirmDialog(new DbTest9Ex(), "정말로 종료하시겠습니까?", "골라", JOptionPane.YES_NO_OPTION);
			switch (re) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					System.out.println("");
					break;
			}
		}
		
	}
	
	public static void main(String[] args) {
		new DbTest9Ex();
	}

}
