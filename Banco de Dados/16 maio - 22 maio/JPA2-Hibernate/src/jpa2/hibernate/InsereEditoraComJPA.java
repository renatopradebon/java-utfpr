package jpa2.hibernate;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsereEditoraComJPA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
		EntityManager manager = factory.createEntityManager();
		Editora novaEditora = new Editora();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o nome da editora: ");
		novaEditora.setNome(entrada.nextLine());
		System.out.println("Digite o email da editora: ");
		novaEditora.setEmail(entrada.nextLine());
		manager.persist(novaEditora);
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		factory.close();
	}

}
