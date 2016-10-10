package teste;

import dao.ContaDAO;
import model.Cliente;

public class Teste
{
    public static void main(String[] args)
    {
        Cliente lyndon = new Cliente("Lyndon Tavares", "B.Brasil", 10000);
        ContaDAO bbrasil = new ContaDAO(lyndon);
        bbrasil.deposito(10000);
        bbrasil.saque(5000);
        bbrasil.extrato();

        System.out.println("=====");

        Cliente renato = new Cliente("Renato Pradebon", "Itau", 20000);
        ContaDAO itau = new ContaDAO(renato);
        itau.deposito(20000);
        itau.saque(10000);
        itau.extrato();

    }

}
