package pedro.jogodaforca.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pedro.jogodaforca.GameException;

public abstract class Dictionary {
    
	
    
	private static Dictionary objeto;
	
	
	
	public static Dictionary getInstance() {
	     
		if(objeto == null) {
			
						
			try {
				String dictionaryClassName = Config.get("dictionaryClassName");

				Class<?> classe = Class.forName(dictionaryClassName.trim());
				Constructor<?> construtor = classe.getConstructor();
				objeto = (Dictionary) construtor.newInstance();
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		     
		}
		
		return objeto;
	}
	
	
	
	public abstract Word nextWord();
	
	public abstract String getName();
}
