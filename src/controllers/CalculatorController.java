package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

import enums.Operation;
import models.DigitalCalculator;
import views.CalculatorView;

public class CalculatorController {
	private DigitalCalculator calculator;
	private Scanner input;
	
	public CalculatorController() {
		this.calculator = new DigitalCalculator();
		this.input = new Scanner(System.in);
	}
	
	public static void init() {
		CalculatorController controller = new CalculatorController();
		
		boolean running = true;
		
		while(running) {
			CalculatorView.showMainMenu();
			
//			
//			switch() {
//			case
//			}
			
			CalculatorView.showCalculatorMenu();
			String[] operationData = controller.askInput();
			controller.performOperation(Double.valueOf(operationData[0]), Double.valueOf(operationData[1]), operationData[2]);
			CalculatorView.showResult(controller.calculator.getCurrentOperation());
			controller.askEnterToContinue();
			
		}
	}

	public String[] askInput() {
		try {
			CalculatorView.print("Primeiro número: ");
			double firstNumber = this.input.nextDouble();
			
			CalculatorView.print("Operação (+, - , * ou /): ");
			String operationSymbol = this.input.next();
			Operation.fromOperationSymbol(operationSymbol);
			
			CalculatorView.print("Segundo número: ");
			double secondNumber = this.input.nextDouble();
			
			String[] operationData = {String.valueOf(firstNumber), String.valueOf(secondNumber), operationSymbol};
			
			return operationData;
		} catch(IllegalArgumentException e) {
			while(true){
				CalculatorView.printExceptionMessage(e.getMessage());
				this.input.nextLine();
				this.input.nextLine();
				return null;
			}
		} catch(InputMismatchException e) {
			while(true) {
				CalculatorView.printExceptionMessage("Input inválido. O valor deve ser numérico.");
				this.input.nextLine();
				this.input.nextLine();
				return null;
			}
		} catch(Exception e) {
			while(true) {
				CalculatorView.printExceptionMessage(null);
				this.input.nextLine();
				this.input.nextLine();
				return null;
			}
		}
	}	
	

	public void performOperation(double firstNumber, double secondNumber, String operationSymbol) {
		switch(operationSymbol) {
			case "+":
				this.calculator.add(firstNumber, secondNumber);
				break;
			case "-":
				this.calculator.subtract(firstNumber, secondNumber);
				break;
			case "*":
				this.calculator.multiply(firstNumber, secondNumber);
				break;
			case "/":
				this.calculator.divide(firstNumber, secondNumber);
				break;
			default:
				while(true) {
					CalculatorView.printExceptionMessage(null);
					break;
				}
		}
	}
	
	public void askEnterToContinue() {
		CalculatorView.print("Pressione \"Enter\" para continuar...");
		this.input.nextLine();
		this.input.nextLine();
	}
	
	public DigitalCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(DigitalCalculator calculator) {
		this.calculator = calculator;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}
}
