package exceptions;

public class InvalidMenuOptionExcepiton extends Exception{
	private static final long serialVersionUID = 1L;

	public InvalidMenuOptionExcepiton() {
		super("Opção inválida.");
	}
	
	public InvalidMenuOptionExcepiton(String message) {
		super(message);
	}
}
