package day12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CopyLab {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		int yearNum = ld.getYear();
		int monthNum = ld.getMonthValue();
		int dateNum = ld.getDayOfMonth();
		String f = "C:/iotest/sample_" + yearNum + "_" + monthNum + "_" + dateNum + ".txt";

		try (FileWriter writer = new FileWriter(f, true);
				FileReader reader = new FileReader("c:/Temp/sample.txt")) {
			while (true) {
				int data = reader.read();
				if (data == -1)
					break;
				char ch = (char) data;
				writer.write(ch);

			}
			System.out.println("저장 완료되었습니다.");
		} catch (FileNotFoundException fnfe) {
			System.out.println("sample.txt 파일을 찾을 수 없습니다.");
		} catch (IOException ioe) {
			System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
		}

	}

}
