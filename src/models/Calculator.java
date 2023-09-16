package models;

import interfaces.ICalculator;

public abstract class Calculator implements ICalculator{
	private double result;
	
	@Override
	public void add(double firstNumber, double secondNumber) {
		this.setResult(firstNumber + secondNumber);
	};
	
	@Override
	public void subtract(double firstNumber, double secondNumber) {
		this.setResult(firstNumber - secondNumber);
	};
	
	@Override
	public void multiply(double firstNumber, double secondNumber) {
		this.setResult(firstNumber * secondNumber);
	};
	
	@Override
	public void divide(double firstNumber, double secondNumber) throws ArithmeticException{
		if (secondNumber == 0)
			throw new ArithmeticException("O divisor não pode ser zero.");
		this.setResult(firstNumber / secondNumber);
	};
	
	public double getResult() {
		return this.result;
	}

	public void setResult(double result) {
		this.result = result;
	}
}
