package uade.ioo.vista.formularios;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uade.ioo.modelo.AdministradorPagos;

public class JFormMenu extends JFormularioBase{

	private static final long serialVersionUID = 1L;
	
	private JMenuBar menuBar;
	
	private JMenu menuPagos;
	private JMenu menuCobranzas;
	private JMenu menuGerencia;
	private JMenu menuRealizarPago;
	
	private JMenuItem menuItemCobrarServicios;
	private JMenuItem menuItemAnalizarCashflow;
	private JMenuItem menuItemUtilizarChequesTerceros;
	private JMenuItem menuItemGenerarChequePropio;
	
	public JFormMenu(AdministradorPagos modelo){
		super(modelo);
		
		initializeForm();
		initializeMenu();
	}
	
	private void initializeForm(){
		
		this.setTitle("Administración de Cheques");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new GridBagLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initializeMenu(){
		
		menuBar = new JMenuBar();
		
		menuPagos = new JMenu("Pagos");
		menuCobranzas = new JMenu("Cobranzas");
		menuGerencia = new JMenu("Gerencia");
		menuRealizarPago = new JMenu("Realizar Pago");
		
		menuItemCobrarServicios = new JMenuItem("Cobrar Servicios Realizados");
		menuItemAnalizarCashflow = new JMenuItem("Analizar Cashflow");
		menuItemUtilizarChequesTerceros = new JMenuItem("Utilizar Cheques Terceros");
		menuItemGenerarChequePropio = new JMenuItem("Generar Cheque Propio");
		
		menuItemCobrarServicios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFormCobrarServicios view = new JFormCobrarServicios(getModelo());
				//CobrarServiciosController controller = new CobrarServiciosController(view); 
				
				view.setVisible(true);
			}
		});
		
		menuItemAnalizarCashflow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFormAnalizarCashflow form = new JFormAnalizarCashflow(getModelo()); 
				form.setVisible(true);
			}
		});
		
		menuItemUtilizarChequesTerceros.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFormUtilizarChequesTerceros form = new JFormUtilizarChequesTerceros(getModelo()); 
				form.setVisible(true);
			}
		});
		
		menuItemGenerarChequePropio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFormGenerarChequePropio view = new JFormGenerarChequePropio(getModelo());
				//GenerarChequePropioController controller = new GenerarChequePropioController(view); 
				
				view.setVisible(true);
			}
		});
		
		menuRealizarPago.add(menuItemUtilizarChequesTerceros);
		menuRealizarPago.add(menuItemGenerarChequePropio);
		
		menuPagos.add(menuRealizarPago);
		menuCobranzas.add(menuItemCobrarServicios);
		menuGerencia.add(menuItemAnalizarCashflow);
		
		menuBar.add(menuPagos);
		menuBar.add(menuCobranzas);
		menuBar.add(menuGerencia);
		
		this.setJMenuBar(menuBar);
	}

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}

}
