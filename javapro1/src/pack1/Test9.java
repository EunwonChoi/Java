package pack1;

public class Test9 {

	public static void main(String[] args) {
		//배열은 while에서안되고 for에서 쓰인다
		//for에서 조건이 참일때만 수행
		//반복문 for
		int a;
		int sum = 0;
		
		//for(a=1 ; a<=5 ; a++ )
		for(a=1 ; a<=10 ; a++ ) { //for(초기치, 목적치, 증감치) { 수행문... }
			System.out.print(a + "\t");
			sum += a;  //누적
			//a = 7; X->for 안에서 변수 값을 건드리면 안됨
		}
		System.out.println("\nfor 탈출 후 a는 " + a);
		System.out.println("합은" + sum);
		
		
		
		System.out.println();
		for (int i=65 ; i<=90 ; i++) {
			System.out.print((char)i + " ");
		}
		
		
		System.out.println();
		for (int i='A' ; i<='Z'; i++) {
			System.out.print(i + " ");
		}
		
		
		System.out.println();
		for(int i=10 ; i>1 ; i-=2) {
			System.out.print(i + " ");
		}
		
		
		System.out.println();
		for(int ytn=0, tvn=5; ytn<=5; ytn++, tvn++) {
			System.out.println(ytn + " " + tvn);
		}
		
		
		System.out.println();
		int aa = 1;
		for(; aa<=5 ; aa++) {
			System.out.print(aa + " ");
		}
		
		
		
		
		System.out.println();
		//문제1) 키보드로부터 숫자를 입력받아(2 ~ 9사이만 허용) 구구단 출력
		// 2 * 1 = 2 ....
		
		//문제2) 1 ~ 100 사이의 숫자 중 3의 배수이면서 5의 배수의 갯수와 그들의 합은?
		
		
		System.out.println("문제1");  //나중에 scanner 넣어서 다시 한 번 해보기(단을 입력시 그 단에 대해 출력)
		for (int i=2; i<=9; i++) {
			for(int j=1 ; j<=9; j++) {
				System.out.println(i + "*" + j + "=" + i*j);
			}
		}
		
		System.out.println("문제2");
		int hap = 0;   //지역 변수는 0으로 초기화(무조건 초기화값을 설정 해 주는 것이 좋음)
		int cnt = 0;
		for(int i=1; i<=100; i++) {
			if(i%3==0 && i%5==0) {
				cnt += 1;
				hap += i;
			}
		}
		System.out.println("개수:" + cnt + "합:" + hap);
		
	}

}
