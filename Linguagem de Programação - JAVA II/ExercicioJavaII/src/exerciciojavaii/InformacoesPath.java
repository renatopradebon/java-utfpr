/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciojavaii;

import java.io.File;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public final class InformacoesPath {

    private double tamanhoPastas;
    private long qtdePastas;
    private long qtdeArquivos;
    private File path;

    public File getPath() {
        return path;
    }

    public void setPath(File path) {
        this.path = path;
    }

    // (1 MB = 1024 KB = 1.048.576 bytes)
    private final double cosciente = (double) 1048576.0;

    public double getCosciente() {
        return cosciente;
    }

    public double getTamanhoPastas() {
        return tamanhoPastas;
    }

    public void setTamanhoPastas(double tamanhoPastas) {
        this.tamanhoPastas = tamanhoPastas;
    }

    public long getQtdePastas() {
        return qtdePastas;
    }

    public void setQtdePastas(long qtdePastas) {
        this.qtdePastas = qtdePastas;
    }

    public long getQtdeArquivos() {
        return qtdeArquivos;
    }

    public void setQtdeArquivos(long qtdeArquivos) {
        this.qtdeArquivos = qtdeArquivos;
    }

    public InformacoesPath(File diretorio) {
        setPath(diretorio);
        setTamanhoPastas(tamanhoAproximadoPath(getPath()) / this.getCosciente());
    }

    public double tamanhoAproximadoPath(File diretorio) {
        double tamanho = 0;

        try {
            for (File arquivo : diretorio.listFiles()) {
                if (arquivo.isDirectory()) {
                    tamanho += tamanhoAproximadoPath(arquivo);

                    setQtdePastas(getQtdePastas() + 1);
                } else {
                    tamanho += arquivo.length();

                    setQtdeArquivos(getQtdeArquivos() + 1);
                }
            }
        } catch (NullPointerException erro) {

        }
        return tamanho;
    }

    public double getTamanhoArquivo() {
        return (getPath().length() / this.getCosciente());
    }
}
