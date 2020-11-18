package pack1;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import java.awt.Toolkit;

//키보드 이벤트
public class PackMan extends JFrame implements KeyListener {
	Image image;
	int x, y, sel = 1;

	public PackMan() {
		super("상하좌우 화살표를 사용하세요");

		setIconImage(Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack1.jpg")); // 아이콘넣어줌

		
		setLayout(null);
		setBackground(Color.white);
		setResizable(false); // 창크기 조절 못함
		setBounds(300, 300, 400, 400);
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addKeyListener(this);

		//프레임의 너비
		x = (int)getWidth() / 2;
		y = (int)getHeight() / 2;
	}

	@Override
	public void paint(Graphics g) {
		switch (sel) {
		case 1:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack1.jpg");
			break;
		case 2:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack2.jpg");
			break;
		case 3:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack3.jpg");
			break;
		case 4:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack4.jpg");
			break;
		case 5:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack5.jpg");
			break;
		case 6:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack6.jpg");
			break;
		case 7:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack7.jpg");
			break;
		case 8:
			image = Toolkit.getDefaultToolkit().getImage("c:/work/pack/pack8.jpg");
			break;
		}
		
		g.clearRect(0, 0, getWidth(), getHeight());   //화면 전체를 clear 해서 잔상이 남지 않도록 함
		g.drawImage(image, x-image.getWidth(this)/2, y-image.getWidth(this)/2, this);   //팩맨의 기본 그림(중간에 있도록함)
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println(key);
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {
			//System.out.println("오른쪽");
			//if(sel == 1) sel = 2; else sel = 1; 
			sel = (sel == 1)?2:1;  //삼항연산자
			x = (x < getWidth())?x+10:-image.getWidth(this);    //프레임의 너비보다 작을때 참이면 계속 움직이고 아니면 다시 들어와라
		}else if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) { 
			sel = (sel == 3)?4:3;  //삼항연산자
			x = (x < 0)?400+image.getWidth(this):x-10;
		}else if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) { 
			sel = (sel == 5)?6:5;  //삼항연산자
			y = (y < getHeight())?y+10:-image.getHeight(this);
		}else if(key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) { 
			sel = (sel == 7)?8:7;  //삼항연산자
			y = (y < 0)?400+image.getHeight(this):y-10;
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {
		new PackMan();

	}

}
