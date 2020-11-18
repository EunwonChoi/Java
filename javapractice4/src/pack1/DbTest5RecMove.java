package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DbTest5RecMove extends JFrame implements ActionListener {
	JButton btnF, btnP, btnN, btnL;
	JTextField txtNo, txtName;
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public DbTest5RecMove() {
		super("레코드 이동");

		setLayout();
		accessDb();

		setBounds(200, 200, 400, 300);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				System.exit(0);
			}
		});
	}
	
	private void setLayout() {
		txtNo = new JTextField("", 5);
		txtName = new JTextField("", 10);
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("직원 자료: "));
		panel1.add(txtNo);
		panel1.add(txtName);
		add("North", panel1);
		
		btnF = new JButton("|<<");
		btnP = new JButton("<");
		btnN = new JButton(">");
		btnL = new JButton(">>|");
		JPanel panel2 = new JPanel();
		panel2.add(btnF);
		panel2.add(btnP);
		panel2.add(btnN);
		panel2.add(btnL);
		add("Center", panel2);
		
		btnF.addActionListener(this);
		btnP.addActionListener(this);
		btnN.addActionListener(this);
		btnL.addActionListener(this);
		
	}

	private void accessDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  //레코드 포인터 이동 순방향, 역방향 가능하게 함(수정 불가능)
			rs = stmt.executeQuery("select jikwon_no, jikwon_name from jikwon");
			rs.next(); 
			displayData();
		} catch (Exception e) {
			System.out.println("err: " + e);
		}
	}
	
	private void displayData() {
		try {
			txtNo.setText(rs.getString("jikwon_no"));  
			txtName.setText(rs.getString("jikwon_name"));   			
		} catch (Exception e) {
			//System.out.println("displayData err: " + e);
			JOptionPane.showMessageDialog(this, "자료의 처음 또는 마지막입니다.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if(e.getSource() == btnF) rs.first();
			else if(e.getSource() == btnP) rs.previous();
			else if(e.getSource() == btnN) rs.next();
			else if(e.getSource() == btnL) rs.last();
			
			displayData();
		} catch (Exception e2) {
			
		}
		
	}
	
	public static void main(String[] args) {
		new DbTest5RecMove();
	}

}
