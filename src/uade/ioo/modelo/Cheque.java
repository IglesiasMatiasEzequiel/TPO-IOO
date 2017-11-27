package uade.ioo.modelo;

import java.util.Date;

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
	
	private long getDiffInDays(Date start, Date end){
		return (end.getTime() - start.getTime())/ (1000 * 60 * 60 * 24);
	}
	
	public boolean sePuedePagarCon(){
		return  getDiffInDays(fechaEmision, new Date()) <= 30;
	}
	
	public boolean esProximoAVencer(){
		long diff = getDiffInDays(fechaEmision, new Date());
		return diff >= 20 && diff <= 30;
	}
	
	public double getMonto(){
		return monto;
	}
}
