package JPQL;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
@NamedQuery(name = "Livro.findByPrecoMinimo", 
            query = "select livro from Livro livro where livro.preco >= :preco")
public class Livro {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private Double preco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}