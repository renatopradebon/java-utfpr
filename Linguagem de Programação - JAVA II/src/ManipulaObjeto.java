
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.sun.java_cup.internal.runtime.Scanner;

public class ManipulaObjeto {

    private File arquivo;
    private ObjectInputStream entrada;
    private ObjectOutputStream saida;
    private ArrayList<Cliente> cliente;
    private int posicaoObjeto = 0;

    public void ManipulaObjeto() {
        arquivo = null;
        entrada = null;
        saida = null;
    }

    public void criarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showSaveDialog(null);//posiciona a janela no centro da tela
        //usando o this a janela Ã© centrada na janela da aplicaÃ§Ã£o. O FileChooser Ã© modal
        if (result == JFileChooser.CANCEL_OPTION) {
            return;//finaliza a execuÃ§ao do metodo
        }
        arquivo = fileChooser.getSelectedFile();
        System.out.println(fileChooser.getName());

        if (arquivo == null || arquivo.getName().equals("")) {
            JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Nome de Arquivo Inválido", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                /* o condicional para gravacao do cabecalho 
                 * eh necessario apenas quando forem gravados
                 * multiplos objetos em arquivo.
                 */
                //if (arquivo.exists()) {
                //    saida = new ObjectOutputStream(new FileOutputStream(arquivo, true)) {
                //        @Override
                //        protected void writeStreamHeader() {
                //            // do not write a header
                //        }
                //    };
                //    System.out.println("arquivo existe");
                //} else {
                    saida = new ObjectOutputStream(new FileOutputStream(arquivo, false));
                //    System.out.println("arquivo NAO existe");
                //}
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

    public void GravaCliente(Cliente c) {
        if (saida == null) {
            criarArquivo();
        }
        try {
            saida.writeObject(c);
            saida.flush();
            if (cliente == null) {
				cliente = new ArrayList<Cliente>();
				cliente.add(c);
			} else {
				cliente.add(c);
				posicaoObjeto++;
			}
            
        } catch (NumberFormatException formatException) {
            JOptionPane.showMessageDialog(null, "Erro", "Formato de Número Inválido.", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioException) {
            fecharArquivo();
        }
    }

    public void GravaObjeto(Object obj) {
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
    
    public void reset() {
        if (arquivo != null) {
            try {
                entrada = new ObjectInputStream(new FileInputStream(arquivo));
                saida = new ObjectOutputStream(new FileOutputStream(arquivo, false));
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }else{
            abrirArquivo();
        }
    }

    public void abrirArquivo() {
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
                if (cliente == null){
                	try {
						carregarListaObjetos();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Erro ao Carregar a lista de cliente", "Erro ao Carregar a lista de cliente", JOptionPane.ERROR_MESSAGE);;
					}
                }
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "Error ao Abrir Arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public Cliente lerRegistroProximo() {
        Cliente c = null;
        if ((entrada == null) && (saida == null)) {
            abrirArquivo();
        }
    
    	if (posicaoObjeto < cliente.size()){
    		c = cliente.get(posicaoObjeto);
    		if ((posicaoObjeto + 1) != cliente.size())
    			posicaoObjeto++;
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Nao existem mais registros no arquivo.", "Fim do Arquivo", JOptionPane.ERROR_MESSAGE);
    	}    		
        return c;
    }    
    
    public Cliente lerRegistroAnterior() {
        Cliente c = null;
        if ((entrada == null) && (saida == null)) {
            abrirArquivo();
            posicaoObjeto = cliente.size() - 1;
        }
    
    	if ((posicaoObjeto <= cliente.size()) && (posicaoObjeto > 0)){
    		posicaoObjeto--;
    		c = cliente.get(posicaoObjeto);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Nao existem mais registros no arquivo.", "Fim do Arquivo", JOptionPane.ERROR_MESSAGE);
    	}    		
        return c;
    }        
    
    public void carregarListaObjetos() throws ClassNotFoundException {
        cliente = new ArrayList<Cliente>();
        if (entrada == null) {
            abrirArquivo();
        }
        try {       
        	while(true){  
        		cliente.add((Cliente)entrada.readObject());
        	}
              
        } catch (EOFException endOfFileException) {
            System.out.println("Fim do Arquivo");
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Erro durante a leitura do arquivo", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Erro na conversao do tipo ou final do arquivo.", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        } finally {
        }
    }    
    
    public Object lerObjeto() {
        Object obj = null;
        if (entrada == null) {
            abrirArquivo();
        }
        try {
            obj = entrada.readObject();
        } catch (EOFException endOfFileException) {
            JOptionPane.showMessageDialog(null, "Nao existem mais registros no arquivo.", "Fim do Arquivo", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(null, "Erro durante a leitura do arquivo", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException err) {
            JOptionPane.showMessageDialog(null, "Erro na conversao do tipo ou final do arquivo.", "Erro de Leitura", JOptionPane.ERROR_MESSAGE);
        } finally {
            return obj;
        }
    }    
}