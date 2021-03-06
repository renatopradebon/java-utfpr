package manipulaobjeto;

import java.io.Serializable;

/**
 *
 * @author Renato Pradebon
 */
public class Cliente implements Serializable {

    private String nome;
    private String fone;
    private int idade;

    public Cliente() {
        nome = "não informado";
        fone = "não informado";
        idade = 0;
    }

    public Cliente(String nm, String fon, int id) {
        nome = nm;
        fone = fon;
        idade = id;
    }

    public boolean Maior() {
        return getIdade() >= 18;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

}
