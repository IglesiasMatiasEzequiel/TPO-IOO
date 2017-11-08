package uade.ioo.vista.formularios;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import uade.ioo.modelo.AdministradorPagos;

public class JFormMenu extends JFrame{

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
	
	protected AdministradorPagos modelo;
	
	public JFormMenu(AdministradorPagos modelo){
		super();
		this.modelo = modelo;
		
		initializeForm();
		initializeMenu();
	}
	
	private void initializeForm(){
		
		this.setTitle("Administración de Cheques");
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 400);
		
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
			public void actionPerformed(ActionEvent arg0) {
				openRealizarPagoForm();
			}
		}); 
		
		menuItemAnalizarCashflow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openCobrarServiciosForm();
			}
		});
		
		menuItemUtilizarChequesTerceros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openCobrarServiciosForm();
			}
		});
		
		menuItemGenerarChequePropio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openCobrarServiciosForm();
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
	
	private void openRealizarPagoForm(){
		JFormRealizarPago form = new JFormRealizarPago(); 
		form.setVisible(true);
	}
	
	private void openCobrarServiciosForm(){
		JFormCobrarServicios form = new JFormCobrarServicios(); 
		form.setVisible(true);
	}
	
	private void openAnalizarCashflowForm(){
		JFormAnalizarCashflow form = new JFormAnalizarCashflow(); 
		form.setVisible(true);
	}
	
	public AdministradorPagos getModelo() {
		return modelo;
	}

}
