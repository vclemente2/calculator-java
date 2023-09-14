package model;

public abstract class BaseCalculator {
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
	
	public void divide(double firstNumber, double secondNumber) throws ArithmeticException{
		try{
			this.setResult(firstNumber / secondNumber);
		} catch(ArithmeticException exception) {
			throw new ArithmeticException("O divisor não pode ser zero.");
		}
	};
	
	public double getResult() {
		return this.result;
	}

	public void setResult(double result) {
		this.result = result;
	}
}
