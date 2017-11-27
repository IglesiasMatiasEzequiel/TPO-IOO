package uade.ioo.vista.modeloVista;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import uade.ioo.modelo.ChequeTercero;

public class TablaChequesProximosAVencer extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	public String[] colNames = { "N° Cheque", "Monto", "Fec. Emisión", "Estado"};
	private List<ChequeTercero> lista;
	
	
	public TablaChequesProximosAVencer(List<ChequeTercero> lista){
		super();
		this.lista = lista;
	};
	
	public void setLista(List<ChequeTercero> lista){
		this.lista = lista;
	}
	
	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		ChequeTercero cheque = (ChequeTercero) lista.get(row);

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
		
	      switch (col) {
	      case 0:
	        return cheque.getNumero();
	      case 1:
	        return cheque.getMonto();
	      case 2:
	        return df.format(cheque.getFechaEmision());
	      case 3:
		        return cheque.getEstado();
	      default:
	    	  return "";
	      }
	}
	
	public String getColumnName(int col) {
      return colNames[col];
    }
}
