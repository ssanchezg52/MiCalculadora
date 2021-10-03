package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

public class UI extends JFrame {

	private JPanel contentPane;

	private JPanel panelBotonera;

	private JTextField textFieldScreen;

	private JPanel panelOperaciones;
	private JPanel panelSur;
	private JOptionPane alerta;
	private JButton btnNewButton;

	/**
	 * Create the frame.
	 */
	public UI() {
		setTitle("Calculadora de Sergio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelTitulo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTitulo.getLayout();
		flowLayout.setVgap(7);
		panelTitulo.setBackground(new Color(139, 69, 19));
		contentPane.add(panelTitulo, BorderLayout.NORTH);

		panelOperaciones = new JPanel();
		panelOperaciones.setBackground(new Color(139, 69, 19));
		contentPane.add(panelOperaciones, BorderLayout.EAST);
		panelOperaciones.setLayout(new GridLayout(0, 1, 0, 4));

		String[] simbolosOperaciones = { "CE", "/", "X", "-", "+" };

		crearBotoneraOperaciones(panelOperaciones, simbolosOperaciones);

		panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		panelSur.setLayout(new GridLayout(0, 2, 3, 2));
		panelSur.setBackground(new Color(139, 69, 19));

		String[] simbolos = { "C", "=" };

		crearBotoneraOperaciones(panelSur, simbolos);

		JPanel panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(new BorderLayout(0, 0));

		JPanel panelScreen = new JPanel();
		panelScreen.setBackground(new Color(139, 69, 19));
		panelCentral.add(panelScreen, BorderLayout.NORTH);

		LineBorder line = new LineBorder(Color.BLACK, 2, true);

		textFieldScreen = new JTextField();
		textFieldScreen.setColumns(10);
		textFieldScreen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldScreen.setBorder(line);
		GroupLayout gl_panelScreen = new GroupLayout(panelScreen);
		gl_panelScreen
				.setHorizontalGroup(gl_panelScreen.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_panelScreen.createSequentialGroup().addContainerGap()
								.addComponent(textFieldScreen, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
								.addContainerGap()));
		gl_panelScreen.setVerticalGroup(gl_panelScreen.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelScreen.createSequentialGroup().addContainerGap()
						.addComponent(textFieldScreen, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelScreen.setLayout(gl_panelScreen);

		panelBotonera = new JPanel();
		panelBotonera.setBackground(new Color(139, 69, 19));
		panelCentral.add(panelBotonera, BorderLayout.CENTER);
		panelBotonera.setLayout(new GridLayout(4, 3, 2, 2));

		String[] teclas = { "0", "." };

		crearBotoneraNumeros(teclas);
	}

	private void crearBotoneraOperaciones(JPanel panelOperaciones, String[] operaciones) {
		for (int i = 0; i < operaciones.length; i++) {
			JButton botonOperacion = crearBoton(operaciones[i]);
			panelOperaciones.add(botonOperacion);
		}
	}

	private void crearBotoneraNumeros(String[] teclas) {
		for (int i = 1, j = 0; i < 13; i++) {
			if (i <= 9) {
				JButton boton = crearBoton(String.valueOf(i));
				panelBotonera.add(boton);
			} else {
				if (i != 10) {
					JButton boton = crearBoton(teclas[j]);
					panelBotonera.add(boton);
					j++;
				} else {
					JLabel label = new JLabel("");
					panelBotonera.add(label);
				}
			}
		}
	}

	private JButton crearBoton(String i) {
		JButton boton = new JButton(i);
		boton.setForeground(Color.BLACK);
		boton.setBackground(Color.WHITE);
		boton.setContentAreaFilled(false);
		boton.setOpaque(true);
		boton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		return boton;
	}
	
	public String getTextoDeLaPantalla() {
		return textFieldScreen.getText();
	}

	public void setTextoEnPantalla(String t) {
		textFieldScreen.setText(t);
	}

	public JPanel getPanelBotonera() {
		return panelBotonera;
	}

	public JPanel getPanelOperaciones() {
		return panelOperaciones;
	}

	public JPanel getPanelSur() {
		return panelSur;
	}

	public JOptionPane getAlerta() {
		return alerta;
	}

}
