package pack1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//로그인 성공 시 DbTest9Ex로 감
//3번 틀릴 시 자동 종료

public class DbTest9Ex2 extends JFrame implements ActionListener {
	JTextField txtNo, txtName;
	JButton btnLogin;
	JTextArea txtResult;
	int count =0;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest9Ex2() {
		setTitle("Login");

		layInit();
		accDb();
		setBounds(300, 300, 400, 300);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void layInit() {
		setLayout(new GridLayout(4, 1));
		
		JPanel panel1 = new JPanel();
		txtNo = new JTextField("", 5);
		panel1.add(new JLabel("사번: "));
		panel1.add(txtNo);
		add(panel1);
		
		JPanel panel2 = new JPanel();
		txtName = new JTextField("", 10);
		panel2.add(new JLabel("이름: "));
		panel2.add(txtName);
		add(panel2);
		
		JPanel panel3 = new JPanel();
		btnLogin = new JButton("로그인");
		panel3.add(btnLogin);
		add(panel3);
		
		JPanel panel4 = new JPanel();
		txtResult = new JTextArea();
		JScrollPane pane = new JScrollPane(txtResult);
		add(pane);

		btnLogin.addActionListener(this);
		
	}

	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");  
		} catch (Exception e) {
			System.out.println("accDb err: " + e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(txtNo.getText().equals("") || txtName.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "로그인 자료 입력!");
			return;   //메소드의 무조건적인 탈출
		}
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123");
			String sql = "select * from jikwon where jikwon_no=? and jikwon_name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  txtNo.getText());
			pstmt.setString(2,  txtName.getText());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sql = "select jikwon_no, jikwon_name, jikwon_pay, jikwon_jik from jikwon";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				txtResult.setText("로긴 성공");
				new DbTest9Ex();
			}else if(count < 4) {
				count++;
				if (count == 1) {
					txtResult.setText("로긴 1번 실패");
				}else if(count ==2) {
					txtResult.setText("로긴 2번 실패");
				}else if(count ==3) {
					txtResult.setText("로긴 3번 실패");
					System.exit(0);
				}
			}
		} catch (Exception e2) {
			System.out.println("actionPerformed err: " + e2);
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
		new DbTest9Ex2();
	}

}
