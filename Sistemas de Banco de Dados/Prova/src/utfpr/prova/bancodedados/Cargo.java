package utfpr.prova.bancodedados;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "cargo")
@NamedQuery(name = "Cargo.findAll", query = "select c from Cargo c")
public class Cargo {

	@Id
	@GeneratedValue
	private long id;

	private String Cargo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}
}
