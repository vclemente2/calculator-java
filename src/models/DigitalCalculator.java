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
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.round(this.getResult()), "add"));
		this.insertInResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void subtract(double firstNumber, double secondNumber) {
		super.subtract(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.round(this.getResult()), "subtract"));
		this.insertInResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void multiply(double firstNumber, double secondNumber) {
		super.multiply(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.round(this.getResult()), "multiply"));
		this.insertInResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void divide(double firstNumber, double secondNumber) throws ArithmeticException{
		try {
			super.divide(firstNumber, secondNumber);
			this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.round(this.getResult()), "divide"));
			this.insertInResultHistory(this.getCurrentOperation());
		} catch(ArithmeticException e) {
			throw e;
		}
	}
	
	public void clearResultHistory() {
		this.getResultHistory().removeAll(getResultHistory());
	}
	
	private double round(double number) {
		return Math.round(number * 1000.0) / 1000.0;
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
