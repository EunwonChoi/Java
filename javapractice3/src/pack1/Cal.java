package pack1;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//연습문제(계산하기)
//근데 뭔가 조금 이상한 것 같아요(에러나옴) -> 종료하기 버튼 누를 시 에러나옴(MouseAdapter다시 하기)
public class Cal extends JFrame implements ActionListener {
	JTextField txtSu1, txtSu2;
	ButtonGroup group = new ButtonGroup();
	JRadioButton rPlus, rMinus, rGo, rNa;
	JLabel lblResult;

	public Cal() {
		super("미니 계산기");
		play();

		setBounds(300, 300, 300, 300);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void play() {
		setLayout(new GridLayout(5, 1)); // 5행 1열

		// 1행
		JLabel lbl1 = new JLabel("숫자1: ");
		txtSu1 = new JTextField("", 20);
		JPanel pn1 = new JPanel();
		pn1.add(lbl1);
		pn1.add(txtSu1);
		add(pn1);

		// 2행
		JLabel lbl2 = new JLabel("숫자2: ");
		txtSu2 = new JTextField("", 20);
		JPanel pn2 = new JPanel();
		pn2.add(lbl2);
		pn2.add(txtSu2);
		add(pn2);

		// 3행
		JLabel lbl3 = new JLabel("연산선택: ");
		rPlus = new JRadioButton("+", true);
		rMinus = new JRadioButton("-", false);
		rGo = new JRadioButton("*", false);
		rNa = new JRadioButton("/", false);
		group.add(rPlus);
		group.add(rMinus);
		group.add(rGo);
		group.add(rNa);
		JPanel pn3 = new JPanel();
		pn3.add(lbl3);
		pn3.add(rPlus);
		pn3.add(rMinus);
		pn3.add(rGo);
		pn3.add(rNa);
		add(pn3);

		// 4행
		lblResult = new JLabel("결과: ", JLabel.CENTER);
		add(lblResult);

		// 5행
		JButton btnOk = new JButton("계산");
		JButton btnReset = new JButton("초기화");
		JButton btnExit = new JButton("종료");
		btnOk.addActionListener(this);
		btnExit.addMouseListener(new Exit());
		btnReset.addMouseListener(new Reset());
		JPanel pn4 = new JPanel();
		pn4.add(btnOk);
		pn4.add(btnReset);
		pn4.add(btnExit);
		add(pn4);

	}
	
	class Exit extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			int re = JOptionPane.showConfirmDialog(new Cal(), "정말로 종료하시겠습니까?", "골라", JOptionPane.YES_NO_OPTION);
			// System.out.println(re);
			// JOptionPane.showMessageDialog(this, "메세지: " + re);
			switch (re) {
				case JOptionPane.YES_OPTION:
					System.exit(0);
					break;
				case JOptionPane.NO_OPTION:
					System.out.println("");
					break;
			}
		}
	}
	
	class Reset extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			Cal.this.txtSu1.setText(null);
			Cal.this.txtSu2.setText(null);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		// 입력자료 유효성 검사 후 결과 출력
		int su1 =0;
		int su2 =0;
		try {
			su1 = Integer.parseInt(txtSu1.getText());
			su2 = Integer.parseInt(txtSu2.getText());
		}catch(Exception e2){
			lblResult.setText("숫자를 넣어주세요");
			txtSu2.requestFocus(); 
			txtSu1.requestFocus(); 
			return;
		}

		double sum1 = Integer.parseInt(txtSu1.getText());
		double sum2 = Integer.parseInt(txtSu2.getText());
		// 계산버튼 누르면 계산해 주는 곳
		double yonsan = 0;
		if (rPlus.isSelected()) {
			yonsan = sum1 + sum2;
		} else if (rMinus.isSelected()) {
			yonsan = sum1 - sum2;
		} else if (rGo.isSelected()) {
			yonsan = sum1 * sum2;
		} else if (rNa.isSelected()) {
			if(sum1/sum2 < 0) {
				System.out.println("나눌 수 없어요");
			}else {
				yonsan = sum1 / sum2;				
			}
		}

		double msg = yonsan;
		lblResult.setText("결과: "+ msg);

	}

	public static void main(String[] args) {

		JFrame frame = new JFrame("대화상자 연습");

		Cal part = new Cal(); // JPanel

		frame.getContentPane().add(part, "Center");

		frame.setBounds(300, 300, 400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new Cal();

	}

}
