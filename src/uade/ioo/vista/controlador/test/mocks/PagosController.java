package uade.ioo.vista.controlador.test.mocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequeTercero;
import uade.ioo.modelo.ChequeTercero.EstadoCheque;
import uade.ioo.vista.comportamiento.IVistaPagos;

public class PagosController implements ActionListener{

	private AdministradorPagos modelo;
	private IVistaPagos view;
	
	public PagosController(AdministradorPagos modelo, IVistaPagos view) {
		this.modelo = modelo;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(validData()){
			
			List<Cheque> chequesParaPagar = new ArrayList<Cheque>();
			List<ChequeTercero> chequesTerceros = modelo.getChequesTerceros();
			
			double sum = 0;
			String chequesAUtilizar = "<i><u>Cheques de Tercero:</u></i><br>";
			
			for(ChequeTercero c : chequesTerceros){
				if(c.getEstado() == EstadoCheque.RECIBIDO && sum + c.getMonto() <= view.getMontoAPagar()){
					sum += c.getMonto();
					chequesAUtilizar += "&#9;- Nro. " + c.getNumero() + " Monto $" + c.getMonto() + "<br>";  
					chequesParaPagar.add(c);
				}
			}
			
			double dif = view.getMontoAPagar() - sum;
			
			if(dif > 0){
				Cheque nuevoCheque = modelo.generarChequeNuevo(dif);
				chequesAUtilizar += "<i><u>Cheque Propio:</u></i><br>&#9;- Nro. " + nuevoCheque.getNumero() + " Monto $" + nuevoCheque.getMonto() + "<br>";
				chequesParaPagar.add(nuevoCheque);
			}
			
			JEditorPane message = new JEditorPane("text/html", "");
			message.setText("<b>Desea pagar con los siguientes cheques?</b><br><br>" + chequesAUtilizar);
			
			int dialogResult = JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION);
			
			if(dialogResult == JOptionPane.YES_OPTION){
				
				for(Cheque c : chequesParaPagar){
					if(c.getClass() == ChequeTercero.class){
						((ChequeTercero)c).setEstado(EstadoCheque.ENTREGADO);
					}else{
						modelo.registrarCheque(c);
					}
				}
				
				JOptionPane.showMessageDialog(null, "¡El pago se realizó correctamente!");
				
				modelo.notificar();
				resetForm();
			}else{		
				
				dialogResult = JOptionPane.showConfirmDialog (null, "Desea generar un cheque propio con el total del monto a pagar?", "Confirmar", JOptionPane.YES_NO_OPTION);
				
				if(dialogResult == JOptionPane.YES_OPTION){
					
					chequesParaPagar.clear();
					chequesParaPagar.add(modelo.generarChequeNuevo(view.getMontoAPagar()));
					
					JOptionPane.showMessageDialog(null, "¡El pago se realizó correctamente!");
					
					resetForm();
				}
			}
		}
	}
	
	private boolean validData(){
		
		if(view.getMontoAPagar() <= 0){
			JOptionPane.showMessageDialog(null, "El Monto a pagar debe ser un valor numérico positivo.");
			return false;
		}
		
		return true;
		
	}
	
	private void resetForm(){

		view.setMontoAPagar("");
	}

}
