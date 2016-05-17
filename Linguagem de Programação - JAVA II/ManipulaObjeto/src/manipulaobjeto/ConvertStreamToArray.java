/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulaobjeto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author renatopradebon
 */
public class ConvertStreamToArray {

    public static ArrayList<ArrayList> convertStreamToArray(InputStream arquivo) throws IOException {
        if (arquivo != null) {
            StringBuilder sb = new StringBuilder();
            
            String line;
            ArrayList<ArrayList> array = null;
            String arrayCliente[] = null;
            
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(arquivo, "UTF-8"));
                int contador = 0;
                while ((line = reader.readLine()) != null) {
                    arrayCliente['idade'] = 'teste';
                    
                    array.add(contador, arrayCliente);
                    //sb.append(line).append("\n");
                    contador++;
                }
            } finally {
                arquivo.close();
            }
            return null;
        } else {
            return null;
        }
    }
}
