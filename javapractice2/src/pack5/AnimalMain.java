package pack5;

public class AnimalMain {

	public static void main(String[] args) {
		AniCow cow = new AniCow();
		System.out.println(cow.callName() + " " + cow.action() + "에 " + cow.eat() + "먹음");
		cow.print();
		
		System.out.println();
		AniLine line = new AniLine();
		System.out.println(line.callName() + " " + line.action() + "에 " + line.eat() + "먹음");
		line.print();
		line.eatOther();
		
		System.out.println("--------------------");
		AnimalFind.find(cow);
		AnimalFind.find(line);
	}

}
