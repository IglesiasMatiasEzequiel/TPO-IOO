package uade.ioo.vista.controlador.test.mocks;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.formularios.JFormMenu;

public class AdministradorPagosController {
	
	private AdministradorPagos model;
	private JFormMenu view;

	public AdministradorPagosController(AdministradorPagos model, JFormMenu view) {
		this.model = model;
		this.view = view;
	}
	
}