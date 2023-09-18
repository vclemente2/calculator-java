package enums;

import exceptions.InvalidOperationException;

public enum Operation {
	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/");	
	
	private String operationSymbol;
	
	Operation(String operationSymbol) {
		this.operationSymbol = operationSymbol;
	}
	
	public static Operation fromOperationSymbol(String operationSymbol) {
		for(Operation operation: values()) {
			if(operation.getOperationSymbol().equals(operationSymbol)) {
				return operation;
			}
		}
		throw new InvalidOperationException(operationSymbol);
	}
	
	public static Operation fromOperationName(String operationName) {
		for(Operation operation: values()) {
			if(operation.name().equalsIgnoreCase(operationName)) {
				return operation;
			}
		}
		throw new InvalidOperationException();
	}
	
	public static boolean validadeSymbol(String symbol) {
		for(Operation operation: values()) {
			if (operation.getOperationSymbol().equals(symbol))
				return true;
		}
		return false;
	}
	
	public String getOperationSymbol() {
		return this.operationSymbol;
	}
	
}
