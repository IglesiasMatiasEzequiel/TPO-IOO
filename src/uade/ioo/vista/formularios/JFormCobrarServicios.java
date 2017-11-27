package uade.ioo.vista.formularios;

import java.awt.BorderLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaCobrarServicios;
import uade.ioo.vista.controlador.test.mocks.CobrarServiciosController;

public class JFormCobrarServicios extends JFormularioBase implements IVistaCobrarServicios{

	private static final long serialVersionUID = 1L;
	
	private JTextField txtNumeroCheque;
	private JTextField txtMonto;
	private JTextField txtFechaEmision;
	private JButton btnCobrarServicios;
	
	public JFormCobrarServicios(AdministradorPagos modelo){
		
		super(modelo);
		
		initializeForm();
		initializeComponents();
	}
	
	private void initializeForm(){
		
		this.setTitle("Cobrar Servicios");
		this.setSize(300, 200);
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	}
	
	private void initializeComponents(){
		
		JLabel lblNumeroCheque = new JLabel("N° Cheque: ");
		JLabel lblMonto = new JLabel("Monto: ");
		JLabel lblFechaEmision = new JLabel("F. de Emisión: ");
		
		JPanel panelNumeroCheque = new JPanel(new BorderLayout());
		JPanel panelMonto = new JPanel(new BorderLayout());
		JPanel panelFechaEmision = new JPanel(new BorderLayout());
		JPanel panelBoton = new JPanel(new BorderLayout());
		
		txtNumeroCheque = new JTextField();
		txtMonto = new JTextField();
		txtFechaEmision = new JTextField();
		
		btnCobrarServicios = new JButton("Cobrar");
		
		panelNumeroCheque.add(lblNumeroCheque, BorderLayout.WEST);
		panelNumeroCheque.add(txtNumeroCheque, BorderLayout.CENTER);

		panelMonto.add(lblMonto, BorderLayout.WEST);
		panelMonto.add(txtMonto, BorderLayout.CENTER);

		panelFechaEmision.add(lblFechaEmision, BorderLayout.WEST);
		panelFechaEmision.add(txtFechaEmision, BorderLayout.CENTER);
		
		panelBoton.add(btnCobrarServicios, BorderLayout.CENTER);
		
		setComponentSize(lblNumeroCheque, 80, 0);
		setComponentSize(lblMonto, 80, 0);
		setComponentSize(lblFechaEmision, 80, 0);
		
		setComponentSize(txtNumeroCheque, 10, 0);
		setComponentSize(txtMonto, 10, 0);
		setComponentSize(txtFechaEmision, 10, 0);
		setComponentSize(btnCobrarServicios, 10, 0);
		
		setPanelMargin(panelNumeroCheque, 5, 5, 0, 5);
		setPanelMargin(panelMonto, 5, 5, 0, 5);
		setPanelMargin(panelFechaEmision, 5, 5, 0, 5);
		setPanelMargin(panelBoton, 5, 5, 5, 5);
		
		btnCobrarServicios.addActionListener(new CobrarServiciosController(getModelo(), this));
		
		this.getContentPane().add(panelNumeroCheque);
		this.getContentPane().add(panelMonto);
		this.getContentPane().add(panelFechaEmision);
		this.getContentPane().add(panelBoton);
	}
	
	@Override
	public int getNumeroCheque(){
		try{
			return Integer.parseInt(txtNumeroCheque.getText());
		}catch(NumberFormatException ex){
			return 0;
		}
	}
	
	@Override
	public void setNumeroCheque(String text){
		txtNumeroCheque.setText(text);
	}
	
	@Override
	public double getMonto() {
		try{
			return Double.parseDouble(txtMonto.getText());
		}catch(NumberFormatException ex){
			return 0;
		}
	}
	
	@Override
	public void setMonto(String text){
		txtMonto.setText(text);
	}
	
	@Override
	public Date getFechaEmision(){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		try{
			return df.parse(txtFechaEmision.getText());
		}catch(ParseException ex){
			return null;
		}
	}
	
	@Override
	public void setFechaEmision(String text){
		txtFechaEmision.setText(text);
	}
	
	@Override
	public void actualizar() {	
	}
}
