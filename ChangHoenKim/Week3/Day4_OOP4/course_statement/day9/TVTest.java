package day9;

public class TVTest {

	public static void main(String[] args) {
		TV sale = new SaleTV(300000, "SALETV-1", 40, 1);
		TV rental = new RentalTV(100000, "RENTALTV-10", 42, 1);

		int sNum = 2;
		int rNum = 3;

		for (int i = 0; i < sNum; i++) {
			sale.channelUp();
		}

		for (int i = 0; i < rNum; i++) {
			rental.channelDown();
		}

		printAllTV(sale);
		System.out.println();

		printAllTV(rental);
		System.out.println();

		printRentalTV((Rentable) rental);
	}

	static void printAllTV(TV tv) {
		System.out.printf("%s", tv.toString());
		if (tv instanceof SaleTV) {
			((SaleTV) tv).play();
			((SaleTV) tv).sale();
		} else {
			((RentalTV) tv).play();
		}
	}

	static void printRentalTV(Rentable tv) {
		tv.rent();
	}

}
