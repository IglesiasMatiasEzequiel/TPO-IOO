package uade.ioo.vista.formularios;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JFormRealizarPago extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton btnUtilizarChequesTerceros;
	private JButton btnGenerarChequePropio;

	public JFormRealizarPago(){
		
		initializeForm();
		initializeButtons();
	}
	
	private void initializeForm(){
		
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setSize(400, 400);
	}
	
	private void initializeButtons(){
		
		btnUtilizarChequesTerceros = new JButton("Utilizar Cheques de Terceros");
		btnGenerarChequePropio = new JButton("Generar Cheque Propio");
		
		this.getContentPane().add(btnUtilizarChequesTerceros);
		this.getContentPane().add(btnGenerarChequePropio);
	}
	
}
