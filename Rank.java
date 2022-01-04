public class Rank {
	private int rank;
	
	Rank(){
		rank = 1;
	}
	
	public int getPlacement() {
		return rank;
	}
	
	public void incrementPlacement() {
		rank++;
	}
}
