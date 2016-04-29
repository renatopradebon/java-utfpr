/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author renatopradebon
 */
public class Inicio {

    public static void main(String args[]) {

        Leitura l = new Leitura();
        Pessoa pes = new Pessoa();
        
        boolean testaInt = true;
        
        while (testaInt) {
        
            try {
                pes.setId(Integer.parseInt(l.inData("\nEntre com o ID <deve ser numero>: ")));
                testaInt = false;
            } catch (NumberFormatException erro) {
                System.out.println("\nO ID deve ser numérico!");
            }
            
        }
        
        pes.setNome(l.inData("\n Entre com o nome: "));
        System.out.println("\n ID....: " + pes.getId());
        System.out.println("\n Nome..: " + pes.getNome());
    }

}
