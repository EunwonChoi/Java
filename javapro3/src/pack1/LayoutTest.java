package pack1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//BorderLayout(east,west,south,north,center)
//FlowLayout(좌->우, 상->하)
//GridLayout(행렬)
//CardLayout(레이아웃 겹치기) .....
public class LayoutTest extends Frame implements ActionListener{
	Panel pn1 = new Panel();   //Visual Object(component)를 담을 수있는 Container 클래스. FlowLayout
	Panel pn2 = new Panel();
	Panel pn3 = new Panel();
	Panel pn4 = new Panel();
	Panel pn5 = new Panel();
	CardLayout card = new CardLayout();
	Button btnOk;
	TextField txtBun, txtIrum;

	public LayoutTest() {
		//Frame은 BorderLayout이 기본이나 여기에서는 GridLayout으로 변경
		setLayout(new GridLayout(2, 1));  //2행 1열
		
		//1행
		Label lbl1 = new Label("bunho: ");
		txtBun = new TextField("10", 20);
		pn1.add(lbl1);
		pn1.add(txtBun);
		pn1.setBackground(Color.yellow);
		//add(pn1);   //Frame에 pn1을 포함
		
		Label lbl2 = new Label("irum: ");
		txtIrum = new TextField("홍길동", 20);
		pn2.add(lbl2);
		pn2.add(txtIrum);
		pn2.setBackground(Color.cyan);
		//add(pn2);   //Frame에 pn2을 포함
		
		pn3.setLayout(card);   //Panel의 FlowLayout을 CardLayout으로 바꿈
		pn3.add("aa", pn1);
		pn3.add("bb", pn2);
		btnOk = new Button("ok");
		btnOk.addActionListener(this);
		pn4.add(pn3);  //FlowLayout
		pn4.add(btnOk);
		add(pn4);   //pn3은 pn1과 pn2를 가지고 있고(겹쳐져 있음) pn4는 pn3을 가지고 있음
		
		
		
		//2행
		pn5.setBackground(Color.red);
		pn5.setLayout(new BorderLayout());
		pn5.add("Center", new Label("center"));
		pn5.add("East", new Label("East"));
		pn5.add("West", new Label("West"));
		pn5.add("South", new Label("South", Label.CENTER));
		pn5.add("North", new Label("North"));
		add(pn5);
		
		setTitle("레이아웃 연습");
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getActionCommand());
		if(e.getActionCommand().equalsIgnoreCase("ok")) {
			btnOk.setLabel("click");
			card.show(pn3, "bb");
		}else {
			btnOk.setLabel("OK");
			card.show(pn3, "aa");
		}
	}
	
	
	
	public static void main(String[] args) {
		new LayoutTest();
	}

}
