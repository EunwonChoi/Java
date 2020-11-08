package pack1;

import java.awt.GridLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest5RecMoveEx extends JFrame implements ActionListener{
	JButton btnF, btnP, btnN, btnL;
	JTextField txtNo, txtName, txtBname, txtBtel;
	JTextArea txtResult = new JTextArea();
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	ResultSet rs2;
	
	public DbTest5RecMoveEx() {
		super("레코드 이동");

		setLayout();
		accessDb();

		setBounds(200, 200, 800, 300);
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
		setLayout(new GridLayout(3, 1));
		
		//1행
		txtNo = new JTextField("", 5);
		txtName = new JTextField("", 10);
		txtBname = new JTextField("", 5);
		txtBtel = new JTextField("", 20);
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("사번: "));
		panel1.add(txtNo);
		panel1.add(new JLabel("이름: "));
		panel1.add(txtName);
		panel1.add(new JLabel("부서명: "));
		panel1.add(txtBname);
		panel1.add(new JLabel("부서전화: "));
		panel1.add(txtBtel);
		add(panel1);
		
		//2행
		btnF = new JButton("|<<");
		btnP = new JButton("<");
		btnN = new JButton(">");
		btnL = new JButton(">>|");
		JPanel panel2 = new JPanel();
		panel2.add(btnF);
		panel2.add(btnP);
		panel2.add(btnN);
		panel2.add(btnL);

		
		btnF.addActionListener(this);
		btnP.addActionListener(this);
		btnN.addActionListener(this);
		btnL.addActionListener(this);
		add(panel2);
		
		//3행
		txtResult.setEditable(false);										
		JScrollPane panel3 = new JScrollPane(txtResult);
		add(panel3);
		
	}

	private void accessDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);  //레코드 포인터 이동 순방향, 역방향 가능하게 함(수정 불가능)
			rs = stmt.executeQuery("select jikwon_no, jikwon_name, buser_name, buser_tel from jikwon inner join buser on buser_no = buser_num");
			//rs2 = stmt.executeQuery("select gogek_no, gogek_name, gogek_tel from gogek left outer join jikwon on jikwon_no=gogek_damsano inner join buser on buser_no=buser_num ");
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
			txtBname.setText(rs.getString("buser_name")); 
			txtBtel.setText(rs.getString("buser_tel")); 
			
			String et = txtNo.getText();
			String sql ="select gogek_no, gogek_name, gogek_tel from gogek left outer join jikwon on jikwon_no=gogek_damsano inner join buser on buser_no=buser_num " + "where jikwon_no='" + et + "'"; //날짜나 문자 있을때는 ''넣으면 됨
			rs2 = stmt.executeQuery(sql);
			int count = 0;
			txtResult.setText("고객번호\t고객명\t고객전화\n");
			while (rs2.next()) {
				String ss = rs2.getString("gogek_no") + "\t" + rs2.getString("gogek_name") + "\t" + rs2.getString("gogek_tel") + "\n";
				txtResult.append(ss);
				count += 1; // ++count도 가능
			}
			txtResult.append("인원수: " + count);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "자료의 처음 또는 마지막입니다.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {		
			if(e.getSource() == btnF) {
				rs.first();
			}else if(e.getSource() == btnP) {
				rs.previous();
			}else if(e.getSource() == btnN) {
				rs.next();
			}else if(e.getSource() == btnL) {
				rs.last();
			}
			
			displayData();
			
		} catch (Exception e2) {

		}
		
	}
	
	public static void main(String[] args) {
		new DbTest5RecMoveEx();

	}

}
