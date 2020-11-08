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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//지역별 월건수

public class Sample5 extends JFrame implements ActionListener {
	String datas[][] = new String[0][13];
	String title[] = { "지점", "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월", "총건수" };
	DefaultTableModel model;
	JTable table;
	JButton btnExit;

	String[] cate = { "대치점", "개포점", "전체" };
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public Sample5() {
		super("조은떡볶이");

		setLayout();
		accDb();

		setBounds(300, 300, 500, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setLayout() {
		setLayout(new GridLayout(3, 1));

		// 1행
		JPanel pn1 = new JPanel();
		JLabel label = new JLabel("지역별 월건수 조회");
		pn1.add(label);
		add(pn1);

		// 2행
		JPanel pn3 = new JPanel();
		btnExit = new JButton("나가기");
		pn3.add(btnExit);
		add(pn3);

		// 3행
		model = new DefaultTableModel(datas, title);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);

		btnExit.addActionListener(this);
	}

	private void accDb() {
		//초기화
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "123");
			pstmt = conn.prepareStatement("select store_name ,\r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '01' THEN 1 END ) AS 1월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '02' THEN 1 END ) AS 2월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '03' THEN 1 END ) AS 3월,\r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '04' THEN 1 END ) AS 4월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '05' THEN 1 END ) AS 5월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '06' THEN 1 END ) AS 6월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '07' THEN 1 END ) AS 7월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '08' THEN 1 END ) AS 8월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '09' THEN 1 END ) AS 9월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '10' THEN 1 END ) AS 10월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '11' THEN 1 END ) AS 11월, \r\n" + "\r\n"
					+ "COUNT( CASE WHEN DATE_FORMAT(jumun_date,'%m') = '12' THEN 1 END ) AS 12월,\r\n" + "\r\n"
					+ "count(*) as 건수    \r\n" + "\r\n"
					+ "from jumun join store on jumun_store = store_no group by jumun_store");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String code = rs.getString("store_name");
				String month1 = rs.getString(2);
				String month2 = rs.getString(3);
				String month3 = rs.getString(4);
				String month4 = rs.getString(5);
				String month5 = rs.getString(6);
				String month6 = rs.getString(7);
				String month7 = rs.getString(8);
				String month8 = rs.getString(9);
				String month9 = rs.getString(10);
				String month10 = rs.getString(11);
				String month11 = rs.getString(12);
				String month12 = rs.getString(13);
				String gunsu = rs.getString(14);
				String[] imsi = { code, month1, month2, month3, month4, month5, month6, month7, month8, month9, month10,
						month11, month12, gunsu };
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
		

	}

	public static void main(String[] args) {
		new Sample5();
	}

}
