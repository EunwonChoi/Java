package pack6;

//인터페이스를 여러개 쓸 수있음
//인터페이스는 다중 상속 가능
//public class InterRadio implements InterVol, InterVol2{   //,를 기준으로 여러개 다중 상속 할 수 있음!
//public class InterRadio implements InterVol{
	public class InterRadio implements InterVol2{
	private int v = 0;
	
	//추상메소드
	public void volUp(int v) {
		this.v += v;	
	}
	
	//추상메소드
	public void volDown(int v) {
		this.v -= v;
	}
	
	//일반메소드
	public void volOff() {
		System.out.println("라디오 끄기");
	}
	
	//일반메소드
	public void volResume() {
		System.out.println("라디오 켜기");
	}
	
	public void show() {
		System.out.println("현재 볼륨은 " + v);
	}
}
