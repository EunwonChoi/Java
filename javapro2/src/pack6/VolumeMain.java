package pack6;

public class VolumeMain {
	public static void main(String[] args) {
		// 인터페이스로 상속
		//Volume volume = new Volume();
		Volume volume;
		
		VolumeRadio radio = new VolumeRadio();
		VolumeTv tv = new VolumeTv();
		radio.volumeUp(5);
		radio.volumeDown(2);
		tv.volumeUp(10);
		tv.volumeDown(3);
	
		System.out.println();
		volume = radio;
		volume.volumeUp(1);
		volume = tv;
		volume.volumeUp(1);
		
		System.out.println();
		Volume v[] = new Volume[2];   //array를 new함
		v[0] = radio;
		v[1] = tv;
		
		for(Volume kbs:v) {
			kbs.volumeDown(2);
		}
	}

}
