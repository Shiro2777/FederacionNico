package insercionesGUI;



import java.awt.BorderLayout;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.SpinnerNumberModel;
import java.awt.Component;

public class GUITiempo extends JFrame {

	private JPanel contentPane;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
		try {
			GUITiempo frame = new GUITiempo();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		});
	}

	public GUITiempo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 293, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Guarde su Tiempo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(10, 10, 258, 273);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Minutos");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(72, 95, 59, 13);
		panel.add(lblNewLabel_1);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinner_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		spinner_1.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		spinner_1.setFont(new Font("Arial", Font.PLAIN, 10));
		spinner_1.setBorder(null);
		spinner_1.setBounds(141, 90, 68, 28);
		panel.add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		spinner_2.setFont(new Font("Arial", Font.PLAIN, 10));
		spinner_2.setBorder(null);
		spinner_2.setBounds(141, 152, 68, 28);
		panel.add(spinner_2);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner_3.setFont(new Font("Arial", Font.PLAIN, 10));
		spinner_3.setBorder(null);
		spinner_3.setBounds(141, 212, 68, 28);
		panel.add(spinner_3);
		
		JLabel lblNewLabel_2 = new JLabel("Segundos");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(55, 152, 76, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Horas");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(84, 41, 47, 13);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Centesimas");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(44, 217, 87, 13);
		panel.add(lblNewLabel_4);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		spinner_4.setFont(new Font("Arial", Font.PLAIN, 10));
		spinner_4.setBorder(null);
		spinner_4.setAlignmentY(1.0f);
		spinner_4.setAlignmentX(1.0f);
		spinner_4.setBounds(141, 36, 68, 28);
		panel.add(spinner_4);
	}
}
