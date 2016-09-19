/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacegrafica;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author renatopradebon
 */
public class MenuSimples {

    private JMenuBar bm;
    private JMenu menuzaum;
    private JMenu arq;
    private JMenuItem abr;

    public MenuSimples() {
        JFrame jan2 = new JFrame();
        jan2.setTitle("Colocando Menus e SubMenus");
        jan2.setSize(400, 400);
        
        abr = new JMenuItem("abrir"); //criando os Itens-de-Menu para o Menu Arquivo
        abr.setMnemonic('a');
        
        arq = new JMenu("Arquivo"); //criando o Menu
        arq.setMnemonic('A');
        arq.add(abr); //adicionando Itens-de-Menu ao Menu Aquivo
        
        //TRABALHANDO COM SUBMENUS
        menuzaum = new JMenu("Menuzaum");//criando menu que conterá o SubMenu Arquivo
        menuzaum.setMnemonic('M');
        menuzaum.add(arq); //adicionando o Menu Arquivo como submenu de Menuzaum
        
        bm = new JMenuBar(); //criando a Barra de Menus
        bm.add(menuzaum); //adicionando o menu Menuzaum a Barra-de-Menus
        
        jan2.setJMenuBar(bm); //adicionando à janela (jan2)Barra de Menus com seus submenus
        jan2.setLayout(new FlowLayout()); //Organizando a janela
        jan2.setVisible(true); //tornando a janela visível
    }

    public static void main(String args[]) {
        new MenuSimples();
    }
}