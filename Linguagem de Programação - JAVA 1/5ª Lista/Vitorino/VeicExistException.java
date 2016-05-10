/**
*
* @author Diego Vitorino dos Santos
*/
public class VeicExistException extends Exception{
	
	public VeicExistException() {
		
	}

	public void impErro(){
		System.out.println("Ja existe um veículo com esta PLACA cadastrada!");
	}
}
