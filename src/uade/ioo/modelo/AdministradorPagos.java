package uade.ioo.modelo;

import java.util.ArrayList;
import java.util.List;

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

	public void obtenerChequesParaPagar(double monto) {

	}
	
	public void registrarChequeTercero(ChequeTercero cheque){
		this.cheques.add(cheque);
		this.notificar();
	}
	
	public double getMontoTotalCheques(){
		double result = 0;
		for(Cheque c : this.cheques){
			result += c.getMontoDisponiblePago();
		}
		return result;
	}

	public Cheque generarChequeNuevo(double monto) {
		chequera.setUltimoNumero(chequera.getUltimoNumero() + 1);
		return new ChequePropio(chequera.getUltimoNumero(), monto);
	}

	public double getMontoDisponiblePagos() {
		return 0;
	}

	public List<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}

}
