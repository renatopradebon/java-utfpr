import java.text.SimpleDateFormat;
import java.util.Date;

/**
*
* @author Diego Vitorino dos Santos
*/

public class Teste {

	public static void main(String[] args) {
		
		BDVeiculos bd = new BDVeiculos();
		Carga carg;
		Passeio pas;
		Leitura in = new Leitura();
		int opcao = 0;
		int local = 0;
		boolean continua = true, resposta = false, inserir = true;
		String cadastrar;
		Date data;     
	    SimpleDateFormat dataHora;
		
		while(continua){
			System.out.println("\n Sistema de Gestão de Veículos - Menu Inicial \n");
			System.out.println(" 1)_ Cadastrar Veículo de Passeio;");
			System.out.println(" 2)_ Cadastrar Veículo de Carga;");
			System.out.println(" 3)_ Imprimir Todos os Veículos de Passeio;");
			System.out.println(" 4)_ Imprimir Todos os Veículos de Carga;");
			System.out.println(" 5)_ Imprimir Veículo de Passeio pela Placa;");
			System.out.println(" 6)_ Imprimir Veículo de Carga pela Placa;");
			System.out.println(" 7)_ Alterar dados do Veículo de Passeio pela Placa;");
			System.out.println(" 8)_ Alterar dados do Veículo de Carga pela Placa;");
			System.out.println(" 9)_ Sair do Sistema;");
			
			opcao = Integer.parseInt(in.entraDados("\n Digite o NUMERO da opção: "));
			
			switch(opcao){
			case 1 : 
				inserir = true;
				while(inserir){   // enqnto opção inserir verdadeiro, insere
					pas = new Passeio();
					local = 0;					
					System.out.println("\n -----Cadastro de Veículo de Passeio-----\n");
					pas.setPlaca(in.entraDados(" Placa  : "));
					pas.setMarca(in.entraDados(" Marca  : "));
					pas.setModelo(in.entraDados(" Modelo : "));
					pas.setCor(in.entraDados(" Cor    : "));
					pas.setQtdRodas(Integer.parseInt(in.entraDados(" Qtd de Rodas: ")));						
					try{
						pas.setVelocMax(Integer.parseInt(in.entraDados(" Velocidade Max: ")));
					} catch(VelocException erro){
						System.out.println("\n Qual erro Aconteceu?");
						erro.impErro(); 
						try{
							pas.setVelocMax(150);
						} catch (VelocException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}	
					pas.getMotor().setQtdPist(Integer.parseInt(in.entraDados(" Qtd de Pistões: ")));					
					pas.getMotor().setPotencia(Integer.parseInt(in.entraDados(" Potência: ")));
					pas.setQtdePessagerios(Integer.parseInt(in.entraDados(" Qtd de Passageiros: ")));
					
					try{
						resposta = false;
				    	bd.setBDPasseio(pas);
				    	inserir = false; // insercao correta, não precisa inserir, volta ao menu
					} catch(VeicExistException erro){
						System.out.println("\n Qual erro Aconteceu?");
						erro.impErro();
						while(!resposta){
							cadastrar = in.entraDados("\nDeseja sobrescrever o Veículo de Passeio Cadastrado? <S> ou <N>: ").toUpperCase();
							if (cadastrar.equals("S")){
								local = bd.consPasseio(pas, local);
								bd.altVeiculoBDPasseio(local, pas);
								resposta = true; // se respondeu correto S ou N recebe verdadeiro
								inserir = false; // insercao correta, não precisa inserir, volta ao menu
							} else if (cadastrar.equals("N")) {								
								resposta = true;// se respondeu correto S ou N recebe verdadeiro
								break;
							} else
								System.out.println("\nValor Informado inválio <diferente de S ou N>, informe corretamente");
						}
					}				
					cadastrar = in.entraDados("\nDeseja cadastrar um outro Veículo de Passeio? <S> ou <N>: ").toUpperCase();
					if (cadastrar.equals("S")) {
						inserir = true;									
					} else if (cadastrar.equals("N")) {
						inserir = false;
					} else {
						System.out.println("Valor informado inválido. Sera retornado ao Menu Inicial!");
						inserir = false;
					}						
				}
				break;
			case 2 :
				inserir = true;	
				while(inserir){// enqnto opção inserir verdadeiro, insere
					carg = new Carga();
					local = 0;					
					System.out.println("\n -----Cadastro de Veículo de Carga-----\n");
					carg.setPlaca(in.entraDados(" Placa  : "));
					carg.setMarca(in.entraDados(" Marca  : "));
					carg.setModelo(in.entraDados(" Modelo: "));
					carg.setCor(in.entraDados(" Cor: "));
					carg.setQtdRodas(Integer.parseInt(in.entraDados(" Qtd de Rodas: ")));
					try{
						carg.setVelocMax(Integer.parseInt(in.entraDados(" Velocidade Max: ")));
					} catch(VelocException erro){
						System.out.println("\n Qual erro Aconteceu?");
						erro.impErro(); 
						try{
							carg.setVelocMax(120);
						} catch (VelocException e) {
							// TODO Auto-generated catch block
						} 
					}	
					carg.getMotor().setQtdPist(Integer.parseInt(in.entraDados(" Qtd de Pistões: ")));					
					carg.getMotor().setPotencia(Integer.parseInt(in.entraDados(" Potência: ")));
					carg.setTara(Integer.parseInt(in.entraDados(" Tara: ")));
					carg.setCargaMax(Integer.parseInt(in.entraDados(" Carga Max: ")));
					
					try{
						resposta = false;
				    	bd.setBDCarga(carg);
				    	inserir = false; // insercao correta, não precisa inserir, volta ao menu
					} catch(VeicExistException erro){
						System.out.println("\n Qual erro Aconteceu?");
						erro.impErro();
						while(!resposta){
							cadastrar = in.entraDados("\nDeseja sobrescrever o Veículo de Carga Cadastrado? <S> ou <N>").toUpperCase();
							if (cadastrar.equals("S")){
								local = bd.consCarga(carg, local);
								bd.altVeiculoBDCarga(local, carg);
								resposta = true; // se respondeu correto S ou N recebe verdadeiro
								inserir = false; // insercao correta, não precisa inserir, volta ao menu
							} else if (cadastrar.equals("N")) {								
								resposta = true;// se respondeu correto S ou N recebe verdadeiro
								break;
							} else
								System.out.println("\nValor Informado inválio <diferente de S ou N>, informe corretamente");
						}
					}
					
					cadastrar = in.entraDados("\nDeseja cadastrar um outro Veículo de Carga? <S> ou <N>").toUpperCase();
					if (cadastrar.equals("S")) {
						inserir = true;									
					} else if (cadastrar.equals("N")) {
						inserir = false;
					} else {
						System.out.println("Valor informado inválido. Sera retornado ao Menu Inicial!");
						inserir = false;
					}	
				}
				break;
			case 3 :
				data = new Date();
				dataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				System.out.println("\nData e Hora do sistema: "+ (dataHora.format(data)));
				System.out.println("\n -----Lista de Veículos de Passeio----- \n");				
				bd.impListaPasseio();				
				break;
			case 4 :
				data = new Date();
				dataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				System.out.println("\nData e Hora do sistema: "+ (dataHora.format(data)));
				System.out.println("\n -----Lista de Veículos de Carga----- \n");
				bd.impListaCarga();				
				break;				
			case 5 :
				data = new Date();
				dataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				System.out.println("\n -----Consulta de Veículo de Passeio pela Placa-----\n");
				pas = new Passeio();
				pas.setPlaca(in.entraDados("\nInforme a Placa: "));
				pas = bd.consPasseio(pas);
				if (pas==null) {
					System.out.println("\n Veículo de Passeio não existe");
				}
				else{
					System.out.println("\nData e Hora do sistema: "+ (dataHora.format(data)));
					System.out.println("\n Veículo Consultado:");
					pas.impVeiculo();
				} 
				break;
			case 6 :
				data = new Date();
				dataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
				System.out.println("\n -----Consulta de Veículo de Carga pela Placa-----\n");
				carg = new Carga();
				carg.setPlaca(in.entraDados("\nInforme a Placa: "));
				carg = bd.consCarga(carg);
				if (carg==null) {
					System.out.println("\n Veículo de Carga não existe");
				}
				else{
					System.out.println("\nData e Hora do sistema: "+ (dataHora.format(data)));
					System.out.println("\n -----Veículo Consultado-----\n");
					carg.impVeiculo();
				} 
				break;
			case 7 :
				System.out.println("\n -----Altera Veículo de Passeio pela Placa-----\n");
			    local = 0;
				pas = new Passeio();
				pas.setPlaca(in.entraDados("\nInforme a Placa: "));
				local = bd.consPasseio(pas, local);
				pas = bd.consPasseio(pas);
				if (local < 0) {
					System.out.println("\n Veículo de Passeio não existente");
				}
				else{
					System.out.println("\n -----Veículo Consultado-----\n");
					pas.impVeiculo();
					System.out.println("\n\n Inserir novos dados para Veículos de Passeio: ");
					pas.setMarca(in.entraDados(" NOVA Marca  : "));
					pas.setModelo(in.entraDados(" NOVO Modelo: "));
					pas.setCor(in.entraDados(" NOVA Cor: "));
					pas.setQtdRodas(Integer.parseInt(in.entraDados(" NOVA Qtd de Rodas: ")));
					try{
						pas.setVelocMax(Integer.parseInt(in.entraDados(" NOVA Velocidade Max: ")));
					} catch(VelocException erro){
						System.out.println("\n Qual erro Aconteceu?");
						erro.impErro(); 
						try{
							pas.setVelocMax(150);
						} catch (VelocException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} 
					}	
					pas.getMotor().setQtdPist(Integer.parseInt(in.entraDados(" NOVA Qtd de Pistões: ")));					
					pas.getMotor().setPotencia(Integer.parseInt(in.entraDados(" NOVA Potência: ")));
					pas.setQtdePessagerios(Integer.parseInt(in.entraDados(" NOVA Qtd de Passageiros: ")));
					bd.altVeiculoBDPasseio(local, pas);
				}
				break;
			case 8 :				
				System.out.println("\n -----Altera Veículo de Carga pela Placa-----\n");
				local = 0;
				carg = new Carga();
				carg.setPlaca(in.entraDados("\nInforme a Placa: "));
				local = bd.consCarga(carg, local);
				carg = bd.consCarga(carg);
				if (local < 0) {
					System.out.println("\n Veículo de Carga não existente");
				}
				else{
					System.out.println("\n -----Veículo Consultado-----\n");
					carg.impVeiculo();
					System.out.println("\n\n Inserir novos dados para Veículos de Carga: ");
					carg.setMarca(in.entraDados(" NOVA Marca  : "));
					carg.setModelo(in.entraDados(" NOVO Modelo: "));
					carg.setCor(in.entraDados(" NOVA Cor: "));
					carg.setQtdRodas(Integer.parseInt(in.entraDados(" NOVA Qtd de Rodas: ")));
					try{
						carg.setVelocMax(Integer.parseInt(in.entraDados(" NOVA Velocidade Max: ")));
					} catch(VelocException erro){
						System.out.println("\n Qual erro Aconteceu?");
						erro.impErro(); 
						try{
							carg.setVelocMax(120);
						} catch (VelocException e) {
							// TODO Auto-generated catch block
						} 
					}
					carg.getMotor().setQtdPist(Integer.parseInt(in.entraDados(" NOVA Qtd de Pistões: ")));					
					carg.getMotor().setPotencia(Integer.parseInt(in.entraDados(" NOVA Potência: ")));
					carg.setTara(Integer.parseInt(in.entraDados(" NOVA Tara: ")));
					carg.setCargaMax(Integer.parseInt(in.entraDados(" NOVA Carga Max: ")));
					bd.altVeiculoBDCarga(local, carg);
				}
				break;
			case 9 :
				continua = false;
				System.out.println("\nSaiu do sistema....\n");
				System.exit(0);
				break;
			default:
				System.out.println("\n Outras opcoes(Valor fora da escala do menu)..:"+opcao);
				break;
			}			
		}
	}

}
