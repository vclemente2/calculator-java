package exceptions;

public class InvalidOperationException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public InvalidOperationException(char Symbol) {
		super("Operação não encontrada para o símbolo: " + Symbol);
	}
	
	public InvalidOperationException(String name) {
		super("Operação não encontrada para o nome: " + name);
	}
}
