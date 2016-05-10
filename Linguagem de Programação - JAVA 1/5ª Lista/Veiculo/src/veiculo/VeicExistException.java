/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculo;

/**
 *
 * @author renatopradebon
 */
public class VeicExistException extends Exception{
    public VeicExistException() {
        System.err.println("Esse veículo já existe na base de dados");
    }
    
}
