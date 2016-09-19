package utfpr.prova.bancodedados;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestPersist {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("entity_manager");
		EntityManager manager = factory.createEntityManager();

		// ABRINDO A TRASACAO
		manager.getTransaction().begin();

		Cargo cargo = new Cargo();
		cargo.setCargo("Programador");
		manager.persist(cargo);
		
		Cargo cargo2 = new Cargo();
		cargo2.setCargo("Tester");
		manager.persist(cargo2);
		
		Cargo cargo3 = new Cargo();
		cargo3.setCargo("Analista de Suporte");
		manager.persist(cargo3);
		
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Renato Pradebon");
		funcionario.setSexo("Masculino");
		funcionario.setTelefone("45-91231923");
		funcionario.setCargo(cargo);
		manager.persist(funcionario);
		
		Funcionario funcionario2 = new Funcionario();
		funcionario2.setNome("Vilson Pradebon");
		funcionario2.setSexo("Masculino");
		funcionario2.setTelefone("67-9-9986-8000");
		funcionario2.setCargo(cargo2);
		manager.persist(funcionario2);
		
		Funcionario funcionario3 = new Funcionario();
		funcionario3.setNome("Bruno Pradebon");
		funcionario3.setSexo("Masculino");
		funcionario3.setTelefone("67-9-9986-4212");
		funcionario3.setCargo(cargo);
		manager.persist(funcionario3);
		
		Funcionario funcionario4 = new Funcionario();
		funcionario4.setNome("Liliane Caroline");
		funcionario4.setSexo("Feminino");
		funcionario4.setTelefone("45-9123-1924");
		funcionario4.setCargo(cargo3);
		manager.persist(funcionario4);

		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
		manager.getTransaction().commit();		

		manager.close();
		factory.close();
	}
}
