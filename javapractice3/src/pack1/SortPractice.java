package pack1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//sort연습
public class SortPractice extends JFrame implements ActionListener {
	ButtonGroup group = new ButtonGroup();
	private JButton btnSelect = new JButton("Selection");
	private JButton btnBubble = new JButton("Bubble");
	private JButton btnClear = new JButton("Clear");
	private JPanel pn3 = new JPanel();
	JTextField txtSu;
	JLabel lblResult;

	public SortPractice() {
		super("sort");
		play();

		setBounds(300, 300, 300, 300);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void play() {
		setLayout(new GridLayout(4, 1));

		// 1행
		JLabel lbl1 = new JLabel("정렬연습(숫자는 10개 이하)");
		JPanel pn1 = new JPanel();
		pn1.add(lbl1);
		add(pn1);

		// 2행
		JLabel lbl2 = new JLabel("대상: ");
		txtSu = new JTextField("", 20);
		JPanel pn2 = new JPanel();
		pn2.add(lbl2);
		pn2.add(txtSu);
		add(pn2);

		// 3행
		lblResult = new JLabel("결과: ", JLabel.CENTER);
		add(lblResult);

		// 4행
		btnSelect.addActionListener(this);
		btnBubble.addActionListener(this);
		btnClear.addActionListener(this);
		JPanel pn3 = new JPanel();
		pn3.add(btnSelect);
		pn3.add(btnBubble);
		pn3.add(btnClear);
		add(pn3);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String temp;
		int i,j;
		if (e.getSource() == btnSelect) {
			String ss = txtSu.getText();
			String ar[] = ss.split(""); // 공백을 기준으로 잘라버림
			for (i = 0; i < ar.length - 1; i++) {
				for (j = i + 1; j < ar.length; j++) {
					if (Integer.parseInt(ar[i]) > Integer.parseInt(ar[j])) {
						temp = ar[i];
						ar[i] = ar[j];
						ar[j] = temp;
					}
				}
			}
			lblResult.setText("결과: " + ar[i]);
		} else if (e.getSource() == btnBubble) { // 여기서부터 sort 계산
			String ss = txtSu.getText();
			String ar[] = ss.split(""); // 공백을 기준으로 잘라버림
			for (i = 0; i < ar.length - 1; i++) {
				for (j = 0; j < ar.length - i - 1; j++) {
					if (Integer.parseInt(ar[j]) > Integer.parseInt(ar[j + 1])) {
						temp = ar[j];
						ar[j] = ar[j + 1];
						ar[j + 1] = temp;
					}
				}
			}				
			lblResult.setText("결과: " + ar[i]);
		} else if (e.getSource() == btnClear) {
			txtSu.setText(null);
		}
	}

	public static void main(String[] args) {
		/*
		 * String ss = "12345"; String ar[] = ss.split(""); //공백을 기준으로 잘라버림 for (int i =
		 * 0; i < ar.length; i++) { System.out.println(ar[i]); }
		 */

		new SortPractice();
	}

}
