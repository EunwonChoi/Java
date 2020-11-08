package pack1;

import javax.swing.JFrame;

public class SwingTest2 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("대화상자 연습");

		Swing2Part part = new Swing2Part();   //JPanel
		
		frame.getContentPane().add(part, "Center");
		frame.setJMenuBar(part.mBar);   //frame에 메뉴 장착
		
		frame.setBounds(300, 300, 400, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
