package pack5;

public class PolyTaxi extends PolyCar{
	private int passenger = 2;
			
	//일반 메소드임
	public void show() {
		System.out.println("택시");
	}
	
	@Override
	public void dispData() {
		System.out.println("택시의 승객 수는 " + passenger);
	}
	
	
}
