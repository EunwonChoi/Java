package pack3;

public class ProductionMain {
	public static void main(String[] args) {
		
		Production pro = new Production();
		pro.display("우동", 5000); //생성자로 입력한 값
		pro.setProductionDay("2020-01-28");  //setter로 입력한 값
		pro.display();
		pro.display("순대");
		pro.display("떡볶이", 3500);
	}

}
