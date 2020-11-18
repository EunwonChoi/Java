package etc_pack;

import pack3.Bank;  //다른 package에서 Bank 클래스 불러옴
//import pack3.*; //pack3에 있는 클래스를 모두 불러옴(권장하지는 않음)

public class BankMain2 {

	public static void main(String[] args) {
		// Bank 클래스 package와 다른 package에서 Bank 클래스 호출
		Bank john = new Bank();
		//System.out.println(john.imsi);  //default라 안보임
		System.out.println(john.imsi2);  //public
		System.out.println(john.getMoney());
		
	}

}
