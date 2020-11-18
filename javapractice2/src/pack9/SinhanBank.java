package pack9;

public class SinhanBank {
	private int money = 10000;   //통장의 잔고. 스레드의 공유자원
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	//자원 공유 중요..!
	public synchronized void saveMoney(int save) {   //입금. synchronized : 스레드의 동기화
		int m = getMoney();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		setMoney(m + save);
	}
	
	public synchronized void minusMoney(int mon) {  //출금
		int m = getMoney();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		setMoney(m - mon);
	}
}
