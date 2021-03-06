package veiculo;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public abstract class Veiculo {
    
    private String placa;
    private String marca;
    private String modelo;
    private int velocMax;
    private Motor motor;

    public Veiculo() {
        this.placa = " ";
        this.marca = " ";
        this.modelo = " ";
        this.velocMax = 0;
        this.motor = new Motor();
    }

    public Veiculo(String placa, String marca, String modelo, int velocMax, Motor motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.velocMax = velocMax;
        this.motor = motor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getVelocMax() {
        return velocMax;
    }

    public Motor getMotor() {
        return motor;
    }

    public final void setPlaca(String placa) {
        this.placa = placa;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public final void setVelocMax(int velocMax) {
        this.velocMax = velocMax;
    }

    public final void setMotor(Motor motor) {
        this.motor = motor;
    }

    abstract int calcVel();

    abstract String velocidadeString();

    abstract String informacoesVeiculo();

    @Override
    public String toString() {
        return "Veiculo{" + "placa=" + placa + ", marca=" + marca + ", modelo=" + modelo + ", velocMax=" + velocMax + ", motor=" + motor + '}';
    }
}
