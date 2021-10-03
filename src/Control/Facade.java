package Control;

import Modelo.Dividir;
import Modelo.Multiplicar;
import Modelo.Operable;
import Modelo.Resta;
import Modelo.Suma;

public class Facade {
	
	private Operable operable;
	
	public Operable getOperable(char operador) {
		switch (operador) {
			case '+': {
				return new Suma();	
			}
			case '-': {
				return new Resta();
			}
			case 'X': {
				return new Multiplicar();
			}
			case '/': {
				return new Dividir();
			}
		}
		return null;
	}
	
	public Float hacerOperacion(String[] numerosAOperar, Operable operador) {	
		return operador.hacerOperacion(Float.valueOf(numerosAOperar[0]),Float.valueOf(numerosAOperar[1]));
	}

}
