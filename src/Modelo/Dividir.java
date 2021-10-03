package Modelo;

public class Dividir implements Operable{

	@Override
	public Float hacerOperacion(float numeroUno, float numeroDos) {
		if (numeroDos != 0) {
			return numeroUno/numeroDos;
		}
		return null;
	}

}
