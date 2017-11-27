package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.List;

import uade.ioo.modelo.ChequeTercero.EstadoCheque;
import uade.ioo.modelo.observer.Observado;

public class AdministradorPagos extends Observado{

	private Chequera chequera;
	private List<Cheque> cheques;
	
	public AdministradorPagos(){
		this.chequera = new Chequera();
		this.cheques = new ArrayList<Cheque>();
	}
	
	public Chequera getChequera() {
		return chequera;
	}
	
	public void registrarCheque(Cheque cheque){
		this.cheques.add(cheque);
		this.notificar();
	}
	
	public double getMontoTotalCheques(){
		double result = 0;
		for(Cheque c : this.cheques){
			result += c.getMonto();
		}
		return result;
	}

	public Cheque generarChequeNuevo(double monto) {
		return new ChequePropio(chequera.getNumeroCheque(), monto);
	}

	public List<Cheque> getCheques() {
		return cheques;
	}
	
	public List<ChequeTercero> getChequesTerceros() {
		
		List<ChequeTercero> chequesTerceros = new ArrayList<ChequeTercero>();
		
		for(Cheque c : cheques){
			if(c.getClass() == ChequeTercero.class){
				chequesTerceros.add((ChequeTercero)c);
			}
		}
		return chequesTerceros;
	}
	
	public List<ChequeTercero> getChequesTercerosProximosAVencer() {
		
		List<ChequeTercero> chequesTerceros = new ArrayList<ChequeTercero>();
		
		for(Cheque c : cheques){
			if(c.getClass() == ChequeTercero.class && ((ChequeTercero)c).getEstado() == EstadoCheque.RECIBIDO && c.esProximoAVencer()){
				chequesTerceros.add((ChequeTercero)c);
			}
		}
		return chequesTerceros;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}

}
