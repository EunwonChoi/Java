package pack1;

public class Test10 {

	public static void main(String[] args) {
		// 다중 for, etc
		for(int m = 1; m <= 3; m++) {
			System.out.println("m:" + m);
			for(int a = 1 ; a <=4; a++) {
				System.out.print("a=" + a + " ");
			}
			System.out.println("--------------");
		}
		
		
		System.out.println();
		for(char i = 65 ; i <= 90; i++) {
			System.out.print(i + " : ");
			for(char j = i ; j <= 'Z'; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		
		System.out.println();
		//continue, break(반복문에서 이용)
		for(int aa = 1; aa <= 10 ; aa++) {
			if(aa == 3)
				continue; //for 블록 내에서 다시 for문으로 올라감(aa가 3일때는 찍지 않는다는 뜻) -> 건너뛴다는 뜻인가...
			System.out.println(aa);
			//if(aa == 5)
				//System.exit(0); -> 현재 위치에서 무조건 응용 프로그램을 끝냄
			//if(aa == 5)
				//return; //main블록을 만나면서 끝냄(응용 프로그램을 끝냄) + method의 탈출(중요...)
			if(aa == 5)
				break; //무조건 for문 탈출(그래서 5밑에 nice라고 찍지 못함) 
			System.out.println("nice");
		}
		
		
		
		//여기서부터는 참고만 하세요
		System.out.println("------------------------");
		//무한루프에 빠짐(하지만 break가 있으면 무한루프가 끝남)(권장하지 않은 문법)
		int kk = 0;
		for(;;) {
			kk++;
			System.out.println("출력");
			if(kk == 5)
				break;
		}
		
		
		System.out.println();
		System.out.println("label이 있는 경우");  //label은 kbs임(권장하지 않은 문법)
		kbs:for(int i=1 ; i<=3 ; i++) {
			mbc:for(int j=1 ; j<=5 ; j++) {
				System.out.print(i + " " + j + " ");
				if(j == 3) continue kbs; //continue하고 kbs로 감
				if(j ==3 ) break kbs;
			}
			System.out.println("^^^^^^");
		}
		
		System.out.println("프로그램 종료");

	}

}
