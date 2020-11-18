package pack6;

public class FlyerMain {

	public static void main(String[] args) {
		System.out.println(Flyer.FAST);
		
		FlyerBird bird = new FlyerBird();
		bird.fly();
		FlyerAirPlane airplane = new FlyerAirPlane();
		airplane.fly();
		
		//다형성임
		//callbyreference
		System.out.println();
		FlyerUtil.show(bird);
		FlyerUtil.show(airplane);
	}

}
