package day6;

class Book{
	String title;
	String author;
	int price;
	
	Book(){
		this("이것이 자바다", "신용권, 임경균", 36000);
	}
	
	Book(String title, String author, int price){
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	String getBookInfo(){
		return title + " " + author + " "+ price;
	}
}

public class BookTest {

	public static void main(String[] args) {
		Book books[] = new Book[5];
		
		books[0] = new Book("데미안","헤르만 헤세", 8000);
		books[1] = new Book("수레바퀴 아래에서","헤르만 헤세", 7000);
		books[2] = new Book("햄릿","셰익스피어", 13000);
		books[3] = new Book("카르마조프의 형제들","도스토예프스키", 12000);
		books[4] = new Book();
		
		for(Book obj : books)
			System.out.println(obj.getBookInfo());
	}

}
