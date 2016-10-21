package br.com.ejb.soma.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Soma.class)
public class SomaBean implements Soma {

	public double somaNumeros(double a, double b) {

		return a + b;
	}
}
