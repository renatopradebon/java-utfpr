package br.com.modelo.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.modelo.Carro;
import br.com.modelo.Proprietario;

public class TesteCarro {

	public static void main(String args[]) {
		
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("frameworks-web");
//		EntityManager manager = factory.createEntityManager();
//
//		// ABRINDO A TRASACAO
//		manager.getTransaction().begin();
		
		List<Proprietario> listaProprietario = new ArrayList<>();
		List<Carro> listaCarros = new ArrayList<>();

		Proprietario proprietario = new Proprietario();
		proprietario.setNome("Renato Pradebon");

		Carro carro = new Carro();
		carro.setPlaca("AAA-1234");
		carro.setProprietario(proprietario);
//		proprietario.getCarros().add(carro);

		Carro carro2 = new Carro();
		carro2.setPlaca("AAA-1235");
		carro2.setProprietario(proprietario);
//		proprietario.getCarros().add(carro2);

		Carro carro3 = new Carro();
		carro3.setPlaca("AAA-1236");
		carro3.setProprietario(proprietario);
//		proprietario.getCarros().add(carro3);

		Carro carro4 = new Carro();
		carro4.setPlaca("AAA-1237");
		carro4.setProprietario(proprietario);
//		proprietario.getCarros().add(carro4);

		Proprietario proprietario2 = new Proprietario();
		proprietario2.setNome("Liliane Pradebon");

		Carro carro5 = new Carro();
		carro5.setPlaca("AAA-1238");
		carro5.setProprietario(proprietario2);
//		proprietario2.getCarros().add(carro5);

		Carro carro6 = new Carro();
		carro6.setPlaca("AAA-1239");
		carro6.setProprietario(proprietario2);
//		proprietario2.getCarros().add(carro6);

		Carro carro7 = new Carro();
		carro7.setPlaca("AAA-1240");
		carro7.setProprietario(proprietario2);
//		proprietario2.getCarros().add(carro7);

		Carro carro8 = new Carro();
		carro8.setPlaca("AAA-1241");
		carro8.setProprietario(proprietario2);
//		proprietario2.getCarros().add(carro8);
		
		listaProprietario.add(proprietario);
		listaProprietario.add(proprietario2);
		
		
		listaCarros.add(carro);
		listaCarros.add(carro2);
		listaCarros.add(carro3);
		listaCarros.add(carro4);
		listaCarros.add(carro5);
		listaCarros.add(carro6);
		listaCarros.add(carro7);
		listaCarros.add(carro8);
		
//		manager.persist(proprietario);
//		manager.persist(proprietario2);
//
//		// SINCRONIZANDO E CONFIRMANDO A TRANSACAO
//		manager.getTransaction().commit();
//
//		System.out.println("Proprietario id: " + proprietario.getCodProprietario());
//
//		manager.close();
//		factory.close();
//		

		for (Carro carroIterador : listaCarros) {
			System.out.print(carroIterador.toString());
		}

	}

}
