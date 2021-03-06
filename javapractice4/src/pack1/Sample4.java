package pack1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import pack1.Sample3.JumunDelete;

//결제 전체 조회

public class Sample4 extends JFrame implements ActionListener {
	String datas[][] = new String[0][3];
	String title[] = { "결제번호", "결제종류", "수수료" };
	DefaultTableModel model;
	JTable table;
	JLabel lblCount;
	JButton btnExit;
	JButton btnUpdate, btnInsert, btnDelete;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Sample4() {
		super("조은떡볶이");

		setLayout();

		setBounds(300, 300, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		accDb();
	}

	private void setLayout() {
		setLayout(new GridLayout(4, 1));

		// 1행
		JPanel pn1 = new JPanel();
		JLabel label = new JLabel("전체 결제 조회");
		pn1.add(label);
		add(pn1);

		// 2행
		JPanel pn2 = new JPanel();
		btnExit = new JButton("나가기");
		pn2.add(btnExit);
		add(pn2);

		// 3행
		model = new DefaultTableModel(datas, title);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		// 4행
		JPanel pn4 = new JPanel();
		btnUpdate = new JButton("수정");
		btnInsert = new JButton("삽입");
		btnDelete = new JButton("삭제");
		pn4.add(btnUpdate);
		pn4.add(btnInsert);
		pn4.add(btnDelete);
		add(pn4);
		
		btnExit.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnInsert.addActionListener(this);
		btnDelete.addActionListener(this);
	}

	private void accDb() {
		//초기화
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0);
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
			pstmt = conn.prepareStatement("select * from payment");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String no = rs.getString("payment_no");
				String cate = rs.getString("payment_cate");
				double fees = rs.getDouble("payment_fees");
				String[] imsi = { no, cate, Double.toString(fees) };
				model.addRow(imsi);
			}
		} catch (Exception e) {
			System.out.println("accDb err: " + e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			dispose();
		}
		if (e.getSource() == btnUpdate) { // 상품수정
			JumunUpdate updateForm = new JumunUpdate(this);

			accDb();
		} else if (e.getSource() == btnInsert) { // 상품 추가
			JumunInsert insertForm = new JumunInsert(this); // 내부 클래스를 부름

			accDb(); // 화면을 초기화시키고 추가된 내용을 보여줌
		} else if (e.getSource() == btnDelete) { // 상품 삭제
			JumunDelete deleteForm = new JumunDelete(this);

			accDb();
		}
	}

	// Inner class 수정
	class JumunUpdate extends JDialog implements ActionListener {
		JTextField txtNo = new JTextField();
		JTextField txtCate = new JTextField();
		JTextField txtSusu = new JTextField();
		JButton btnOk = new JButton("수정하기");
		JButton btnCancel = new JButton("내용지우기");

		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;

		public JumunUpdate(JFrame frame) {
			super(frame, "결제정보수정");
			setModal(true);

			JPanel pn1 = new JPanel(new GridLayout(4, 2));
			// 1행
			pn1.add(new JLabel("번호: ")); // 1열
			pn1.add(txtNo); // 2열

			// 2행
			pn1.add(new JLabel("결제명: ")); // 1열
			pn1.add(txtCate); // 2열

			// 3행
			pn1.add(new JLabel("수수료: "));
			pn1.add(txtSusu);

			// 4행
			pn1.add(btnOk);
			pn1.add(btnCancel);

			btnOk.addActionListener(this);
			btnCancel.addActionListener(this);

			add("North", new JLabel("설명"));
			add("Center", pn1);

			setBounds(310, 310, 200, 200);
			setVisible(true);

			addWindowListener((WindowListener) new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) {
				// 입력 자료 검사
				if (txtNo.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "번호 입력");
					txtNo.requestFocus(); // 원하는 곳으로 focus 줌
					return;
				}

				if (txtCate.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "결제명 입력");
					txtCate.requestFocus(); // 원하는 곳으로 focus 줌
					return;
				}

				if (txtSusu.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "수 입력");
					txtSusu.requestFocus();
					return;
				}

				// 숫자인지 아닌지 확인하는 작업
				int no = 0;
				try {
					no = Integer.parseInt(txtNo.getText().trim()); // trim은 앞뒤공백을 잘라버림
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(this, "숫자만 허용!");
					txtNo.requestFocus();
					return;
				}

				double susu = 0.0;
				try {
					susu = Double.valueOf(txtSusu.getText().trim()); // trim은 앞뒤공백을 잘라버림
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(this, "소수점자리까지!");
					txtSusu.requestFocus();
					return;
				}

				// 등록 가능한 상태
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");

					// 요고요고 중요..! pstmt
					String sql = "update payment set payment_cate=?, payment_fees=? where payment_no=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, txtCate.getText());
					pstmt.setDouble(2, susu);
					pstmt.setInt(3, no);
					if (pstmt.executeUpdate() > 0) { // 잘 들어갔는지 사용자에게 보여줌
						JOptionPane.showMessageDialog(this, "등록성공");
					} else {
						JOptionPane.showMessageDialog(this, "등록실패");
					}
				} catch (Exception e2) {
					System.out.println("결제정보 추가 에러: " + e2);
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

			} else if (e.getSource() == btnCancel) { // 입력 자료 초기화
				txtNo.setText(null);
				txtCate.setText(null);
				txtSusu.setText(null);

			}
		}
	}

	// Inner class 삽입
	class JumunInsert extends JDialog implements ActionListener {
		JTextField txtCate = new JTextField();
		JTextField txtSusu = new JTextField();
		JButton btnOk = new JButton("등록하기");
		JButton btnCancel = new JButton("내용지우기");

		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;

		public JumunInsert(JFrame frame) {
			super(frame, "결제 정보 등록");
			setModal(true);

			JPanel pn1 = new JPanel(new GridLayout(3, 2));

			// 1행
			pn1.add(new JLabel("결제명: ")); // 1열
			pn1.add(txtCate); // 2열

			// 2행
			pn1.add(new JLabel("수수료: "));
			pn1.add(txtSusu);

			// 3행
			pn1.add(btnOk);
			pn1.add(btnCancel);

			btnOk.addActionListener(this);
			btnCancel.addActionListener(this);

			add("North", new JLabel("설명"));
			add("Center", pn1);

			setBounds(310, 310, 200, 200);
			setVisible(true);

			addWindowListener((WindowListener) new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) { 
				// 입력 자료 검사

				if (txtCate.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "결제명 입력");
					txtCate.requestFocus(); // 원하는 곳으로 focus 줌
					return;
				}

				if (txtSusu.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "수 입력");
					txtSusu.requestFocus();
					return;
				}

				// 숫자인지 아닌지 확인하는 작업

				double susu = 0.0;
				try {
					susu = Double.valueOf(txtSusu.getText().trim()); // trim은 앞뒤공백을 잘라버림
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(this, "소수점 자리까지!");
					txtSusu.requestFocus();
					return;
				}

				// 등록 가능한 상태
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");

					// 새상품 코드 얻기(가장 큰 값에 +1씩 자동 증가)
					int new_code = 0;
					String sql = "select max(payment_no) from payment"; // 가장 큰 번호를 얻을 수 있음
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						new_code = rs.getInt(1); // max(code)임 -> new_code = rs.getInt("max");로도 가능
					}

					// 요고요고 중요..! pstmt
					sql = "insert into payment values(?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, new_code + 10);
					pstmt.setString(2, txtCate.getText());
					pstmt.setDouble(3, susu);
					if (pstmt.executeUpdate() > 0) { // 잘 들어갔는지 사용자에게 보여줌
						JOptionPane.showMessageDialog(this, "등록성공");
					} else {
						JOptionPane.showMessageDialog(this, "등록실패");
					}
				} catch (Exception e2) {
					System.out.println("신상품 추가 에러: " + e2);
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

			} else if (e.getSource() == btnCancel) { // 입력 자료 초기화
				txtCate.setText(null);
				txtSusu.setText(null);

			}
		}
	}

	// InnerClass 삭제
	class JumunDelete extends JDialog implements ActionListener {
		JTextField txtNo = new JTextField();
		JButton btnOk = new JButton("삭제하기");
		JButton btnCancel = new JButton("내용지우기");

		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;

		public JumunDelete(JFrame frame) {
			super(frame, "상품삭제");
			setModal(true);

			JPanel pn1 = new JPanel(new GridLayout(2, 2));
			// 1행
			pn1.add(new JLabel("삭제할 번호: ")); // 1열
			pn1.add(txtNo); // 2열

			// 4행
			pn1.add(btnOk);
			pn1.add(btnCancel);

			btnOk.addActionListener(this);
			btnCancel.addActionListener(this);

			add("North", new JLabel("설명"));
			add("Center", pn1);

			setBounds(310, 310, 200, 200);
			setVisible(true);

			addWindowListener((WindowListener) new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});

		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnOk) { // 상품추가
				// 입력 자료 검사
				if (txtNo.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "번호입력");
					txtNo.requestFocus(); // 원하는 곳으로 focus 줌
					return;
				}


				// 숫자인지 아닌지 확인하는 작업
				int no = 0;
				try {
					no = Integer.parseInt(txtNo.getText().trim()); // trim은 앞뒤공백을 잘라버림
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(this, "숫자만 허용!");
					txtNo.requestFocus();
					return;
				}

				// 등록 가능한 상태
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");

					// 요고요고 중요..! pstmt
					String sql = "delete from payment where payment_no=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, no);
					if (pstmt.executeUpdate() >= 1) { // 잘 들어갔는지 사용자에게 보여줌
						int re = JOptionPane.showConfirmDialog(JumunDelete.this, "정말 삭제할까요?", "삭제",JOptionPane.OK_CANCEL_OPTION);
						if (re == JOptionPane.OK_OPTION) {
							try {
								JOptionPane.showMessageDialog(this, "삭제성공");
							} catch (Exception e2) {

							} finally {
								dispose();
							}
						} else {
							setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
						}
					} else {
						JOptionPane.showMessageDialog(this, " 삭제실패");
					}
				} catch (Exception e2) {
					System.out.println("삭제 에러: " + e2);
				} finally {
					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}

			} else if (e.getSource() == btnCancel) { // 입력 자료 초기화
				txtNo.setText(null);

			}
		}
	}

	public static void main(String[] args) {
		new Sample4();
	}

}
