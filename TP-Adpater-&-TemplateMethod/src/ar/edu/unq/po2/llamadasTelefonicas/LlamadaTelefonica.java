package ar.edu.unq.po2.llamadasTelefonicas;

public abstract class LlamadaTelefonica {
	private int tiempo;
	private int horaDelDia;
	
	public LlamadaTelefonica(int tiempo, int horaDelDia){
		this.tiempo=tiempo;
		this.horaDelDia=horaDelDia;
	}
	
	public float costoFinal(){
		if(this.esHoraPico()){
			return this.costoNeto()*1.2f*this.getTiempo();
	}else{
		return this.costoNeto()*this.getTiempo();
		}
	}
	
	public abstract boolean esHoraPico();
	
	public float costoNeto(){
		return this.getTiempo()*1;
	}
	
	public int getTiempo(){
		return this.tiempo;
	}	
	
	public int getHoraDelDia(){
		return this.horaDelDia;
	}
}
