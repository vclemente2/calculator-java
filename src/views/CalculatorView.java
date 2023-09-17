package views;

import java.util.Deque;

import enums.Operation;
import models.MathOperation;

public class CalculatorView {
	
	public static void showCalculator() {
		System.out.print(CalculatorView.usageOrientation());
		System.out.println(CalculatorView.template());
	}
	
	public static void showResult(MathOperation mathOperation) {
		Operation operation = Operation.fromOperationName(mathOperation.getOperationType());
		
		System.out.print("\n" + mathOperation.getFirstNumber());
		System.out.print(" " + operation.getOperationSymbol());
		System.out.print(" " + mathOperation.getSecondNumber() + " = ");
		System.out.println(mathOperation.getResult());
	}
	
	public static void showHistoryResults(Deque<MathOperation> resultHistory) {
		for(MathOperation mathOperation: resultHistory) {
			showResult(mathOperation);
		}
	}
	
	private static String usageOrientation() {
		return  "  *****************************************************************************************************\n" +
	            "  |                                                                                                   |\n" +
				"  |                   		        CALCULADORA DIGITAL                                           |\n" +
	            "  |                                                                                                   |\n" +
				"  *****************************************************************************************************\n" +
				"  | Orientações:                                                                                      |\n" +
				"  | - Digite o primeiro número e tecle \"Enter\"                                                        |\n" +
				"  | - Digite o simbolo da operação (+, -, / ou *) e tecle \"Enter\"                                     |\n" +
				"  | - Digite o segundo número e tecle \"Enter\" para visualizar o resultado no terminal.                |\n" +
				"  | - Para visualizar o histórico de operações digite \"H\"                                             |\n" +
				"  | - Para limpar os dados armazenados em memória digite \"C\"                                          |\n" +
				"  *****************************************************************************************************\n";
	}
	
	private static String template() {
		return 	"  _______________________\n" +
				" |  7  |  8  |  9  |  +  |\n" +
				" |_____|_____|_____|_____|\n" +
				" |  4  |  5  |  6  |  -  |\n" +
				" |_____|_____|_____|_____|\n" +
				" |  1  |  2  |  3  |  *  |\n" +
				" |_____|_____|_____|_____|\n" +
				" |  .  |  0  |  ⏎  |  /  |\n" +
				" |_____|_____|_____|_____|\n" +
				"       |  H  |  C  |\n" +
				"       |_____|_____|\n";
	}
	
	

}
