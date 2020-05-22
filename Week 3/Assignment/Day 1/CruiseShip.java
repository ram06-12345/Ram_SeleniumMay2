package week3.day1;

public class CruiseShip extends CargoShip {
	public void maximumPassengers(int a) {
		System.out.println("Maximum passengers in Thousands - "+a);

	}
	public void cruiseCategory(String category) {
		System.out.println("Cruise category - "+category);
	}
	public static void main(String[] args) {
		CruiseShip obj = new CruiseShip();
		obj.shipName();
		obj.shipBuiltYear();
		obj.cargoCapacityinTons();
		obj.maximumPassengers(50);
		obj.cruiseCategory("Ocanview");
	}
	
}