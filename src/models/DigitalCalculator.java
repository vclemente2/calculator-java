package models;

import java.util.ArrayDeque;
import java.util.Deque;

public class DigitalCalculator extends Calculator{
	private MathOperation currentOperation;
	private Deque<MathOperation> resultHistory;
	
	public DigitalCalculator() {
		this.resultHistory = new ArrayDeque<MathOperation>();
	}
	
	@Override
	public void add(double firstNumber, double secondNumber) {
		super.add(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.getResult(), "add"));
		this.insertInResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void subtract(double firstNumber, double secondNumber) {
		super.subtract(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.getResult(), "subtract"));
		this.insertInResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void multiply(double firstNumber, double secondNumber) {
		super.multiply(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.getResult(), "multiply"));
		this.insertInResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void divide(double firstNumber, double secondNumber) throws ArithmeticException{
		try {
			super.divide(firstNumber, secondNumber);
			this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.getResult(), "divide"));
			this.insertInResultHistory(this.getCurrentOperation());
		} catch(ArithmeticException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch(Exception e) {
			System.out.println("Erro: Erro inesperado, favor refaça a operação.");
		}
	}
	
	private void insertInResultHistory(MathOperation operation) {
		this.getResultHistory().push(operation);
	}
	
	public Deque<MathOperation> getResultHistory(){
		return this.resultHistory;
	}

	public MathOperation getCurrentOperation() {
		return currentOperation;
	}

	public void setCurrentOperation(MathOperation currentOperation) {
		this.currentOperation = currentOperation;
	}

}