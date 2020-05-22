package week3.day1;

public class KVB extends RBI {
	public void loadInterestRate(String agri) {
		System.out.println("Rate of Interest for Personal loan - "+agri);
	}
	
	public static void main(String[] args) {
		KVB obj = new KVB();
		obj.loanInterestRate();
		obj.loadInterestRate("14%");
		obj.loanInterestRate("4.5%");
	}

}
