package uade.ioo.vista.formularios;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaDepositarCheques;
import uade.ioo.vista.controlador.test.mocks.DepositarChequesController;
import uade.ioo.vista.modeloVista.TablaChequesProximosAVencer;

public class JFormDepositarCheques extends JFormularioBase implements IVistaDepositarCheques{

	private static final long serialVersionUID = 1L;
 
	JButton btnDepositar;
	JTable tablaChequesADepositar;
	TablaChequesProximosAVencer tableModel;
	
	public JFormDepositarCheques(AdministradorPagos modelo) {

		super(modelo);
		initializeForm();
		initializeComponents();
	}

	private void initializeForm() {

		this.setTitle("Gerencia - Depositar Cheques");
		this.setSize(600,200);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	}
	
	private void initializeComponents(){
		
		JPanel panelBtn = new JPanel();
		JScrollPane panelTable = new JScrollPane();
		
		btnDepositar = new JButton("Depositar");
		tableModel = new TablaChequesProximosAVencer(getModelo().getChequesTercerosProximosAVencer());
		tablaChequesADepositar = new JTable(tableModel);
		
		panelBtn.add(btnDepositar);
		panelTable.getViewport().add(tablaChequesADepositar);
		
		setComponentSize(panelBtn, 200, 40);
		
		setPanelMargin(panelBtn, 0, 5, 0, 5);
		setScrollPanelMargin(panelTable, 5, 5, 5, 5);
		
		btnDepositar.addActionListener(new DepositarChequesController(getModelo(), this));
		
		this.getContentPane().add(panelTable, BorderLayout.CENTER);
		this.getContentPane().add(panelBtn);
	}
	
	@Override
	public void actualizar() {
		tableModel.setLista(getModelo().getChequesTercerosProximosAVencer());
		tableModel.fireTableDataChanged();
	}
}
