package sample;

import java.awt.Frame;

//윈도우 창 띄우게 하기
public class MyFrame1 {   //클래스의 포함
	private Frame fr;
	
	//생성자
	public MyFrame1() {
		fr = new Frame("포함 연습용");
		
		displayWindow();
	}
	
	public void displayWindow() {
		fr.setSize(500, 300);  //너비와 높이임
		fr.setLocation(200, 150);  //x, y값 넣기
		fr.setVisible(true);  //보여줘
	}
	
	
	//일단은 여기서 main을 만들어놓고 다른곳에서 가져다가 쓰도록 함...(원래는 할때마다 만들어야됨..)
	public static void main(String[] args) {
//		MyFrame1 frame1 = new MyFrame1();  //frame1은 객체변수임
//		frame1.displayWindow();
		new MyFrame1();
	}
}
