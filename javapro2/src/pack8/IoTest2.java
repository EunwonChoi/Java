package pack8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IoTest2 {
	public static void main(String[] args) {
		// console을 통한 입력
		//방법 1
		/*
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("이름 입력: ");
			String ir = br.readLine();
			System.out.println("나이 입력: ");
			//int nai = Integer.parseInt(br.readLine());
			String nai = br.readLine();
			System.out.println("이름은 " + ir + ", 나이는 " + nai);
			br.close();
			isr.close();
			*/
		//방법2
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("이름 입력: ");
			String ir = scanner.nextLine();
			System.out.println("나이 입력: ");
			int nai = scanner.nextInt();
			System.out.println("몸무게 입력: ");
			double wei = scanner.nextDouble();
			System.out.println("이름은 " + ir + ", 나이는 " + nai + ", 몸무게는 " + wei);
			
			//파일 읽기
			//File fi = new File("c:\\work\\iotest.txt");
			//FileReader fr = new FileReader(fi);
			FileReader fr = new FileReader(new File("c:\\work\\iotest.txt"));
			BufferedReader reader = new BufferedReader(fr);
			while(true) {
				String ss = reader.readLine();
				if(ss == null) break;
				System.out.println(ss);
			}
			reader.close();
			fr.close();
			
		} catch (Exception e) {
		System.out.println("에러: " + e.getMessage());}
		
		
	}

}
