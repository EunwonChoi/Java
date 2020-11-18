package pack8;

import java.io.FileNotFoundException;
import java.io.FileReader;

//예외처리 : 외부장치(키보드, 파일, DB, 네트워크 등)와 연결해 작업 시 반드시 기술. 그 외는 선택적으로 기술
public class TryTest {
	
	//지역 우선으로 지역에서 문제가 생기면 이곳에서 에러가 생기고 끝남
	public void Test() {
		try {
			int a[] = {1,2,3};
			System.out.println("배열 값: " + a[0]);   //통과
			//System.out.println("배열 값: " + a[5]);    //에러			
		} catch (Exception e) {
			System.out.println("허걱 에러: " + e);
		}
		
	}
	
	//public static void main(String[] args) throws Exception{    //throws Exception은 좋은 방법이 아님
		public static void main(String[] args) {
		//FileReader fr = new FileReader("c:/work/aa.txt");   //유닉스방식
		
			try {
				FileReader fr = new FileReader("c:\\work\\aa.txt");   //윈도우방식	
				
				int re = 10 / 2;
				System.out.println("re : " + re);
				
				//TryTest tt = null;  //에러
				TryTest tt = new TryTest();  //통과
				tt.Test();
				
				/*
				//exception의 서브 클래스들...
			}catch(FileNotFoundException e) {
				System.out.println("파일 오류");
			}catch(ArithmeticException e) {
				e.printStackTrace();   //에러 메세지를 볼 수 있음
				System.out.println("나누기 에러" + e.getMessage());   //에러 메세지를 볼 수 있음
			}catch(NullPointerException e) {
				System.out.println("객체 오류: " + e);
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열 참조 오류: " + e);
			}
			*/
			}catch(Exception e) {
				System.out.println("오류: " + e);   //모든 에러 메세지를 다 받음
			}
			System.out.println("종료");
	}
}

