

/**
*
* @author Diego Vitorino dos Santos
*/


final public class Passeio extends Veiculo implements Calc{
	
	private int qtdePessagerios;
	
	public Passeio(){
		this.qtdePessagerios = 0;
	}

	public Passeio(int qtdePessagerios) {
		this.qtdePessagerios = qtdePessagerios;
	}

	public int getQtdePessagerios() {
		return qtdePessagerios;
	}

	final public void setQtdePessagerios(int qtdePessagerios) {
		this.qtdePessagerios = qtdePessagerios;
	}
	
	public int getVelocMax() {
		return this.calcVel();
	}	
	
	@Override
	public int calcVel() {
		// calc velocMax(km) por 1.000 para sair em m/h
		return super.getVelocMax() * 1000;
	}
	
	public void impVeiculo(){
		super.impVeiculo();
		System.out.println("Qtd de Passageiros..: " + this.getQtdePessagerios());
		System.out.println("Velocidade Max: " + this.getVelocMax() + "M/h");
	}

	@Override
	public int calcular() {		
		return this.getCor().length() + this.getMarca().length() + this.getModelo().length() 
			 + this.getPlaca().length();
	}
	
}
