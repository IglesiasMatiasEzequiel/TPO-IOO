package uade.ioo.vista.formularios;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;

public class JFormAnalizarCashflow extends JFormularioBase{

	private static final long serialVersionUID = 1L;

	private JTextField lblMontoTotal;
	
	public JFormAnalizarCashflow(AdministradorPagos modelo){
		
		super(modelo);
		
		initializeForm();
		initialize();
	}
	
	private void initializeForm(){
	
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
	}
	
	private void initialize(){
		
		lblMontoTotal = new JTextField();
		lblMontoTotal.setText("0");
		lblMontoTotal.setSize(new Dimension(100,100));
		
		this.getContentPane().add(new JLabel("Monto total: "));
		this.getContentPane().add(lblMontoTotal);
	}

	@Override
	public void actualizar() {
		super.actualizar();
		this.lblMontoTotal.setText(Double.toString(this.getModelo().getMontoTotalCheques()));
	}
	
}
