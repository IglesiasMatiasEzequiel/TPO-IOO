package uade.ioo.principal;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.formularios.JFormMenu;

public class main {

	public static void main(String[] args) {
		
		 
		
		 JFormMenu mainForm = new JFormMenu(new AdministradorPagos());
		 
		 mainForm.setVisible(true);
	}
}
