package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	JTextField txtId, txtPw;
	JButton btnLogin;
	JTextArea txtResult;
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public Login() {
		setTitle("Login");
		
		layInit();
		accDb();
		setBounds(300, 300, 400, 150);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void layInit() {
		JPanel panel = new JPanel();
		txtId = new JTextField("", 10);
		txtPw = new JTextField("", 10);
		btnLogin = new JButton("로그인");
		
		panel.add(new JLabel("ID: "));
		panel.add(txtId);
		panel.add(new JLabel("PW: "));
		panel.add(txtPw);
		panel.add(btnLogin);
		
		add("Center", panel);
		
		btnLogin.addActionListener(this);
		
	}
	
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");  
		} catch (Exception e) {
			System.out.println("accDb err: " + e);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(txtId.getText().equals("") || txtPw.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "로그인 자료 입력!");
			return;   //메소드의 무조건적인 탈출
		}
		
		if(txtId.getText().equals("admin") && txtPw.getText().equals("1234")) {
			JOptionPane.showMessageDialog(this, "로그인 성공! 환영합니다.");
			new MainWindow();
			dispose();
		}else {
			JOptionPane.showMessageDialog(this, "로그인 실패! 다시 입력해주세요.");
		}
		
}
	
	
	
	
	public static void main(String[] args) {
		new Login();

	}

}
