package uade.ioo.principal;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequeTercero;
import uade.ioo.vista.formularios.JFormMenu;

public class main {

	public static void main(String[] args) {
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Cheque> cheques = new ArrayList<Cheque>();
		
		try{
		
			cheques.add(new ChequeTercero(1, 10000, df.parse("02/10/2017")));
			cheques.add(new ChequeTercero(2, 6000, df.parse("14/09/2017")));
			cheques.add(new ChequeTercero(3, 25000, df.parse("25/11/2017")));
			
		}catch(ParseException e){
			//ignore
		}
		
		AdministradorPagos model = new AdministradorPagos();
		model.setCheques(cheques);
		JFormMenu view = new JFormMenu(model);
		
		view.setVisible(true);
	}
}
