package uade.ioo.vista.controlador.test.mocks;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import uade.ioo.modelo.AdministradorPagos;
import uade.ioo.modelo.Cheque;
import uade.ioo.modelo.ChequePropio;
import uade.ioo.modelo.ChequeTercero;
import uade.ioo.modelo.ChequeTercero.EstadoCheque;
import uade.ioo.vista.comportamiento.IVistaAnalizarCashflow;

public class AnalizarCashflowController {

	private AdministradorPagos modelo;
	private IVistaAnalizarCashflow view;

	public AnalizarCashflowController(AdministradorPagos modelo, IVistaAnalizarCashflow view) {
		this.modelo = modelo;
		this.view = view;
	}

	public void actionPerformed() {

		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());

		cal.add(Calendar.DAY_OF_MONTH, -30);
		Date fechaDesde = cal.getTime();

		cal.add(Calendar.DAY_OF_MONTH, +60);
		Date fechaHasta = cal.getTime();

		double disponibleTerceros = 0;
		double pagado = 0;
		double depositado = 0;
		double emitido = 0;
		double aVencer = 0;

		for (Cheque c : modelo.getCheques()) {
			if (c.getFechaEmision().after(fechaDesde)
					&& c.getFechaEmision().before(fechaHasta)) {
				if (c.getClass() == ChequeTercero.class) {

					ChequeTercero chequeTercero = (ChequeTercero) c;

					if (chequeTercero.getEstado() == EstadoCheque.RECIBIDO) {
						disponibleTerceros += chequeTercero.getMonto();

						if (chequeTercero.esProximoAVencer()) {
							aVencer += chequeTercero.getMonto();
						}
					} else if (chequeTercero.getEstado() == EstadoCheque.ENTREGADO) {
						pagado += chequeTercero.getMonto();
					} else if (chequeTercero.getEstado() == EstadoCheque.DEPOSITADO) {
						depositado += chequeTercero.getMonto();
					}

				} else {

					ChequePropio chequePropio = (ChequePropio) c;

					emitido += chequePropio.getMonto();
					pagado += chequePropio.getMonto();
				}
			}
		}

		view.setValueDisponibleTerceros(disponibleTerceros + "");
		view.setValuePagado(pagado + "");
		view.setValueDepositado(depositado + "");
		view.setValueEmitido(emitido + "");
		view.setValueAVencer(aVencer + "");
	}
}
