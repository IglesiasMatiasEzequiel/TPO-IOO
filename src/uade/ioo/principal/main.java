package uade.ioo.principal;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.controlador.test.mocks.AdministradorPagosController;
import uade.ioo.vista.formularios.JFormMenu;

public class main {

	public static void main(String[] args) {
		
		
		 AdministradorPagos model = new AdministradorPagos();
		 JFormMenu view = new JFormMenu(new AdministradorPagos());
		 AdministradorPagosController controller = new AdministradorPagosController(model, view); 
		 
		 view.setVisible(true);
	}
}
