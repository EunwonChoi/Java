package pack8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

//List 인터페이스: 중복 가능, 순서 있음, 가장 많이 쓰임!!!

public class TestList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("kim");
		list.clear();  //모두 지움
		System.out.println(list.size());  //데이터 크기(collection에서는 size로 씀)
		list.add("kim");
		list.add("lee");
		list.add("park");
		list.add("kim");
		list.add("choi");
		list.remove("lee");
		list.remove(0);
		System.out.println(list.size());
		System.out.println(list);
		//System.out.println(list[0]);   // X
		System.out.println(list.get(0));  //몇번째를 불러옴
		System.out.println(list.contains("park"));
		
		print(list);
		System.out.println();
		print2(list);
	}

	//static은  static만 부를 수 있음
	//이거 잘 안쓰고 밑에 있는걸로 많이 쓰긴 함...
		public static void print(List list) {
			Iterator iter = list.iterator();   //collection data값을 줄을 세워 받음, Iterator은 나열임
			while(iter.hasNext()) { 
				//hasNext는 물어보면서 true와 false를 구별(참인동안은 수행)
				String ss = (String)iter.next();
				System.out.println(ss);
			}
		}
		
		//toArray를 써서 객체 배열을 만든 후에 for 씀
		public static void print2(List obj) {
			for(Object aa:obj) {
				System.out.println((String)aa);
			}
		}
}
