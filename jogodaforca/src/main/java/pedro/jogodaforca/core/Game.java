package pedro.jogodaforca.core;

import java.util.HashSet;
import java.util.Set;

public class Game {
	
	private Set<Character> digitadas = new HashSet<>();
	
	
	
	
	public void start(String[] args) {
		
		int counts = 0;
		System.out.println("BEM-VINDO AO JOGO DA FORCA!");
		
		
		
		Dictionary dictionary = Dictionary.getInstance();
		
		
		
		System.out.println(dictionary.getName());
		
		
		
		Word palavra = dictionary.nextWord();
		
		
		if(args.length > 0) {
			Config.set(args[0]);
		}
		
		
		int maxErros = Integer.parseInt(Config.get("maxErro"));
		
		System.out.println("A PALAVRA TEM " + palavra.size() + " LETRAS");
		
		System.out.println("VOCÊ TEM " + maxErros + " VEZES");
		
		while(true) {
			
			try {
			
			   System.out.println(palavra);
			   char letra = UI.readChar("DIGITE UMA LETRA");
			   
			   if(digitadas.contains(letra)) {
				   throw new InvalidChar("ESTA LETRA JÁ FOI DIGITADA");
			   }
			   
			   digitadas.add(letra);
			   
			   if(palavra.hasChar(letra)) {
				   System.out.println("VOCÊ ACHOU UMA LETRA ");
			   }else {
				   counts++;
				   
				   if(counts < maxErros) {
					   System.out.println("VOCÊ AINDA TEM " + (maxErros - counts) + " CHANCE(S)");
				   }
			   }
			   
			   if(palavra.discovered()) {
				   
				   System.out.println("PARABÉNS, VOCÊ ACERTOU A PALAVRA: " + palavra.getOriginalWord());
				   System.out.println("FIM DE JOGO!!!");
				   break;
				   
			   }
			   
			   if(counts == maxErros) {
				   System.out.println("VOCÊ PERDEU, A PALAVRA ERA: " + palavra.getOriginalWord());
				   System.out.println("FIM DE JOGO!!");
				   break;
			   }
			   
			   
				
			} catch (InvalidChar c) {
				
				System.out.println("ERRO: " + c.getMessage());
				System.out.println();
				
			}
			
			
			
		}
		
	}

}
