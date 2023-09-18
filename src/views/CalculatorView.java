package views;

import java.util.Deque;
import java.util.Optional;

import enums.Operation;
import models.MathOperation;

public class CalculatorView {
	
	public static void showCalculatorMenu() {
		System.out.println(CalculatorView.calculatorTemplate());
	}
	
	public static void showMainMenu() {
		System.out.println(CalculatorView.mainMenuTemplate());
	}
	
	public static void showQuitMessage() {
		System.out.println(CalculatorView.quitTemplate());
	}
	
	public static void showResult(MathOperation mathOperation){
		Operation operation = Operation.fromOperationName(mathOperation.getOperationType());
		
		System.out.print("\n" + mathOperation.getFirstNumber());
		System.out.print(" " + operation.getOperationSymbol());
		System.out.print(" " + mathOperation.getSecondNumber() + " = ");
		System.out.println(mathOperation.getResult());
	}
	
	public static void showHistoryResults(Deque<MathOperation> resultHistory){
		resultHistory.stream().forEach(result -> showResult(result));
	}
	
	public static void printExceptionMessage(String message) {
		Optional<String> optional = Optional.ofNullable(message);
		message = optional.orElse("Erro inesperado.");
		
		System.out.println("\nErro: "+ message);
	}
	
	public static void print(String message) {
		System.out.println(message);
	}
	
	private static String mainMenuTemplate() {
		return  "  *****************************************************************************************************\n" +
	            "  |                                                                                                   |\n" +
				"  |                   		        CALCULADORA DIGITAL                                           |\n" +
	            "  |                                                                                                   |\n" +
				"  *****************************************************************************************************\n" +
				"  | Orientações:                                                                                      |\n" +
				"  | - Para iniciar a calculadora digite \"I\".                                                          |\n" +
				"  | - Para visualizar o histórico de operações digite \"H\".                                            |\n" +
				"  | - Para limpar o histórico de operações digite \"C\".                                                |\n" +
				"  | - Para encerrar o programa digite \"Q\".                                                            |\n" +
				"  *****************************************************************************************************\n" +
				"   ___________________________\n" +
				"  |   Init (I)  |  Clear (C)  |\n" +
				"  |_____________|_____________|\n" +
				"  | History (H) |   Quit (Q)  |\n" +
				"  |_____________|_____________|\n";
	}
	
	private static String calculatorTemplate() {
		return 	"  *****************************************************************************************************\n" +
				"  | Orientações:                                                                                      |\n" +
				"  | - Digite o primeiro número e tecle \"Enter\".                                                       |\n" +
				"  | - Digite o simbolo da operação (+, -, / ou *) e tecle \"Enter\".                                    |\n" +
				"  | - Digite o segundo número e tecle \"Enter\" para visualizar o resultado no terminal.                |\n" +
				"  *****************************************************************************************************\n" +
				"   _______________________\n" +
				"  |  7  |  8  |  9  |  +  |\n" +
				"  |_____|_____|_____|_____|\n" +
				"  |  4  |  5  |  6  |  -  |\n" +
				"  |_____|_____|_____|_____|\n" +
				"  |  1  |  2  |  3  |  *  |\n" +
				"  |_____|_____|_____|_____|\n" +
				"  |  .  |  0  |  ⏎  |  /  |\n" +
				"  |_____|_____|_____|_____|\n";
	}
	
	
	private static String quitTemplate() {
		return  "  *****************************************************************************************************\n" +
				"  |                                                                                                   |\n" +
				"  |                      OBRIGADO POR UTILIZAR A CALCULADORA DIGITAL. ATÉ LOGO!                       |\n" +
				"  |                                                                                                   |\n" +
				"  *****************************************************************************************************\n" +
				"  Programa Encerrado... ";
	}
	

}
