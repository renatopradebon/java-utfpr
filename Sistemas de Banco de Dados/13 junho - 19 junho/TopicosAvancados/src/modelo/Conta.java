package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "conta")
public class Conta {

	@Id
	@GeneratedValue
	private Long id;

	private double saldo;

	@Version
	private Long versao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Long getVersao() {
		return versao;
	}

	public void setVersao(Long versao) {
		this.versao = versao;
	}

	@PrePersist
	public void prePersist() {
		System.out.println("Persistindo....");
	}

	@PostPersist
	public void postPersist() {
		System.out.println("Já persistiu....");
	}
}