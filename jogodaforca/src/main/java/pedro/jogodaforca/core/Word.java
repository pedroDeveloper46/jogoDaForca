package pedro.jogodaforca.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Word {
	
	private static final char SECRET_CHAR = '_';
	
	private String originalWord;
	
	private Set<Character> foundsChars = new HashSet<>();
	
	private Set<Character> wordsChars = new HashSet<>();
	
	public Word(String original) {
		
		this.originalWord = original.replace(" ", "");
		this.originalWord = original.toUpperCase();
		char[] chars = this.originalWord.toCharArray();
		
		for (char c : chars) {
			if(!(Character.isWhitespace(c))) {
				wordsChars.add(c);
			}
		}
	}
	
	public int size() {
		return originalWord.length();
	}
	
	
	public boolean hasChar(char c) {
		c = Character.toUpperCase(c);
		if(originalWord.indexOf(c) > -1) {
			foundsChars.add(c);
			return true;
		}
		
		return false;
	}

	public String getOriginalWord() {
		return originalWord;
	}
	
	public boolean discovered() {
		return foundsChars.equals(wordsChars);
	}
	
	@Override
	public String toString() {
		StringBuilder st = new StringBuilder();
		
		
		char[] array = originalWord.toCharArray();
		
		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			
			if(foundsChars.contains(c)) {
				st.append(c);
			}else {
				st.append(SECRET_CHAR);
			}
			
			st.append(" ");
		
		
		
	   }
		return st.toString();
   }
	
	

}
