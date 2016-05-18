package manipulaobjeto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author Renato Pradebon
 */
public class ConvertStreamToArray {

    public static ArrayList<Cliente> convertStreamToArray(File arquivo) throws IOException, ClassNotFoundException {
        ArrayList<Cliente> array = new ArrayList<>();

        if (arquivo != null) {
            try {
                ObjectInputStream reader= new ObjectInputStream(new FileInputStream(arquivo));

                int contador = 0;
                while (true) {
                    array.add(contador, (Cliente) reader.readObject());
                    //sb.append(line).append("\n");
                    contador++;
                }
            } catch (IOException erro) {
                
            }
        }

        return array;
    }
}
