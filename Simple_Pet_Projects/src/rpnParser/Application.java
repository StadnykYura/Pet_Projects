package rpnParser;


import java.util.Deque;
import java.util.LinkedList;

public class Application {

	public static double parse(String rpnString) {
		
		Deque<Double> output = new LinkedList<>();
		
		String [] strArrayOfRPN = rpnString.split("\\s+");
		
		for (String string : strArrayOfRPN) {
			if(string.matches("^\\-\\d+") || string.matches("^\\d+") || 
					string.matches("^\\-\\d+\\.\\d+") || string.matches("^\\d+\\.\\d+")){
				output.push(Double.parseDouble(string));
			} else if (string.length() == 1 && string.matches("^[\\+|\\-|\\*|\\/]$") && output.size() >=2 ){
				
					double leftNumber = output.pop();
					double rightNumber = output.pop();

					switch (string) {
						case "+":
							output.push(rightNumber + leftNumber);
							break;
						case "-":
							output.push(rightNumber - leftNumber);
							break;
						case "*":
							output.push(rightNumber * leftNumber);
							break;
						case "/":
							if (leftNumber == 0) {
								throw new ArithmeticException();
							}
							output.push(rightNumber / leftNumber);
							break;
						default:
							throw new RPNParserException();
					}
			} else {
				throw new RPNParserException();
			}
			
				
		}
		if (output.size() > 1) {
			throw new RPNParserException();
		} else {
			return output.pop();
		}
		
		
	}
	
	public static double valueOF(String RPNstring) {
		
		LinkedList<Double> stack = new LinkedList<>();
		String [] arrayStringOfRpn = RPNstring.split("\\s+");
		double leftOperandInStack;
		double rightOperandInStack;
		
		for (String string : arrayStringOfRpn) {
				
				switch (string) {
					case "+":
						if (stack.size() >=2) {
							leftOperandInStack = stack.pop();
							rightOperandInStack = stack.pop();
						stack.push(rightOperandInStack + leftOperandInStack);
						} else {
							throw new RPNParserException();
						}
						break;
					case "-":
						if (stack.size() >=2) {
							leftOperandInStack = stack.pop();
							rightOperandInStack = stack.pop();
						stack.push(rightOperandInStack - leftOperandInStack);
						} else {
							throw new RPNParserException();
						}
						break;
					case "*":
						if (stack.size() >=2) {
							leftOperandInStack = stack.pop();
							rightOperandInStack = stack.pop();
						stack.push(rightOperandInStack * leftOperandInStack);
						} else {
							throw new RPNParserException();
						}
						break;
					case "/":
						if (stack.size() >=2){
							leftOperandInStack = stack.pop();
							rightOperandInStack = stack.pop();
							if (leftOperandInStack != 0.0) {
							stack.push(rightOperandInStack / leftOperandInStack);
							} else {
								throw new ArithmeticException();
							}
						} else {
							throw new RPNParserException();
						}
						break;
					default:
						try {
							stack.push(Double.parseDouble(string));
						} catch (Exception a){
							throw new RPNParserException();
						}
				} 
			
			
		}
		if (stack.size() == 1){
			return stack.pop();
		} else {
			throw new RPNParserException();
		}
		
		
	}
	
	

	public static void main(String[] args) {


//		Application.parse("12 2 3 4 * 10 5 / + * +");
		System.out.println(Application.valueOF("12 2 3 4 * 10 5 / + * +"));
		System.out.println(Application.valueOF("12 2 -3 4 * 10 -5 / + * +"));
		System.out.println(Application.valueOF("10 20 + 30 40 + *"));
		System.out.println(Application.valueOF("10 20 30.0 * +"));
//		System.out.println(Application.valueOF("10 20 30 () +"));
//		System.out.println(Application.valueOF("10 20 Е * +"));
//		System.out.println(Application.valueOF("0 0 /"));
//		System.out.println(Application.valueOF("10 * 6 7 +"));
//		System.out.println(Application.valueOF("10 NaN 6 7 + - *")); valueOF повертає NaN, а parse RPN;
//		System.out.println(Application.valueOF("10 20 30 40 * +"));
//		System.out.println(Application.valueOF("10 20 + 30 40 +"));

		
		
		double s = -4.0;
		System.out.println(s);
		
	}









}
      