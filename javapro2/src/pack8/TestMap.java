package pack8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//Map 인터페이스 : 자료를 key, value 형태로 저장. 
//많은 양의 데이터인 경우 검색이 편리함
//value는 중복되어도 되지만 key는 중복되면 안됨

public class TestMap {
	public static void main(String[] args) {
	HashMap<String, String> list = new HashMap<String, String>();
	list.put("0", "lee");
	list.clear();
	list.put("1", "lee");
	list.put("2", "kim");
	list.put("3", "lee");
	list.put("4", "park");
	list.put("5", "choi");
	list.remove("3");   //key 3을 없앤것임
	System.out.println(list.size());
	System.out.println(list.containsKey("0"));
	System.out.println(list.containsValue("kim"));
	System.out.println(list);
	
	System.out.println();
	print(list);
	}
	
	public static void print(Map map) {
		Set set = map.keySet();
		Iterator iter = set.iterator();   //collection data값을 줄을 세워 받음, Iterator은 나열임
		while(iter.hasNext()) { 
			//hasNext는 물어보면서 true와 false를 구별(참인동안은 수행)
			String key = (String)iter.next();
			System.out.println("key: " + key);
			System.out.println("value: " + map.get(key));
		}
	}
}
