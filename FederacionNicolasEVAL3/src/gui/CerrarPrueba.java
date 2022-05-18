package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import dao.AtletaDAO;
import dao.MetalDAO;
import dao.PatrocinadorDAO;
import dao.PruebaDAO;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;

import entidades.Atleta;
import entidades.Lugar;
import entidades.Metal;
import entidades.Patrocinador;
import entidades.Prueba;
import utils.ConexBD;
import utils.Datos;
import validaciones.Validaciones;

import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class CerrarPrueba extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private final ButtonGroup buttonGroupTipo = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int idprueba = 1;
					CerrarPrueba frame = new CerrarPrueba(idprueba);
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
	public CerrarPrueba(int idprueba) {
		PruebaDAO pDAO = new PruebaDAO(ConexBD.getCon());
		Prueba prueba = pDAO.buscarPorID(idprueba);
		if (prueba != null) {
			setTitle("Cerrar Prueba" + idprueba);
		} else
			setTitle("Cerrar Prueba INDETERMINADA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(
				new TitledBorder(null, "Datos de la prueba", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 21, 424, 199);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblIdPrueba = new JLabel("IdPrueba:");
		lblIdPrueba.setBounds(22, 21, 77, 14);
		panel_1.add(lblIdPrueba);

		textField = new JTextField("" + prueba.getId());
		textField.setBounds(86, 14, 86, 20);
		panel_1.add(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(22, 48, 77, 14);
		panel_1.add(lblNombre);

		textFieldNombre = new JTextField(prueba.getNombre());
		textFieldNombre.setBounds(86, 41, 261, 20);
		panel_1.add(textFieldNombre);
		textFieldNombre.setEnabled(false);
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(22, 73, 46, 14);
		panel_1.add(lblFecha);

		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(200, 73, 46, 14);
		panel_1.add(lblLugar);

		JComboBox comboBoxLugar = new JComboBox();
		comboBoxLugar.setBounds(245, 69, 169, 22);
		panel_1.add(comboBoxLugar);
		comboBoxLugar.setEnabled(false);
		comboBoxLugar.setModel(new DefaultComboBoxModel(Lugar.values()));

		JPanel panel = new JPanel();
		panel.setBounds(22, 98, 210, 52);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Tipo de Prueba:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		JRadioButton rbIndividual = new JRadioButton("Individual");

		rbIndividual.setEnabled(false);
		buttonGroupTipo.add(rbIndividual);
		panel.add(rbIndividual);

		JRadioButton rbEquipos = new JRadioButton("Por Equipos");
		rbEquipos.setEnabled(false);
		buttonGroupTipo.add(rbEquipos);
		panel.add(rbEquipos);
		if (prueba.isIndividual())
			rbIndividual.setSelected(true);
		else
			rbEquipos.setSelected(true);

		JLabel lblPatrocinador = new JLabel("Patrocinador:");
		lblPatrocinador.setBounds(22, 161, 87, 14);
		panel_1.add(lblPatrocinador);

		JLabel lblprimerpuesto = new JLabel("Primer puesto *:");
		lblprimerpuesto.setBounds(10, 226, 109, 14);
		contentPane.add(lblprimerpuesto);

		JLabel lblsegundopuesto = new JLabel("Segundo puesto *:");
		lblsegundopuesto.setBounds(10, 302, 109, 14);
		contentPane.add(lblsegundopuesto);

		JLabel lbltercerpuesto = new JLabel("Tercer puesto *:");
		lbltercerpuesto.setBounds(10, 386, 109, 14);
		contentPane.add(lbltercerpuesto);

		DefaultComboBoxModel<Atleta> atletasModel = new DefaultComboBoxModel<Atleta>();
		AtletaDAO aDAO = new AtletaDAO(ConexBD.getCon());
		ArrayList<Atleta> atletassList = (ArrayList<Atleta>) aDAO.buscarTodos();
		/// Pero el modelo de comboBox básico requiere Strings
		String[] atletasStr = new String[50];
		for (int i = 0; i < 50; i++)
			atletasStr[i] = atletassList.get(i).getPersona().data();

		JComboBox<Atleta> comboBoxPuesto1 = new JComboBox<Atleta>();
		comboBoxPuesto1.setModel(new DefaultComboBoxModel(atletasStr));
		lblprimerpuesto.setLabelFor(comboBoxPuesto1);
		comboBoxPuesto1.setBounds(109, 222, 287, 22);
		contentPane.add(comboBoxPuesto1);

		JComboBox<Atleta> comboBoxPuesto2 = new JComboBox<Atleta>();
		comboBoxPuesto2.setModel(new DefaultComboBoxModel(atletasStr));
		lblsegundopuesto.setLabelFor(comboBoxPuesto2);
		comboBoxPuesto2.setBounds(109, 298, 287, 22);
		contentPane.add(comboBoxPuesto2);

		JComboBox<Atleta> comboBoxPuesto3 = new JComboBox<Atleta>();
		comboBoxPuesto3.setModel(new DefaultComboBoxModel(atletasStr));
		lbltercerpuesto.setLabelFor(comboBoxPuesto3);
		comboBoxPuesto3.setBounds(109, 382, 287, 22);
		contentPane.add(comboBoxPuesto3);

		LocalDate hoyMas1MesLD = LocalDate.now().plusMonths(1);
		java.util.Date hoyMas1Mes = new Date(hoyMas1MesLD.getYear() - 1900, hoyMas1MesLD.getMonthValue() - 1,
				hoyMas1MesLD.getDayOfMonth());

		/// Las siguientes lineas seria lo deseable: trabajar diectamente con objetos en
		/// el model del comboBox
		DefaultComboBoxModel<Patrocinador> patrocinadoresModel = new DefaultComboBoxModel<Patrocinador>();
		JComboBox<Patrocinador> comboBoxPatrocinador = new JComboBox<Patrocinador>(patrocinadoresModel);
		PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
		ArrayList<Patrocinador> patrocinadoresList = (ArrayList<Patrocinador>) patDAO.buscarTodos();
		for (Patrocinador pat : patrocinadoresList)
			comboBoxPatrocinador.addItem(pat);

		/// Pero el modelo de comboBox básico requiere Strings
		String[] patrocinadoresStr = new String[patrocinadoresList.size()];
		for (int i = 0; i < patrocinadoresList.size(); i++)
			patrocinadoresStr[i] = patrocinadoresList.get(i).mostrarBasico();
		comboBoxPatrocinador.setModel(new DefaultComboBoxModel(patrocinadoresStr));
		comboBoxPatrocinador.setBounds(96, 157, 261, 22);
		panel_1.add(comboBoxPatrocinador);
		comboBoxPatrocinador.setEnabled(false);

		JSpinner spinnerFecha = new JSpinner();
		spinnerFecha.setBounds(86, 69, 86, 20);
		panel_1.add(spinnerFecha);
		spinnerFecha.setEnabled(false);
		spinnerFecha.setModel(new SpinnerDateModel(hoyMas1Mes, hoyMas1Mes, null, Calendar.DAY_OF_YEAR));

		JButton buttonAceptar = new JButton("Aceptar");
		buttonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean valido = false;
				String titulo = "";
				String msj = "";
				String errores = "";
				/// Tomar cada campo y validarlo. Si alguno no es correcto, avisar al usuario

//				valido = Validaciones.validarNombrePrueba(nombre);
//				if (!valido) {
//					errores += "El nombre de la prueba no es válido (5-150 caracteres).\n";
//					lblNombre.setForeground(Color.RED);
//				} else
//					nueva.setNombre(nombre);
//				valido = false;
//
//				java.util.Date fecha = (java.util.Date) spinnerFecha.getValue();
//				valido = Validaciones.validarFechaNuevaPrueba(fecha);
//				if (!valido) {
//					errores += "La fecha de la prueba no es válido (posterior a 1 mes desde hoy).\n";
//					lblFecha.setForeground(Color.RED);
//				} else {
//					LocalDate fechaLD = LocalDate.of(fecha.getYear() + 1900, fecha.getMonth() + 1, fecha.getDate());
//					nueva.setFecha(fechaLD);
//				}
//				valido = false;
//				
//				valido = (comboBoxLugar.getSelectedIndex() != -1);
//				if (!valido) {
//					errores += "Debe seleccionar el lugar de celebración de la nueva prueba.\n";
//					lblLugar.setForeground(Color.RED);
//				} else {
//					Lugar lugar = (Lugar) comboBoxLugar.getSelectedItem();
//					nueva.setLugar(lugar);
//				}
//				valido = false;
//				valido = !(!rbIndividual.isSelected() && !rbEquipos.isSelected())
//						|| (rbIndividual.isSelected() && rbEquipos.isSelected());
//				if (!valido) {
//					errores += "Debe seleccionar si la nueva prueba es individual O por equipos.\n";
//					rbIndividual.setForeground(Color.RED);
//					rbEquipos.setForeground(Color.RED);
//				} else {
//					nueva.setIndividual(rbIndividual.isSelected() ? true : false);
//				}
//				valido = false;
//				
//				valido = (comboBoxPatrocinador.getSelectedIndex() != -1);
//				if (!valido) {
//					errores += "Debe seleccionar el Patrocinador de la nueva prueba.\n";
//					lblPatrocinador.setForeground(Color.RED);
//				} else {
//					PatrocinadorDAO patDAO = new PatrocinadorDAO(ConexBD.getCon());
//					String seleccionado = (String) comboBoxPatrocinador.getSelectedItem();
//					String[] aux = seleccionado.split("\\.");
//					long idPat = Long.valueOf(aux[0]);
//					Patrocinador patrocinador = patDAO.buscarPorID(idPat);
//					ConexBD.cerrarConexion();
//					if (patrocinador == null)
//						valido = false;
//					else
//						nueva.setPatrocinador(patrocinador);
//				}

				valido = errores.isEmpty();

				if (!valido) {
					titulo = "ERROR: Campos inválidos";
					msj = "ERROR: los siguientes campos NO son válidos:\n\n";
					if (!errores.isEmpty())
						msj += errores + "\n";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
					return;
				}

				/// Si todos los datos son correctos, llamar a PruebaDAO para insertar en la BD
				PruebaDAO pruebadao = new PruebaDAO(ConexBD.establecerConexion());
				boolean correcto = pruebadao.modificar(prueba);
				/// Tanto si la inserción de la nueva prueba tiene éxito como si no, avisar al
				/// usuario
				if (!correcto) {
					// hubo error al insertar en BD y no se generó la nueva prueba
					titulo = "ERROR al cerrar la Prueba en la BD";
					msj = "Hubo un error y NO se ha cerrado la prueba en la BD.";
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.ERROR_MESSAGE);
				} else {
					titulo = "Prueba " + prueba.getId() + " cerrada en la BD";
					msj = "Se ha cerrado correctamente la  prueba:\n" + prueba.toString();
					JOptionPane.showMessageDialog(null, msj, titulo, JOptionPane.INFORMATION_MESSAGE);
					/// Aqui se redirigiría al usuario hacia la pantalla principal
					/// TODO
				}
			}
		});
		buttonAceptar.setBounds(232, 479, 89, 23);
		contentPane.add(buttonAceptar);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = "Cerrar ventana";
				String msj = "¿Realmente desea cerrar la ventana?";
				int opcion = JOptionPane.showConfirmDialog(null, msj, titulo, JOptionPane.OK_CANCEL_OPTION);
				if (opcion == JOptionPane.YES_OPTION) {
					/// Aqui se redirigiría al usuario hacia la pantalla principal o se saldria
					System.exit(0); /// SALIR directamente
				}

			}
		});
		buttonCancelar.setBounds(345, 479, 89, 23);
		contentPane.add(buttonCancelar);

		JLabel lblNewLabelHoras = new JLabel("Horas:");
		lblNewLabelHoras.setBounds(27, 249, 30, 13);
		contentPane.add(lblNewLabelHoras);

		JSpinner spinnerHoras = new JSpinner();
		spinnerHoras.setBounds(67, 246, 32, 20);
		contentPane.add(spinnerHoras);

		JLabel lblNewLabelMinutos = new JLabel("Minutos:");
		lblNewLabelMinutos.setBounds(109, 250, 39, 13);
		contentPane.add(lblNewLabelMinutos);

		JSpinner spinnerMinutos = new JSpinner();
		spinnerMinutos.setBounds(158, 248, 41, 20);
		contentPane.add(spinnerMinutos);

		JLabel lblNewLabelSegundos = new JLabel("Segundos:");
		lblNewLabelSegundos.setBounds(209, 250, 49, 13);
		contentPane.add(lblNewLabelSegundos);

		JLabel lblNewLabelCentesimas = new JLabel("Centésimas:");
		lblNewLabelCentesimas.setBounds(319, 250, 57, 13);
		contentPane.add(lblNewLabelCentesimas);

		JSpinner spinnerSegundos = new JSpinner();
		spinnerSegundos.setBounds(268, 248, 41, 20);
		contentPane.add(spinnerSegundos);

		JSpinner spinnerCentesimas = new JSpinner();
		spinnerCentesimas.setBounds(386, 248, 41, 20);
		contentPane.add(spinnerCentesimas);

		JLabel lblEstablecerComoDefinitivo = new JLabel("Establecer como DEFINITIVO:");
		lblEstablecerComoDefinitivo.setBounds(10, 467, 138, 14);
		contentPane.add(lblEstablecerComoDefinitivo);

		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(154, 467, 21, 21);
		contentPane.add(chckbxNewCheckBox);

		JLabel lblIdOro = new JLabel("Id Oro *:");
		lblIdOro.setBounds(150, 278, 49, 13);
		contentPane.add(lblIdOro);

		JLabel lblNewLabelHoras_1 = new JLabel("Horas:");
		lblNewLabelHoras_1.setBounds(27, 330, 30, 13);
		contentPane.add(lblNewLabelHoras_1);

		JSpinner spinnerHoras_1 = new JSpinner();
		spinnerHoras_1.setBounds(67, 327, 32, 20);
		contentPane.add(spinnerHoras_1);

		JLabel lblNewLabelMinutos_1 = new JLabel("Minutos:");
		lblNewLabelMinutos_1.setBounds(109, 330, 39, 13);
		contentPane.add(lblNewLabelMinutos_1);

		JSpinner spinnerMinutos_1 = new JSpinner();
		spinnerMinutos_1.setBounds(158, 327, 41, 20);
		contentPane.add(spinnerMinutos_1);

		JLabel lblNewLabelSegundos_1 = new JLabel("Segundos:");
		lblNewLabelSegundos_1.setBounds(209, 330, 49, 13);
		contentPane.add(lblNewLabelSegundos_1);

		JSpinner spinnerSegundos_1 = new JSpinner();
		spinnerSegundos_1.setBounds(268, 327, 41, 20);
		contentPane.add(spinnerSegundos_1);

		JLabel lblNewLabelCentesimas_1 = new JLabel("Centésimas:");
		lblNewLabelCentesimas_1.setBounds(319, 330, 57, 13);
		contentPane.add(lblNewLabelCentesimas_1);

		JSpinner spinnerCentesimas_1 = new JSpinner();
		spinnerCentesimas_1.setBounds(386, 327, 41, 20);
		contentPane.add(spinnerCentesimas_1);

		JLabel lblIdPlata = new JLabel("Id Plata *:");
		lblIdPlata.setBounds(150, 359, 49, 13);
		contentPane.add(lblIdPlata);

		JLabel lblNewLabelHoras_1_1 = new JLabel("Horas:");
		lblNewLabelHoras_1_1.setBounds(27, 414, 30, 13);
		contentPane.add(lblNewLabelHoras_1_1);

		JSpinner spinnerHoras_1_1 = new JSpinner();
		spinnerHoras_1_1.setBounds(67, 411, 32, 20);
		contentPane.add(spinnerHoras_1_1);

		JLabel lblNewLabelMinutos_1_1 = new JLabel("Minutos:");
		lblNewLabelMinutos_1_1.setBounds(109, 414, 39, 13);
		contentPane.add(lblNewLabelMinutos_1_1);

		JSpinner spinnerMinutos_1_1 = new JSpinner();
		spinnerMinutos_1_1.setBounds(158, 411, 41, 20);
		contentPane.add(spinnerMinutos_1_1);

		JLabel lblNewLabelSegundos_1_1 = new JLabel("Segundos:");
		lblNewLabelSegundos_1_1.setBounds(209, 414, 49, 13);
		contentPane.add(lblNewLabelSegundos_1_1);

		JSpinner spinnerSegundos_1_1 = new JSpinner();
		spinnerSegundos_1_1.setBounds(268, 411, 41, 20);
		contentPane.add(spinnerSegundos_1_1);

		JLabel lblNewLabelCentesimas_1_1 = new JLabel("Centésimas:");
		lblNewLabelCentesimas_1_1.setBounds(319, 414, 57, 13);
		contentPane.add(lblNewLabelCentesimas_1_1);

		JSpinner spinnerCentesimas_1_1 = new JSpinner();
		spinnerCentesimas_1_1.setBounds(386, 411, 41, 20);
		contentPane.add(spinnerCentesimas_1_1);

		JLabel lblIdBronce = new JLabel("Id Bronce *:");
		lblIdBronce.setBounds(150, 441, 64, 13);
		contentPane.add(lblIdBronce);

		DefaultComboBoxModel<Metal> metales = new DefaultComboBoxModel<Metal>();
		ArrayList<Metal> metalesListO = new ArrayList<Metal>();
		ArrayList<Metal> metalesListP = new ArrayList<Metal>();
		ArrayList<Metal> metalesListB = new ArrayList<Metal>();
		String[] metalStrOro = new String[50];
		String[] metalStrPlata = new String[50];
		String[] metalStrBronce = new String[50];
		for (Metal o : Datos.OROS) {
			metalesListO.add(o);
		}
		for (Metal p : Datos.PLATAS) {
			metalesListP.add(p);
		}
		for (Metal b : Datos.BRONCES) {
			metalesListB.add(b);
		}
		for (int i = 0; i < 50; i++) {
			metalStrOro[i] = metalesListO.get(i).toString();
		}

		for (int i = 0; i < 50; i++) {
			metalStrPlata[i] = metalesListP.get(i).toString();
		}

		for (int i = 0; i < 50; i++) {
			metalStrBronce[i] = metalesListB.get(i).toString();
		}

		JComboBox comboBox_Oro = new JComboBox(metalStrOro);
		comboBox_Oro.setBounds(219, 273, 59, 21);
		contentPane.add(comboBox_Oro);

		JComboBox comboBox_Plata = new JComboBox(metalStrPlata);
		comboBox_Plata.setBounds(219, 355, 59, 21);
		contentPane.add(comboBox_Plata);

		JComboBox comboBox_Bronce = new JComboBox(metalStrBronce);
		comboBox_Bronce.setBounds(219, 437, 59, 21);
		contentPane.add(comboBox_Bronce);
	}
}
