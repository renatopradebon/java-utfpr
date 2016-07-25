package utfpr.atividade4.servidorpiadas.leitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorPiadas {

	private Scanner leitor;

	public LeitorPiadas() throws FileNotFoundException {
		String caminho = "./public/piadas.txt";
		leitor = new Scanner(new File(caminho));
	}

	public String getProximaPiada() throws FileNotFoundException {
		String piada = "Sem mais piadas para enviar";

		try {
			if (leitor.hasNextLine()) {
				piada = leitor.nextLine();
			} else {

			}
		} catch (IllegalStateException e) {
			System.err.println("erro no arquivo => " + e);
		}

		return piada;
	}

	public static void main(String[] args) throws FileNotFoundException {

		LeitorPiadas leitor = new LeitorPiadas();

		for (int cont = 0; cont < 12; cont++) {
			System.out.println(leitor.getProximaPiada());
		}

	}
}
