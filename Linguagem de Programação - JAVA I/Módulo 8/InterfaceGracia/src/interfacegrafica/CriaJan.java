/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author renatopradebon
 */
public class CriaJan {

    private static final JTextField campo1 = new JTextField(20);
    private static final JButton botao1 = new JButton("Clique aqui");
    private static final JFrame janela1 = new JFrame("Título da Janela");
    private static final JLabel rotulo1 = new JLabel("Rotulo 1 - Nome");
    private static final CriaJan criaJanela = new CriaJan();

    public static void main(String[] args) {

        int largura = 300, altura = 250;
        janela1.setSize(largura, altura);

        janela1.add(rotulo1);

        janela1.add(campo1);

        botao1.setMnemonic('C');

        janela1.setLayout(new FlowLayout());

        janela1.setVisible(true);
        botao1.addActionListener(criaJanela);
    }

    public void actionPerformed(ActionEvent evt) {
        Object obj = evt.getSource();

        if (obj.equals(botao1)) {

            String frase = "É fácil...";
            campo1.setText(frase);
            janela1.setVisible(true);
            JOptionPane.showMessageDialog(null, "Você escolheu a opção: " + frase, "Exibição de Dados", JOptionPane.INFORMATION_MESSAGE);
        } //fim do IF
    }

}
