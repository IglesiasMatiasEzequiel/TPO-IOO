package uade.ioo.vista.controlador.test.mocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		
		if(validData()){
			this.modelo.registrarCheque(new ChequeTercero(view.getNumeroCheque(), view.getMonto(), view.getFechaEmision()));
			this.modelo.notificar();
			JOptionPane.showMessageDialog(null, "�El Cheque se cobr� satisfactoriamente!");
			resetForm();
		}
	}
	
	private boolean validData(){
		
		if(view.getNumeroCheque() <= 0){
			JOptionPane.showMessageDialog(null, "El N�mero de cheque debe ser un valor num�rico mayor a 0.");
			return false;
		}
		
		if(view.getMonto() <= 0){
			JOptionPane.showMessageDialog(null, "El Monto debe ser un valor num�rico positivo.");
			return false;
		}
		
		if(view.getFechaEmision() == null){
			JOptionPane.showMessageDialog(null, "La fecha es inv�lida. El formato es dd/MM/yyyy.");
			return false;
		}
		
		return true;
		
	}
	
	private void resetForm(){
		
		view.setNumeroCheque("");
		view.setMonto("");
		view.setFechaEmision("");
	}

}
