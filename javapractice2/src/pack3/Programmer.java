package pack3;

public class Programmer {
	//public String nickName = "";
	public String nickName = "null";  //초기 값은 null (참조형)
	private int age;  //초기 값은 0
	String spec = "자바, C, 파이썬";
	
	//static, final
	public static String moto = "미치자";
	//public final double PI = 3.14;  //final을 넣으면 그 값은 수정할 수 없음(변수가 대문자이여야 함)
	public final static double PI = 3.14;
	
	public Programmer() {
		System.out.println("생성자. 생략도 가능");
		age = 20;   //생성자를 통해 private를 사용할 수 있게 함(setter로도 할 수 있음)
	}
	
	public void displayData() {
		String re = reSpeck();
		System.out.println("별명이 " + nickName + "은 " + age + "살 " + re);
	}
	
	private String reSpeck() {
		return "보유 기술은 " + spec;
	}
	
	//캡슐화
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	
	//static 메소드는 일반 메소드를 부를 수 없음
	//일반 메소드는 static 메소드를 부를 수 있음
	public static void staticMethod() {  
		//System.out.println("age: " + age);   //new를 써서 static을 불러야함(만약 static이 없으면 그냥 써도 됨)
		System.out.println("moto: " + moto);  
	}
}
