package day5;

public class MethodLab9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isRightTriangle(3, 4, 5));
		System.out.println(isRightTriangle(1, 2, 3));
	}
	static boolean isRightTriangle(int width, int height, int hypo) {
		if(hypo*hypo == width*width + height*height) {
			return true;
		}else
			return false;
	}
}
