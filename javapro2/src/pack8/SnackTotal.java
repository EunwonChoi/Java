package pack8;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SnackTotal {
	ArrayList<Snack> list = new ArrayList<Snack>();
	
	String ji;  //지역
	int gso;  //감자깡 소계액
	int sso;  //새우깡 소계액
	int ggc; //감자깡 건수
	int ssc; //새우깡 건수
	int tot;  //총액
	
	
	public void insertData() {
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("지역 코드, 상품명, 수량을 입력해 주세요: ");
			String a = sc.next();
			StringTokenizer tok = new StringTokenizer(a, ",");
			int local = Integer.parseInt(tok.nextToken());
			String product = tok.nextToken();
			int su = Integer.parseInt(tok.nextToken());
			Snack dto = new Snack();
			dto.setLocal(local);
			dto.setProduct(product);
			dto.setSu(su);
			list.add(dto);
			System.out.println("계속할까요?(y/n)");
			String b = sc.next();
			if(b.equals("y")) {
				System.out.println();
			}else {
				break;
			}
		}
	}	

	
		
		
	public void ShowData() {
		System.out.println("지역  " + "상품명  " + "수량  " + "단가 " + "금액");
		for (Snack dto:list) {
			if(dto.getProduct().equals("감자깡")) {
				ggc++;
				gso += (dto.getSu()*300);
				if (dto.getLocal()==100) ji = "강북";
				else if(dto.getLocal()==200) ji = "강남";
				else if(dto.getLocal()==300) ji = "강서";				
				System.out.println(ji + "  " + dto.getProduct() + "  " + dto.getSu() + "  "+ 300 + dto.getSu()*300 );
			}else if(dto.getProduct().equals("새우깡")) {
				ssc++;
				sso += (dto.getSu()*450);
				if (dto.getLocal()==100) ji = "강북";
				else if(dto.getLocal()==200) ji = "강남";
				else if(dto.getLocal()==300) ji = "강서";
				System.out.println(ji + "  " + dto.getProduct() + "  " + dto.getSu() + "  "+ 450 + dto.getSu()*450 );
			}
		}
		System.out.println("소계\n" + "감자깡: " + ggc + "건" + "\t소계액: " + gso + "원" );
		System.out.println("새우깡: " + ssc + "건" + "\t소계액: " + sso + "원" );
		System.out.println("총 건수: " + list.size() + "\t총액: " + (gso+sso));
	}
	
	
	
	
	
	

	public static void main(String[] args) {
		SnackTotal test = new SnackTotal();
		test.insertData();
		test.ShowData();
	}

}
