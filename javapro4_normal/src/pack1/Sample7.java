package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sample7 extends JFrame implements ActionListener {
	String[][] datas = new String[0][1]; // 2차원이라 행,열
	String[] title = { "월", "지점명", "수익" };
	DefaultTableModel model;
	JTable table;
	JLabel lblCount;
	JButton btnPre, btnNex;
	String month;
	double realPay1, realPay2 = 0;
	int when = 1;
	
	JButton btnExit;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Sample7() {
		super("월별 매출 순위");

		layInit();
		accDb();

		setBounds(300, 300, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void layInit() {
		model = new DefaultTableModel(datas, title);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		lblCount = new JLabel("건수 : 0");
		JPanel pane = new JPanel();
		btnPre = new JButton("이전달");
		btnNex = new JButton("다음달");
		JPanel pane2 = new JPanel();
		btnExit = new JButton("나가기");
		pane.add(btnPre);
		pane.add(btnNex);
		pane2.add(btnExit);

		add("Center", scrollPane);
		add("South", pane);
		add("North", pane2);

		btnPre.addActionListener(this);
		btnNex.addActionListener(this);
		btnExit.addActionListener(this);
	}

	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
			pstmt = conn.prepareStatement(
					"select jumun_no,jumun_store,(jumun_cnt * menu_cost) as 수익,payment_fees, DATE_FORMAT(jumun_date,'%m') from jumun "
							+ "join menu on jumun_menu = menu_no " + "join payment on jumun_cate = payment_no "
							+ "where DATE_FORMAT(jumun_date,'%m') = ?");
			switch (when) {
			case 1:
				pstmt.setString(1, "01");
				break;
			case 2:
				pstmt.setString(1, "02");
				break;
			case 3:
				pstmt.setString(1, "03");
				break;
			case 4:
				pstmt.setString(1, "04");
				break;
			case 5:
				pstmt.setString(1, "05");
				break;
			case 6:
				pstmt.setString(1, "06");
				break;
			case 7:
				pstmt.setString(1, "07");
				break;
			case 8:
				pstmt.setString(1, "08");
				break;
			case 9:
				pstmt.setString(1, "09");
				break;
			case 10:
				pstmt.setString(1, "10");
				break;
			case 11:
				pstmt.setString(1, "11");
				break;
			case 12:
				pstmt.setString(1, "12");
				break;
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {
				String jNo = rs.getString(1);
				String jSt = rs.getString(2);
				int inc = rs.getInt(3);
				double py = rs.getDouble(4);
				month = rs.getString(5);
				double rPay = inc - (inc * py);

				if (rs.getInt(2) == 1) {
					realPay1 += rPay;
				} else if (rs.getInt(2) == 2) {
					realPay2 += rPay;
				}

			}
			if (realPay1 > realPay2) {
				String[] imsi = { month, "대치점", String.format("%10.1f", realPay1) };
				model.addRow(imsi);
				String[] imsi2 = { month, "개포점", String.format("%10.1f", realPay2) };
				model.addRow(imsi2);

			} else if (realPay1 < realPay2) {
				String[] imsi2 = { month, "개포점", String.format("%10.1f", realPay2) };
				model.addRow(imsi2);
				String[] imsi = { month, "대치점", String.format("%10.1f", realPay1) };
				model.addRow(imsi);
			}
			realPay1 = 0;
			realPay2 = 0;
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
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
		
		if (when == 12 && e.getSource()== btnNex){
			JOptionPane.showMessageDialog(this, "자료의 처음 또는 마지막입니다.");
			when = 1;
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			accDb();
		}else if (e.getSource() == btnNex) {
			if (when <= 12) {
				when++;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
				accDb();
		}
		}
		if (when == 1 && e.getSource()== btnPre){
			JOptionPane.showMessageDialog(this, "자료의 처음 또는 마지막입니다.");
			when = 1;
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setNumRows(0);
			accDb();
		}else if (e.getSource() == btnPre) {
			if (when >= 1) {
				when--;
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setNumRows(0);
				accDb();
		}
		}
	}

	public static void main(String[] args) {
		new Sample7();
	}

}