package veiculo;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class Teste {

    private static int contVeiculos = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Veiculo p = new Veiculo();
        BDSist bd = new BDSist();
        InData in = new InData();
        int opcao = 0;

        boolean vai = true; //vari�vel "vai" para condi��o de parada do sistema

        while (vai) {
            System.out.println("\n( 1 ) - Cadastrar Veículo de Passeio");
            System.out.println("\n( 2 ) - Cadastrar Veículo de Carga");
            System.out.println("\n( 3 ) - Imprimir todos os Veículos de Passeio");
            System.out.println("\n( 4 ) - Imprimir todos os Veículos de Carga");
            System.out.println("\n( 5 ) - Imprimir Veículo de Passeio pela Placa");
            System.out.println("\n( 6 ) - Imprimir Veículo de Carga pela Placa");
            System.out.println("\n( 7 ) - Alterar dados do Veículo de Passeio pela Placa");
            System.out.println("\n( 8 ) - Alterar dados do Veículo de Carga pela Placa");
            System.out.println("\n( 9 ) - Sair do Sistema");

            opcao = Integer.parseInt(in.entra(("\n\n Digite o NUMERO da op��o: ")));

            switch (opcao) {
                case 1:
                    p = new Pessoa();
                    System.out.println("\n Cadastro de Pessoas\n");
                    p.setRg(Integer.parseInt(in.entra("\nRG do Pai: ")));
                    p.setNome(in.entra("\nNome: "));
                    p.getF().setCodF(Integer.parseInt(in.entra("\nCodigo do Filho: ")));
                    p.getF().setNomeF(in.entra("\nNome do Filho: "));
                    try {
                        bd.setBDPes(p);
                    } catch (RgExistenteException rge) {
                        System.out.println("\n RG EXISTENTE...");
                    }
                    break;
                case 2:
                    System.out.println("\n Lista de Pessoas\n");
                    bd.impLista();
                    break;
                case 3:
                    p = new Pessoa();
                    System.out.println("\n Consultar Pessoa pelo RG ");
                    p = new Pessoa();
                    p.setRg(Integer.parseInt(in.entra("\n Informe o RG: ")));
                    p = bd.consRg(p);
                    if (p == null) {
                        System.out.println("\n Pessoa não existente");
                    } else {
                        System.out.println("\n RG..: " + p.getRg());
                        System.out.println("\n Nome: " + p.getNome());
                        System.out.println("\n Codigo do Filho: " + p.getF().getCodF());
                        System.out.println("\n Nome do Filho..: " + p.getF().getNomeF());
                    }
                    break;
                case 4:
                    System.out.println("\n Opcao 4 Em constru��o ");
                    ;
                    break;
                case 5:
                    p = new Pessoa();
                    System.out.println("\n Excluir Pessoa pelo RG");
                    p = new Pessoa();
                    p.setRg(Integer.parseInt(in.entra("\n Informe o RG: ")));
                    bd.delRgBDPes(p);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Outras Op��es (Valor fora da escala do menu)..: " + opcao);
                    break;
            }

        }

    }

    private static void retonarDados(Veiculo veiculo, int contadorVeiculos) {
        System.out.println("--------------------- Veículo nº " + contadorVeiculos + " ---------------------");
        System.out.println("Dados do veiculo " + veiculo.getModelo() + ".");
        System.out.println("Marca: " + veiculo.getMarca() + ".");
        System.out.println("Placa: " + veiculo.getPlaca() + ".");
        System.out.println("Velocidade Máxima: " + veiculo.velocidadeString());
        System.out.println("Potência do Motor: " + veiculo.getMotor().getPotencia() + " Cavalo(s).");
        System.out.println("Quantidade de Pistões do Motor: " + veiculo.getMotor().getQtdPist() + ".");
        System.out.println("Demais informações \n" + veiculo.informacoesVeiculo());
        System.out.println("\n");
        incrementaContador();
    }

    private static void incrementaContador() {
        Teste.contVeiculos++;
    }

    private static int getContVeiculos() {
        return Teste.contVeiculos;
    }
}
