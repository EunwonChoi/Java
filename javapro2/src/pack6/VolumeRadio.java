package pack6;

public class VolumeRadio implements Volume {
	private int vollevel;
	
	public VolumeRadio() {
		vollevel = 0;
	}
	
	@Override
	public void volumeUp(int level) {
		vollevel += level;
		System.out.println("라디오 볼륨 올리면 " + vollevel);
	}
	
	@Override
	public void volumeDown(int level) {
		vollevel -= level;
		System.out.println("라디오 볼륨 내리면 " + vollevel);
	}
	
}
