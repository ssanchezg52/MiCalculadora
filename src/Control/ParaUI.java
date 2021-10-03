package Control;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Utiles.Utiles;
import Vista.UI;

public class ParaUI extends UI {

	private Facade facade;

	private final JPanel[] PANELES = { getPanelBotonera(), getPanelOperaciones(), getPanelSur() };

	public ParaUI() {
		super();
		facade = new Facade();
		for (int i = 0; i < PANELES.length; i++) {
			annadirEventoBotones(PANELES[i]);
		}
	}

	private void annadirEventoBotones(JPanel panel) {
		Component[] components = panel.getComponents();
		for (Component component : components) {
			if (component instanceof JButton) {
				elegirPanelParaAnnadirEventos(panel, component);
			}
		}
	}

	private void elegirPanelParaAnnadirEventos(JPanel panel, Component component) {
		if (panel == getPanelBotonera()) {
			annadirEventoBotonPanelBotonera((JButton) component);
		} else if (panel == getPanelOperaciones()) {
			annadirEventoBotonPanelOperaciones((JButton) component);
		} else {
			annadirEventoBotonPanelSur((JButton) component);
		}
	}

	private void annadirEventoBotonPanelSur(JButton btn) {
		btn.addActionListener(e -> {
			JButton botonLlamado = (JButton) e.getSource();
			if (botonLlamado.getText() != "=") {
				setTextoEnPantalla("");
			} else {
				try {
					String[] numerosCortados = getTextoDeLaPantalla().split("[+\\-/X()]");
					String[] cadenaOperadoresSinEspacios = Utiles.sacarOperadoresSinEspacios(getTextoDeLaPantalla());
					char operador = Utiles.getOperador(getTextoDeLaPantalla());
					String[] numerosAOperar = Utiles.concatenarOperadoresConNumeros(numerosCortados,
							cadenaOperadoresSinEspacios);
					Float resultado = facade.hacerOperacion(numerosAOperar, facade.getOperable(operador));
					mostrarEnPantallaResultado(resultado);
				} catch (Exception k) {
					if (!getTextoDeLaPantalla().isEmpty() && !Utiles.isPuntos(getTextoDeLaPantalla())
							 && !getTextoDeLaPantalla().equals("+") && !getTextoDeLaPantalla().equals("-")) {
						String[] numerosCortados = getTextoDeLaPantalla().split("[+\\-/X()]");
						if (numerosCortados.length != 1) {
							getAlerta().showMessageDialog(getContentPane(),
									"NO SE PUEDE HACER UNA OPERACION CON 3 NUMEROS, COMO MAXIMO 2", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						} else {
							int resultado = Integer.valueOf(getTextoDeLaPantalla())
									+ Integer.valueOf(getTextoDeLaPantalla());
							setTextoEnPantalla(String.valueOf(resultado));
						}
					}
				}

			}
		});
	}

	private void mostrarEnPantallaResultado(Float resultado) {
		if (resultado != null) {
			setTextoEnPantalla(String.valueOf(resultado));
		} else {
			getAlerta().showMessageDialog(getContentPane(), "NO SE PUEDE DIVIDIR ENTRE 0", "ERROR",
					JOptionPane.ERROR_MESSAGE);
			setTextoEnPantalla("");
		}
	}

	private void annadirEventoBotonPanelOperaciones(JButton btn) {
		btn.addActionListener(e -> {
			JButton botonLlamado = (JButton) e.getSource();
			if (botonLlamado.getText() != "CE") {
				annadirOperandoALaPantalla(botonLlamado);
			} else {
				setTextoEnPantalla(Utiles.borrarUltimaLetra(getTextoDeLaPantalla()));
			}
		});

	}

	private void annadirOperandoALaPantalla(JButton botonLlamado) {
		if (getTextoDeLaPantalla().length() > 0) {
			if (!Utiles.isOperadorElUltimo(getTextoDeLaPantalla())) {
				setTextoEnPantalla(getTextoDeLaPantalla() + botonLlamado.getText());
			} else {
				if (getTextoDeLaPantalla().length() != 1) {
					setTextoEnPantalla(getTextoDeLaPantalla() + "(" + botonLlamado.getText() + ")");
				}
			}
		} else {
			if (!Utiles.isOperadorElUltimo(getTextoDeLaPantalla()) && botonLlamado.getText() != "/"
					&& botonLlamado.getText() != "X" && botonLlamado.getText() != ".") {
				setTextoEnPantalla(getTextoDeLaPantalla() + botonLlamado.getText());
			}
		}
	}

	private void annadirEventoBotonPanelBotonera(JButton btn) {
		btn.addActionListener(e -> {
			JButton botonLlamado = (JButton) e.getSource();
			if (Utiles.isParentesisElUltimo(getTextoDeLaPantalla())) {
				String textoUltimoCaracBorrado = Utiles.borrarUltimaLetra(getTextoDeLaPantalla());
				setTextoEnPantalla(textoUltimoCaracBorrado + botonLlamado.getText() + ")");		
			} else {
				if (!Utiles.isParentesisAbierto(getTextoDeLaPantalla())) {
					setTextoEnPantalla(getTextoDeLaPantalla() + botonLlamado.getText());
				}else {
					setTextoEnPantalla(getTextoDeLaPantalla() + botonLlamado.getText() + ")");
				}
			}
		});
	}
}