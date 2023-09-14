package controller;

import model.Calculator;
import view.CalculatorView;

public class Teste {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		calculator.add(2, 2);
		CalculatorView.showResult(calculator.getCurrentOperation());
		
		calculator.subtract(53, 4);
		CalculatorView.showResult(calculator.getCurrentOperation());
		
		calculator.multiply(5, 4);
		CalculatorView.showResult(calculator.getCurrentOperation());
		
		calculator.divide(8, 4);
		CalculatorView.showResult(calculator.getCurrentOperation());

		
//		for(MathOperation operation: calculator.getResultHistory()) {
//			System.out.print(operation.getFirstNumber());
//			System.out.print(" " + operation.getOperationType() + " ");
//			System.out.print(operation.getSecondNumber());
//			System.out.print(" = " + operation.getResult());
//			System.out.println("\n*****************************************");
//		}
		
		
//		CalculatorView.showCalculator();

		
	}
}
