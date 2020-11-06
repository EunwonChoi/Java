package pack5;

public class PolyProductMain {
	public static void main(String[] args) {
		// 다형성 연습
		PolyProduct product = null;
		
		
		//방법①
		PolyRadio radio = new PolyRadio();
		radio.setVolume(6);
		System.out.println(radio.getVolume());
		radio.volumeControl();
		
		System.out.println();
		PolyTv tv = new PolyTv();
		tv.setVolume(10);
		tv.volumeControl();
		tv.tvShow();
		
		//방법②
		System.out.println("---------다형성-------");  //답은 같지만 다양하게 출력
		product = radio;
		product.volumeControl();
		product = tv;
		product.setVolume(15);
		product.volumeControl();
		//product.tvShow(); // X
		
		//방법③
		System.out.println();
		PolyProduct[] p = new PolyProduct[2];
		p[0] = radio;
		p[1] = tv;
		for(PolyProduct abc:p) {
			abc.volumeControl();
		}
	}

}
