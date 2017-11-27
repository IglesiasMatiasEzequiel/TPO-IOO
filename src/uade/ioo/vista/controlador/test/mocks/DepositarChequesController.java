package uade.ioo.vista.controlador.test.mocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.ChequeTercero;
import uade.ioo.modelo.ChequeTercero.EstadoCheque;
import uade.ioo.vista.comportamiento.IVistaDepositarCheques;

public class DepositarChequesController implements ActionListener{

	private AdministradorPagos modelo;
	private IVistaDepositarCheques view;
	
	public DepositarChequesController(AdministradorPagos modelo, IVistaDepositarCheques view) {
		this.modelo = modelo;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(validData()){
			
			List<ChequeTercero> chequesADepositar = modelo.getChequesTercerosProximosAVencer();
			
			String chequesAVencer = "<i><u>Cheques a Vencer:</u></i><br>";
			
			for(ChequeTercero c : chequesADepositar){
					chequesAVencer += "&#9;- Nro. " + c.getNumero() + " Monto $" + c.getMonto() + "<br>";  
			}
			
			JEditorPane message = new JEditorPane("text/html", "");
			message.setText("<b>Desea depositar los siguientes cheques?</b><br><br>" + chequesAVencer);
			
			int dialogResult = JOptionPane.showConfirmDialog(null, message, "Confirmar", JOptionPane.YES_NO_OPTION);
			
			if(dialogResult == JOptionPane.YES_OPTION){
				
				for(ChequeTercero c : chequesADepositar){
					if(c.getClass() == ChequeTercero.class){
						c.setEstado(EstadoCheque.DEPOSITADO);
					}
				}
				
				JOptionPane.showMessageDialog(null, "¡Los cheques se depositaron correctamente!");
				
				modelo.notificar();
			}
		}
	}
	
	private boolean validData(){
		
		if(modelo.getChequesTercerosProximosAVencer().size() <= 0){
			JOptionPane.showMessageDialog(null, "No hay cheques próximos a vencer.");
			return false;
		}
		
		return true;
	}

}
