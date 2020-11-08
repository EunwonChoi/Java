package pack8;

import java.util.ArrayList;

//중요중요!!

public class DtoTest {
	ArrayList<StudentDto> list = new ArrayList<StudentDto>(); //여러개의 student 객체를 담아둠
	
	public void aa() {
		String[] persons = new String[3];
		persons[0] = "홍길동";
		persons[1] = "고길동";
		persons[2] = "나길동";
		for(String s:persons) {
			System.out.println(s);
		}
	}
	
	public void insertData() {
		//학번, 이름, 점수를 레코드 단위로 입력 후 기억
		//나중에 for문으로 돌려서 넣기로 함
		StudentDto dto = null;
		
		dto = new StudentDto();   //dto : 덮어쓰기가 됨
		dto.setHakbun("ks1");
		dto.setIrum("홍길동");
		dto.setJumsu(90);
		list.add(dto);  //첫번째 학생 자료 기억
		
		dto = new StudentDto();
		dto.setHakbun("ks2");
		dto.setIrum("고길동");
		dto.setJumsu(80);
		list.add(dto);  //두번째 학생 자료 기억
		
		dto = new StudentDto();
		dto.setHakbun("ks3");
		dto.setIrum("신길동");
		dto.setJumsu(70);
		list.add(dto);  //세번째 학생 자료 기억
	}
	
	public void ShowData() {
		System.out.println("학생 수는 " + list.size() + "명");
		for (int i = 0; i < list.size(); i++) {
			StudentDto dto = new StudentDto();   //record타입으로 저장하고 받음
			dto = list.get(i);   //한명씩 나옴
			//System.out.println(dto);  //주소 나옴
			System.out.println(dto.getHakbun() + " " + dto.getIrum() + " " + dto.getJumsu());
		}
	}
	
	public static void main(String[] args) {
		//엄청 중요!
		//DTO 연습 : 레코드형 기억장소
		//데이타의 성격과 크기가 모두 다르지만 하나로 묶어서 사용(클래스로 묶음)
		DtoTest test = new DtoTest();
		test.aa();
		test.insertData();
		//System.out.println(test.list.size());   //3
		test.ShowData();
	}

}
