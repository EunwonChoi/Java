package pack9;

//이벤트 리스너와 thread를 이용하여 시계 만들기

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class ThreadTestClock extends Frame implements ActionListener, Runnable{
	private Label lblMessage;
	private Boolean flag = false;
	private Thread thread;
	
	public ThreadTestClock() {
		lblMessage = new Label("display date&time", Label.CENTER);
		add("Center", lblMessage);
		lblMessage.setFont(new Font("궁서", Font.BOLD, 24));
		Button button = new Button("click");
		add("South", button);
		button.addActionListener(this);
		
		setTitle("스레드 연습");
//		setSize(300, 300);
//		setLocation(300,400);
		setBounds(300, 400, 500, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				flag = true;
				System.exit(0);
			}
		});
		
		thread = new Thread(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("클릭");
		//calShow();
		if(thread.isAlive()) return;
		thread.start();
	}

	@Override
	public void run() {
		while(true) {
			if(flag == true) break;
			
			calShow();
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	private void calShow() {
		Calendar calendar = Calendar.getInstance();
		int y = calendar.get(Calendar.YEAR);
		int m = calendar.get(Calendar.MONTH) + 1;
		int d = calendar.get(Calendar.DATE);
		int h = calendar.get(Calendar.HOUR);
		int mi = calendar.get(Calendar.MINUTE);
		int s = calendar.get(Calendar.SECOND);
		
		lblMessage.setText(y + "-" + m + "-" + d + "\n" + h + ":" + mi + ":" + s);
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ThreadTestClock();
	}

}
