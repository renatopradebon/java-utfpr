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

    public Passeio(int qtdePassageiros, String placa, String marca, String modelo, int velocMax, Motor motor, String cor) {
        super(placa, marca, modelo, velocMax, motor, cor);
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
        return calcVel() + " M/h";
    }
    
    @Override
    public String informacoesVeiculo() {
        return "    Quantidade de Passageiros: " + getQtdePassageiros();
    }
}