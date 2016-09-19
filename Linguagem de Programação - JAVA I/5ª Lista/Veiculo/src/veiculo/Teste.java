package veiculo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BDVeiculo bd = new BDVeiculo();
        InData in = new InData();

        int opcao = 0;
        int posicao;

        boolean vai = true;
        boolean testaInt;
        boolean continuaCadastrando;
        boolean sobrescreverVeiculo;

        Passeio passeio;
        Carga carga;

        while (vai) {
            mostraMenu();

            testaInt = true;
            while (testaInt) {
                try {
                    opcao = Integer.parseInt(in.entra(("\nDigite o NUMERO da opção: ")));
                    testaInt = false;
                } catch (NumberFormatException erro) {
                    System.out.println("\nA opção deve ser numérico!");
                }
            }

            switch (opcao) {
                case 1:
                    continuaCadastrando = true;

                    while (continuaCadastrando) {
                        passeio = new Passeio();
                        cadastroVeiculoPasseio(passeio, bd, in, false);
                        sobrescreverVeiculo = false;

                        try {
                            bd.setVeiculoPasseio(passeio);
                        } catch (VeicExistException erro) {
                            System.err.println("\nErro -> " + erro);

                            sobrescreverVeiculo = in.entra("\nDeseja sobrescrever o veículo existente? <S>im ou <N>ão: ").toUpperCase().equals("S");

                            if (sobrescreverVeiculo) {
                                posicao = bd.consultaPosicaoPlacaPasseio(passeio);
                                bd.altVeiculoBDPasseio(posicao, passeio);
                                continuaCadastrando = false;
                            }
                        }
                        if (sobrescreverVeiculo == false) {
                            continuaCadastrando = in.entra("\nDeseja cadastrar outro veículo de passeio? <S>im ou <N>ão: ").toUpperCase().equals("S");
                        }
                    }
                    break;
                case 2:
                    continuaCadastrando = true;

                    while (continuaCadastrando) {
                        carga = new Carga();
                        cadastroVeiculoCarga(carga, bd, in, false);
                        sobrescreverVeiculo = false;

                        try {
                            bd.setVeiculoCarga(carga);
                        } catch (VeicExistException erro) {
                            System.err.println("\nErro -> " + erro);

                            sobrescreverVeiculo = in.entra("\nDeseja sobrescrever o veículo existente? <S>im ou <N>ão: ").toUpperCase().equals("S");

                            if (sobrescreverVeiculo) {
                                posicao = bd.consultaPosicaoPlacaCarga(carga);
                                bd.altVeiculoBDCarga(posicao, carga);
                                continuaCadastrando = false;
                            }
                        }
                        if (sobrescreverVeiculo == false) {
                            continuaCadastrando = in.entra("\nDeseja cadastrar outro veículo de carga? <S>im ou <N>ão: ").toUpperCase().equals("S");
                        }
                    }
                    break;
                case 3:
                    mostraDataHoraAtual();
                    bd.imprimeListaVeiculosPasseio();
                    break;
                case 4:
                    mostraDataHoraAtual();
                    bd.imprimeListaVeicuolosCarga();
                    break;
                case 5:
                    mostraDataHoraAtual();
                    System.out.println("\nConsulta de Veículos de Passeio por placa");
                    passeio = new Passeio();

                    passeio.setPlaca(in.entra("\nDigite a Placa do Veículo: "));
                    posicao = bd.consultaPosicaoPlacaPasseio(passeio);

                    if (posicao == -1) {
                        System.out.println("\nVeículo não cadastrado");
                    } else {
                        bd.imprimeVeiculoPasseio(posicao);
                    }
                    break;
                case 6:
                    mostraDataHoraAtual();
                    System.out.println("\nConsulta de Veículos de Carga por placa");
                    carga = new Carga();

                    carga.setPlaca(in.entra("\nDigite a Placa do Veículo: "));
                    posicao = bd.consultaPosicaoPlacaCarga(carga);

                    if (posicao == -1) {
                        System.out.println("\nVeículo não cadastrado");
                    } else {
                        bd.imprimeVeiculoCarga(posicao);
                    }
                    break;
                case 7:
                    passeio = new Passeio();

                    passeio.setPlaca(in.entra("\nDigite a Placa do Veículo: "));
                    posicao = bd.consultaPosicaoPlacaPasseio(passeio);

                    if (posicao == -1) {
                        System.out.println("\nVeículo não cadastrado");
                    } else {
                        bd.imprimeVeiculoPasseio(posicao);
                        cadastroVeiculoPasseio(passeio, bd, in, true);
                        bd.altVeiculoBDPasseio(posicao, passeio);
                    }
                    break;
                case 8:
                    carga = new Carga();

                    carga.setPlaca(in.entra("\nDigite a Placa do Veículo: "));
                    posicao = bd.consultaPosicaoPlacaCarga(carga);

                    if (posicao == -1) {
                        System.out.println("\nVeículo não cadastrado");
                    } else {
                        bd.imprimeVeiculoPasseio(posicao);
                        cadastroVeiculoCarga(carga, bd, in, true);
                        bd.altVeiculoBDCarga(posicao, carga);
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Outras Opções (Valor fora da escala do menu)..: " + opcao);
                    break;
            }
        }
    }

    public static void mostraMenu() {
        System.out.println("\n---------------- Menu de Opções ----------------------");
        System.out.println("( 1 ) - Cadastrar Veículo de Passeio");
        System.out.println("( 2 ) - Cadastrar Veículo de Carga");
        System.out.println("( 3 ) - Imprimir todos os Veículos de Passeio");
        System.out.println("( 4 ) - Imprimir todos os Veículos de Carga");
        System.out.println("( 5 ) - Imprimir Veículo de Passeio pela Placa");
        System.out.println("( 6 ) - Imprimir Veículo de Carga pela Placa");
        System.out.println("( 7 ) - Alterar dados do Veículo de Passeio pela Placa");
        System.out.println("( 8 ) - Alterar dados do Veículo de Carga pela Placa");
        System.out.println("( 9 ) - Sair do Sistema");
    }

    public static void mostraDataHoraAtual() {
        Date data = new Date();
        SimpleDateFormat dataHora = new SimpleDateFormat("DD/MM/YYYY HH:MM:SS");

        System.out.println("\nData e Hora do sistema: " + (dataHora.format(data)));
    }

    public static void cadastroVeiculoPasseio(Passeio passeio, BDVeiculo bd, InData in, boolean editar) {
        boolean testaInt;
        String tipoCadastro = editar ? "Edição" : "Cadastro";

        System.out.println("\n" + tipoCadastro + " de Veículo de Passeio");

        if (!editar) {
            passeio.setPlaca(in.entra("\nPlaca do Veículo: "));
        }

        passeio.setMarca(in.entra("\nMarca do Veículo: "));
        passeio.setModelo(in.entra("\nModelo do Veículo: "));
        passeio.setCor(in.entra("\nCor do Veículo: "));

        testaInt = true;
        while (testaInt) {
            try {
                passeio.setVelocMax(Integer.parseInt(in.entra("\nVelocidade Máxima do Veículo: ")));
                testaInt = false;
            } catch (NumberFormatException erro) {
                System.out.println("\nA velocidade máxima deve ser numérico!");
            } catch (VelocException erro2) {
                //erro2.impErro();
                try {
                    passeio.setVelocMax(150);
                } catch (VelocException e) {
                    e.printStackTrace();
                }
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
    }

    public static void cadastroVeiculoCarga(Carga carga, BDVeiculo bd, InData in, boolean editar) {
        boolean testaInt;
        String tipoCadastro = editar ? "Edição" : "Cadastro";

        System.out.println("\n" + tipoCadastro + " de Veículo de Carga");

        if (!editar) {
            carga.setPlaca(in.entra("\nPlaca do Veículo: "));
        }

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
            } catch (VelocException erro2) {
                //erro2.impErro();
                try {
                    carga.setVelocMax(120);
                } catch (VelocException e) {
                    e.printStackTrace();
                }
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
                carga.setQtdRodas(Integer.parseInt(in.entra("\nQuantidade de rodas do Veículo: ")));
                testaInt = false;
            } catch (NumberFormatException erro) {
                System.out.println("\nA Quantidade de rodas deve ser numérico!");
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
    }
}
