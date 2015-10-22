package by.grodno.rmd.training.SE03;


public class MainClass2 {

	public static void main(String[] args) {
		
		NewbiePack np = new NewbiePack();
		
		//np.createNewbiePack();

		np.addStationery(new Pen(30));
		np.addStationery(new Scissors(20));
		np.addStationery(new Scissors(27));
		np.addStationery(new Pen(14));
		np.addStationery(new Pencil(29));
		np.addStationery(new Scissors(13));
		
		System.out.println("unsorted");
		np.showAllStationeries();
		
		
		np.sortByPriceandType();
		System.out.println("sorted");
		np.showAllStationeries();
		
	}
}