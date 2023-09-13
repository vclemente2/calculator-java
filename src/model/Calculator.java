package model;

public abstract class Calculator {
	private double result;

	public void add(double firstNumber, double secondNumber) {
		this.setResult(firstNumber + secondNumber);
	};
	
	public void subtract(double firstNumber, double secondNumber) {
		this.setResult(firstNumber - secondNumber);
	};
	
	public void multiply(double firstNumber, double secondNumber) {
		this.setResult(firstNumber * secondNumber);
	};
	
	public void divide(double firstNumber, double secondNumber) {
		this.setResult(firstNumber / secondNumber);
	};
	
	public double getResult() {
		return this.result;
	}

	public void setResult(double result) {
		this.result = result;
	}
}
