package sample;

import java.awt.Frame;

public class MyFrame2 extends Frame{
	
	public MyFrame2() {
		// TODO Auto-generated constructor stub
		super("상속 연습");
		
		dispWindow();
	
	}
	
	void dispWindow() {
		//super.setSize(500,300);
		//this.setSize(500,300);  //틀린건 아니지만 가독성이 떨어짐
		setSize(500,300);
		setLocation(200, 150);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame2();

	}

}
