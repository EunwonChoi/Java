package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DbTest3Gui extends JFrame implements ActionListener{
	JButton btnAll = new JButton("전체");
	JButton btnM = new JButton("남자");
	JButton btnF = new JButton("여자");
	JTextArea txtResult = new JTextArea();
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public DbTest3Gui() {
		super("고객 자료 출력");
		
		setLayout();
		accessDb();
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void setLayout() {
		JPanel panel = new JPanel();
		panel.add(btnAll);
		panel.add(btnM);
		panel.add(btnF);
		
		txtResult.setEditable(false);  //편집불가 . Read Only
		JScrollPane pane = new JScrollPane(txtResult);   //scroll bar 추가
		
		add("North", panel);
		add("Center", pane);
		
		btnAll.addActionListener(this);
		btnM.addActionListener(this);
		btnF.addActionListener(this);
		
		
	}
	
	private void accessDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accessDb err: " + e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
			stmt = conn.createStatement();
			String sql = "select gogek_no, gogek_name, gogek_jumin, gogek_tel from gogek";
			
			//버튼 구분
			if(e.getSource() == btnAll) {
				
			}else if(e.getSource() == btnM) {
				sql += " where gogek_jumin like '%-1%'";
				//sql += "where gogke_jumin like '_______1%'";
				//sql += "where substr(gogke_jumin, 8, 1) = 1";
			}else if(e.getSource() == btnF) {
				sql += " where gogek_jumin like '%-2%'";
			}
			
			rs = stmt.executeQuery(sql);
			int count = 0;
			txtResult.setText("번호\t고객명\t주민번호\t전화\n");
			while(rs.next()) {
				String ss = rs.getString("gogek_no") + "\t" +
						rs.getString("gogek_name") + "\t" +
						rs.getString("gogek_jumin") + "\t" +
						rs.getString("gogek_tel") + "\n";
				txtResult.append(ss);
				count += 1;  //++count도 가능
			}
			txtResult.append("인원수: " + count);
		} catch (Exception e2) {
			System.out.println("actionPerformed err: " + e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
	}
	
	
	public static void main(String[] args) {
		new DbTest3Gui();
	}

}
