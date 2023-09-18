package controllers;

import java.util.InputMismatchException;
import java.util.Scanner;

import enums.MainMenuOption;
import enums.Operation;
import exceptions.InvalidMenuOptionExcepiton;
import exceptions.InvalidOperationException;
import interfaces.IVoidMethod;
import models.DigitalCalculator;
import views.CalculatorView;

public class CalculatorController{
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
			String menuOption = controller.askMainMenuInput();
			
			controller.performMenuOption(menuOption);
			
		}
	}
	
	public String askMainMenuInput() {
		while(true) {
			try {
				CalculatorView.print("Digite uma das opções do menu:");
				String option = this.input.nextLine().toLowerCase();
				
				MainMenuOption.fromOptionLetter(option);
				
				return option;
			}catch(InvalidMenuOptionExcepiton e) {
				while(true) {
					CalculatorView.printExceptionMessage(e.getMessage());
					this.askEnterToContinue();
					break;
				}
			}
		}
	}

	public String[] askOperationInput() {
		try {
			CalculatorView.print("Primeiro número: ");
			double firstNumber = Double.valueOf(this.input.nextLine()); // AQUI
			
			CalculatorView.print("Operação (+, - , * ou /): ");
			String operationSymbol = this.input.nextLine();
			Operation.fromOperationSymbol(operationSymbol);
			
			CalculatorView.print("Segundo número: ");
			double secondNumber = Double.valueOf(this.input.nextLine()); // AQUI
			
			String[] operationData = {String.valueOf(firstNumber), String.valueOf(secondNumber), operationSymbol};
			
			return operationData;
		} catch(IllegalArgumentException e) {
			while(true){
				CalculatorView.printExceptionMessage("Input inválido. O valor deve ser numérico.");
				this.askEnterToContinue();
				return null;
			}
		} catch(InputMismatchException e) {
			while(true) {
				CalculatorView.printExceptionMessage("Input inválido. O valor deve ser numérico.");
				this.askEnterToContinue();
				return null;
			}
		} catch(InvalidOperationException e) {
			CalculatorView.printExceptionMessage(e.getMessage());
			this.askEnterToContinue();
			return null;
		} catch(Exception e) {
			while(true) {
				CalculatorView.printExceptionMessage(null);
				this.askEnterToContinue();
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
	
	public void performOptionInit() {
		try {
			CalculatorView.showCalculatorMenu();
			String[] operationData = this.askOperationInput();
			this.performOperation(Double.valueOf(operationData[0]), Double.valueOf(operationData[1]), operationData[2]);
			CalculatorView.showResult(this.calculator.getCurrentOperation());
		}catch (ArithmeticException e) {
			CalculatorView.printExceptionMessage(e.getMessage());
		}catch(Exception e) {}
	}
	
	public void performOptionHistory() {
		try {
			CalculatorView.showHistoryResults(this.calculator.getResultHistory());
		}catch (Exception e) {}
	}
	
	public void executeOption(IVoidMethod method, String message) {
		while(true) {
			method.execute();
			
			if (message == null) {
				this.askEnterToContinue();
				break;
			}
			else {
				CalculatorView.print("\n" + message + "\n");	
				if(this.input.nextLine().equalsIgnoreCase("r"))
					break;					
			}

		}
	}
	
	public void performMenuOption(String menuOption) {
			switch(menuOption) {
			case "i":
				IVoidMethod methodI = new IVoidMethod() {
					@Override
					public void execute() {
						performOptionInit();
					}
				};
				this.executeOption(methodI, "Pressione (R) para retornar ao menu principal ou qualquer tecla para continuar na calculadora");
				break;
			case "h":
				IVoidMethod methodH = new IVoidMethod() {
					@Override
					public void execute() {
						performOptionHistory();
					}
				};
				this.executeOption(methodH, null);
				break;
			}
	}
	
	public void askEnterToContinue() {
		CalculatorView.print("\nPressione \"Enter\" para retornar...");
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
