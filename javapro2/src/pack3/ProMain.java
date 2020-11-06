package pack3;

public class ProMain {
	public static void main(String[] args) {
		System.out.println("뭔짓을 하다가...");
		
		//programmer 객체를 2개 만듦(tom, oscar)
		Programmer tom = new Programmer();
		//tom.Programmer();  X
		System.out.println("tom: " + tom.spec);
		tom.displayData();
		tom.nickName = "자바도사";
		tom.displayData();
		
		tom.setAge(28);
		tom.displayData();
		System.out.println("나이는 " + tom.getAge());
		
		System.out.println(tom.moto);
		System.out.println(Programmer.moto);   //static + new로 부르지 않아도 됨 + class 이름으로 부름
		//tom.PI = 10;
		System.out.println(tom.PI);   
		System.out.println(Programmer.PI);   //final static
		
		Programmer.staticMethod();
		
		System.out.println("-----------------");
		Programmer oscar = new Programmer();
		oscar.displayData();
//		oscar = null;   //실행 오류
//		oscar.displayData();
		oscar.setAge(33);
		oscar.displayData();
		
		Programmer.staticMethod();
	}
}
