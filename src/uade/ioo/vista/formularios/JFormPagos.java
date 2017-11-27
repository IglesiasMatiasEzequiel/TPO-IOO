package uade.ioo.vista.formularios;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaPagos;
import uade.ioo.vista.controlador.test.mocks.PagosController;
import uade.ioo.vista.modeloVista.TablaChequesTerceros;

public class JFormPagos extends JFormularioBase implements IVistaPagos{

	private static final long serialVersionUID = 1L;

	JTextField txtMontoAPagar; 
	JButton btnPagar;
	JTable tablaChequesTerceros;
	TablaChequesTerceros tableModel;
	
	public JFormPagos(AdministradorPagos modelo) {

		super(modelo);
		initializeForm();
		initializeComponents();
	}

	private void initializeForm() {

		this.setTitle("Pagos - Pagar");
		this.setSize(600, 250);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	}
	
	private void initializeComponents(){
		
		JLabel lblMontoAPagar = new JLabel("Monto a Pagar: ");
		JLabel lblChequesTerceros = new JLabel("Cheques de Terceros disponibles");
		lblChequesTerceros.setFont(new Font("TimesRoman", Font.BOLD, 16));
		
		JPanel panelMontoAPagar = new JPanel(new BorderLayout());
		JPanel panelChequesTerceros = new JPanel(new BorderLayout());
		JPanel panelBtn = new JPanel(new BorderLayout());
		JScrollPane panelTable = new JScrollPane(tablaChequesTerceros);
		
		btnPagar = new JButton("Determinar Cheques a usar");
		txtMontoAPagar = new JTextField();
		tableModel = new TablaChequesTerceros(getModelo().getChequesTerceros());
		tablaChequesTerceros = new JTable(tableModel);

		panelBtn.add(btnPagar);
		
		panelChequesTerceros.add(lblChequesTerceros);
		
		panelMontoAPagar.add(lblMontoAPagar, BorderLayout.WEST);
		panelMontoAPagar.add(txtMontoAPagar, BorderLayout.CENTER);
		panelMontoAPagar.add(panelBtn, BorderLayout.EAST);
		
		panelTable.getViewport().add(tablaChequesTerceros);
		
		setComponentSize(lblMontoAPagar, 100, 40);
		setComponentSize(txtMontoAPagar, 200, 40);
		setComponentSize(panelBtn, 200, 40);
		
		setPanelMargin(panelMontoAPagar, 5, 5, 20, 5);
		setPanelMargin(panelChequesTerceros, 5, 5, 5, 5);
		setPanelMargin(panelBtn, 0, 5, 0, 5);
		setScrollPanelMargin(panelTable, 0, 5, 0, 5);
		
		btnPagar.addActionListener(new PagosController(getModelo(), this));
		
		this.getContentPane().add(panelMontoAPagar);
		this.getContentPane().add(panelChequesTerceros);
		this.getContentPane().add(panelTable, BorderLayout.CENTER);
	}

	@Override
	public void actualizar() {
		tableModel.setLista(getModelo().getChequesTerceros());
		tableModel.fireTableDataChanged();
	}

	@Override
	public double getMontoAPagar() {
		try{
			return Double.parseDouble(txtMontoAPagar.getText());
		}catch(NumberFormatException ex){
			return 0;
		}
	}

	@Override
	public void setMontoAPagar(String text) {
		txtMontoAPagar.setText(text);
	}

}
