package manipulaobjeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Renato Pradebon
 */
public class ManipulaObjeto {

    private File arquivo;
    private ObjectInputStream entrada;
    private ObjectOutputStream saida;
    private ArrayList<Cliente> arrayCliente;
    private int posicaoArray;
    private int tamanhoArray;
    private final String tipoVisualizacaoProximo = "p";
    private final String tipoVisualizacaoAnterior = "a";

    public void ManipulaObjeto() {
        arquivo = null;
        entrada = null;
        saida = null;
        arrayCliente = null;
        posicaoArray = 0;
        tamanhoArray = 0;
    }

    public void criarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showSaveDialog(null);//posiciona a janela no centro da tela
        //usando o this a janela é centrada na janela da aplicação. O FileChooser é modal
        if (result == JFileChooser.CANCEL_OPTION) {
            return;//finaliza a execuçao do metodo
        }
        arquivo = fileChooser.getSelectedFile();

        System.out.println(fileChooser.getName());

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                saida = new ObjectOutputStream(new FileOutputStream(arquivo, false));

            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Erro ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void fecharArquivo() {
        try {
            if (saida != null) {
                saida.close();
            }
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Error ao Fechar Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void GravaCliente(Cliente cliente) {
        if (saida == null) {
            criarArquivo();
        }
        try {
            saida.writeObject(cliente);
            saida.flush();
        } catch (NumberFormatException formatException) {
            JOptionPane.showMessageDialog(null, "Erro", "Formato de Número Inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioException) {
            fecharArquivo();
        }
    }

    public void GravaObjeto(Object obj) throws ClassNotFoundException {
        if (saida == null) {
            criarArquivo();
        }
        reset();
        try {
            saida.writeObject(obj);
            saida.flush();
        } catch (NumberFormatException formatException) {
            JOptionPane.showMessageDialog(null, "Erro", "Formato de Número Inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioException) {
            fecharArquivo();
        }
    }

    public void reset() throws ClassNotFoundException {
        if (arquivo != null) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(arquivo));
                saida = new ObjectOutputStream(new FileOutputStream(arquivo, false));
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            abrirArquivo();
        }
    }

    public void abrirArquivo() throws ClassNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        arquivo = fileChooser.getSelectedFile();
        System.out.println(arquivo);

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                entrada = new ObjectInputStream(new FileInputStream(arquivo));

                arrayCliente = ConvertStreamToArray.convertStreamToArray(arquivo);

                tamanhoArray = arrayCliente.size();

            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Cliente lerRegistro() throws ClassNotFoundException {
        return retornaObjetoCliente(tipoVisualizacaoProximo);
    }

    public Cliente lerRegistroAnterior() throws ClassNotFoundException {
        return retornaObjetoCliente(tipoVisualizacaoAnterior);
    }

    public Cliente retornaObjetoCliente(String tipoVisualizacao) throws ClassNotFoundException {
        Cliente cliente = null;

        if (entrada == null) {
            abrirArquivo();
        }
        try {
            setPosicaoAtualArrayCliente(tipoVisualizacao);
            cliente = (Cliente) arrayCliente.get(posicaoArray);

        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Erro na conversao do tipo ou final do arquivo.", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        } finally {
            return cliente;
        }
    }

    public void setPosicaoAtualArrayCliente(String tipoVisualizacao) {

        if (tipoVisualizacao.equals("p")) {
            if (posicaoArray == tamanhoArray) {
                posicaoArray = 0;
            } else {
                posicaoArray++;
            }
        } else if (tipoVisualizacao.equals("a")) {
            if (posicaoArray == 0) {
                posicaoArray = tamanhoArray;
            } else {
                posicaoArray--;
            }
        }
    }
}
