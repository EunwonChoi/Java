package pack1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MemoAbout extends JDialog implements ActionListener{
	public MemoAbout(JFrame frame) {
		/*
		super(frame);
		setTitle("메모장 정보");
		setModal(false);   //대화상자에서 true일경우 다른곳이 눌리지 않음 (true : Modal, false : Modeless)
		*/
		
		super(frame, "메모장 정보", true);
		
		JLabel label = new JLabel("미니 메모장 Ver 0.9");
		JButton btn = new JButton("확인");
		btn.addActionListener(this);
		add("Center", label);
		add("South", btn);
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(350, 350, 200, 200);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();  //JDialog 닫기
	}
}
