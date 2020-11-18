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
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DbTest10Crd extends JFrame implements ActionListener{
	JButton btnInsert = new JButton("추가");
	JButton btnDelete = new JButton("삭제");
	JButton btnExit = new JButton("종료");
	String [][] datas = new String[0][5];
	String [] title = {"코드", "상품명", "수량", "단가", "금액"};
	DefaultTableModel model = new DefaultTableModel(datas, title);
	JTable table = new JTable(model);
	JLabel lblCou = new JLabel("건수: 0");
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public DbTest10Crd() {
		layInit();
		accDb();
		
		setTitle("상품처리");
		setResizable(false);  //창의 크기 고정
		setBounds(300, 300, 300, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int re = JOptionPane.showConfirmDialog(DbTest10Crd.this, "정말 종료할까요?", "종료", JOptionPane.OK_CANCEL_OPTION);
				if(re == JOptionPane.OK_OPTION) {
					try {
						if(rs != null)rs.close();
						if(pstmt != null)pstmt.close();
						if(conn != null)conn.close();
				
					} catch (Exception e2) {
					
					}finally {
						System.exit(0);
					}
				}else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
	}
	
	private void layInit() {
		JPanel panel = new JPanel();
		panel.add(btnInsert);
		panel.add(btnDelete);
		panel.add(btnExit);
		add("North", panel);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(30);  //code 부분의 열 폭 설정
		JScrollPane scrollPane = new JScrollPane(table);
		add("Center", scrollPane);
		
		add("South", lblCou);
		
		//listener
		btnInsert.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패: " + e);
			return;
		} 
		
		dispData();
	}
	
	private void dispData() {
		model.setNumRows(0);  //테이블 초기화(안하면 원본 데이터가 바뀌어버릴수도 있음)
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
			String sql = "select * from sangdata";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			int count = 0;
			//순방향
			while(rs.next()) {
				int keum = rs.getInt("su") * rs.getInt("dan");
				String[] imsi = {
					rs.getString("code"),
					rs.getString("sang"),
					rs.getString("su"),
					rs.getString("dan"),
					Integer.toString(keum)
				};
				model.addRow(imsi);
				count++;
			}
			lblCou.setText("건수: " + count);
		} catch (Exception e) {
			System.out.println("dispData err: " + e);
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
		if(e.getSource() == btnInsert) {  //상품 추가
			InsertForm insertForm = new InsertForm(this);  //내부 클래스를 부름
			
			dispData();  //화면을 초기화시키고 추가된 내용을 보여줌
		}else if(e.getSource() == btnDelete) {  //상품 삭제
			String delNo = JOptionPane.showInputDialog(this, "삭제할 코드 입력");  //키보드로 값 받음(값 받는건 무조건 String임)
			if(delNo == null) return;
			//System.out.println("delNo: " + delNo);
			
			//삭제 출발
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
				String sql = "delete from sangdata where code=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, delNo);
				if(pstmt.executeUpdate() == 0) {
					JOptionPane.showMessageDialog(this, delNo + "번은 등록된 코드가 아닙니다");
					return;  //빠져나옴
				}
				
				dispData();   //삭제 후 자료 보기
			} catch (Exception e2) {
				System.out.println("삭제 실패: " + e2);
			}finally {
				try {
					if(rs != null) rs.close();	
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}else if(e.getSource() == btnExit) {   //종료
			int re = JOptionPane.showConfirmDialog(DbTest10Crd.this, "정말 종료할까요?", "종료", JOptionPane.OK_CANCEL_OPTION);
			if(re == JOptionPane.OK_OPTION) {
				try {
					if(rs != null)rs.close();
					if(pstmt != null)pstmt.close();
					if(conn != null)conn.close();
			
				} catch (Exception e2) {
				
				}finally {
					System.exit(0);
				}
			}else {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			}
		}
	}
	
	//추가를 위한 내부 클래스(굳이 내부 클래스로 안만들어줘도 됨)
	//JDialog사용(+ Modal)
	//현재는 mariadb에 맞춰진 auto_increment(자동 수 증가)
	//나중에는 직접 짜야함(mariadb, oracle, ms-db가 사용하는것이 모두 달라서..)
	class InsertForm extends JDialog implements ActionListener{
		JTextField txtSang = new JTextField();
		JTextField txtSu = new JTextField();
		JTextField txtDan = new JTextField();
		JButton btnOk = new JButton("등록");
		JButton btnCancel = new JButton("지움");
		
		public InsertForm(JFrame frame ) {
			super(frame, "상품추가");
			setModal(true);
			
			JPanel pn1 = new JPanel(new GridLayout(4, 2));
			//1행
			pn1.add(new JLabel("품명: "));  //1열
			pn1.add(txtSang);  //2열
			
			//2행
			pn1.add(new JLabel("수량: "));  //1열
			pn1.add(txtSu);  //2열
			
			//3행
			pn1.add(new JLabel("단가: "));
			pn1.add(txtDan);
			
			//4행
			pn1.add(btnOk);
			pn1.add(btnCancel);
			
			btnOk.addActionListener(this);
			btnCancel.addActionListener(this);
			
			add("North", new JLabel("상품자료 입력"));
			add("Center", pn1);
			
			setBounds(310, 310, 200, 150);
			setVisible(true);
			
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("aa");
			if(e.getSource() == btnOk) {  //상품추가
				//입력 자료 검사
				if(txtSang.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "상품명 입력");
					txtSang.requestFocus();  //원하는 곳으로 focus 줌
					return;
				}
				
				if(txtSu.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "수량 입력");
					txtSu.requestFocus();
					return;
				}
				
				if(txtDan.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "단가 입력");
					txtDan.requestFocus();
					return;
				}
				
				//수량과 단가는 숫자(숫자인지 아닌지 확인하는 작업)
				int su = 0;
				try {
					su = Integer.parseInt(txtSu.getText().trim());  //trim은 앞뒤공백을 잘라버림
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(this, "수량은 숫자만 허용!");
					txtSu.requestFocus();
					return;
				}
				
				int dan = 0;
				try {
					dan = Integer.parseInt(txtDan.getText().trim());  //trim은 앞뒤공백을 잘라버림
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(this, "단가는 숫자만 허용!");
					txtDan.requestFocus();
					return;
				}
				
				//등록 가능한 상태
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
					
					//새상품 코드 얻기(가장 큰 값에 +1씩 자동 증가)
					int new_code = 0;
					String sql = "select max(code) from sangdata";   //가장 큰 번호를 얻을 수 있음
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if(rs.next()) {
						new_code = rs.getInt(1);  //max(code)임   -> new_code = rs.getInt("max");로도 가능
					}
					//System.out.println("새상품 코드: " + (new_code + 1));  //새로운 레코드에 추가
					
					sql = "insert into sangdata values(?,?,?,?)";
					pstmt= conn.prepareStatement(sql);
					pstmt.setInt(1, new_code+1);  //첫번째 물음표
					pstmt.setString(2, txtSang.getText());  //두번째 물음표
					pstmt.setInt(3, su);  //세번째 물음표
					pstmt.setInt(4, dan);   //네번째 물음표
					if(pstmt.executeUpdate() > 0) {   //잘 들어갔는지 사용자에게 보여줌
						JOptionPane.showMessageDialog(this, "등록성공");
					}else {
						JOptionPane.showMessageDialog(this, "등록실패");
					}
				} catch (Exception e2) {
					System.out.println("신상품 추가 에러: " + e2);
				}finally {
					try {
						if(rs != null) rs.close();	
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
			}else if(e.getSource() == btnCancel) {   //입력 자료 초기화
				txtSang.setText(null);
				txtSu.setText(null);
				txtDan.setText(null);
				txtSang.requestFocus();
				
			}
		}
	}
	
	
	public static void main(String[] args) {
		new DbTest10Crd();

	}

}
