package uade.ioo.vista.comportamiento;

import java.util.Date;

public interface IVistaCobrarServicios {
	
	public int getNumeroCheque();

	public double getMonto();
	
	public Date getFechaEmision();
	
	public void setNumeroCheque(String text);
	
	public void setMonto(String text);
	
	public void setFechaEmision(String text);
}
