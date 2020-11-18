package pack3;

//문제풀이

public class Production {
	private String name;  //상품
	private int price;  //가격
	private String productionDay;  //생산일(2020-1-28)
	
	//생성자
	public Production() {
		//생략가능
	}
	
	//생성자로 값 입력(name)
	public Production(String name) {
		this.name = name;
	}
	
	//생성자로 값 입력(price)
	public Production(int price) {
		this.price = price;
	}
	
	//setter(productionDay)
	public void setProductionDay(String productionDay) {
		this.productionDay = productionDay;
	}
	
	//getter(productionDay)
	public String getProductionDay() {
		return productionDay;
	}
	
	//display 메소드
	public void display() {
		System.out.println("상품: " + name + ", 가격: " + price + ", 생산일: " + productionDay);
	}
	
	//오버로딩의 성립조건(시험에 나옴!)
	//display 오버로딩①
	public void display(String name) {  
		this.name = name;
		System.out.println("상품: " + name + ", 가격: " + price + ", 생산일: " + productionDay);
	}
	
	//display 오버로딩②
	public void display(String name, int price) {  
		this.name = name;
		this.price = price;
		System.out.println("상품: " + name + ", 가격: " + price + ", 생산일: " + productionDay);
	}
}
