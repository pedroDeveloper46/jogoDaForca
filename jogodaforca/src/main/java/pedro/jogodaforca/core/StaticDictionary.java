package pedro.jogodaforca.core;

import java.util.List;
import java.util.Random;

public class StaticDictionary extends Dictionary {
	
	
	private List<String> words = List.of("casa", "janela", "apartamento", "futebol", "amor", "bola de futebol");
    
	private int currentIndex;
     
	
	@Override
	public Word nextWord() {
		// TODO Auto-generated method stub
		Random random = new Random();
		
		currentIndex = random.nextInt(words.size() + 1);
		
		return new Word(words.get(5));
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Estático";
	}
	
	

}
