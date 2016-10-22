package br.com.ejb.soma.sessionbeans;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Soma.class)
public class SomaBean implements Soma {

	public double soma(double numero1, double numero2) {

		return numero1 + numero2;
	}
}
