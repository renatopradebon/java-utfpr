package br.com.exercicio;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.exercicio.modelo.Usuario;

@ManagedBean(name = "loginMb")
@ViewScoped
public class loginMB {

	private Usuario usuario = new Usuario();

	/* VALORES DO BANCO DE DADOS */
	private static final String loginUsuario = "renato";
	private static final String senhaUsuario = "123456";

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String logar() {

		if (verificaLoginSenha()) {

			return "sucesso";
		} else {

			FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");

			FacesContext.getCurrentInstance().addMessage("erro", msg);
			
			return null;
		}
	}

	private boolean verificaLoginSenha() {

		return usuario.getLogin().equals(loginUsuario) && usuario.getSenha().equals(senhaUsuario);
	}

}
