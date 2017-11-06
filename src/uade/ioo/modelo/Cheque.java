package uade.ioo.modelo;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public abstract class Cheque {

	protected int numero;
	protected double monto;
	protected Date fechaEmision;

	public Cheque(int numero, double monto, Date fechaEmision){
		this.numero = numero;
		this.monto = monto;
		this.fechaEmision = fechaEmision;
	}
	
	public int getNumero() {
		return numero;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}
	
	public boolean sePuedePagarCon(){
		return TimeUnit.DAYS.convert(new Date().getTime() - fechaEmision.getTime(), TimeUnit.DAYS) <= 30;
	}
	
	public double getMontoDisponiblePago(){
		return monto;
	}
}
