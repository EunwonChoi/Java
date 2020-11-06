package sample;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//원하는 것만 얻어옴
public class MyFrame4 extends WindowAdapter {
	//Adapter엔 Frame을 가지고 있지 않음(extends 하지 않음). 그래서 따로 불러와야 함
	private Frame frame = new Frame("Adapter 사용");  
	
	public MyFrame4() {
		frame.setSize(300,200);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		
		frame.addWindowListener(this);   //listener는 adapter가 가지고 있음
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	
	
	public static void main(String[] args) {
		new MyFrame4();
	}
}
