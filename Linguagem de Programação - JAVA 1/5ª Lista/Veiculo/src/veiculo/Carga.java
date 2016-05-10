package veiculo;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public final class Carga extends Veiculo {

    private int tara;
    private int cargaMax;

    public Carga() {
        this.tara = 0;
        this.cargaMax = 0;
    }

    public Carga(int tara, int cargaMax, String placa, String marca, String modelo, int velocMax, Motor motor, String cor) {
        super(placa, marca, modelo, velocMax, motor, cor);
        this.tara = tara;
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public final void setTara(int tara) {
        this.tara = tara;
    }

    public final void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return "Carga{" + "tara=" + tara + ", cargaMax=" + cargaMax + '}';
    }

    @Override
    int calcVel() {
        return super.getVelocMax() * 100000;
    }

    @Override
    public String velocidadeString() {
        return calcVel() + " cm/h";
    }

    @Override
    public String informacoesVeiculo() {
        return "    Tara: " + getTara() + " Kg\n"
                + "    Carga Máxima: " + getCargaMax() + " Kg";
    }
}