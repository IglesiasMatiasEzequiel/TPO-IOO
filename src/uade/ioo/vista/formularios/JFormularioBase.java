package uade.ioo.vista.formularios;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.observer.IObservador;

public abstract class JFormularioBase extends JFrame implements IObservador{
	
	private static final long serialVersionUID = 1L;

	private AdministradorPagos modelo;
	
	public JFormularioBase(AdministradorPagos modelo){
		this.modelo = modelo;
		this.modelo.registrarObservador(this);
		
		this.setSize(640, 480);
		this.setLocationRelativeTo(null);
	}

	protected AdministradorPagos getModelo() {
		return modelo;
	}
	
	protected void setComponentSize(Component component, int width, int height){
		component.setMinimumSize(new Dimension(width, height));
		component.setPreferredSize(new Dimension(width, height));
		component.setMaximumSize(new Dimension(width, height));
	}
	
	protected void setPanelMargin(JPanel panel, int top, int right, int bottom, int left){
		panel.setBorder(new CompoundBorder(null, new EmptyBorder(top, left, bottom, right)));
	}
	
	protected void setScrollPanelMargin(JScrollPane panel, int top, int right, int bottom, int left){
		panel.setBorder(new CompoundBorder(null, new EmptyBorder(top, left, bottom, right)));
	}
	
	protected void setButtonMargin(JButton btn, int top, int right, int bottom, int left){
		btn.setBorder(new EmptyBorder(50, 50, 50, 50));
	}
	
	@Override
	public void actualizar(){
	}
}
