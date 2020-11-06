package pack9;

//스레드의 자원 공유
//멀티테스킹
//synchronized : 스레드의 동기화

public class SinhanBankMain {
	public static SinhanBank myBank = new SinhanBank();	
	
	public static void main(String[] args) {
		System.out.println("초기 예금액: " + myBank.getMoney());
		
		Kim kim = new Kim();
		KimWife wife = new KimWife();
		
		kim.start();  //스레드를 부름
		wife.start();  
	}

}
