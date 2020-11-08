package pack8;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

public class DtoTest2 {
	
	ArrayList<HaksaengDto> list;
	
	public DtoTest2() {
		list = new ArrayList<HaksaengDto>();
	}
	
	public void inputData(String[] datas) {
		for (int i = 0; i <datas.length; i++) {
			StringTokenizer tok = new StringTokenizer(datas[i], ",");
			String irum = tok.nextToken();
			int kor = Integer.parseInt(tok.nextToken());
			int eng = Integer.parseInt(tok.nextToken());
			int mat = Integer.parseInt(tok.nextToken());
			HaksaengDto dto = new HaksaengDto();
			dto.setName(irum);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMat(mat);
			list.add(dto);
	}
	}
	
	//일반 for문
	public void dispData() {
		for (int i = 0; i < list.size(); i++) {
			HaksaengDto dto = new HaksaengDto();
			dto = list.get(i);
			int tot = dto.getKor() + dto.getEng() + dto.getMat();
			double avg = tot / 3;
			System.out.println(dto.getName() + " " + tot + " " + Math.round(avg));  //반올림
		}
		
		//향상된 for문
		System.out.println();
		for(HaksaengDto dto:list) {
			int tot = dto.getKor() + dto.getEng() + dto.getMat();
			double avg = tot / 3;
			System.out.println(dto.getName() + " " + tot + " " + Math.round(avg));  //반올림
		}
		}
	
	
	public static void main(String[] args) {
		// 문자열 분리 클래스
		String da = "kbs,mbc";
		StringTokenizer tokenizer = new StringTokenizer(da, ",");
		String s1 = tokenizer.nextToken();
		String s2 = tokenizer.nextToken();
		System.out.println(s1 + " " + s2);

		
		System.out.println("---------------------");
		String[] datas = new String[3];
		datas[0] = "공기밥,100,100,100";
		datas[1] = "김밥,80,90,88";
		datas[2] = "주먹밥,77,88,66";
		
		DtoTest2 test2 = new DtoTest2();
		test2.inputData(datas);
		test2.dispData();
		
		
		//년월일 출력
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);   //final static 써준거임
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		System.out.println("오늘은 " + year + "년" + month + "월 " + day + "일");
	}

}
