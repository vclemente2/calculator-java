package controllers;

import java.io.IOException;
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
		CalculatorController calculatorController = new CalculatorController();
		
		boolean running = true;
		
		while(running) {
			CalculatorView.showCalculator();
			calculatorController.askInput();
			
		}
	}

	public void askInput() {
		try {
			System.out.print("Primeiro número: ");
			double firstNumber = this.input.nextDouble();
			System.out.print("Operação (+, - , * ou /): ");
			String operationSymbol = this.input.next();
			Operation operation = Operation.fromOperationSymbol(operationSymbol);
			System.out.print("Segundo número: ");
			double secondNumber = this.input.nextDouble();
			
		} catch(IllegalArgumentException e) {
			while(true){
				System.out.println("Erro: " + e.getMessage() + "\n");
				System.out.println("Pressione enter para reiniciar...");
				this.input.nextLine();
				this.input.nextLine();
				break;
			}
		} catch(InputMismatchException e) {
			while(true) {
				System.out.println("Erro: Input inválido. O valor deve ser numérico.\n");
				System.out.println("Pressione enter para reiniciar...");
				this.input.nextLine();
				this.input.nextLine();
				break;
			}
		} catch(Exception e) {
			while(true) {
				System.out.println("Erro: Erro inesperado\n");
				System.out.println("Pressione enter para reiniciar...");
				this.input.nextLine();
				this.input.nextLine();
				break;
			}
		}
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
