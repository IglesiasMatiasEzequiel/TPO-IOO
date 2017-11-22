package uade.ioo.vista.controlador.test.mocks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequePropio;
import uade.ioo.vista.formularios.JFormGenerarChequePropio;

public class GenerarChequePropioController {

	private JFormGenerarChequePropio view;
	
	private List<Cheque> cheques;
	
	public GenerarChequePropioController(JFormGenerarChequePropio view, List<Cheque> cheques) {
		this.view = view;
		this.cheques = cheques;
		
		view.addGenerarChequeListener(new GenerarCheque());
		view.addCancelarListener(new Cancelar());
	}
	
	public class GenerarCheque implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			cheques.add(new ChequePropio(view.getNumeroCheque(), view.getMonto()));
		}
	}
	
	public class Cancelar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
