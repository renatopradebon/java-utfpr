package br.com.ejb.soma.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.ejb.soma.sessionbeans.Soma;

@ManagedBean
public class SomaMB {

	@EJB
	private Soma soma;

	private double numero1;
	private double numero2;
	private double resultado;

	public void somaNumero() {
		this.resultado = this.soma.soma(numero1, numero2);
	}

	public Soma getSoma() {
		return soma;
	}

	public void setSoma(Soma soma) {
		this.soma = soma;
	}

	public double getNumero1() {
		return numero1;
	}

	public void setNumero1(double numero1) {
		this.numero1 = numero1;
	}

	public double getNumero2() {
		return numero2;
	}

	public void setNumero2(double numero2) {
		this.numero2 = numero2;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
}
