package day12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutLab {

	public static void main(String[] args) {
		String path = "C:/Temp";
		File isDir = new File(path);
		if (!isDir.exists()) {
			isDir.mkdirs();
		}
		try (FileWriter writer = new FileWriter("c:/Temp/event.txt");) {
			writer.write("2023년 5월 5일은 금요일입니다.\n");
			writer.write("2023년 6월 6일은 화요일입니다.");
			
			System.out.println("저장이 완료되었습니다.");
		} catch (IOException ioe) {
			System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
		}
	}

}
