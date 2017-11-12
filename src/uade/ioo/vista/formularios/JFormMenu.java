package uade.ioo.vista.formularios;

import java.awt.GridBagLayout;
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
	
	//Listener Events
	
	public void addGenerarChequePropioListener(ActionListener e) {
		menuItemGenerarChequePropio.addActionListener(e);
    }
	
	public void addUtilizarChequesTercerosListener(ActionListener e) {
		menuItemUtilizarChequesTerceros.addActionListener(e);
    }
	
	public void addCobrarServiciosListener(ActionListener e) {
		menuItemCobrarServicios.addActionListener(e);
    }
	
	public void addAnalizarCashflowListener(ActionListener e) {
		menuItemAnalizarCashflow.addActionListener(e);
    }
	
	//region Getters and Setters
	
	public AdministradorPagos getModelo() {
		return modelo;
	}

}
