package br.integrador.cliente.indata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InData {

	public String entra(String label) {
		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader memoria = new BufferedReader(teclado);
		System.out.print(label);
		String s = "";
		try {
			s = memoria.readLine();
		} catch (IOException e) {
			System.out.println("Erro de entrada");
		}
		return s;
	}
}
