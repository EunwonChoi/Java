package pack6;

public class FlyerAirPlane implements Flyer{
	
	@Override
	public void fly() {
		System.out.println("엔진소리를 힘차게 내며 구름 속으로 날아감");
	}
	
	@Override
	public boolean isAnimal() {
		return false;
	}
}
