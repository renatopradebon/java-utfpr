package utfpr.segundalista;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo();
        veiculo.setMarca("Volskwagem");
        veiculo.setModelo("Parati");
        veiculo.setPlaca("ALS-2721");
        veiculo.setVelocMax(185);
        veiculo.getMotor().setPotencia(112);
        veiculo.getMotor().setQtdPist(4);
        retonarDados(veiculo, 1);
        
        Veiculo veiculo2 = new Veiculo();
        veiculo2.setMarca("Renault");
        veiculo2.setModelo("Sandero");
        veiculo2.setPlaca("AZY-5237");
        veiculo2.setVelocMax(165);
        veiculo2.getMotor().setPotencia(107);
        veiculo2.getMotor().setQtdPist(4);
        retonarDados(veiculo2, 2);
        
        Veiculo veiculo3 = new Veiculo();        
        retonarDados(veiculo3, 3);
    }
    
    private static void retonarDados(Veiculo veiculo, int contadorVeiculos) {
        System.out.println("--------------------- Veiculo nº " + contadorVeiculos + " ---------------------");
        System.out.println("Dados do veiculo " + veiculo.getModelo() + ".");
        System.out.println("Marca: " + veiculo.getMarca()+ ".");
        System.out.println("Placa: " + veiculo.getPlaca()+ ".");
        System.out.println("Velocidade Máxima: " + veiculo.getVelocMax()+ " Km/h.");
        System.out.println("Potência do Motor: " + veiculo.getMotor().getPotencia()+ " Cavalo(s).");
        System.out.println("Quantidade de Pistões do Motor: " + veiculo.getMotor().getQtdPist()+ ".");        
        System.out.println("\n");
    }
}