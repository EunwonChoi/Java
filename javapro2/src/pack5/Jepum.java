package pack5;

//추상 클래스
//추상 클래스는 new를 할 수 없음
//추상 클래스는 다형성을 위해 필요(부모를 위한 것)

public abstract class Jepum {
	public int volume = 0;
	
	public Jepum() {
		System.out.println("Jepum 추상 클래스 생성자");
	}
	
	abstract public void volumeControl();   //추상 메소드(abstract메소드)
	
	public void volumeShow() {
		System.out.println("소리 크기: " + volume);
	}
}
