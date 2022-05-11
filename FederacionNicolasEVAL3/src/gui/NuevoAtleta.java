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
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.PruebaDAO;
import dao.PatrocinadorDAO;
import dao.AtletaDAO;
import entidades.Atleta;
import entidades.DatosPersona;
import entidades.Equipo;
import entidades.Lugar;
import entidades.Patrocinador;
import entidades.Prueba;
import utils.ConexBD;
import validaciones.Validaciones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class NuevoAtleta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoAtleta frame = new NuevoAtleta();
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
	public NuevoAtleta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre *:");
		lblNewLabel.setBounds(10, 46, 56, 13);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(76, 43, 298, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Seleccione la <br> opción e <br> introduzca el valor<html>");
		lblNewLabel_1.setBounds(10, 69, 90, 48);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NIF");
		rdbtnNewRadioButton.setBounds(106, 70, 46, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNie = new JRadioButton("NIE");
		rdbtnNie.setBounds(154, 70, 46, 21);
		contentPane.add(rdbtnNie);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 98, 90, 19);
		contentPane.add(textField_1);
		
		JLabel lblTelfono = new JLabel("Teléfono:");
		lblTelfono.setBounds(10, 130, 46, 13);
		contentPane.add(lblTelfono);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(62, 127, 90, 19);
		contentPane.add(textField_2);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento *:");
		lblFechaNacimiento.setBounds(162, 130, 94, 13);
		contentPane.add(lblFechaNacimiento);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(-315622800000L), new Date(-315622800000L), null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(263, 127, 111, 20);
		contentPane.add(spinner);
		
		JLabel lblDatosPersonales = new JLabel("Datos Personales\r\n");
		lblDatosPersonales.setBounds(10, 23, 78, 13);
		contentPane.add(lblDatosPersonales);
		
		JLabel lblDatosFsicos = new JLabel("Datos Físicos\r\n");
		lblDatosFsicos.setBounds(10, 166, 78, 13);
		contentPane.add(lblDatosFsicos);
		
		JLabel lblAltura = new JLabel("Altura *:");
		lblAltura.setBounds(10, 189, 56, 13);
		contentPane.add(lblAltura);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(62, 186, 90, 19);
		contentPane.add(textField_3);
		
		JLabel lblMenFormato = new JLabel("m. (en formato xx.xx)");
		lblMenFormato.setBounds(157, 189, 99, 13);
		contentPane.add(lblMenFormato);
		
		JLabel lblPeso = new JLabel("Peso *:");
		lblPeso.setBounds(10, 214, 56, 13);
		contentPane.add(lblPeso);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(62, 212, 90, 19);
		contentPane.add(textField_4);
		
		JLabel lblKgenFormato = new JLabel("Kg. (en formato xx.xx)");
		lblKgenFormato.setBounds(157, 214, 99, 13);
		contentPane.add(lblKgenFormato);
		
		
		DefaultComboBoxModel<Atleta> atletas = new DefaultComboBoxModel<Atleta>();
		JComboBox<Atleta> comboBoxEquipos = new JComboBox<Atleta>(atletas);
		AtletaDAO atDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletasList = (ArrayList<Atleta>) atDAO.buscarTodos();
		for (Atleta at : atletasList)
			comboBoxEquipos.addItem(at);
		
		String[] equiposStr = new String[atletasList.size()];
		for (int i = 0; i < atletasList.size(); i++)
			equiposStr[i] = atletasList.get(i).mostrarBasico();
		comboBoxEquipos.setModel(new DefaultComboBoxModel(equiposStr));

		comboBoxEquipos.setBounds(62, 245, 312, 22);
		contentPane.add(comboBoxEquipos);
		
		JLabel lblEquipo = new JLabel("Equipo:");
		lblEquipo.setBounds(10, 250, 56, 13);
		contentPane.add(lblEquipo);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atleta nueva1 = new Atleta();
				DatosPersona nueva2 = new DatosPersona();
				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				/// Tomar cada campo y validarlo. Si alguno no es correcto, avisar al usuario
				String nombre = textField.getText();
				valido = Validaciones.validarNombre(nombre);
				if (!valido) {
					errores += "El nombre del atleta no es válido (3-50 caracteres).\n";
					lblNewLabel.setForeground(Color.RED);
				} else
					nueva2.setNombre(nombre);
				valido = false;
				
				valido = !(!rdbtnNewRadioButton.isSelected() && !rdbtnNie.isSelected())
						|| (rdbtnNewRadioButton.isSelected() && rdbtnNie.isSelected());
				if (!valido) {
					errores += "Debe seleccionar NIF o NIE.\n";
					rdbtnNewRadioButton.setForeground(Color.RED);
					rdbtnNie.setForeground(Color.RED);
				} else {
					nueva2.setNifnie(null); //deberias de pasar el nif o el nie no se como se hace
				}
				valido = false;
				
				//falta validar el campo donde se inserta el nif o el nie
				
				String telefono = textField_2.getText();
				valido = Validaciones.validarTelefono(telefono);
				if (!valido) {
					errores += "El nombre del atleta no es válido (3-50 caracteres).\n";
					lblTelfono.setForeground(Color.RED);
				} else
					nueva2.setTelefono(telefono);
				valido = false;
				
				java.util.Date fecha = (java.util.Date) spinner.getValue();
				valido = Validaciones.validarFechaNuevaPrueba(fecha);
				if (!valido) {
					errores += "La fecha de nac no es válida.\n";
					lblFechaNacimiento.setForeground(Color.RED);
				} else {
					LocalDate fechaLD = LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDate());
					nueva2.setFechaNac(fechaLD);
				}
				valido = false;
				
				//aqui se inserta la persona en la base de datos
				
				String altura = textField_3.getText();
				// valido = Validaciones.validarAltura(altura); //habria que castearlo a un float
				if (!valido) {
					errores += "La altura es invalida.\n";
					lblTelfono.setForeground(Color.RED);
				} else
					// nueva1.setAltura(altura);
				valido = false;
			}
		});
		btnNewButton.setBounds(76, 288, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(225, 288, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
