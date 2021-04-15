package pedro.jogodaforca.core;

import java.io.Console;
import java.util.Scanner;

public class UI {
	
	
	public static char readChar(String text) throws InvalidChar {
		
		Scanner ler = new Scanner(System.in);
		System.out.println(text);
		
		String letra = ler.nextLine();
		
		if(letra.trim().isEmpty()) {
			throw new InvalidChar("NENHUMA LETRA FOI DIGITADA");
		}
		
		if (letra.length() > 1) {
			throw new InvalidChar("DIGITE APENAS UMA LETRA");
		}
		
		
		char c = letra.charAt(0);
		
		if(!(Character.isLetter(c))) {
			throw new InvalidChar("DIGITE APENAS LETRAS");
		}
		
		return c;
		
	}

}
