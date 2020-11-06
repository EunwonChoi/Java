package pack8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


//이거는 그냥 알아만 두세요...
//Set 인터페이스 : 중복 불가, 순서 없음

public class TestSet {
	public static void main(String[] args) {
		//HashSet<Object> list = new HashSet<Object>();
		HashSet<String> list = new HashSet<String>();
		list.add("lee");
		//list.add(1);   // Boxing:자동적으로 원하는 객체로 바꿔줌(기본형을 객체로 바꿔줌)/UnBoxing:객체를 기본형으로 바꿔줌
		//TestSet ts = new TestSet();
		//list.add(ts);
		list.add("kim");
		list.add("lee");
		list.add("park");
		list.add("choi");
		System.out.println(list.size());   // 중복을 허용하지 않음
		list.remove("kim");
		System.out.println(list.size());
		System.out.println(list);
		System.out.println(list.toString());   //주소가 나오지 않음
		//System.out.println(lsit[0]);   // X
		
		
		print(list);
		print2(list.toArray());
	}
	//static은  static만 부를 수 있음
	public static void print(Set set) {
		Iterator iter = set.iterator();   //collection data값을 줄을 세워 받음, Iterator은 나열임
		while(iter.hasNext()) { 
			//hasNext는 물어보면서 true와 false를 구별(참인동안은 수행)
			String ss = (String)iter.next();
			System.out.println(ss);
		}
	}
	
	//toArray를 써서 객체 배열을 만든 후에 for 씀
	public static void print2(Object[] obj) {
		int count = obj.length;
		for(int i = 0; i < count; i++) {
			System.out.println(obj[i]);
		}
		for(Object aa:obj) {
			System.out.println((String)aa);
		}
	}
}
