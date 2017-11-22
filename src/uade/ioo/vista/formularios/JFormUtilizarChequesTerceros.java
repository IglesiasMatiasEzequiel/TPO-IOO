package uade.ioo.vista.formularios;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.modeloVista.MiModeloChequesUsados;

public class JFormUtilizarChequesTerceros extends JFormularioBase {

	private static final long serialVersionUID = 1L;

	JTextField txtMontoAPagar = new JTextField();
	JButton btnPagar = new JButton("Determinar Cheques a usar");
	JTable tabla;
	
	public JFormUtilizarChequesTerceros(AdministradorPagos modelo) {

		super(modelo);
		initializeForm();
		initialize();
	}

	private void initializeForm() {

		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setSize(400, 400);
	}
	
	private void initialize(){
		this.getContentPane().add(new JLabel("Monto a Pagar: "));
		this.getContentPane().add(txtMontoAPagar);
		this.getContentPane().add(btnPagar);
		btnPagar.setMaximumSize(getMaximumSize());
		this.tabla = new JTable(new MiModeloChequesUsados());
		this.getContentPane().add(this.tabla);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

}
