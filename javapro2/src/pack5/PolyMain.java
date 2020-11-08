package pack5;

public class PolyMain {
	public static void main(String[] args) {
		PolyCar car1 = new PolyCar();
		car1.dispData();
		
		System.out.println();
		PolyBus bus1 = new PolyBus();
		bus1.dispData();
		bus1.show();
		
		System.out.println();
		PolyTaxi taxi1 = new PolyTaxi();
		taxi1.dispData();
		taxi1.show();
		
		//여기서부터는 중요한 부분이에여!!!
		System.out.println("---------------------");
		PolyCar car2 = new PolyBus();   //부모인 polycar의 car2에 polybus를 넣어줌(promotion)
		car2.dispData();
		System.out.println(car2.getSpeed());
		//car2.show()  // X
		
		System.out.println();
		PolyCar car3 = new PolyTaxi();   //promotion
		car3.dispData();
		
		System.out.println("--------------------");
		//PolyBus bus2 = new PolyCar();  //X 자식의 객체에 부모의 객체를 넣을 수 없음
		PolyBus bus2 = (PolyBus)car2;  //car2가 부모타입이긴 하지만 polybus값을 가지고 있는 car2에 polybus를 넣을 수 있음(대신 cast이용!)
		bus2.dispData();
		bus2.show();  // show가 원래는 나오지 않았지만 cast를 하고 나면 됨!
		
		System.out.println();
		//PolyTaxi taxi2 = new PolyCar();  //X
		PolyTaxi taxi2 = (PolyTaxi)car3;   //O
		//PolyTaxi taxi3 = (PolyTaxi)car1;   //문법상에서는 error가 없으나 실행시키면 error가 생김(ClassCastException : 실행오류)
		
		
		
		//중요중ㅇ......
		System.out.println("*************");
		PolyCar p[] = new PolyCar[3];   //3개짜리의 배열을 만듦
		p[0] = car1;
		p[1] = bus1;
		p[2] = taxi1;
		
		//방법①
		for (int i = 0; i < p.length; i++) {
			p[i].dispData();
		}
		
		//방법② + 다른 방법으로 같은 답이 나옴(다형성)
		System.out.println();
		for(PolyCar car:p) {
			car.dispData();
		}
		
	}
}
