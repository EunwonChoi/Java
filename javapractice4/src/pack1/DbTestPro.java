package pack1;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTestPro extends JFrame implements ActionListener {
	JButton btnCheck = new JButton("확인");
	JTextArea txtResult = new JTextArea();
	JTextField txtF;
	ButtonGroup group = new ButtonGroup();
	JRadioButton buttonA, buttonB;

	Connection conn;
	Statement stmt;
	ResultSet rs;

	public DbTestPro() {
		super("직급");

		setLayout();
		// accessDb();

		setBounds(200, 200, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setLayout() {
		JPanel panel = new JPanel();
		JLabel lbl1 = new JLabel("직급: ");
		panel.add(lbl1);
		txtF = new JTextField("", 20);
		panel.add(txtF);
		panel.add(btnCheck);
		buttonA = new JRadioButton("오름", true);
		buttonB = new JRadioButton("내림", false);
		group.add(buttonA);
		group.add(buttonB);
		panel.add(buttonA);
		panel.add(buttonB);
		add(panel);

		txtResult.setEditable(false); // 편집불가 . Read Only
		JScrollPane pane = new JScrollPane(txtResult); // scroll bar 추가

		add("North", panel);
		add("Center", pane);

		btnCheck.addActionListener(this);
		buttonA.addActionListener(this);
		buttonB.addActionListener(this);
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
			String sql = "select jikwon_no, jikwon_name, jikwon_jik, jikwon_gen, jikwon_pay, buser_name from jikwon inner join buser on buser_no = buser_num";
			
			// 버튼 구분
			if (txtF.getText().equals("이사")) {
				if (e.getSource() == btnCheck) {
					sql += " where jikwon_jik = '이사'";
				}
			} else if (txtF.getText().equals("부장")) {
				if (e.getSource() == btnCheck) {
					sql += " where jikwon_jik = '부장'";
				}
			} else if (txtF.getText().equals("과장")) {
				if (e.getSource() == btnCheck) {
					sql += " where jikwon_jik = '과장'";
				}
			} else if (txtF.getText().equals("대리")) {
				if (e.getSource() == btnCheck) {
					sql += " where jikwon_jik = '대리'";
				}
			} else if (txtF.getText().equals("사원")) {
				if (e.getSource() == btnCheck) {
					sql += " where jikwon_jik = '사원'";
				}
			}else if(txtF.getText().equals("")) {
				if (e.getSource() == btnCheck) {
					txtF.setText(null);   //깨끗하게 비워짐 ""
					txtF.requestFocus();
					return;
				}
			}
			
			if (buttonA.isSelected()) {
				sql += " order by jikwon_no asc";// 오름차순
			} else if (buttonB.isSelected()) {
				sql += " order by jikwon_no desc";// 내림차순
			}

			
			rs = stmt.executeQuery(sql);
			int count = 0;
			int sum = 0;
			txtResult.setText("사번\t직원명\t직급\t성별\t부서명\n");
			while (rs.next()) {
				String ss = rs.getString("jikwon_no") + "\t" + rs.getString("jikwon_name") + "\t"
						+ rs.getString("jikwon_jik") + "\t" + rs.getString("jikwon_gen") + "\t" + rs.getString("buser_name") + "\n";
				txtResult.append(ss);
				count += 1; // ++count도 가능
				sum += Integer.parseInt(rs.getString("jikwon_pay"));
			}
			
			txtResult.append("인원수: " + count + "\t연봉평균: " + Math.round(sum/count));
			
		} catch (Exception e2) {
			System.out.println("actionPerformed err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		new DbTestPro();

	}

}
