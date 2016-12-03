package br.com.prova.multimedia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.com.prova.multimedia.modelo.Animal;

@ManagedBean(name = "animanlService")
@ApplicationScoped
public class AnimalService {

	private final static String[] animals;

	static {
		animals = new String[10];
		animals[0] = "Tigre";
		animals[1] = "Onça";
		animals[2] = "Cachorro";
		animals[3] = "Gato";
		animals[4] = "Urso";
		animals[5] = "Coelho";
		animals[6] = "Tartaruga";
		animals[7] = "Leão";
		animals[8] = "Porco";
		animals[9] = "Vaca";
	}

	public static String[] getAnimals() {
		return animals;
	}

	public List<Animal> createAnimals(int size) {
		List<Animal> list = new ArrayList<Animal>();
		for (int i = 1; i <= size; i++) {
			list.add(new Animal(i, getRandomNome()));
		}

		return list;
	}

	private Integer getRandomId() {
		return Integer.valueOf(UUID.randomUUID().toString().substring(0, 8));
	}

	private String getRandomNome() {
		return animals[(int) (Math.random() * 10)];
	}

	
//	public static void main(String args[]) {
//		AnimalService service = new AnimalService();
//		List<Animal> lista = service.createAnimals(10);
//		
//		System.out.println(lista.size());
//	}
}
