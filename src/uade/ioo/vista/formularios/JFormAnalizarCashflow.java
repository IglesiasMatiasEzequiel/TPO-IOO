package uade.ioo.vista.formularios;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.vista.comportamiento.IVistaAnalizarCashflow;
import uade.ioo.vista.controlador.test.mocks.AnalizarCashflowController;

public class JFormAnalizarCashflow extends JFormularioBase implements IVistaAnalizarCashflow{

	private static final long serialVersionUID = 1L;
	
	JLabel valueDisponibleTerceros;
	JLabel valuePagado;
	JLabel valueDepositado;
	JLabel valueEmitido;
	JLabel valueAVencer;
	
	public JFormAnalizarCashflow(AdministradorPagos modelo){
		
		super(modelo);
		
		initializeForm();
		initializeComponents();
		
		new AnalizarCashflowController(modelo, this).actionPerformed();
	}
	
	private void initializeForm(){
	
		this.setTitle("Gerencia - Analizar Cashflow");
		this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	}
	
	private void initializeComponents(){
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		
		cal.add(Calendar.DAY_OF_MONTH, -30);
		Date fechaDesde = cal.getTime();
		
		cal.add(Calendar.DAY_OF_MONTH, +60);
		Date fechaHasta = cal.getTime();
		
		JLabel lblPeriodoComprendido = new JLabel("Período comprendido desde " + df.format(fechaDesde) + " hasta " + df.format(fechaHasta));
		lblPeriodoComprendido.setFont(new Font("TimesRoman", Font.PLAIN, 16));
		
		JLabel lblDisponibleTerceros = new JLabel("Monto disponible Terceros: ");
		JLabel lblPagado = new JLabel("Monto Pagado: ");
		JLabel lblDepositado = new JLabel("Monto Depositado: ");
		JLabel lblEmitido = new JLabel("Monto Emitido: ");
		JLabel lblAVencer = new JLabel("Monto a Vencer: ");
		
		valueDisponibleTerceros = new JLabel("-");
		valuePagado = new JLabel("-");
		valueDepositado = new JLabel("-");
		valueEmitido = new JLabel("-");
		valueAVencer = new JLabel("-");
		
		JPanel panelPeriodo = new JPanel();
		JPanel panelDisponibleTerceros = new JPanel();
		JPanel panelPagado = new JPanel();
		JPanel panelDepositado = new JPanel();
		JPanel panelEmitido = new JPanel();
		JPanel panelAVencer = new JPanel();
		
		panelPeriodo.add(lblPeriodoComprendido);
		
		panelDisponibleTerceros.setAlignmentX(RIGHT_ALIGNMENT);
		panelDisponibleTerceros.add(lblDisponibleTerceros, BorderLayout.WEST);
		panelDisponibleTerceros.add(valueDisponibleTerceros, BorderLayout.CENTER);

		panelPagado.setAlignmentX(RIGHT_ALIGNMENT);
		panelPagado.add(lblPagado, BorderLayout.WEST);
		panelPagado.add(valuePagado, BorderLayout.CENTER);
		
		panelDepositado.setAlignmentX(RIGHT_ALIGNMENT);
		panelDepositado.add(lblDepositado, BorderLayout.WEST);
		panelDepositado.add(valueDepositado, BorderLayout.CENTER);
		
		panelEmitido.setAlignmentX(RIGHT_ALIGNMENT);
		panelEmitido.add(lblEmitido, BorderLayout.WEST);
		panelEmitido.add(valueEmitido, BorderLayout.CENTER);
		
		panelAVencer.setAlignmentX(RIGHT_ALIGNMENT);
		panelAVencer.add(lblAVencer, BorderLayout.WEST);
		panelAVencer.add(valueAVencer, BorderLayout.CENTER);		
		
		setComponentSize(lblDisponibleTerceros, 200, 10);
		setComponentSize(valueDisponibleTerceros, 150, 10);
		
		setComponentSize(lblPagado, 200, 10);
		setComponentSize(valuePagado, 150, 10);
		
		setComponentSize(lblDepositado, 200, 10);
		setComponentSize(valueDepositado, 150, 10);
		
		setComponentSize(lblEmitido, 200, 10);
		setComponentSize(valueEmitido, 150, 10);
		
		setComponentSize(lblAVencer, 200, 10);
		setComponentSize(valueAVencer, 150, 10);
		
		setPanelMargin(panelPeriodo, 5, 20, 0, 20);
		setPanelMargin(panelDisponibleTerceros, 5, 20, 0, 20);
		setPanelMargin(panelPagado, 5, 20, 0, 20);
		setPanelMargin(panelDepositado, 5, 20, 0, 20);
		setPanelMargin(panelEmitido, 5, 20, 0, 20);
		setPanelMargin(panelAVencer, 5, 20, 5, 20);
		
		this.getContentPane().add(panelPeriodo);
		this.getContentPane().add(panelDisponibleTerceros);
		this.getContentPane().add(panelPagado);
		this.getContentPane().add(panelDepositado);
		this.getContentPane().add(panelEmitido);
		this.getContentPane().add(panelAVencer);
	}

	@Override
	public void setValueDisponibleTerceros(String text) {
		valueDisponibleTerceros.setText(text);
	}

	@Override
	public void setValuePagado(String text) {
		valuePagado.setText(text);
	}

	@Override
	public void setValueDepositado(String text) {
		valueDepositado.setText(text);
	}

	@Override
	public void setValueEmitido(String text) {
		valueEmitido.setText(text);
	}

	@Override
	public void setValueAVencer(String text) {
		valueAVencer.setText(text);
	}

	@Override
	public void actualizar() {
		new AnalizarCashflowController(getModelo(), this).actionPerformed();
	}
	
}
