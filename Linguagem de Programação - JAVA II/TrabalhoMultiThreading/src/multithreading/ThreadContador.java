/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Renato Pradebon
 */
public class ThreadContador implements Runnable {

    Thread thread;
    private final JLabel labelContador;
    private final int num;
    private int contador;
    private volatile RunnableObject father;

    public RunnableObject getFather() {
        return father;
    }

    public void setFather(RunnableObject father) {
        this.father = father;
    }

    public ThreadContador(JLabel labelContador, int contador) {
        this.labelContador = labelContador;
        this.num = contador;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        for (contador = num; contador >= 0; contador--) {

            System.out.println(Thread.currentThread().getName() + "  " + contador);
            try {
                labelContador.setText(Integer.toString(contador));
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                System.out.println("Erro no dome => " + exception);
            }
        }
        if (contador == -1) {
            try {
                father.toggle();
                father.getCheckBox().setSelected(false);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadContador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
