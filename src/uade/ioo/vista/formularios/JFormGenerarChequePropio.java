package uade.ioo.vista.formularios;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;

public class JFormGenerarChequePropio extends JFormularioBase{

	private static final long serialVersionUID = 1L;
	
	private JTextField txtNumeroCheque;
	private JTextField txtMonto;
	private JButton btnGenerarCheque;
	private JButton btnCancelar;

	public JFormGenerarChequePropio(AdministradorPagos modelo){
		
		super(modelo);
		
		initializeForm();
		initializeComponents();
	}
	
	private void initializeForm(){
		
		this.setTitle("Generar Cheque Propio");
		this.setLocationRelativeTo(null);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		this.setSize(400, 400);
	}
	
	private void setSize(Component component, int width, int height){
		component.setMinimumSize(new Dimension(width, height));
		component.setPreferredSize(new Dimension(width, height));
		component.setMaximumSize(new Dimension(width, height));
	}
	
	private void initializeComponents(){
		
		JLabel lblNumeroCheque = new JLabel("N° Cheque: ");
		JLabel lblMonto = new JLabel("Monto: ");
		
		JPanel panelNumeroCheque = new JPanel(new BorderLayout());
		JPanel panelMonto = new JPanel(new BorderLayout());
		
		txtNumeroCheque = new JTextField();
		txtMonto = new JTextField();
		
		btnGenerarCheque = new JButton("Generar");
		btnCancelar = new JButton("Cancelar");
		
		panelNumeroCheque.add(lblNumeroCheque, BorderLayout.WEST);
		panelNumeroCheque.add(txtNumeroCheque, BorderLayout.CENTER);

		panelMonto.add(lblMonto, BorderLayout.WEST);
		panelMonto.add(txtMonto, BorderLayout.CENTER);
		
		setSize(lblNumeroCheque, 100, 20);
		setSize(lblMonto, 100, 20);
		
		setSize(txtNumeroCheque, 10, 10);
		setSize(txtMonto, 10, 10);
		
		this.getContentPane().add(panelNumeroCheque);
		this.getContentPane().add(panelMonto);
		this.getContentPane().add(btnGenerarCheque);
		this.getContentPane().add(btnCancelar);
	}
	
	public int getNumeroCheque(){
		return Integer.parseInt(txtNumeroCheque.getText());
	}
	
	public double getMonto(){
		return Double.parseDouble(txtMonto.getText());
	}
	
	public Date getFechaEmision(){
		return new Date();
	}
	
	
	public void addGenerarChequeListener(ActionListener e) {
		btnGenerarCheque.addActionListener(e);
    }
	
	public void addCancelarListener(ActionListener e) {
		btnCancelar.addActionListener(e);
    }

	@Override
	public void actualizar() {
		// TODO Auto-generated method stub
		
	}
	
}
