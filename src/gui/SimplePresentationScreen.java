package gui;

import entities.Student;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.BorderLayout;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {
	//Atributos de instancia
	private Student studentData;
	private String lu;
	
	private DateTimeFormatter formateadorDeFecha;
	private DateTimeFormatter formateadorDeHora;
	private String fechaHora;
	private LocalDateTime momentoActual;
	
	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	
	private JLabel lblLegado;
	private JLabel lblApellido;
	private JLabel lblNombre;
	private JLabel lblEmail;
	private JLabel lblGithubUrl;
	
	private JTextField txtfLU;
	private JTextField txtfApellido;
	private JTextField txtfNombre;
	private JTextField txtfEmail;
	private JTextField txtfGithubUrl;
	
	private JPanel panelContenedorDeImagen;
	private JLabel lblImageLabel;
	private ImageIcon img;
	
	private JPanel panelFecha;
	private JLabel lblFecha;
	
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentacion");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(625, 260));
		setResizable(false);
		setContentPane(contentPane);
		setVisible(true);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 180);
		
		tabInformation = new JPanel();
		tabInformation.setBorder(null);
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Informacion del alumno", null, tabInformation, "Muestra la informacion declarada por el alumno");
		tabInformation.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 63, 51, 15);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		tabInformation.add(lblNombre);
		
		lblLegado = new JLabel("LU");
		lblLegado.setHorizontalAlignment(SwingConstants.LEFT);
		lblLegado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLegado.setBounds(10, 11, 51, 15);
		tabInformation.add(lblLegado);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(10, 37, 51, 15);
		tabInformation.add(lblApellido);
		
		lblEmail = new JLabel("E-Mail");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(10, 89, 51, 15);
		tabInformation.add(lblEmail);
		
		lblGithubUrl = new JLabel("GitHub URL");
		lblGithubUrl.setHorizontalAlignment(SwingConstants.LEFT);
		lblGithubUrl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGithubUrl.setBounds(10, 115, 76, 15);
		tabInformation.add(lblGithubUrl);
		
		txtfLU = new JTextField();
		txtfLU.setEditable(false);
		txtfLU.setColumns(10);
		txtfLU.setBounds(105, 9, 280, 20);
		
		lu = "Error!"; //Inicializamos con un mensaje de error por si el LU del estudiante no es valido.
		lu = ((Integer) studentData.getId()).toString();
		
		txtfLU.setText(lu);
		tabInformation.add(txtfLU);
		
		txtfApellido = new JTextField();
		txtfApellido.setEditable(false);
		txtfApellido.setColumns(10);
		txtfApellido.setBounds(105, 35, 280, 20);
		txtfApellido.setText(studentData.getLastName());
		tabInformation.add(txtfApellido);
		
		txtfNombre = new JTextField();
		txtfNombre.setEditable(false);
		txtfNombre.setColumns(10);
		txtfNombre.setBounds(105, 61, 280, 20);
		txtfNombre.setText(studentData.getFirstName());
		tabInformation.add(txtfNombre);
		
		txtfEmail = new JTextField();
		txtfEmail.setEditable(false);
		txtfEmail.setColumns(10);
		txtfEmail.setBounds(105, 87, 280, 20);
		txtfEmail.setText(studentData.getMail());
		tabInformation.add(txtfEmail);
		
		txtfGithubUrl = new JTextField();
		txtfGithubUrl.setEditable(false);
		txtfGithubUrl.setColumns(10);
		txtfGithubUrl.setBounds(105, 113, 280, 20);
		txtfGithubUrl.setText(studentData.getGithubURL());
		tabInformation.add(txtfGithubUrl);
		
		contentPane.add(tabbedPane);
		
		panelContenedorDeImagen = new JPanel();
		panelContenedorDeImagen.setBounds(445, 30, 150, 150);
		contentPane.add(panelContenedorDeImagen);
		
		/**DISPLAY DE LA FOTO:
		 * Primero creamos la label
		 * Cargamos la foto como una ImageIcon
		 * Re-escalamos la foto para que entre en la label (150 x 150)
		 * Cargamos la foto a la label como icono
		 * Dejamos el codigo generado por WindowBuilder para la posicion y las bounds
		 * **/
		lblImageLabel = new JLabel("");
		
		img = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		img = new ImageIcon(img.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
		panelContenedorDeImagen.setLayout(new BorderLayout(0, 0));
		lblImageLabel.setIcon(img);
		
		lblImageLabel.setBounds(604, 5, 0, 211);
		panelContenedorDeImagen.add(lblImageLabel);
		
		/**Fin del display de la foto**/
		
		panelFecha = new JPanel();
		panelFecha.setBounds(5, 190, 430, 20);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);
		
		/**FECHA Y HORA
		 * Creamos la label
		 * Creamos objetos formateadores de fecha y hora
		 * Obtenemos la fecha y hora actual
		 * Generamos un string a partir de la fecha  hora actual y los formateadores
		 * Setteamos ese string como texto de la label
		 * Dejamos el codigo generado automaticamente por Windowbuilder
		 * **/
		lblFecha = new JLabel("");
		
		formateadorDeFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formateadorDeHora = DateTimeFormatter.ofPattern("HH:mm:ss");
		momentoActual = LocalDateTime.now();
		fechaHora = "Esta ventana fue generada el " + formateadorDeFecha.format(momentoActual) + " a las: " + formateadorDeHora.format(momentoActual); 
		
		lblFecha.setText(fechaHora);
		
		lblFecha.setBounds(3, 3, 417, 15);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFecha.add(lblFecha);
		
		/**Fin del manejo de fecha y hora**/
	}
}
