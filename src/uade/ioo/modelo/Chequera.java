package uade.ioo.modelo;

public class Chequera {

	private int numeroCheque;

	public Chequera(){
		numeroCheque = 0;
	}
	
	public int getNumeroCheque() {
		int num = numeroCheque;
		numeroCheque++;
		return num;
	}
}
