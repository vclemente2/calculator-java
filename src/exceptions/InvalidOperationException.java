package exceptions;

public class InvalidOperationException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidOperationException(String Symbol) {
		super("Operação não encontrada para o símbolo: " + Symbol);
	}
	
	public InvalidOperationException() {
		super("Operação não encontrada.");
	}
}
