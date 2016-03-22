package veiculo;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public final class Passeio extends Veiculo{
    
    private int qtdePassageiros;

    public Passeio() {
        this.qtdePassageiros = 0;
    }

    public Passeio(int qtdePassageiros, String placa, String marca, String modelo, int velocMax, Motor motor) {
        super(placa, marca, modelo, velocMax, motor);
        this.qtdePassageiros = qtdePassageiros;
    }

    public int getQtdePassageiros() {
        return qtdePassageiros;
    }

    public final void setQtdePassageiros(int qtdePassageiros) {
        this.qtdePassageiros = qtdePassageiros;
    }

    @Override
    public String toString() {
        return "Passeio{" + "qtdePassageiros=" + qtdePassageiros + '}';
    }        

    @Override
    public int calcVel() {
        return super.getVelocMax() * 1000;
    }
    
    @Override
    public String velocidadeString() {
        return calcVel() + " m/h";
    }
    
    @Override
    public String informacoesVeiculo() {
        return "    Tipo de Veículo: Passeio\n"
             + "    Quantidade de Passageiros: " + getQtdePassageiros();
    }
}