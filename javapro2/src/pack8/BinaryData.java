package pack8;

import java.io.Serializable;

//직렬화시킴 : serializable
public class BinaryData implements Serializable{  //이진 자료 처리, 네트웍에서 자료 송수신 유용
	int i = 100;
	double d = 123.4567;
	String s1 = "korea";
	String s2 = "대한민국";
	
}
