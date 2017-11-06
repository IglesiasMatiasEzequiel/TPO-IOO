package uade.ioo.modelo;

import java.util.Date;

public class ChequeTerceros extends Cheque{

	public enum EstadoCheque {
		VENCIDO, 
		RECIBIDO,
		ENTREGADO,
		DEPOSITADO;
	};
	
	private EstadoCheque estado;

	public ChequeTerceros(int numero, double monto, Date fechaEmision){
		super(numero, monto, fechaEmision);
	}
	
	public EstadoCheque getEstado() {
		return estado;
	}

	public void setEstado(EstadoCheque estado) {
		this.estado = estado;
	}
	
}
