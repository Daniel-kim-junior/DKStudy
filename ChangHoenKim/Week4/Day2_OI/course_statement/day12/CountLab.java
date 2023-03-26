package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountLab {

	public static void main(String[] args) {
		File f = new File("c:/Temp/yesterday.txt");
		
		try (Scanner scan = new Scanner(f);) {
			int cnt = 0;
			String sig;
			while (scan.hasNext()) {
				sig = scan.next().toString();
				if(sig.substring(0, sig.length() - 1).equals("yesterday") || sig.equals("yesterday"))
					cnt++;
			}
			System.out.println(cnt);
		} catch (FileNotFoundException fnfe) {
			System.out.println("yesterday.txt 파일을 찾을 수 없습니다.");
		}

	}

}
