package view;

import enums.Operation;
import model.MathOperation;

public class CalculatorView {
	
	public static void showCalculator() {
		System.out.println(CalculatorView.template());
	}
	
	public static void showResult(MathOperation mathOperation) {
		Operation operation = Operation.fromOperationName(mathOperation.getOperationType());
		
		System.out.print("\n" + mathOperation.getFirstNumber());
		System.out.print(" " + operation.getOperationSymbol());
		System.out.print(" " + mathOperation.getSecondNumber() + " = ");
		System.out.println(mathOperation.getResult());
	}
	
	private static String template() {
		return "  _______________________\n"
				+ " |  7  |  8  |  9  |  +  |\n"
				+ " |_____|_____|_____|_____|\n"
				+ " |  4  |  5  |  6  |  -  |\n"
				+ " |_____|_____|_____|_____|\n"
				+ " |  1  |  2  |  3  |  *  |\n"
				+ " |_____|_____|_____|_____|\n"
				+ " |  .  |  0  |  =  |  /  |\n"
				+ " |_____|_____|_____|_____|\n"
				+ "       |  H  |  C  |\n"
				+ "       |_____|_____|\n";
	}
	
	

}
