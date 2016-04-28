public class Cliente {
	
	private int codCli;
	private String nomeCli;
	private double salarioCli;
	private String profissaoCli;
		
	public void setCodCli(int codCli) {
		this.codCli = codCli;
	}
	
	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}
	
	public double calcSalarioCli(double base) {
		return base + (base * 0.1);
	}
	
	public void setSalarioCli(double  salarioCli) {
		this.salarioCli = calcSalarioCli(salarioCli);
	}
	
	public void setProfissaoCli(String profissaoCli) {
		this.profissaoCli = profissaoCli;
	}
	
	public int getCodCli() {
		return this.codCli;
	}
	
	public String getNomeCli() {
		return this.nomeCli;
	}
	
	public double getSalarioCli() {
		return this.salarioCli;
	}
	
	public String getProfissaoCli() {
		return this.profissaoCli;
	}
}
