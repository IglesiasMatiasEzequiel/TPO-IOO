package uade.ioo.modelo;

import java.util.Date;

public class ChequePropio extends Cheque{
	
	public ChequePropio(int numero, double monto){
		super(numero, monto, new Date());
	}
}
