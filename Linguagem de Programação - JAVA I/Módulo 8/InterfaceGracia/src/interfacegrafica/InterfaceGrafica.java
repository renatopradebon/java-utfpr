/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author renatopradebon
 */
public class InterfaceGrafica {
    public static String path;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        path = new File("images/gremio.png").getCanonicalPath();

        JOptionPane.showMessageDialog(null,
                "Oi amor!",
                "Liliane Caroline",
                JOptionPane.ERROR_MESSAGE,
                new ImageIcon(path));
//                new ImageIcon("/home/renatopradebon/git-repository/renato-git/java-utfpr/Linguagem de Programação - JAVA I/Módulo 8/InterfaceGracia/images/gremio.png"));

        String inputDialog = JOptionPane.showInputDialog(null,
                "Oi amor2!",
                "Liliane Caroline Servat",
                JOptionPane.PLAIN_MESSAGE);
        
        JOptionPane.showMessageDialog(null,
                "Você digitou o nome " + inputDialog,
                "Janela do " + inputDialog,
                JOptionPane.ERROR_MESSAGE,
                new ImageIcon(path));        
        
        mostraMensagem(JOptionPane.showConfirmDialog(null,
                "Oi amor2?",
                "Liliane Caroline Servat Pradebon",
                JOptionPane.YES_NO_CANCEL_OPTION));
                             
    }
    public static void mostraMensagem(int opcao) {
        String texto = "";
        switch (opcao) {
            case 0:
                texto = "Clicou no SIM - Vale 0";
                break;
            case 1:
                texto = "Clicou no NÃO - Vale 1";
                break;
            case 2:
                texto = "Clicou no CANCELAR - Vale 2";
                break;
            default:
                break;
        }
        
        JOptionPane.showMessageDialog(null,
                texto,
                "Resposta do clique",
                JOptionPane.PLAIN_MESSAGE,
                new ImageIcon(path));
        
    }
}
