package Utiles;

public class Utiles {
	
	public static String[] concatenarOperadoresConNumeros(String[] numerosCortados, String[] cadenaCortadaOperadores) {
		String[] numerosSacados = new String[2];
		for (int i = 0,j = 0; i < numerosCortados.length; i++) {
			if(!numerosCortados[i].isEmpty()) {
				if(!cadenaCortadaOperadores[j].isEmpty()) {
					numerosSacados[j] = cadenaCortadaOperadores[j]+numerosCortados[i];
				}else {
					numerosSacados[j] = numerosCortados[i];
				}
				j++;
			}
		}
		return numerosSacados;
	}
	
	public static String[] quitarEspaciosEnBlanco(String[] cadenaCortadaOperadores) {
		String[] operadores = {"",""};
		for (int i = 0, j = 0; i < cadenaCortadaOperadores.length; i++) {
			if(!cadenaCortadaOperadores[i].isEmpty()) {
				if(i>1 && j !=1) {
					operadores[j+1] = cadenaCortadaOperadores[i];
					j++;		
				}else {
					operadores[j] = cadenaCortadaOperadores[i];		
				}
				j++;
			}
		}
		return operadores;
	}
	
	public static char getOperador(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (!Character.isDigit(text.charAt(i+1)) && text.charAt(i+1) != '.') {
				return text.charAt(i+1);
			}
		}
		return 0;
	}
	
	public static boolean isOperadorElUltimo(String text) {
		try {
			char letra = text.charAt(text.length()-1);
			if (!Character.isDigit(letra) && letra != ')') {
				return true;
			}
			return false;
		}catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isParentesisElUltimo(String text) {
		int lengthTexto = text.length()-1;
		try {
			String letra = text.substring(lengthTexto);
			if (letra.equals(")")) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public static String borrarUltimaLetra(String palabra) {
		String nuevaPalabra = "";
		for (int i = 0; i < palabra.length() - 1; i++) {
			nuevaPalabra = nuevaPalabra + palabra.charAt(i);
		}
		return nuevaPalabra;
	}
	
	public static String[] sacarOperadoresSinEspacios(String text) {
		String[] cadenaCortadaOperadores = text.split("[\\d.]+[+\\-/X.]|[\\d()]");
		return quitarEspaciosEnBlanco(cadenaCortadaOperadores);
	}
	
	public static boolean isPuntos(String texto) {
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == '.') {
				return true;
			}
		}
		return false;
	}

	public static boolean isParentesisAbierto(String texto) {
		boolean abierto = false;
		boolean cerrado = false;
		for (int i = 0; i < texto.length(); i++) {
			if (texto.charAt(i) == '(') {
				abierto = true;
			}else if (texto.charAt(i) == ')') {
				cerrado = true;
			}
		}
		if (abierto == true && cerrado == true) {
			return false;
		}else {
			if (abierto == true) {
				return true;
			} 
		}
		return false;
	}

}
