package veiculo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class BDVeiculo {

    private final List<Carga> BDCarga;
    private final List<Passeio> BDPasseio;

    public BDVeiculo() {
        BDCarga = new ArrayList<>();
        BDPasseio = new ArrayList<>();
    }

    public int consultaPosicaoPlacaPasseio(Passeio passeio) {
        for (int i = 0; i < BDPasseio.size(); i++) {
            if (BDPasseio.get(i).getPlaca().equals(passeio.getPlaca())) {
                return i;
            }
        }
        return -1;
    }

    public Passeio consultaPlacaPasseio(Passeio passeio) {
        int posicao = consultaPosicaoPlacaPasseio(passeio);
        return posicao == -1 ? null : BDPasseio.get(posicao);
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
        int posicao = consultaPosicaoPlacaCarga(carga);
        return posicao == -1 ? null : BDCarga.get(posicao);
    }

    public void setVeiculoPasseio(Passeio passeio) throws VeicExistException {
        if (consultaPlacaPasseio(passeio) == null) {
            BDPasseio.add(passeio);
            System.out.println("\nVeículo de passeio " + passeio.getMarca() + " " + passeio.getModelo() + " cadastrado com sucesso!");
        } else {
            throw new VeicExistException();
        }
    }

    public void setVeiculoCarga(Carga carga) throws VeicExistException {
        if (consultaPlacaCarga(carga) == null) {
            BDCarga.add(carga);
            System.out.println("\nVeículo de carga " + carga.getMarca() + " " + carga.getModelo() + " cadastrado com sucesso!");
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
        System.out.println("Demais informações\n" + BDPasseio.get(posicao).informacoesVeiculo());
        System.out.println("------------------------------------------------------------------------");
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
        System.out.println("Demais informações\n" + BDCarga.get(posicao).informacoesVeiculo());
        System.out.println("----------------------------------------------------------------------");
    }

    public void altVeiculoBDPasseio(int posicao, Passeio passeio) {
        BDPasseio.set(posicao, passeio);
        System.out.println("\nVeículo de passeio " + passeio.getMarca() + " " + passeio.getModelo() + " alterado com sucesso!");
    }

    public void altVeiculoBDCarga(int posicao, Carga carga) {
        BDCarga.set(posicao, carga);
        System.out.println("\nVeículo de carga " + carga.getMarca() + " " + carga.getModelo() + " alterado com sucesso!");
    }
}
