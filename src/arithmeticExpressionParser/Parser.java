package arithmeticExpressionParser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class Parser {
	 ArrayList<Object> stack = new ArrayList<Object>();
	 Tokenizer tokenizer;
	public Parser(Tokenizer tokenizer) {
		this.tokenizer = tokenizer;
	}

	public static void main(String[] args) {
		parserTest(2, "2");
		parserTest(6, "(2*3)");
		parserTest(69, "((1+2)*(3+(4*5)))");

		
	}

	private static void parserTest(int expectedResult, String stringToParse) {
		Parser parser = new Parser(new Tokenizer(stringToParse));		
		assertEquals(expectedResult, parser.parse());
		
	}

	private  Object parse() {

		
		Object result = null;
		while(tokenizer.hasToken()) {		
			Object token = tokenizer.getNextToken();
			
			if (token.equals(")")) {				
				calculateResultOfComputationBetweenParenthesis();
			}else if (!token.equals("(")) {
				stackPush(token);
			}			
			
		}
		result = stackPop();
		
		return result;
	}
	
	private  void calculateResultOfComputationBetweenParenthesis() {
		Integer firstOperand = (Integer) stackPop();
		String operator = (String) stackPop();
		Integer secondOperand = (Integer) stackPop();
		Integer result = null;
		if (operator.equals("*")) {
			 result = firstOperand * secondOperand;
		}
		if (operator.equals("+")) {
			 result = firstOperand + secondOperand;
		}
		stackPush(result);
	}

	 void stackPush(Object token) {
	    stack.add(token);
	}
	public Object stackPop() {
	    
	    Object token = stack.get(stack.size() - 1);
	    
	    stack.remove(stack.size() - 1);
	    return token;
	}

}
