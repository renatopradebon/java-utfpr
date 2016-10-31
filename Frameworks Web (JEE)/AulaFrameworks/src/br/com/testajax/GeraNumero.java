package br.com.testajax;

import java.util.Random;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "geradorNumeros")
public class GeraNumero {

	private Random gerador = new Random();
	private double numero = gerador.nextDouble();

//	public GeraNumero() {
//		numero = gerador.nextDouble();
//	}

	public double getNumero() {
		return numero;
	}

	public void randomize() {
		numero = gerador.nextDouble();
	}
}
