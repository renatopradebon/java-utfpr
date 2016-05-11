/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculo;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class VelocException extends Exception {

    public VelocException() {
        System.err.println("A velocidade máxima está fora dos limites brasileiros");
    }

    public void impErro() {
        System.err.println("A velocidade máxima está fora dos limites brasileiros");
    }
}
