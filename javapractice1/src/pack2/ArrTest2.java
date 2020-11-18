package pack2;

import java.util.Scanner;

public class ArrTest2 {

	public static void main(String[] args) {
		// 연습1 : 분산, 표준편차 구하기
		
		int arr[] = {1,3,-2,4};
		
		double sum = 0;
		for (int i = 0 ; i < arr.length; i++) {
			sum += arr[i];  //배열 요소의 합
		}
		System.out.println("합은 " + sum);
		double avg = sum / arr.length;
		System.out.println("평균은 " + avg);
		
		double tot = 0.0;
		for (int su = 0; su < arr.length; su++) {
			tot += Math.pow(arr[su] - avg, 2);  //제곱
		}
		double dev = tot / arr.length;
		System.out.println("분산은 " + dev);
		
		double sd = Math.sqrt(dev);
		System.out.println("표준편차는 " + sd);
		
		
		System.out.println("----------------------------------");
		//연습2 : 키보드로 5개의 점수를 입력받아 등수 구하기
		Scanner sc = new Scanner(System.in);
		
		int[] score = new int[5];  //점수
		int[] rank = new int[5];  //등수
		int index = 0;
		
		for(int i = 0 ; i < score.length; i++) {
			System.out.println(i + 1 +"번 점수 입력:");
			score[i] = sc.nextInt();
			rank[i] = 1;
		}
		for(int i = 0 ; i < score.length; i++) {
			System.out.print(score[i] + " ");  //50 70 90 80 60
		}
		System.out.println();
		for (int i = 0; i < score.length; i++) {  //점수들을 비교
			for (int j = 0; j < score.length; j++) {
				index = score[i];
				if(score[j] > index)
					rank[i] += 1;
			}
		}
		System.out.println("결과는 ");
		for (int i = 0; i < rank.length; i++) {
			System.out.println(score[i] + "점은 " + rank[i] + "등");
		}
	}

}
