package veiculo;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BDSist bd = new BDSist();
        InData in = new InData();

        int opcao = 0;
        int posicao;

        boolean vai = true;
        boolean testaInt = true;

        while (vai) {

            mostraMenu();

            testaInt = true;
            while (testaInt) {
                try {
                    opcao = Integer.parseInt(in.entra(("\n\n Digite o NUMERO da opção: ")));
                    testaInt = false;
                } catch (NumberFormatException erro) {
                    System.out.println("\nA opção deve ser numérico!");
                }
            }

            switch (opcao) {
                case 1:
                    Passeio passeio = new Passeio();
                    System.out.println("\n Cadastro de Veículo de Passeio\n");
                    passeio.setPlaca(in.entra("\nPlaca do Veículo: "));
                    passeio.setMarca(in.entra("\nMarca do Veículo: "));
                    passeio.setModelo(in.entra("\nModelo do Veículo: "));
                    passeio.setCor(in.entra("\nCor do Veículo: "));

                    testaInt = true;
                    while (testaInt) {
                        try {
                            passeio.setVelocMax(Integer.parseInt(in.entra("\nVelocidade Máxima do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA velocidade deve ser numérico!");
                        }
                    }

                    testaInt = true;
                    while (testaInt) {
                        try {
                            passeio.getMotor().setPotencia(Integer.parseInt(in.entra("\nPotência do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA Potência deve ser numérico!");
                        }
                    }

                    testaInt = true;
                    while (testaInt) {
                        try {
                            passeio.getMotor().setQtdPist(Integer.parseInt(in.entra("\nQuantidade de pistões do motor do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA Quantidade de pistões deve ser numérico!");
                        }
                    }

                    testaInt = true;
                    while (testaInt) {
                        try {
                            passeio.setQtdePassageiros(Integer.parseInt(in.entra("\nQuantidade de passageiros do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA Quantidade de passageiros deve ser numérico!");
                        }
                    }

                    testaInt = true;
                    while (testaInt) {
                        try {
                            passeio.setQtdRodas(Integer.parseInt(in.entra("\nQuantidade de rodas do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA Quantidade de rodas deve ser numérico!");
                        }
                    }

                    try {
                        bd.setVeiculoPasseio(passeio);
                    } catch (VeicExistException erro) {
                        System.err.println("\n Erro -> " + erro);
                    }
                    break;
                case 2:
                    Carga carga = new Carga();
                    System.out.println("\n Cadastro de Veículo de Carga\n");
                    carga.setPlaca(in.entra("\nPlaca do Veículo: "));
                    carga.setMarca(in.entra("\nMarca do Veículo: "));
                    carga.setModelo(in.entra("\nModelo do Veículo: "));
                    carga.setCor(in.entra("\nCor do Veículo: "));

                    testaInt = true;
                    while (testaInt) {
                        try {
                            carga.setVelocMax(Integer.parseInt(in.entra("\nVelocidade Máxima do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA velocidade deve ser numérico!");
                        }
                    }

                    testaInt = true;
                    while (testaInt) {
                        try {
                            carga.getMotor().setPotencia(Integer.parseInt(in.entra("\nPotência do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA potência deve ser numérico!");
                        }
                    }

                    testaInt = true;
                    while (testaInt) {
                        try {
                            carga.getMotor().setQtdPist(Integer.parseInt(in.entra("\nQuantidade de pistões do motor do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA quantidade de pistões deve ser numérico!");
                        }
                    }

                    testaInt = true;
                    while (testaInt) {
                        try {
                            carga.setCargaMax(Integer.parseInt(in.entra("\nCarga Máxima do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA Carga Máxima deve ser numérico!");
                        }
                    }
                    testaInt = true;
                    while (testaInt) {
                        try {
                            carga.setTara(Integer.parseInt(in.entra("\nTara do Veículo: ")));
                            testaInt = false;
                        } catch (NumberFormatException erro) {
                            System.out.println("\nA Tara do veículo deve ser numérico!");
                        }
                    }

                    try {
                        bd.setVeiculoCarga(carga);
                    } catch (VeicExistException erro) {
                        System.err.println("\n Erro -> " + erro);
                    }
                    break;
                case 3:
                    bd.imprimeListaVeiculosPasseio();
                    break;
                case 4:
                    bd.imprimeListaVeicuolosCarga();
                    break;
                case 5:
                    System.out.println("\n Consulta de Veículos de Passeio por placa");
                    passeio = new Passeio();

                    passeio.setPlaca(in.entra("\nDigite a Placa do Veículo: "));
                    posicao = bd.consultaPosicaoPlacaPasseio(passeio);

                    if (posicao == -1) {
                        System.out.println("\n Veículo não cadastrado");
                    } else {
                        bd.imprimeVeiculoPasseio(posicao);
                    }
                    break;
                case 6:
                    System.out.println("\n Consulta de Veículos de Carga por placa");
                    carga = new Carga();

                    carga.setPlaca(in.entra("\nDigite a Placa do Veículo: "));
                    posicao = bd.consultaPosicaoPlacaCarga(carga);

                    if (posicao == -1) {
                        System.out.println("\n Veículo não cadastrado");
                    } else {
                        bd.imprimeVeiculoCarga(posicao);
                    }
                    break;
                case 7:
                    System.out.println("\n Opcao 4 Em constru��o ");
                    break;
                case 8:
                    System.out.println("\n Opcao 4 Em constru��o ");
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Outras Op��es (Valor fora da escala do menu)..: " + opcao);
                    break;
            }

        }

    }

    public static void mostraMenu() {
        System.out.println("\n---------------- Menu de Opções ----------------------");
        System.out.println("\n( 1 ) - Cadastrar Veículo de Passeio");
        System.out.println("\n( 2 ) - Cadastrar Veículo de Carga");
        System.out.println("\n( 3 ) - Imprimir todos os Veículos de Passeio");
        System.out.println("\n( 4 ) - Imprimir todos os Veículos de Carga");
        System.out.println("\n( 5 ) - Imprimir Veículo de Passeio pela Placa");
        System.out.println("\n( 6 ) - Imprimir Veículo de Carga pela Placa");
        System.out.println("\n( 7 ) - Alterar dados do Veículo de Passeio pela Placa");
        System.out.println("\n( 8 ) - Alterar dados do Veículo de Carga pela Placa");
        System.out.println("\n( 9 ) - Sair do Sistema");
    }
}
