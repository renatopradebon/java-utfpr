/**
*
* @author Diego Vitorino dos Santos
*/

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {

	private List<Passeio> BDPasseio;
	private List<Carga> BDCarga;
	
	public BDVeiculos(){
		BDPasseio = new ArrayList<Passeio>();
		BDCarga = new ArrayList<Carga>();
	} 
	
	public int consPasseio(Passeio pas, int endereco){
		endereco = -1;
		for (int i = 0; i < BDPasseio.size(); i++) {
			if (BDPasseio.get(i).getPlaca().equals(pas.getPlaca())) {				
				return i;
			}
		}
		return endereco;
	}
	
	public Passeio consPasseio(Passeio pas){
		for (int i = 0; i < BDPasseio.size(); i++) {
			if (BDPasseio.get(i).getPlaca().equals(pas.getPlaca())) {
				return BDPasseio.get(i);
			}
		}		
		return null;
	}
	
	public int consCarga(Carga carg, int endereco){
		endereco = -1;
		for (int i = 0; i < BDCarga.size(); i++) {
			if (BDCarga.get(i).getPlaca().equals(carg.getPlaca())) {
				return i;
			}
		}
		return endereco;
	}
	
	public Carga consCarga(Carga carg){
		for (int i = 0; i < BDCarga.size(); i++) {
			if (BDCarga.get(i).getPlaca().equals(carg.getPlaca())) {
				return BDCarga.get(i);
			}
		}		
		return null;
	}	
	
	public void setBDPasseio(Passeio pas) throws VeicExistException{
		if (consPasseio(pas)==null) {
			BDPasseio.add(pas);
		} else
			throw new VeicExistException();
	}
	
	public void setBDCarga(Carga carg) throws VeicExistException{
		if (consCarga(carg)==null) {
			BDCarga.add(carg);
		} else
			throw new VeicExistException();
	}
	
	public void impListaPasseio(){
		for (int i = 0; i < BDPasseio.size(); i++) {
			BDPasseio.get(i).impVeiculo();
		}
	}
	
	public void impListaCarga(){
		for (int i = 0; i < BDCarga.size(); i++) {
			BDCarga.get(i).impVeiculo();
		}
	}	

	public List<Passeio> getBDPasseio(){
		return BDPasseio;		
	}
	
	public List<Carga> getBDCarga(){
		return BDCarga;		
	}
	
	public void altVeiculoBDPasseio(int local, Passeio pas){
		BDPasseio.set(local, pas); // altera obj da lista
	}
	
	public void altVeiculoBDCarga(int local, Carga carg){
		BDCarga.set(local, carg); // altera obj da lista
	}
	
}
