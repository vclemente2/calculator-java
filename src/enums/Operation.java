package enums;

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
		throw new IllegalArgumentException("Operação não encontrada para o símbolo: " + operationSymbol);
	}
	
	public static Operation fromOperationName(String operationName) {
		for(Operation operation: values()) {
			if(operation.name().equalsIgnoreCase(operationName)) {
				return operation;
			}
		}
		throw new IllegalArgumentException("Operação não encontrada para o nome: " + operationName);
	}
	
	public String getOperationSymbol() {
		return this.operationSymbol;
	}
	
}
