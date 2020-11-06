package pack6;

public class VolumeTv implements Volume {
	
private int vollevel;
	
	public VolumeTv() {
		vollevel = 0;
	}
	
	@Override
	public void volumeUp(int level) {
		vollevel += level;
		System.out.println("TV 볼륨 올리면 " + vollevel);
	}
	
	@Override
	public void volumeDown(int level) {
		vollevel -= level;
		System.out.println("TV 볼륨 내리면 " + vollevel);
	}
}
