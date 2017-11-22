package uade.ioo.vista.modeloVista;

import javax.swing.table.AbstractTableModel;

public class MiModeloChequesUsados extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return "Hola";
	}

}
