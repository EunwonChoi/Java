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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//지역별 전체 매출

public class Sample6 extends JFrame implements ActionListener{
	String [][] datas = new String[0][1]; //2차원이라 행,열
	String [] title = {"지점명","전체 수익"};
	DefaultTableModel model;
	JTable table;
	JLabel lblCount;
	JButton btnPre,btnNex, btnExit;
	double realPay1,realPay2 = 0;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Sample6() {
	super("전체 매출 순위");
	
	layInit();
	accDb();
	
	setBounds(300,300,300,300);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void layInit() {
		model = new DefaultTableModel(datas,title);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		lblCount = new JLabel("건수 : 0");
		JPanel pane = new JPanel();
		btnExit = new JButton("나가기");
		pane.add(btnExit);
		
		add("North", pane);
		add("Center",scrollPane);
		
		btnExit.addActionListener(this);
	}
	private void accDb() {
		//초기화
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.setRowCount(0);
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","123");
			pstmt = conn.prepareStatement("select jumun_no,jumun_store,jumun_cnt * menu_cost as 수익,"
					+ "payment_fees from jumun join menu on jumun_menu = menu_no join payment on jumun_cate = payment_no;");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String jNo = rs.getString(1);
				String jSt = rs.getString(2);
				int inc = rs.getInt(3);
				double py = rs.getDouble(4);
				double rPay = inc - (inc*py);
				
				if(rs.getInt(2) == 1 ) {
					realPay1 += rPay;
				}else if(rs.getInt(2) == 2) {
					realPay2 += rPay;
				}
				
			}
			if(realPay1>realPay2) {
				String []imsi = {"대치점",String.format("%10.1f",realPay1)};
				model.addRow(imsi);
				String []imsi2 = {"개포점",String.format("%10.1f",realPay2)};
				model.addRow(imsi2);
			} else if (realPay1<realPay2) {
				String []imsi2 = {"개포점",String.format("%10.1f",realPay2)};
				model.addRow(imsi2);
				String []imsi = {"대치점",String.format("%10.1f",realPay1)};
				model.addRow(imsi);
			}
				
		} catch (Exception e) {
			System.out.println("accDb err : "+e);
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
				
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
		new Sample6();
	}


}

