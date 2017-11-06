package uade.ioo.vista.formularios;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import uade.ioo.modelo.AdministradorPagos;

public class JFormMenu extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton btnRealizarPago;
	private JButton btnCobrarServicios;
	private JButton btnAnalizarCashflow;
	
	protected AdministradorPagos modelo;
	
	public JFormMenu(AdministradorPagos modelo){
		super();
		this.modelo = modelo;
		
		initializeForm();
		initializeButtons();
	}
	
	private void initializeForm(){
		
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new GridBagLayout());
		this.setSize(400, 400);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void initializeButtons(){
		
		btnRealizarPago = new JButton("Realizar Pago");
		btnCobrarServicios = new JButton("Cobrar Servicios");
		btnAnalizarCashflow = new JButton("Analizar Cashflow");
		
		btnRealizarPago.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openRealizarPagoForm();
			}
		});
		
		btnCobrarServicios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openCobrarServiciosForm();
			}
		});
		
		btnAnalizarCashflow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openAnalizarCashflowForm();
			}
		});
		
		this.getContentPane().add(btnRealizarPago);
		this.getContentPane().add(btnCobrarServicios);
		this.getContentPane().add(btnAnalizarCashflow);
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
