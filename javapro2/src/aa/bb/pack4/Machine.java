package aa.bb.pack4;

import java.util.Scanner;

public class Machine {

	private int cupCount = 1;
	private CoinIn coinin = new CoinIn();

	//생성자
	public Machine(){
		
	}
	

	public void showData() {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("동전을 입력하세요: " );
		int ll = sc1.nextInt();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.println("몇 잔을 원하세요: " );
		cupCount = sc2.nextInt();
		
		coinin.calc(ll, cupCount);
		
		System.out.println("커피 " + cupCount + "잔과 잔돈 " + coinin.getJandon() +"원" );
	}
	
	
	
	
}
	



