package uade.ioo.vista.controlador.test.mocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.ChequeTercero;
import uade.ioo.vista.comportamiento.IVistaCobrarServicios;

public class CobrarServiciosController implements ActionListener{

	private AdministradorPagos modelo;
	private IVistaCobrarServicios view;
	
	public CobrarServiciosController(AdministradorPagos modelo, IVistaCobrarServicios view) {
		this.modelo = modelo;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ChequeTercero c = new ChequeTercero(view.getNumeroCheque(), view.getMonto(), view.getFechaEmision());
		this.modelo.registrarChequeTercero(c);
	}

}
