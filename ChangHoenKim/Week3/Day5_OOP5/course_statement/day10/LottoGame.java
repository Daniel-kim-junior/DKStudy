package day10;

public class LottoGame {
	public static void main(String[] args) throws DuplicateException {
		LottoMachine machine = new LottoMachine();
		machine.createLottoNums();
//		machine.checkLottoNums();
		
		try {
			machine.checkLottoNums();
			day5.MethodTest9.printArray(machine.getNums());
		}catch(DuplicateException e) {
			System.out.println(e.getMessage());
		}
//		day5.MethodTest9.printArray(machine.getNums());
	}

}
