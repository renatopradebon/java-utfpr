package helloworld.modelos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Livro {
	private long codigo;
	private String titulo;
	private String autor;
	private int ano;
	private double preco;

	public Livro() {

	}

	public Livro(long codigo, String titulo, String autor, int ano, double preco) {
		super();
		setCodigo(codigo);
		setTitulo(titulo);
		setAutor(autor);
		setAno(ano);
		setPreco(preco);
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Livro [codigo=" + codigo + ", titulo=" + titulo + ", autor=" + autor + ", ano=" + ano + ", preco="
				+ preco + "]";
	}
}
