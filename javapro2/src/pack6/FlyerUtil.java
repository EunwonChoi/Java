package pack6;

public class FlyerUtil {
	public static void show(Flyer f) {   //flyer는 누구든지 치환 가능
		f.fly();
		System.out.println("동물인가요?" + f.isAnimal());
	}
}
