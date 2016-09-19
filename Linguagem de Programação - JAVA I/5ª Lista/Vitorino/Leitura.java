/**
*
* @author Diego Vitorino dos Santos
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {
	public static String entraDados(String label){
		InputStreamReader c = new InputStreamReader(System.in);
		BufferedReader cd = new BufferedReader(c);
		System.out.print(label);
		
		String s = "";
		
		try {
			s = cd.readLine();
		} catch (IOException e) {
			System.out.println("Erro de entrada");
		}		
		return s;
	}
	
}
