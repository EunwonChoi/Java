package pack5;

public class AnimalFind {
	public static void find(Animal animal) {
		animal.print();
		
		//instanceof : 객체 타입 비교 연산자
		if(animal instanceof AniCow) {
			Animal a = animal;
			System.out.println("이름: " + a.callName());
		}else if(animal instanceof AniLine) {
			System.out.println("이름: " + animal.callName());
		}else {
			System.out.println("소도 사자도 아닌 동물");
		}
	}
}
