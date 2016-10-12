/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integradorcliente;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import integrador.wsimplementation.BancarioService;
import integrador.wsimplementation.BancarioServiceImplService;

/**
 *
 * @author Machado
 */
public class IntegradorCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
                int retorno = 0;
                int numConta = 0;
                double valor = 0;
                String nome;
            
                BancarioServiceImplService acessor = new BancarioServiceImplService();
                BancarioService servico = acessor.getBancarioServiceImplPort();
                
                while (retorno != 8) {
            
                    System.out.println("#################################################");
                    System.out.println("            BEM VINDO AO BANCO DO SALIN          ");
                    System.out.println("#################################################");
                    System.out.println(" Escolha uma opcoes:                             ");
                    System.out.println("        1. Criar nova conta                      ");
                    System.out.println("        2. Consultar saldo de conta              ");
                    System.out.println("        3. Efetuar deposito de conta             ");
                    System.out.println("        4. Efetuar saque na conta                ");
                    System.out.println("        5. Fechar conta                          ");
                    System.out.println("        6. Listar todas as transacoes da conta   ");
                    System.out.println("        7. Listar todas as transacoes            ");
                    System.out.println("        8. Sair                                  ");
                    System.out.println("#################################################");
                    retorno = Keyin.inInt("Opcao selecionada: ");   
                    
                    switch (retorno) {

                    case 8:
                        
                        System.out.println("Banco do Salin AGRADECE $$$$$$");                       
                        break;

                    case 1:

                        nome = Keyin.inString("Opcao 1 > Nome Cliente: ");
                        valor = Keyin.inDouble("Opcao 1 > Deposito Inicial: ");

                        System.out.println("Opcao 1 > O Numero da Conta Criada é: "+
                                servico.criarConta(nome, valor));
                        System.out.println("------------------------------------------------");


                        break;
                    case 2:

                        numConta = Keyin.inInt("Opcao 2 > Informe Conta para Consulta: ");
                        System.out.println("Opcao 2 > SALDO: "+servico.consultarSaldo(numConta) );
                        System.out.println("------------------------------------------------");

                        break;

                    case 3:

                        numConta = Keyin.inInt("Opcao 3 > Informe Conta para Deposito: ");
                        valor = Keyin.inInt("Opcao 3 > Valor: ");

                        System.out.println("Opcao 3 > Deposito com sucesso " + 
                                servico.efetuarDeposito(numConta, valor));
                        System.out.println("------------------------------------------------");

                        break;

                    case 4:

                        numConta = Keyin.inInt("Opcao 4 > Informe Conta para Saque: ");
                        valor = Keyin.inInt("Opcao 4 > Valor: ");

                        System.out.println("Opcao 4 > Saque com sucesso " + 
                                servico.efetuarSaque(numConta, valor));
                        System.out.println("------------------------------------------------");

                        break;

                    case 5:

                        numConta = Keyin.inInt("Opcao 5 > Informe Conta para encerramento: ");
                        System.out.println("Opcao 5 > Conta encerrada com sucesso ");                         
                        System.out.println("------------------------------------------------");

                        break;

                    case 6:

                        numConta = Keyin.inInt("Informe Num.Conta para listar transacoes: ");
                        
                        Client client = Client.create();
                        WebResource resource = client.resource("http://localhost:4000/log/" + numConta);                       
                        System.out.println(resource);
                        System.out.println("------------------------------------------------");

                        break;

                    case 7:

                        client = Client.create();
                        WebResource resource1 = client.resource("http://localhost:4000/log");                        
                        String s = resource1.get(String.class);
                        System.out.println(s);
                        System.out.println("------------------------------------------------");

                        break;
                    default:
                        break;
                    }                                        
                }
        } catch (Exception ex) {
                ex.printStackTrace();
        }
    }    
}
