package uade.ioo.modelo;

public class AdministradorPagos {

	private Chequera chequera;
	
	public AdministradorPagos(){
		this.chequera = new Chequera();
	}
	
	public Chequera getChequera() {
		return chequera;
	}

	public void obtenerChequesParaPagar(double monto) {

	}

	public Cheque generarChequeNuevo(double monto) {
		chequera.setUltimoNumero(chequera.getUltimoNumero() + 1);
		return new ChequePropio(chequera.getUltimoNumero(), monto);
	}

	public double getMontoDisponiblePagos() {
		return 0;
	}

}
