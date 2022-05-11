package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import dao.PatrocinadorDAO;
import dao.PruebaDAO;
import entidades.Lugar;
import entidades.Patrocinador;
import entidades.Prueba;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NuevaPersona extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaPersona frame = new NuevaPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NuevaPersona() {
			setTitle("Nueva Prueba");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 395, 214);
			contentPane = new JPanel();
			contentPane.setBorder(new TitledBorder(null, "Datos Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblNombre = new JLabel("Nombre *:");
			lblNombre.setBounds(10, 29, 57, 14);
			contentPane.add(lblNombre);

			textFieldNombre = new JTextField();
			textFieldNombre.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					if(textFieldNombre.getText().length() >= 50 || e.getKeyChar() >= 48 && e.getKeyChar() <=57) {
						e.consume();
					}
				}
			});
	
			textFieldNombre.setBounds(66, 27, 306, 20);
			contentPane.add(textFieldNombre);
			textFieldNombre.setColumns(10);

			JSpinner spinnerFecha = new JSpinner();
			LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
			java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
					hoyMas1MesLD.getDayOfMonth());
			spinnerFecha.setModel(new SpinnerDateModel(new Date(-315622800000L), new Date(-315622800000L), null, Calendar.DAY_OF_YEAR));
			spinnerFecha.setBounds(276, 145, 96, 20);
			contentPane.add(spinnerFecha);

			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Documentacion *:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(10, 53, 219, 84);
			contentPane.add(panel);
			
			JLabel lblSeleccioneLaOpcin = new JLabel("<html>Seleccione la opción e <br> introduzca el valor<html>");
			panel.add(lblSeleccioneLaOpcin);

			JRadioButton rbIndividual = new JRadioButton("NIF");
			buttonGroupTipo.add(rbIndividual);
			panel.add(rbIndividual);

			JRadioButton rbEquipos = new JRadioButton("NIE");
			buttonGroupTipo.add(rbEquipos);
			panel.add(rbEquipos);
			
			textField_1 = new JTextField();
			panel.add(textField_1);
			textField_1.setColumns(10);

			JLabel lblPatrocinador = new JLabel("Teléfono:");
			lblPatrocinador.setBounds(10, 147, 46, 14);
			contentPane.add(lblPatrocinador);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(66, 147, 96, 20);
			contentPane.add(textField);
			
			JLabel lblFecha_1 = new JLabel("Fecha Nacimiento *:");
			lblFecha_1.setBounds(172, 147, 96, 14);
			contentPane.add(lblFecha_1);
		}
}
