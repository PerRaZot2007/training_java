package se026with027;

public class MainClass {

	public static void main(String[] args) {
		NuclearSubMarine sub =  new NuclearSubMarine("first", 500, 10);
		
		sub.launchSubMarine();
		sub.moveSubMarine(500);
		
		sub.diveSubMarine(200);
		sub.moveSubMarine(500);
		
		sub.tankUp(1000);
		sub.showInformation();
		sub.openFire("USA");
		sub.showInformation();
	}

}
