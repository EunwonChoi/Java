package pack1;

import java.util.Scanner;

public class Test11 {

	public static void main(String[] args) {
		// 반복문 while(반복문이 불특정할때 쓰임)
		// while안에는 반드시 블록을 나가기 위해 탈출문이 필요!
		// 중요!!
		
		int w = 1;
		while(w <= 5) {
			System.out.print("w:" + w + " ");  //여기서 끝내면 무한루프에 빠짐
			w++;  //반복문 탈출 문장이 반드시 필요
		}
		System.out.println("\n반복문 탈출 후 w:"+ w);
		
		
		System.out.println();
		w = 0;
		while(true) {
			++w;
			if(w == 10) break;
			if(w == 5) continue;
			System.out.print("w =" + w +" ");
		}
		System.out.println();
		
		//do는 일단 한번 수행해보고 조건이 만족하면 while를 돌게 함
		w = 10;
		do {
			System.out.println("w=" + w + " ");
			w++;
		}while(w <= 5); //현재 while을 수행하지 않고 탈출하게 됨...
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("---------문제 풀이-----------");
		//문제1) 1~100 사이의 숫자 중 3의 배수이나 2의 배수가 아닌 수를 출력하고 합과 갯수도 출력(for x)
		System.out.println("문제1");
		int i = 0;
		int hap = 0;
		int cnt = 0;
		while(i < 100) {
			i++;
			if(i%3==0) continue;
			if(i%2==0) continue;
			cnt +=1;
			hap +=i;
			System.out.println(i);
		}
		System.out.println("합: " + hap + "\t개수: " + cnt);
	
		
		//문제2) -1, 3, -5, 7, -9, 11 ~ 99까지의 합
		System.out.println();
		System.out.println("문제2");
		
		int aa=0;
		int bb=0;
		int a=1;
		int b=3;
		while(a<100) {
			a += 4;
			aa += a;
		}
		while(b<100) {
			b += 4;
			bb += b;
		}
		System.out.println(-aa + bb);
		
//		int j = 1;
//		int hap2 = 0;
//		while(j < 100) {
//			j++;
//			hap2 += j;
//		}
//		System.out.println("-1~99까지의 합:" + hap2);
		
		//문제3) 1 ~ 1000 사이의 소수와 그 갯수를 출력
		//소수 : 1보다 크고 1과 그 수 자체로만 나누어 떨어지는 수 
		//방법1 : while
		//방법2 : for
		System.out.println();
		System.out.println("문제3-1");
		int k = 1;
		int k2 = 0;
		
		while(k < 1001) {
			k++;
			if(2<k && k%2==0)continue;
			if(3<k && k%3==0)continue;
			if(5<k && k%5==0)continue;
			if(7<k && k%7==0)continue;
			System.out.println(k);
			k2 += 1;
		}
		System.out.println("개수:" + k2 );
		
		System.out.println();
//		System.out.println("문제3-2");
//		int f,g;
//		
//		for(f=2; f<=1000; f++) {
//			for(g=2 ; g<=1000; g++) {
//				
//			}
//		}
//		
		
		
		//문제4)
		/*
		 	AA
		   ABBA
		  ABCCBA
		 ABCDDCBA
		ABCDEEDCBA
		 ABCDDCBA
		  ABCCBA
		   ABBA
		    AA
		 */
		
		System.out.println();
		System.out.println("문제4");
		
		
		for(int ii=0; ii<5; ii++) {
			for(int jj=4-ii; jj>0; jj--) {
				System.out.print(" ");
			}
			for(char jj=0; jj<=ii*2+1; jj++) {
				System.out.print((char)65);
			}
			System.out.println();
		}
		
		
		System.out.println();
		System.out.println("문제3-2");
		
		 
		//문제5) 키보드로 숫자 입력 : 5
		// 그러면 5까지의 합 출력
		// 계속할까요?(y/n)  묻게 하고 y면 다시 키보드로 정수 받아 합 출력하고 n이면 탈출
	
		
		System.out.println();
		System.out.println("문제5");
		
		int su;
		int plus = 0;
		int y = 0;
		Scanner sc = new Scanner(System.in);
		
		while (true) { 
			System.out.println("숫자 입력:");
			su = sc.nextInt();
			if(su > 0) {
				while(su > 0) {
					plus += su;
					su -= 1;
				}
				System.out.println("합:" + plus + "\n계속할까요?(yes=1, no=2)");
				y = sc.nextInt();
				su = 0;
				plus = 0;
				if(y==1) {
					while(su > 0) {
						System.out.println();
					}
				}else if(y==2) {
					break;
				}
			}

		}
		System.out.println("종료");
	}
}
