package uade.ioo.vista.formularios;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uade.ioo.modelo.ChequeTerceros.EstadoCheque;

public class JFormCobrarServicios extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JTextField txtNumeroCheque;
	private JTextField txtMonto;
	private JComboBox<EstadoCheque> cbEstado;
	private JButton btnCobrarServicios;
	private JButton btnCancelar;

	public JFormCobrarServicios(){
		
		initializeForm();
		initializeComponents();
	}
	
	private void initializeForm(){
		
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
		JLabel lblEstado = new JLabel("Estado: ");
		
		JPanel panelNumeroCheque = new JPanel(new BorderLayout());
		JPanel panelMonto = new JPanel(new BorderLayout());
		JPanel panelEstado = new JPanel(new BorderLayout());
		
		txtNumeroCheque = new JTextField();
		txtMonto = new JTextField();
		
		cbEstado = new JComboBox();
		cbEstado.addItem(EstadoCheque.RECIBIDO);
		cbEstado.addItem(EstadoCheque.ENTREGADO);
		cbEstado.addItem(EstadoCheque.DEPOSITADO);
		cbEstado.addItem(EstadoCheque.VENCIDO);
		
		btnCobrarServicios = new JButton("Cobrar");
		btnCancelar = new JButton("Cancelar");
		
		panelNumeroCheque.add(lblNumeroCheque, BorderLayout.WEST);
		panelNumeroCheque.add(txtNumeroCheque, BorderLayout.CENTER);

		panelMonto.add(lblMonto, BorderLayout.WEST);
		panelMonto.add(txtMonto, BorderLayout.CENTER);

		panelEstado.add(lblEstado, BorderLayout.WEST);
		panelEstado.add(cbEstado, BorderLayout.CENTER);
		
		setSize(lblNumeroCheque, 100, 20);
		setSize(lblMonto, 100, 20);
		setSize(lblEstado, 100, 20);
		
		this.getContentPane().add(panelNumeroCheque);
		this.getContentPane().add(panelMonto);
		this.getContentPane().add(panelEstado);
		this.getContentPane().add(btnCobrarServicios);
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
	
	public EstadoCheque getEstadoCheque(){
		return (EstadoCheque) cbEstado.getSelectedItem();
	}
	
	public void addCobrarServicioListener(ActionListener e) {
		btnCobrarServicios.addActionListener(e);
    }
	
	public void addCancelarListener(ActionListener e) {
		btnCancelar.addActionListener(e);
    }
	
}
