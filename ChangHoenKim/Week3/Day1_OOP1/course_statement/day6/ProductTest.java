package day6;

class Product{
	String name;
	int balance;
	int price;
	
	Product(){
		this("듀크인형", 5, 10000);
	}
	
	Product(String name, int balance, int price){
		this.name = name;
		this.balance = balance;
		this.price = price;
	}
	
	String getName() {
		return name;
	}
	
	int getBalance() {
		return balance;
	}
	
	int getPrice() {
		return price;
	}
}
public class ProductTest {

	public static void main(String[] args) {
		Product products[] = new Product[5];
		products[0] = new Product("텀블러", 10, 10000);
		products[1] = new Product("이것이 자바다", 15, 36000);
		products[2] = new Product("필통", 20, 5000);
		products[3] = new Product("에어팟", 4, 199000);
		products[4] = new Product();
		
		for(Product obj : products)
			System.out.printf("(%s %d %,d원) \n", obj.getName(), obj.getBalance(), obj.getPrice());
	}

}
