package pack5;

public class PolyBus extends PolyCar{
	private int passenger = 10;
			
	//일반 메소드임
	public void show() {
		System.out.println("버스");
	}
	
	@Override
	public void dispData() {
		System.out.println("버스의 승객 수는 " + passenger);
		System.out.println("버스의 속도는 " + speed);
	}
	
	
}
