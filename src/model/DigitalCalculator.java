package model;

import java.util.ArrayList;
import java.util.List;

public class DigitalCalculator extends Calculator{
	private List<MathOperation> resultHistory;
	
	public DigitalCalculator() {
		this.resultHistory = new ArrayList<MathOperation>();
	}
	
	@Override
	public void add(double firstNumber, double secondNumber) {
		super.add(firstNumber, secondNumber);
		this.insertResultHistory(firstNumber, secondNumber, this.getResult(), "add");
	}
	
	@Override
	public void subtract(double firstNumber, double secondNumber) {
		super.subtract(firstNumber, secondNumber);
		this.insertResultHistory(firstNumber, secondNumber, this.getResult(), "subtract");
	}
	
	@Override
	public void multiply(double firstNumber, double secondNumber) {
		super.multiply(firstNumber, secondNumber);
		this.insertResultHistory(firstNumber, secondNumber, this.getResult(), "multiply");
	}
	
	@Override
	public void divide(double firstNumber, double secondNumber) {
		super.multiply(firstNumber, secondNumber);
		this.insertResultHistory(firstNumber, secondNumber, this.getResult(), "divide");
	}
	
	private void insertResultHistory(double firstNumber, double secondNumber, double result, String operationType) {
		MathOperation result = MathOperation.generate(firstNumber, secondNumber, result, operationType);
		this.getResultHistory().add(result);
	}
	
	public List<MathOperation> getResultHistory(){
		return this.resultHistory;
	}
}
