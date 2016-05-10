/**
*
* @author Diego Vitorino dos Santos
*/


abstract class Veiculo {

	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private int qtdRodas;
	private int velocMax;
	private Motor motor;
	
	public Veiculo(){
		this.placa  = "";
		this.marca  = "";
		this.modelo = "";
		this.velocMax = 0;
		this.motor = new Motor();
		this.cor = "";
		this.qtdRodas = 0;
	}	
	
	public Veiculo(String placa, String marca, String modelo, int velocMax, Motor motor, String cor, int qtdRodas) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.velocMax = velocMax;
		this.motor = motor;
		this.qtdRodas = qtdRodas;
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	final public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	final public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	final public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	final public void setCor(String cor) {
		this.cor = cor;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}

	final public void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}	
	
	public int getVelocMax() {
		return velocMax;
	}

	final public void setVelocMax(int velocMax) throws VelocException{
		if ((velocMax >= 100) && (velocMax <= 250)) {
			this.velocMax = velocMax;	
		} else 
			throw new VelocException();
	}

	public Motor getMotor() {
		return motor;
	}

	final public void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public abstract int calcVel();
	
	public void impVeiculo(){		
		System.out.println("\nPlaca.........: " + this.getPlaca());
		System.out.println("Marca.........: " + this.getMarca());
		System.out.println("Modelo........: " + this.getModelo());
		System.out.println("Potência......: " + this.getMotor().getPotencia());
		System.out.println("Qtd de Pistões: " + this.getMotor().getQtdPist());
		System.out.println("Cor...........: " + this.getCor());
		System.out.println("Qtd de Rodas..: " + this.getQtdRodas());
	}
	
}
