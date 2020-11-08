package pack3;

public class MyMain {

	public static void main(String[] args) {
		//응용 프로그램이 시작
		//int kbs = 9;
		//System.out.println("kbs: " + kbs);

		Car mycar1 = new Car();  //객체가 만들어짐(생성자 반드시 호출)
		//Car mycar1 = null;
		System.out.println(mycar1);  //pack3.Car@7d6f77cc <- 주소가 찍힘 		
		System.out.println(mycar1.wheel);  //속성을 찍음(멤버필드)
		mycar1.abc(); //행위를 찍음(메소드)
		//mycar1.airBag;   //private 멤버 이므로 접근 불가
		int air = mycar1.getAirBag();
		System.out.println("air: " + air);
		System.out.println("air: " + mycar1.getAirBag());
		mycar1.setAirBag(123, 4);
		System.out.println("air: " + mycar1.getAirBag());
	}

}
