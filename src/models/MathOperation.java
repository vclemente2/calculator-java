package models;

public class MathOperation {
	private double firstNumber;
	private double secondNumber;
	private double result;
	private String operationType;
	
	public MathOperation(double firstNumber, double secondNumber, double result, String operationType) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.result = result;
		this.operationType = operationType;
	}

	public static MathOperation generate(double firstNumber, double secondNumber, double result, String operationType) {
		return new MathOperation(firstNumber, secondNumber, result, operationType);
	}

	public double getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public double getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(double secondNumber) {
		this.secondNumber = secondNumber;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	
}
