package br.com.exercicio;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "login")
@ViewScoped
public class Exercicio {
	private String login;
	private String senha;

	private static final String loginUsuario = "renato";
	private static final String senhaUsuario = "123456";

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String logar() {
		if (verificaLoginSenha()) {
			return "Login realizado com sucesso!";
		} else {
			return "Usuário ou senha inválidos!";
		}
	}

	private boolean verificaLoginSenha() {
		return login.equals(loginUsuario) && senha.equals(senhaUsuario);
	}

}
