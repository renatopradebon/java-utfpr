package br.com.ejb.soma.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.ejb.soma.sessionbeans.Soma;

@ManagedBean
public class SomaMB {

	@EJB
	private Soma soma;

	private double a;
	private double b;
	private double resultado;

	public void somaNumeros() {
		System.out.println("teste");
		this.resultado = this.soma.somaNumeros(a, b);
	}

	public Soma getSoma() {
		return soma;
	}

	public void setSoma(Soma soma) {
		this.soma = soma;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

}
