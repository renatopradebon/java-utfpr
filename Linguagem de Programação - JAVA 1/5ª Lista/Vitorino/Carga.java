

/**
*
* @author Diego Vitorino dos Santos
*/

final public class Carga extends Veiculo implements Calc {

	private int tara;
	private int cargaMax;
	
	public Carga(){
		this.tara = 0;
		this.cargaMax = 0;
	}
	
	public Carga(int tara, int cargaMax) {
		this.tara = tara;
		this.cargaMax = cargaMax;
	}

	public int getTara() {
		return tara;
	}

	final public void setTara(int tara) {
		this.tara = tara;
	}

	public int getCargaMax() {
		return cargaMax;
	}

	final public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}
	
	public int getVelocMax() {
		return this.calcVel();
	}

	@Override
	public int calcVel() {
		// calc velocMax(km) por 100.000 para sair em cm/h
		return super.getVelocMax() * 100000;
    }
	
	public void impVeiculo(){
		super.impVeiculo();
		System.out.println("Tara.....: " + this.getTara());
		System.out.println("Carga Max: " + this.getCargaMax());
		System.out.println("Velocidade Max: " + this.getVelocMax() + "Cm/h");
	}

	@Override
	public int calcular() {
		return this.getCargaMax() + this.getQtdRodas() + this.getTara() + this.getVelocMax()
		     + this.getMotor().getPotencia() + this.getMotor().getQtdPist();
	}
	
}
