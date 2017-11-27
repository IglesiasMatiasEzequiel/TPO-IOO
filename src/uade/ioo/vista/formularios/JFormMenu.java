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
	
	private JMenuItem menuItemCobrarServicios;
	private JMenuItem menuItemAnalizarCashflow;
	private JMenuItem menuItemPagar;
	private JMenuItem menuItemDepositarCheques;
	
	public JFormMenu(AdministradorPagos modelo){
		super(modelo);
		
		initializeForm();
		initializeMenu();
	}
	
	private void initializeForm(){
		
		this.setTitle("Administración de Cheques");
		this.getContentPane().setLayout(new GridBagLayout());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initializeMenu(){
		
		menuBar = new JMenuBar();
		
		menuPagos = new JMenu("Pagos");
		menuCobranzas = new JMenu("Cobranzas");
		menuGerencia = new JMenu("Gerencia");
		
		menuItemCobrarServicios = new JMenuItem("Cobrar Servicios Realizados");
		menuItemAnalizarCashflow = new JMenuItem("Analizar Cashflow");
		menuItemPagar = new JMenuItem("Pagar");
		menuItemDepositarCheques = new JMenuItem("Depositar Cheques");
		
		menuItemCobrarServicios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFormCobrarServicios view = new JFormCobrarServicios(getModelo());				
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
		
		menuItemPagar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFormPagos form = new JFormPagos(getModelo()); 
				form.setVisible(true);
			}
		});
		
		menuItemDepositarCheques.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFormDepositarCheques view = new JFormDepositarCheques(getModelo());			
				view.setVisible(true);
			}
		});
		
		menuPagos.add(menuItemPagar);
		menuCobranzas.add(menuItemCobrarServicios);
		menuGerencia.add(menuItemAnalizarCashflow);
		menuGerencia.add(menuItemDepositarCheques);
		
		menuBar.add(menuPagos);
		menuBar.add(menuCobranzas);
		menuBar.add(menuGerencia);
		
		this.setJMenuBar(menuBar);
	}

	@Override
	public void actualizar() { 
	}

}
