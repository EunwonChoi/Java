package pack5;

public class DogMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		dog.print();
		System.out.println(dog.callName());
		
		System.out.println("---------------");
		HouseDog hd = new HouseDog("집개");
		hd.print();
		hd.show();
		System.out.println(hd.callName());
	
		System.out.println("---------------");
		WolfDog wd = new WolfDog("늑대");
		wd.print();
		wd.show();
		System.out.println(wd.callName());
		wd.display();
		
		System.out.println("==============");
		WolfDog bushdog = wd; //bushdog과 wd는 같은 주소를 가지고 있음
		bushdog.print();
		
		//엄청 중요해요!!
		//promotion
		System.out.println();
		Dog dog2 = wd;  //wd는 Dog의 자식임(자식의 객체를 부모의 객체에 넣어줌)
		dog2.print();  //부모의 객체 변수로 자식의 객체 변수를 부름, 호출 가능. 단, 오버라이딩된 메소드만 가능
		//dog2.display();  //자식 고유의 메소드는 호출 불가능, 불간섭의 원칙
	
		//엄청 중요해요!!
		//bushdog = dog2;  //X
		bushdog = (WolfDog)dog2;  //casting
		bushdog.print();
		
		//폴리모피즘
		//결과가 각가 다르게 나옴
		System.out.println("--------------------");
		Dog coyote = new Dog("코요태");
		coyote.print();
		coyote = bushdog;
		coyote.print();
		coyote = hd;
		coyote.print();
	}

}
