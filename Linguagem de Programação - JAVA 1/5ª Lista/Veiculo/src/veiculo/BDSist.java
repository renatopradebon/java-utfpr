package veiculo;

import java.util.ArrayList;
import java.util.List;

public class BDSist {

    private List<Veiculo> BDPes = new ArrayList<Veiculo>();

    // ==================================================================================================
    /*
     * Subs?dio:
         * O m?todo consRg recebe um obj do tipo Pessoa por par?metro. Utiliza este obj para fazer uma busca no List
         * de pessoas COMPARANDO OS RG?S (da pessoa passada por par?metro com o da pessoa que ocupa o atual
         * endere?o no List). CASO ENCONTRE no LIst uma pessoa com o mesmo RG, retornar? a pessoa encontrada 
         * no List, SE N?O retornar? null (um obj pessoa "vazio").
         * M?todos e seus usos: 
         * BDPes.size() -> size() = retorna a quantidade de endere?os utilizados no List. O tamanho do List
         * BDPes.get(i) -> get(i) = retorna o obj existente no List (BDPes) na posi??o "i".
         * BDPes.get(i).getRg() = retorna o obj rexistente no endere?o "i" (get(i)) e deste retorna o RG (getRg()).
     */
    public Veiculo consRg(Veiculo pes) {
        for (int i = 0; i < BDPes.size(); i++) {
            if (BDPes.get(i).getRg() == pes.getRg()) {
                return BDPes.get(i);
            }

        }
        return null;
    }

    /* 

  * Subs?dio:
      * Outra forma de encontrar uma pessoa no List de pessoas seria utilizando um "FOR" EXTENDIDO que, neste caso est?
      * associado ao m?todo "equals()" da classe Object. O equals testa se dois objetos s?o iguais, neste caso o obj "p" (criado pelo
      * "FOR" EXTENDIDO e o obj "pes" (passado por par?metro).

     */
 
// ==================================================================================================   
    /*

  * Subs?dio:
      * m?todo para INSERIR objeto Pessoa no List.  Por?m antes de inserir ser? feita, por meio do m?todo consRG, 
      * uma busca no List de Pessoas. "Se" n?o encontrar uma Pessoa (isto porque o retorno do m?todo consRg foi null),
      * adicionar? a pessoa no List e exbir? seus dados. "Se n?o" for null,   quer dizer que encontrou uma pessoa com o 
      * mesmo Rg no List de pessoas, ent?o disparar? a exce??o rgExitenteException, passando a mensagem 
      * "\nJ? existe Pessoa com este ID!" para o m?todo construtor da classe de exce??o RgExistenteException.
     */
    public void setBDPes(Pessoa pes) throws RgExistenteException {
        if (consRg(pes) == null) {
            BDPes.add(pes);
            System.out.println("\n\nPessoa " + pes.getRg() + " " + pes.getNome() + " cadastrada com sucesso!");
        } else {
            throw new RgExistenteException();
        }

    }

// ==================================================================================================
    public void impLista() {
        for (int i = 0; i < BDPes.size(); i++) {
            System.out.println("RG_Pai..: " + BDPes.get(i).getRg());
            System.out.println("Nome_Pai: " + BDPes.get(i).getNome());
            System.out.println("Codigo_Filho: " + BDPes.get(i).getF().getCodF());
            System.out.println("Nome_Filho..: " + BDPes.get(i).getF().getNomeF());
        }
    }

//m?todo para RETORNAR a List de pessoas.
    public List<Pessoa> getBDPes() {
        System.out.println("\n\nLista de Pessoas retornadas cadastrada com sucesso!");
        return BDPes; //retornando a lista
    }

// ==================================================================================================
/*
* m?todo para ALTERAR obj do List de pessoas. Neste caso dever?o ser passados dois par?metros:
         * int local = local do List onde est? o obj a ser alterado;
         * Pessoa pes = novo obj (com novos dados) que ir? substituir o obj existente no "local" 
         * BDPes.set -> set(local, pes) = m?todo que atualiza o List no local definido (local) pelo novo objeto Pessoa (pes).
     */
    public void altItemBDPes(int local, Pessoa pes) {
        BDPes.set(local, pes); //alterando obj da lista
        System.out.println("\n\nPessoa alterada com sucesso!");
    }

// ==================================================================================================
    /* 2 m?todos para APAGAR obj da lista:

	* 1?)_ pelo ?NDICE (inteiro)
          * int local = indica o local do List, onde est? o  objeto a ser apagado (removido)
          * BDPes.remove(int local) -> remove (int local) = m?todo que remove o obj do List que estiver em determinada posi??o (local). 
     */
    public void delItemBDPes(int local) {
        BDPes.remove(local); //apagando obj da lista pelo ?ndice (inteiro)
        System.out.println("\n\nPessoa removida com sucesso!");
    }

// 	2?)_ m?todo para APAGAR obj da lista pelo encontro do OBJ em sua primeira ocorr?ncia
    public void delItemBDPes(Pessoa pes) {
        BDPes.remove(pes); //apagando obj da lista pelo obj
        System.out.println("\n\nPessoa removida com sucesso!");
    }

    public void delRgBDPes(Pessoa pes) {
        if (consRg(pes) == null) {
            System.out.println("\n\nPessoa n�o existente ");
        } else {
            delItemBDPes(pes);
            System.out.println("\n\nPessoa removida com sucesso");
        }
        BDPes.remove(pes); //apagando obj da lista pelo obj
        System.out.println("\n\nPessoa removida com sucesso!");
    }
}
