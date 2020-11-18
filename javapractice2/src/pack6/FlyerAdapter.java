package pack6;


//Adapter 클래스
//여러개의 인터페이스들 중 원하는 것 한개만 오버라이드 할 수 있도록 함
//일반메소드로 쓸 수 있음
//인터페이스들을 모두 가져와야 한다는 부담을 줄일 수 있음

public abstract class FlyerAdapter implements Flyer{
	@Override
	public void fly() {
		
	}
	
	@Override
	public boolean isAnimal() {
		return false;
	}
}
