package pack1;

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

public class Pto extends JFrame implements ActionListener{
	// 멤버 변수
	JTextField txtf = new JTextField();
	JTextArea txtResult = new JTextArea();
	JButton btnCheck = new JButton("확인");
	ButtonGroup group = new ButtonGroup();
	JRadioButton radAc, radDc;
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	// 생성자
	public Pto() {
		super("Windwo DB Test");
		
		setLayout();
		accessDb();
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// 메서드
	private void setLayout() {
		JLabel label = new JLabel("직급 : ");
		txtf = new JTextField("", 10);										
		radAc = new JRadioButton("오름", true);								// Radio버튼 ( 오름을 기본으로 지정 ) 
		radDc = new JRadioButton("내림", false);
		group.add(radAc);													// button group에 오름 버튼을 추가
		group.add(radDc);													// button group에 내림 버튼 추가
		JPanel panel1 = new JPanel();
		panel1.add(label);
		panel1.add(txtf);
		panel1.add(btnCheck);
		panel1.add(radAc);
		panel1.add(radDc);
		
		txtResult.setEditable(false);										// txtArea를 수정불가
		JScrollPane pane = new JScrollPane(txtResult);
		
		add("North", panel1);
		add("Center", pane);
		
		btnCheck.addActionListener(this);
		radAc.addActionListener(this);
		radDc.addActionListener(this);
	}
	
	private void accessDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accessDb err : " + e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			txtResult.setText("");
			
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
			stmt = conn.createStatement();
			String sql = "select jikwon_no, jikwon_name, jikwon_jik, jikwon_gen, buser_name, jikwon_pay from "
					+ "buser inner join jikwon on buser_no = buser_num";
			// DB에서 사번, 이름, 직급, 성별, 부서명, 연봉을 검색 - 부서명이 jikwon테이블이 아닌 buser테이블이기에 조인을 이용
			
			switch(txtf.getText()) {
			case "":
				System.out.println(txtf.getText());
				break;
			case "사원":
				System.out.println(txtf.getText());
				sql += " where jikwon_jik = '사원'";
				break;
			case "대리":
				System.out.println(txtf.getText());
				sql += " where jikwon_jik = '대리'";
				break;
			case "과장":
				System.out.println(txtf.getText());
				sql += " where jikwon_jik = '과장'";
				break;
			case "부장":
				System.out.println(txtf.getText());
				sql += " where jikwon_jik = '부장'";
				break;
			case "이사":
				System.out.println(txtf.getText());
				sql += " where jikwon_jik = '이사'";
				break;
			default:												// 각 직급이나 아무것도 검색하지 않은 다른 검색어를 입력시 아래를 실행
				txtResult.setText("입력을 다시 해주세요.");
				txtf.setText(null);
				txtf.requestFocus();
				return;
			}
			
			if(radAc.isSelected()) {								// 라디오 버튼을 선택시 정렬 sql문을 추가
				sql += " order by jikwon_no asc";
			}
			else if(radDc.isSelected()) {
				sql += " order by jikwon_no desc";
			}
			
			rs = stmt.executeQuery(sql);							// rs에 sql문 실행 결과를 반환
			int count = 0;											// 인원수와 연봉평균을 위한 변수들
			double sum = 0;
			
			
			txtResult.append("사번 \t직원명\t직급\t성별\t부서명\n");
			
			while(rs.next()) {										// rs.next()는 true나 false를 반환하는데 true일 경우만 실행
				String ss = rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" +
						 rs.getString(5) + "\n";
				txtResult.append(ss);
				sum += rs.getInt(6);								// sum변수에 직원의 연봉을 계속 더함
				count++;
			}
			
			txtResult.append("인원수 : " + count + "\t" + "연봉평균 : " + Math.round(sum/count));
		} catch (Exception e2) {
			System.out.println("err : " + e2);
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e3) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) {
		new Pto();
	}

}
