package controller;

import java.util.Scanner;

import model.Calculator;
import view.CalculatorView;

public class Teste {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Scanner scan = new Scanner(System.in);
		
		
		
		calculator.add(2, 2);
//		CalculatorView.showResult(calculator.getCurrentOperation());
		
		calculator.subtract(53, 4);
//		CalculatorView.showResult(calculator.getCurrentOperation());
		
		calculator.multiply(5, 4);
//		CalculatorView.showResult(calculator.getCurrentOperation());
		
//			calculator.add(scan.nextDouble(), scan.nextDouble());
//		CalculatorView.showResult(calculator.getCurrentOperation());
		
		
		CalculatorView.showHistoryResults(calculator.getResultHistory());
		
//		for(MathOperation operation: calculator.getResultHistory()) {
//			System.out.print(operation.getFirstNumber());
//			System.out.print(" " + operation.getOperationType() + " ");
//			System.out.print(operation.getSecondNumber());
//			System.out.print(" = " + operation.getResult());
//			System.out.println("\n*****************************************");
//		}
		
		
		CalculatorView.showCalculator();

		
	}
}
