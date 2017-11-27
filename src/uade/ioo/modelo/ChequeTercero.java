package uade.ioo.modelo;

import java.util.Date;

public class ChequeTercero extends Cheque{

	public enum EstadoCheque {
		VENCIDO, 
		RECIBIDO,
		ENTREGADO,
		DEPOSITADO;
	};
	
	private EstadoCheque estado;

	public ChequeTercero(int numero, double monto, Date fechaEmision){
		
		super(numero, monto, fechaEmision);
		
		if(sePuedePagarCon()){
			estado = EstadoCheque.RECIBIDO;
		}else{
			estado = EstadoCheque.VENCIDO;
		}
	}
	
	public EstadoCheque getEstado() {
		return estado;
	}

	public void setEstado(EstadoCheque estado) {
		this.estado = estado;
	}
	
}
