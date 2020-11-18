package sample;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame5 extends Frame{
	MyClass myClass;
	
	int x,y;  //마우스로 폼 바닥을 찍었을 때의 해당 지점 좌표
	String str [] = {"김치국", "공기밥", "김밥", "주먹밥", "박치기"};
	
	public MyFrame5() {
		//super("내부 클래스 사용");
		setTitle("내부 클래스 사용");
		setSize(400,300);
		setLocation(200, 200);
		setVisible(true);
	
		//내부클래스 선언
		myClass = new MyClass();
		addWindowListener(myClass); //myClass가 받도록 함
		addMouseListener(new OurClass());  //OurClass를 바로 받도록 함
	}
	
	//내부클래스
	class MyClass extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	//내부 클래스
	class OurClass extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			//int m = e.getX();
			//int n = e.getY();
			//System.out.println("m: " + m + ", n:" + n);
			//setTitle("m: " + m + ", n:" + n);  //요로코롬 해도 됨
			
			x = e.getX();
			y = e.getY();
			//paint(getGraphics());  //refresh X
			repaint();  //refresh O
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.setFont(new Font("굴림", Font.BOLD,(int)(Math.random() * 50) + 8 ));
		//g.drawString("홍길동", x, y);
		int ar = (int)(Math.random() * 5);
		g.drawString(str[ar], x, y);
	}
	
	public static void main(String[] args) {
		new MyFrame5();
	}
}
