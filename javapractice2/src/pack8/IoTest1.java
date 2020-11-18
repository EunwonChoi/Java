package pack8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class IoTest1 {
	public static void main(String[] args) throws Exception{
		// 1byte 단위의 입출력
		/*
		System.out.println("1byte 입력:");
		int a = System.in.read();   //char나 string으로 받을 수 없음, 예외처리 하도록 함
		System.out.println("a: " + a + " " + (char)a);
		*/
		
		OutputStreamWriter os = new OutputStreamWriter(System.out);
		/*
		byte imsi = 65;
		os.write(imsi);
		os.flush();  //buffer에서 남아있는 것을 지움
		os.close();
		*/
		
		BufferedWriter bw = new BufferedWriter(os, 1024);  //1kb단위로 저장
		PrintWriter out = new PrintWriter(bw);
		out.println(123);
		out.println("문자열 출력");
		out.close();  //자원 해제
		bw.close();
		os.close();
		System.out.println("문자열 출력");
		
		System.out.println();
		File f = new File("c:/work/iotest.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw2 = new BufferedWriter(fw, 1024);
		PrintWriter out2 = new PrintWriter(bw2);
		out2.println("날씨가 춥네");
		out2.println("내일까지");
		out2.println("견디자");
		out2.close();
		bw2.close();
		fw.close();
		
		
	}

}
