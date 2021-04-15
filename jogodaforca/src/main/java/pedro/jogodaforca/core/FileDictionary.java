package pedro.jogodaforca.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pedro.jogodaforca.GameException;

public class FileDictionary extends Dictionary {
    
	private static final String FILE_NAME = "dicionario.txt";
	
	private List<String> words = new ArrayList<>();
    
	private static FileDictionary objeto;
	
	public FileDictionary() {
		load();
	}
	
	public static FileDictionary getInstance() {
	     
		if(objeto == null) {
			objeto = new FileDictionary();
		     
		}
		
		return objeto;
	}
	
	
	
	private void load() {
		
		try(Scanner scanner = new Scanner(getClass().getResourceAsStream("/" + FILE_NAME))) {
		  
		    while(scanner.hasNextLine()) {
		    	String palavra = scanner.nextLine().trim();
		    	words.add(palavra);
		    	
		    }
		    
		    if(words.size() == 0) {
		    	throw new GameException("A LISTA DE PALAVRAS ESTÁ VAZIA");
		    }
			
		}
		
	}
	
	
	public Word nextWord() {
		
		int index = RandomUtils.newInt(0,  words.size());
		
		Word word = new Word(words.get(index));
	    
		return word;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Arquivo " + FILE_NAME;
	}
}
