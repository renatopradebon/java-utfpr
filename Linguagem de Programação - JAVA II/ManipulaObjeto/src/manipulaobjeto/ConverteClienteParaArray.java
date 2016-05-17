/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulaobjeto;

import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author renatopradebon
 */
public class ConverteClienteParaArray {

    public static ArrayList ConverteClienteParaArray(Cliente cliente) {
        ArrayList<Cliente> array = new ArrayList<>();
        int contador = 0;
        for (Cliente cliente1 : array) {
            array.add(contador, cliente1);
            contador++;
        }

        return array;
    }
}
