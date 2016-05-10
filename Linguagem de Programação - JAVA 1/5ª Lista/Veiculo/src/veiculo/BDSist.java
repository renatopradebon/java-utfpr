package veiculo;

import java.util.ArrayList;
import java.util.List;

public class BDSist {

    private final List<Carga> BDCarga = new ArrayList<>();
    private final List<Passeio> BDPasseio = new ArrayList<>();

    public Passeio consultaPlacaPasseio(Passeio passeio) {
        for (int i = 0; i < BDPasseio.size(); i++) {
            if (BDPasseio.get(i).getPlaca().equals(passeio.getPlaca())) {
                return BDPasseio.get(i);
            }

        }
        return null;
    }
    
    public int consultaPosicaoPlacaPasseio(Passeio passeio) {
        for (int i = 0; i < BDPasseio.size(); i++) {
            if (BDPasseio.get(i).getPlaca().equals(passeio.getPlaca())) {
                return i;
            }
        }
        return -1;
    }
    
    public int consultaPosicaoPlacaCarga(Carga carga) {
        for (int i = 0; i < BDCarga.size(); i++) {
            if (BDCarga.get(i).getPlaca().equals(carga.getPlaca())) {
                return i;
            }
        }
        return -1;
    }

    public Carga consultaPlacaCarga(Carga carga) {
        for (int i = 0; i < BDCarga.size(); i++) {
            if (BDCarga.get(i).getPlaca().equals(carga.getPlaca())) {
                return BDCarga.get(i);
            }
        }
        return null;
    }

    public void setVeiculoPasseio(Passeio passeio) throws VeicExistException {
        if (consultaPlacaPasseio(passeio) == null) {
            BDPasseio.add(passeio);
            System.out.println("\n\nVeículo de passeio " + passeio.getMarca() + " " + passeio.getModelo() + " cadastrado com sucesso!");
        } else {
            throw new VeicExistException();
        }
    }

    public void setVeiculoCarga(Carga carga) throws VeicExistException {
        if (consultaPlacaCarga(carga) == null) {
            BDCarga.add(carga);
            System.out.println("\n\nVeículo de carga " + carga.getMarca() + " " + carga.getModelo() + " cadastrado com sucesso!");
        } else {
            throw new VeicExistException();
        }
    }

    public void imprimeListaVeiculosPasseio() {
        System.out.println("--------------------- Lista de Veículos de Passeio ---------------------");
        for (int i = 0; i < BDPasseio.size(); i++) {
            imprimeVeiculoPasseio(i);
        }
    }
    public void imprimeVeiculoPasseio(int posicao) {
            System.out.println("Veículo nº " + (posicao + 1));
            System.out.println("Dados do veiculo de passeio " + BDPasseio.get(posicao).getModelo() + ".");
            System.out.println("Placa: " + BDPasseio.get(posicao).getPlaca() + ".");
            System.out.println("Marca: " + BDPasseio.get(posicao).getMarca() + ".");
            System.out.println("Cor: " + BDPasseio.get(posicao).getCor() + ".");
            System.out.println("Quantidade de Rodas: " + BDPasseio.get(posicao).getQtdRodas() + ".");
            System.out.println("Velocidade Máxima: " + BDPasseio.get(posicao).velocidadeString());
            System.out.println("Potência do Motor: " + BDPasseio.get(posicao).getMotor().getPotencia() + " Cavalo(s).");
            System.out.println("Quantidade de Pistões do Motor: " + BDPasseio.get(posicao).getMotor().getQtdPist() + ".");
            System.out.println("Demais informações \n" + BDPasseio.get(posicao).informacoesVeiculo());
            System.out.println("\n");        
    }

    public void imprimeListaVeicuolosCarga() {
        System.out.println("--------------------- Lista de Veículos de Carga ---------------------");
        for (int i = 0; i < BDCarga.size(); i++) {
            imprimeVeiculoCarga(i);
        }
    }
    
    public void imprimeVeiculoCarga(int posicao) {
            System.out.println("Veículo nº " + (posicao + 1));
            System.out.println("Dados do veiculo de passeio " + BDCarga.get(posicao).getModelo() + ".");
            System.out.println("Placa: " + BDCarga.get(posicao).getPlaca() + ".");
            System.out.println("Marca: " + BDCarga.get(posicao).getMarca() + ".");
            System.out.println("Cor: " + BDCarga.get(posicao).getCor() + ".");
            System.out.println("Quantidade de Rodas: " + BDCarga.get(posicao).getQtdRodas() + ".");
            System.out.println("Velocidade Máxima: " + BDCarga.get(posicao).velocidadeString());
            System.out.println("Potência do Motor: " + BDCarga.get(posicao).getMotor().getPotencia() + " Cavalo(s).");
            System.out.println("Quantidade de Pistões do Motor: " + BDCarga.get(posicao).getMotor().getQtdPist() + ".");
            System.out.println("Demais informações \n" + BDCarga.get(posicao).informacoesVeiculo());
            System.out.println("\n");        
    }

//m?todo para RETORNAR a List de pessoas.
//    public List<Pessoa> getBDPes() {
//        System.out.println("\n\nLista de Pessoas retornadas cadastrada com sucesso!");
//        return BDPes; //retornando a lista
//    }
// ==================================================================================================
/*
* m?todo para ALTERAR obj do List de pessoas. Neste caso dever?o ser passados dois par?metros:
         * int local = local do List onde est? o obj a ser alterado;
         * Pessoa pes = novo obj (com novos dados) que ir? substituir o obj existente no "local" 
         * BDPes.set -> set(local, pes) = m?todo que atualiza o List no local definido (local) pelo novo objeto Pessoa (pes).
     */
//    public void altItemBDPes(int local, Pessoa pes) {
//        BDPes.set(local, pes); //alterando obj da lista
//        System.out.println("\n\nPessoa alterada com sucesso!");
//    }
// ==================================================================================================
    /* 2 m?todos para APAGAR obj da lista:

	* 1?)_ pelo ?NDICE (inteiro)
          * int local = indica o local do List, onde est? o  objeto a ser apagado (removido)
          * BDPes.remove(int local) -> remove (int local) = m?todo que remove o obj do List que estiver em determinada posi??o (local). 
     */
//    public void delItemBDPes(int local) {
//        BDPes.remove(local); //apagando obj da lista pelo ?ndice (inteiro)
//        System.out.println("\n\nPessoa removida com sucesso!");
//    }
//
//// 	2?)_ m?todo para APAGAR obj da lista pelo encontro do OBJ em sua primeira ocorr?ncia
//    public void delItemBDPes(Pessoa pes) {
//        BDPes.remove(pes); //apagando obj da lista pelo obj
//        System.out.println("\n\nPessoa removida com sucesso!");
//    }
//
//    public void delRgBDPes(Pessoa pes) {
//        if (consRg(pes) == null) {
//            System.out.println("\n\nPessoa n�o existente ");
//        } else {
//            delItemBDPes(pes);
//            System.out.println("\n\nPessoa removida com sucesso");
//        }
//        BDPes.remove(pes); //apagando obj da lista pelo obj
//        System.out.println("\n\nPessoa removida com sucesso!");
//    }
}
