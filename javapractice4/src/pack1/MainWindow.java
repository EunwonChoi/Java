package pack1;

import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

//메인화면일세

public class MainWindow extends JFrame implements ActionListener {
	JComboBox combo1;
	JComboBox combo2;

	String[] cate1 = { "매장", "메뉴", "결제" };
	String[] cate2 = { "월별 판매 순위", "지역별 전체 매출", "지역별 건수" };

	JButton btnSearch1, btnSearch2;
	JTextArea txtResult;

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;

	public MainWindow() {
		super("조은떡볶이 사장화면");

		setLayout();

		setBounds(300, 300, 600, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void setLayout() {
		setLayout(new GridLayout(2, 2));

		// 1행1열
		JPanel pn1 = new JPanel();
		JLabel label1 = new JLabel("찾으시는 테이블 선택");
		pn1.add(label1);
		add(pn1);

		// 1행 2열
		JPanel pn2 = new JPanel();
		combo1 = new JComboBox(cate1);
		pn2.add(combo1);
		btnSearch1 = new JButton("조회");
		pn2.add(btnSearch1);
		add(pn2);

		// 2행 1열
		JPanel pn3 = new JPanel();
		JLabel label2 = new JLabel("찾고싶은 메뉴명");
		pn3.add(label2);
		add(pn3);

		// 2행 2열
		JPanel pn4 = new JPanel();
		combo2 = new JComboBox(cate2);
		pn4.add(combo2);
		btnSearch2 = new JButton("조회");
		pn4.add(btnSearch2);
		add(pn4);

		combo1.addActionListener(this);
		combo2.addActionListener(this);
		btnSearch1.addActionListener(this);
		btnSearch2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// String tableSelect = combo1.getSelectedItem().toString();
		if (combo1.getSelectedItem().equals("매장")) {
			if (e.getSource() == btnSearch1) {
				new Sample2();
			}
		} else if (combo1.getSelectedItem().equals("메뉴")) {
			if (e.getSource() == btnSearch1) {
				new Sample3();
			}
		} else if (combo1.getSelectedItem().equals("결제")) {
			if (e.getSource() == btnSearch1) {
				new Sample4();
			}
		}
		if (combo2.getSelectedItem().equals("월별 판매 순위")) {
			if (e.getSource() == btnSearch2) {
				new Sample7();
			}
		} else if (combo2.getSelectedItem().equals("지역별 전체 매출")) {
			if (e.getSource() == btnSearch2) {
				new Sample6();
			}
		} else if (combo2.getSelectedItem().equals("지역별 건수")) {
			if (e.getSource() == btnSearch2) {
				new Sample5();
			}
		}
		
	}

	public static void main(String[] args) {
		new MainWindow();
	}

}
