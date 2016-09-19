/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renatopradebon
 */
public class Exemplo extends Thread {
// classe interna que estende thread
// (a classe é definida como static apenas para podermos
// alocar uma instancia no main)

    static class Tarefa1 extends Thread {
// método que sobrescreve o método run() herdado

        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Usando Herança");
            }
        }
    }
// classe interna que implementa a interface Runnable

    static class Tarefa2 implements Runnable {

        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println("Usando Runnable");
            }
        }
    }

    public static void main(String[] args) {
// basta criarmos uma intancia da classe que extende Thread
        Thread threadComHeranca = new Tarefa1();
// primeiro devemos alocar uma instancia de tarefa 
        Tarefa2 tarefa = new Tarefa2();
// e depois criamos a nova Thread, passando tarefa como argumento
        Thread threadComRunnable = new Thread(tarefa);
// agora iniciamos as duas Threads
        threadComHeranca.start();
        threadComRunnable.start();
    }
}
