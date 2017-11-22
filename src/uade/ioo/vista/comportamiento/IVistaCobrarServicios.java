package uade.ioo.vista.comportamiento;

import java.util.Date;

import uade.ioo.modelo.ChequeTercero.EstadoCheque;

public interface IVistaCobrarServicios {
	
	int getNumeroCheque();

	double getMonto();
	
	EstadoCheque getEstadoCheque();
	
	Date getFechaEmision();
}
