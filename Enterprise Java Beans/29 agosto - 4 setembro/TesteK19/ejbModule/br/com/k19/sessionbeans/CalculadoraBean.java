package br.com.k19.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Calculadora.class)
public class CalculadoraBean implements Calculadora {

	public double soma(double a, double b) {
		return a + b;
	}

}
