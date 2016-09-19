package imcservice.wsinterface;

import java.util.Date;

public class DadosImc {
	String nome;
	double peso, altura;
	Date data;
	private double imc;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getImc() {
		return imc;
	}
}
