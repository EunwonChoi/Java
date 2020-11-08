package aa.bb.pack4;

public class PohamHandle {
	int quantity;  //회전량
	
	public PohamHandle() {
		quantity = 0;
	}
	
	//별도의 클래스를 만들어줌
	String leftTurn(int quantity) {
		this.quantity = quantity;
		return "좌회전";
	}
	
	String rightTurn(int quantity) {
		this.quantity = quantity;
		return "우회전";
	}
	
	String straight(int quantity) {
		this.quantity = quantity;
		return "직진";
	}
}
