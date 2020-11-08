package pack2;

public class ArrTest1 {

	public static void main(String[] args) {
		// 배열(Array) : 성격과 크기가 일치하는 여러 개의 기억장소에 대해 대표명을 주고 첨자로 각 기억장소를 구분
		// 반복처리가 효과적
		//int[] ar;  //위랑 아래랑 같음
//		int ar[];
//		ar = new int[5]; //배열 기억장소를 확보
//		System.out.println("ar의 크기: " + ar.length);
		
		//1차원 배열
		int ar[] = new int[5];  //크기 지정
		System.out.println("ar의 크기: " + ar.length);
		ar[0] = 10; ar[1] = 20; ar[4] = ar[0] + ar[1];  //열첨자(index)로 기억장소를 구분
		System.out.println("ar[4]: " + ar[4]);
		System.out.println("ar[3]: " + ar[3]);   //아무것도 넣지 않은 곳에는 기본적으로 0임
		//System.out.println("ar[5]: " + ar[5]);   //error //ArrayIndexOutOfBoundsException -> 선언하지 않은 첨자를 사용하면 이 메세지가 뜸

		int a = 4, b = 4;
		System.out.println(ar[4] + " " + ar[a] + " " + ar[b] + " " + ar[1+3]);  //다 같은 기억장소임
		
		
		System.out.println("-----------------------------------------");
		
		int[] ar1 = {1,2,3,4,5};  //배열 선언 및 초기값 기억
		
		//방법1
		//System.out.println(ar1[0]);
		for(int i = 0; i < ar1.length; i++) {   //length는 배열의 크기
			//System.out.println(i);
			System.out.print(ar1[i] + " ");
		}
		
		//방법2-1
		System.out.println();
		for(int no:ar1) {  //향상된 for문 : 객체 자료를 출력시 사용이 가능
			System.out.print(no + " ");
		}
		
		//방법2-2
		System.out.println();
		String[] city = {"서울", "인천", "수원", "안산", "성남"};
		//System.out.println(city[0]);
		for(String c:city) {
			System.out.println("도시명 : " + c);
		}
		
		
		System.out.println("-------------------------------");
		
		int[] ar2 = new int[5];
		for(int i = 0; i <ar2.length; i++) {
			ar2[i] = i + 1;
		}
		
		//위와 아래의 i는 다른거임
		int tot = 0;
		for(int i = 0; i <ar2.length; i++) {
			System.out.print(ar2[i] + " " );
			tot += i;
	}
		System.out.println("tot: " + tot); //합을 구함

		
		System.out.println("------------------다차원 배열-------------------");
		//int su[] = new int[12];
		int su[][] = new int[3][4];  //2차원 배열 - 행, 열
		System.out.println(su.length + " " + su[0].length);  //행의 갯수 , 열의 갯수
		su[0][0] = 100;
		//System.out.println(su[0][0]);
		int num = 10;
		for(int i = 0 ; i < su.length; i++) {
			for(int j = 0; j < su[i].length; j++) {
				//System.out.println("i: " + i + ", j: " + j);
				su[i][j] = num++;
				
			}
		}
		System.out.println(su[0][0]);
		for(int m = 0 ; m < 3; m++) {
			for(int n = 0; n < 4; n++) {
				System.out.print(su[m][n] + " ");
			}
			System.out.println();
		}
		
		
		System.out.println("------------------가변 배열(처음부터 고정되어 있지 않음)--------------------");
		//가변배열은 잘 나오지 않음
		int [][] scores = new int[2][];
		scores[0] = new int[2];
		scores[1] = new int[3];
		System.out.println(scores.length + " " + scores[0].length + " " + scores[1].length);
		
		System.out.println();
		int[][] jum = {{90, 96}, {89, 87, 85}};
		for(int i = 0; i < jum.length; i++) {
			for(int j = 0 ; j < jum[i].length; j++) {
				System.out.print(jum[i][j] + " ");
			}
			System.out.println();
		}
		
		
		
		
}
}