package pack5;

//추상 메소드는 강요를 할려고 만든거임
//다형성을 구사하기 위해서...

public class Jepum_Tv extends Jepum {
	public Jepum_Tv() {
		System.out.println("TV 생성자");
	}
	
	//부모의 abstract을 풀어야 함
	@Override
	public void volumeControl() {	
		System.out.println("TV 소리 조절");
	}
}
