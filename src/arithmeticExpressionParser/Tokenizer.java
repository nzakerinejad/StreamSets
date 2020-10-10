package arithmeticExpressionParser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tokenizer {
	int currentLocation = 0;
	String question;
	public static void main(String[] args) {
		Tokenizer tokenizer = new Tokenizer("(3+2)*");
		assertEquals(true, tokenizer.hasToken());
		assertEquals("(", tokenizer.getNextToken());
		assertEquals(Integer.valueOf(3), tokenizer.getNextToken());
		assertEquals("+", tokenizer.getNextToken());
		assertEquals(Integer.valueOf(2), tokenizer.getNextToken());
		assertEquals(")", tokenizer.getNextToken());
		assertEquals("*", tokenizer.getNextToken());
		assertEquals(false, tokenizer.hasToken());
	}

	public Tokenizer(String question) {
		this.question = question;
	}

	public Object getNextToken() {		
		
		String token = String.valueOf(question.charAt(currentLocation));	
		currentLocation++;
		if (token.matches("[0-9]")) {
			return Integer.parseInt((token));
		}

		return token;
	}

	public boolean hasToken() {
		if(currentLocation == question.length()) {
			return false;
		} 
		return true;
	}

}
