/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulaobjeto;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
 
/**
 *
 * @author renatopradebon
 */
public class ConvertObjectToByteArray {
     
    /**
     * Converte um Objeto para um array de bytes
     * @param object
     * @return byte[]
     */
    public static byte[] convertObjectToByteArray(Object object) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            bytes = byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return bytes;
    }
 
    /**
     * Converte um array de bytes para um objeto
     * @param bytes
     * @return object
     */
    public static Object convertByteArrayToObject(byte[] bytes) {
        Object object = null;
 
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            object = objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         
        return object;
    }
    
    
     public static byte[] convertObjectToeArray(Object object) {
        byte[] bytes = null;
        ArrayList<ArrayList> array = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            bytes = byteArrayOutputStream.toByteArray();
            
                
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        return bytes;
    }
     
}