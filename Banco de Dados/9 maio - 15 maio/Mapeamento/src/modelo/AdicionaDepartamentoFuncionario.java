package modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdicionaDepartamentoFuncionario {
	
public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mapeamento");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		// endereco
		Endereco endereco = new Endereco();
		endereco.setCidade("Nioaque");
		endereco.setEstado("Mato Grosso do Sul");
		endereco.setLogradouro("Rua Visconde de Taunay");
		endereco.setNumero(150);
		
		// funcionario
		Funcionario funcionario = new Funcionario();		
		funcionario.setNome("Vilson Pradebon");
		funcionario.setEndereco(endereco);
		
		// departamento
		Departamento departamento = new Departamento();
		departamento.setNome("Desenvolvimento");
		departamento.getFuncionarios().add(funcionario);
		
		manager.persist(funcionario);
		manager.persist(departamento);		
		
		manager.getTransaction().commit();
		manager.close();

		factory.close();
	}

}
