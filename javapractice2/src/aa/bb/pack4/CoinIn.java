package aa.bb.pack4;


public class CoinIn {
	private int coin = 200;
	private int jandon = 0;
	
	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	public int getCoin() {
		return coin;
	}
	
	public int getJandon() {
		return jandon;
	}
	
	public void setJandon(int jandon) {
		this.jandon = jandon;
	}
	
	public void calc(int coin, int count) {
		this.coin = coin;

		if(coin >= 200) {
			jandon = coin -(count*200);
		}
		else {
			System.out.println("요금이 부족합니다");
		}
	}
}

