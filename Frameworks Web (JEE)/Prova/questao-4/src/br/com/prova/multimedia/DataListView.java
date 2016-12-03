package br.com.prova.multimedia;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prova.multimedia.modelo.Animal;
import br.com.prova.multimedia.service.AnimalService;

@ManagedBean
@ViewScoped
public class DataListView implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Animal> animals1;

	private AnimalService service = new AnimalService();

	@PostConstruct
	public void init() {
		animals1 = service.createAnimals(10);
	}

	public List<Animal> getAnimals1() {
		return animals1;
	}

	public void setService(AnimalService service) {
		this.service = service;
	}
}