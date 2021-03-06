package pack1;

import java.awt.Dialog;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//매장 전체 조회

public class Sample2 extends JFrame implements ActionListener {
	String datas[][] = new String[0][5];
	String title[] = { "매장번호", "매장이름", "전화번호", "주소", "담당자" };
	DefaultTableModel model;
	JTable table;
	JLabel lblCount;
	JButton btnExit;
	JButton btnUpdate, btnInsert, btnDelete;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Sample2() {

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
		JLabel label = new JLabel("전체 매장 조회");
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
			pstmt = conn.prepareStatement("select * from store");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String no = rs.getString("store_no");
				String name = rs.getString("store_name");
				String tel = rs.getString("store_tel");
				String juso = rs.getString("store_juso");
				String spv = rs.getString("store_spv");
				String[] imsi = { no, name, tel, juso, spv };
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
		JTextField txtName = new JTextField();
		JTextField txtTel = new JTextField();
		JTextField txtJuso = new JTextField();
		JTextField txtPer = new JTextField();
		JButton btnOk = new JButton("수정");
		JButton btnCancel = new JButton("지움");

		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;

		public JumunUpdate(JFrame frame) {
			super(frame, "가게수정");
			setModal(true);

			JPanel pn1 = new JPanel(new GridLayout(6, 2));
			// 1행
			pn1.add(new JLabel("가게번호: ")); // 1열
			pn1.add(txtNo); // 2열

			// 2행
			pn1.add(new JLabel("가게이름: ")); // 1열
			pn1.add(txtName); // 2열

			// 3행
			pn1.add(new JLabel("전화번호: "));
			pn1.add(txtTel);

			// 4행
			pn1.add(new JLabel("주소: "));
			pn1.add(txtJuso);

			// 5행
			pn1.add(new JLabel("담당: "));
			pn1.add(txtPer);

			// 5행
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
			if (e.getSource() == btnOk) { // 상품추가
				// 입력 자료 검사
				if (txtNo.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "번호 입력");
					txtNo.requestFocus(); // 원하는 곳으로 focus 줌
					return;
				}

				if (txtName.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "이름 입력");
					txtName.requestFocus(); // 원하는 곳으로 focus 줌
					return;
				}

				if (txtTel.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "전화번호 입력");
					txtTel.requestFocus();
					return;
				}

				if (txtJuso.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "주소 입력");
					txtJuso.requestFocus();
					return;
				}

				if (txtPer.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "담당자 입력");
					txtPer.requestFocus();
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
					String sql = "update store set store_name=?, store_tel=?, store_juso=?, store_spv=? where store_no=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, txtName.getText());
					pstmt.setString(2, txtTel.getText());
					pstmt.setString(3, txtJuso.getText());
					pstmt.setString(4, txtPer.getText());
					pstmt.setInt(5, no);
					if (pstmt.executeUpdate() > 0) { // 잘 들어갔는지 사용자에게 보여줌
						JOptionPane.showMessageDialog(this, "등록성공");
					} else {
						JOptionPane.showMessageDialog(this, "등록실패");
					}
				} catch (Exception e2) {
					System.out.println("가게 수정 에러: " + e2);
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
				txtName.setText(null);
				txtTel.setText(null);
				txtJuso.setText(null);
				txtPer.setText(null);

			}
		}
	}

	// Inner class 삽입
	class JumunInsert extends JDialog implements ActionListener {
		JTextField txtName = new JTextField();
		JTextField txtTel = new JTextField();
		JTextField txtJuso = new JTextField();
		JTextField txtPer = new JTextField();
		JButton btnOk = new JButton("등록하기");
		JButton btnCancel = new JButton("내용지우기");

		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;

		public JumunInsert(JFrame frame) {
			super(frame, "상품수정");
			setModal(true);

			JPanel pn1 = new JPanel(new GridLayout(5, 2));

			// 1행
			pn1.add(new JLabel("가게이름: ")); // 1열
			pn1.add(txtName); // 2열

			// 2행
			pn1.add(new JLabel("전화번호: "));
			pn1.add(txtTel);

			// 3행
			pn1.add(new JLabel("주소: "));
			pn1.add(txtJuso);

			// 4행
			pn1.add(new JLabel("담당: "));
			pn1.add(txtPer);

			// 5행
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
			if (e.getSource() == btnOk) { 
				// 입력 자료 검사

				if (txtName.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "이름 입력");
					txtName.requestFocus(); // 원하는 곳으로 focus 줌
					return;
				}

				if (txtTel.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "전화번호 입력");
					txtTel.requestFocus();
					return;
				}

				if (txtJuso.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "주소 입력");
					txtJuso.requestFocus();
					return;
				}

				if (txtPer.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "담당자 입력");
					txtPer.requestFocus();
					return;
				}

				// 등록 가능한 상태
				try {
					conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");

					// 새상품 코드 얻기(가장 큰 값에 +1씩 자동 증가)
					int new_code = 0;
					String sql = "select max(store_no) from store"; // 가장 큰 번호를 얻을 수 있음
					pstmt = conn.prepareStatement(sql);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						new_code = rs.getInt(1); // max(code)임 -> new_code = rs.getInt("max");로도 가능
					}

					// 요고요고 중요..! pstmt
					sql = "insert into store values(?,?,?,?,?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, new_code + 1);
					pstmt.setString(2, txtName.getText());
					pstmt.setString(3, txtTel.getText());
					pstmt.setString(4, txtJuso.getText());
					pstmt.setString(5, txtPer.getText());
					if (pstmt.executeUpdate() > 0) { // 잘 들어갔는지 사용자에게 보여줌
						JOptionPane.showMessageDialog(this, "등록성공");
					} else {
						JOptionPane.showMessageDialog(this, "등록실패");
					}
				} catch (Exception e2) {
					System.out.println("가게 추가 에러: " + e2);
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
				txtName.setText(null);
				txtTel.setText(null);
				txtJuso.setText(null);
				txtPer.setText(null);

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
			pn1.add(new JLabel("가게번호: ")); // 1열
			pn1.add(txtNo); // 2열

			// 2행
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
			if (e.getSource() == btnOk) { 
				// 입력 자료 검사
				if (txtNo.getText().equals("")) {
					JOptionPane.showConfirmDialog(this, "번호 입력");
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
					String sql = "delete from store where store_no=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, no);
					if (pstmt.executeUpdate() >= 1) { // 잘 들어갔는지 사용자에게 보여줌
						int re = JOptionPane.showConfirmDialog(JumunDelete.this, "정말 삭제할까요?", "삭제", JOptionPane.OK_OPTION);
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
		new Sample2();
	}

}
