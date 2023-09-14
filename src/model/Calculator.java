package model;

import java.util.ArrayList;
import java.util.List;

public class Calculator extends BaseCalculator{
	private MathOperation currentOperation;
	private List<MathOperation> resultHistory;
	
	public Calculator() {
		this.resultHistory = new ArrayList<MathOperation>();
	}
	
	@Override
	public void add(double firstNumber, double secondNumber) {
		super.add(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.getResult(), "add"));
		this.insertResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void subtract(double firstNumber, double secondNumber) {
		super.subtract(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.getResult(), "subtract"));;
		this.insertResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void multiply(double firstNumber, double secondNumber) {
		super.multiply(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.getResult(), "multiply"));;
		this.insertResultHistory(this.getCurrentOperation());
	}
	
	@Override
	public void divide(double firstNumber, double secondNumber) {
		super.divide(firstNumber, secondNumber);
		this.setCurrentOperation(MathOperation.generate(firstNumber, secondNumber, this.getResult(), "divide"));;
		this.insertResultHistory(this.getCurrentOperation());
	}
	
	private void insertResultHistory(MathOperation operation) {
		this.getResultHistory().add(operation);
	}
	
	public List<MathOperation> getResultHistory(){
		return this.resultHistory;
	}

	public MathOperation getCurrentOperation() {
		return currentOperation;
	}

	public void setCurrentOperation(MathOperation currentOperation) {
		this.currentOperation = currentOperation;
	}

}
