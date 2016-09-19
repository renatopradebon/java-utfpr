package utfpr.atividade5.servidor.leitor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorPiadas {

	private Scanner leitor;
	private String caminho = "./public/piadas.txt";

	public LeitorPiadas() throws FileNotFoundException {
		iniciaLeitor();
	}

	public void iniciaLeitor() throws FileNotFoundException {
		leitor = new Scanner(new File(caminho));
	}

	public String getProximaPiada() throws FileNotFoundException {
		String piada = "Sem mais piadas para enviar";

		try {
			if (!leitor.hasNextLine()) {
				leitor.close();
				iniciaLeitor();
			}

			piada = leitor.nextLine();

		} catch (IllegalStateException e) {
			System.err.println("erro no arquivo => " + e);
		}

		return piada;
	}

	public static void main(String[] args) throws FileNotFoundException {

		LeitorPiadas leitor = new LeitorPiadas();

		for (int cont = 0; cont < 15; cont++) {
			System.out.println(leitor.getProximaPiada());
		}

	}
}
