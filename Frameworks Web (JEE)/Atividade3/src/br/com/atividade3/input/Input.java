package br.com.atividade3.input;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class Input {

	private String valorMinimo;
	private Boolean booleanButton;
	private Integer rangeSlide1;
	private Integer rangeSlide2;
	private String text;
	private String colorPopup;
	private List<String> listaAutoComplete;
	
	@PostConstruct
	public void iniciaParametros() {
		this.rangeSlide1 = 1;
		this.rangeSlide2 = 15;
		this.setListaAutoComplete(completeText("Testando essa nova aplicação"));
	}

	public String getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(String valorMinimo) {
		this.valorMinimo = valorMinimo;
	}

	public Boolean getBooleanButton() {
		return booleanButton;
	}

	public void setBooleanButton(Boolean booleanButton) {
		this.booleanButton = booleanButton;
	}

	public Integer getRangeSlide1() {
		return rangeSlide1;
	}

	public void setRangeSlide1(Integer rangeSlide1) {
		this.rangeSlide1 = rangeSlide1;
	}

	public Integer getRangeSlide2() {
		return rangeSlide2;
	}

	public void setRangeSlide2(Integer rangeSlide2) {
		this.rangeSlide2 = rangeSlide2;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getColorPopup() {
		return colorPopup;
	}

	public void setColorPopup(String colorPopup) {
		this.colorPopup = colorPopup;
	}
	
	public List<String> completeText(String query) {
		query = query != null ? query : "Testando"; 
        List<String> results = new ArrayList<String>();
        for(int i = 0; i < 10; i++) {
            results.add(query + i);
        }
         
        return results;
    }

	public List<String> getListaAutoComplete() {
		return listaAutoComplete;
	}

	public void setListaAutoComplete(List<String> listaAutoComplete) {
		this.listaAutoComplete = listaAutoComplete;
	}

}
