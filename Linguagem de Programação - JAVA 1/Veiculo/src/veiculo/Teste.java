package veiculo;

/**
 *
 * @author Renato Sotolani Pradebon
 */
public class Teste {
    
    private static int contVeiculos = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Passeio passeio = new Passeio();
        passeio.setMarca("Renault");
        passeio.setModelo("Sandero");
        passeio.setPlaca("AZY-5237");
        passeio.setVelocMax(150);
        passeio.getMotor().setPotencia(200);
        passeio.getMotor().setQtdPist(4);
        passeio.setQtdePassageiros(5);
        
        retonarDados(passeio, getContVeiculos());
        
        Passeio passeio2 = new Passeio();
        passeio2.setMarca("Volkswagem");
        passeio2.setModelo("SpaceFox");
        passeio2.setPlaca("AZY-5238");
        passeio2.setVelocMax(160);
        passeio2.getMotor().setPotencia(180);
        passeio2.getMotor().setQtdPist(4);
        passeio2.setQtdePassageiros(4);
        
        retonarDados(passeio2, getContVeiculos());
        
        Carga carga = new Carga();
        carga.setMarca("Scannia");
        carga.setModelo("STREAMLINE");
        carga.setPlaca("AZY-5240");
        carga.setVelocMax(125);
        carga.getMotor().setPotencia(480);
        carga.getMotor().setQtdPist(8);
        carga.setCargaMax(75000);
        carga.setTara(15000);
        
        retonarDados(carga, getContVeiculos());        
                
        Carga carga2 = new Carga();
        carga2.setMarca("Volvo");
        carga2.setModelo("FH16");
        carga2.setPlaca("AZY-5241");
        carga2.setVelocMax(130);
        carga2.getMotor().setPotencia(520);
        carga2.getMotor().setQtdPist(8);
        carga2.setCargaMax(80000);
        carga2.setTara(15000);
        
        retonarDados(carga2, getContVeiculos());
        
        Carga carga3 = new Carga(16000, 90000, "HRR-1412", "MAN", "TGX 29,440", 130, new Motor(8, 560));
        retonarDados(carga3, getContVeiculos());
        
    }
    
    private static void retonarDados(Veiculo veiculo, int contadorVeiculos) {
        System.out.println("--------------------- Veículo nº " + contadorVeiculos + " ---------------------");
        System.out.println("Dados do veiculo " + veiculo.getModelo() + ".");
        System.out.println("Marca: " + veiculo.getMarca()+ ".");
        System.out.println("Placa: " + veiculo.getPlaca()+ ".");
        System.out.println("Velocidade Máxima: " + veiculo.velocidadeString());
        System.out.println("Potência do Motor: " + veiculo.getMotor().getPotencia() + " Cavalo(s).");
        System.out.println("Quantidade de Pistões do Motor: " + veiculo.getMotor().getQtdPist() + ".");
        System.out.println("Demais informações \n" + veiculo.informacoesVeiculo());        
        System.out.println("\n");
        incrementaContador();
    }
    
    private static void incrementaContador() {
        Teste.contVeiculos++;
    }
    
    private static int getContVeiculos() {
        return Teste.contVeiculos;
    }
}