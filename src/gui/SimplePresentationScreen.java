package gui;

import entities.Student;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.awt.Color;
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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {
	private Student studentData;
	
	private DateTimeFormatter formateadorDeFecha;
	private DateTimeFormatter formateadorDeHora;
	private String fechaHora;
	
	private boolean modoClaro;
	
	private static final Color defaultBackground = Color.decode("#f0f0f0");
	private static final Color defaultForeground = Color.decode("#000000");
	private static final Color defaultTextFieldBackground = Color.WHITE;
	
	private static final Color darkThemeBackground = Color.decode("#272727");
	private static final Color darkThemeForeground = Color.decode("#d6d6d6");
	private static final Color darkThemeTextFieldBackground = Color.decode("#1f1f1f");
	
	
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
	
	private JButton btnCambioDeModo;
	
	private JPanel panelFecha;
	private JLabel lblFecha;
	
	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		modoClaro = true;
		
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
		
		String lu = "Error!";
		Integer legado = studentData.getId();
		lu = legado.toString();
		
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
		panelContenedorDeImagen.setBounds(445, 11, 150, 150);
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
		lblImageLabel.setIcon(img);
		
		lblImageLabel.setBounds(604, 5, 0, 211);
		panelContenedorDeImagen.add(lblImageLabel);
		
		btnCambioDeModo = new JButton("Modo Oscuro");
		btnCambioDeModo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCambioDeModo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarModo();
			}
		});
		btnCambioDeModo.setBounds(445, 165, 150, 20);
		contentPane.add(btnCambioDeModo);
		
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
		LocalDateTime now = LocalDateTime.now();
		fechaHora = "Esta ventana fue generada el " + formateadorDeFecha.format(now) + " a las: " + formateadorDeHora.format(now); 
		
		lblFecha.setText(fechaHora);
		
		lblFecha.setBounds(3, 3, 417, 15);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelFecha.add(lblFecha);
	}
	
	private void cambiarModo() {
		if(modoClaro){
			ponerModoOscuro();
		} else {
			ponerModoClaro();
		}
	}
	
	private void ponerModoOscuro() {
		modoClaro = false;
		
		//Background
		contentPane.setBackground(darkThemeBackground);
		
		//Tabed Pane
		tabbedPane.setBackground(darkThemeBackground);
		
		//Informacion del alumno
		tabInformation.setBackground(darkThemeBackground);
		tabInformation.setForeground(darkThemeForeground);
		
		//Informacion del alumno: labels
		lblLegado.setForeground(darkThemeForeground);
		lblApellido.setForeground(darkThemeForeground);
		lblNombre.setForeground(darkThemeForeground);
		lblEmail.setForeground(darkThemeForeground);
		lblGithubUrl.setForeground(darkThemeForeground);
		
		//Informacion del alumno: text fields
		txtfLU.setBackground(darkThemeTextFieldBackground);
		txtfLU.setForeground(darkThemeForeground);
		txtfApellido.setBackground(darkThemeTextFieldBackground);
		txtfApellido.setForeground(darkThemeForeground);
		txtfNombre.setBackground(darkThemeTextFieldBackground);
		txtfNombre.setForeground(darkThemeForeground);
		txtfEmail.setBackground(darkThemeTextFieldBackground);
		txtfEmail.setForeground(darkThemeForeground);
		txtfGithubUrl.setBackground(darkThemeTextFieldBackground);
		txtfGithubUrl.setForeground(darkThemeForeground);
		
		//Imagen
		panelContenedorDeImagen.setBackground(darkThemeBackground);
		
		//Fecha
		panelFecha.setBackground(darkThemeBackground);
		lblFecha.setForeground(darkThemeForeground);
		
		//Boton
		btnCambioDeModo.setText("Modo Claro");
		btnCambioDeModo.setBackground(darkThemeBackground);
		btnCambioDeModo.setForeground(darkThemeForeground);
	}
	
	private void ponerModoClaro() {
		modoClaro = true;
		
		//Background
		contentPane.setBackground(defaultBackground);
		
		//Tabed Pane
		tabbedPane.setBackground(defaultBackground);
		
		//Informacion del alumno
		tabInformation.setBackground(defaultBackground);
		tabInformation.setForeground(defaultForeground);
		
		//Informacion del alumno: labels
		lblLegado.setForeground(defaultForeground);
		lblApellido.setForeground(defaultForeground);
		lblNombre.setForeground(defaultForeground);
		lblEmail.setForeground(defaultForeground);
		lblGithubUrl.setForeground(defaultForeground);
		
		//Informacion del alumno: text fields
		txtfLU.setBackground(defaultTextFieldBackground);
		txtfLU.setForeground(defaultForeground);
		txtfApellido.setBackground(defaultTextFieldBackground);
		txtfApellido.setForeground(defaultForeground);
		txtfNombre.setBackground(defaultTextFieldBackground);
		txtfNombre.setForeground(defaultForeground);
		txtfEmail.setBackground(defaultTextFieldBackground);
		txtfEmail.setForeground(defaultForeground);
		txtfGithubUrl.setBackground(defaultTextFieldBackground);
		txtfGithubUrl.setForeground(defaultForeground);
		
		//Imagen
		panelContenedorDeImagen.setBackground(defaultBackground);
		
		//Fecha
		panelFecha.setBackground(defaultBackground);
		lblFecha.setForeground(defaultForeground);
		
		//Boton
		btnCambioDeModo.setText("Modo Oscuro");
		btnCambioDeModo.setBackground(defaultBackground);
		btnCambioDeModo.setForeground(defaultForeground);
	}
}
