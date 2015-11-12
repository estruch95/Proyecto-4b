package Vistas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controladores.ActividadController;
import Modelo.Actividad;
import Modelo.ConexionPostgreSQL;

public class FramePrincipal extends JFrame {
	//Atributos de la clase
	private JPanel contenedor;
	private JTextField asignatura;
	private JTextField nombre;
	private JTextField inicio;
	private JTextField fintf;
	private JTextField entregada;
	private ActividadController controladorActividad;
	

	public FramePrincipal() {
		//Título asignado al Frame
		setTitle("Gestor de actividades DAM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Dimensiones
		setBounds(100, 100, 450, 300);
		
		//Declaración de atributos de la clase
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		controladorActividad = new ActividadController();
		
		//Ejecución de métodos en constructor
		labels();
		textFields();
		buttons();
	}
	
	//Método que genera los Label's
	public void labels(){
		JLabel lblNuevaActividad = new JLabel("Nueva actividad");
		lblNuevaActividad.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNuevaActividad.setBounds(20, 6, 117, 16);
		contenedor.add(lblNuevaActividad);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 83, 81, 16);
		contenedor.add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Asignatura:");
		lblNewLabel.setBounds(20, 50, 81, 16);
		contenedor.add(lblNewLabel);
		
		JLabel lblInicio = new JLabel("Inicio:");
		lblInicio.setBounds(20, 120, 81, 16);
		contenedor.add(lblInicio);
		
		JLabel lblFin = new JLabel("Fin:");
		lblFin.setBounds(20, 161, 81, 16);
		contenedor.add(lblFin);
		
		JLabel lblEntregada = new JLabel("Entregada:");
		lblEntregada.setBounds(20, 201, 81, 16);
		contenedor.add(lblEntregada);
	}
	
	//Método que genera los campos de texto
	public void textFields(){
		asignatura = new JTextField();
		asignatura.setBounds(129, 45, 280, 26);
		contenedor.add(asignatura);
		asignatura.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(129, 78, 280, 26);
		contenedor.add(nombre);
		nombre.setColumns(10);
		
		inicio = new JTextField();
		inicio.setColumns(10);
		inicio.setBounds(129, 115, 280, 26);
		contenedor.add(inicio);
		
		fintf = new JTextField();
		fintf.setBounds(129, 156, 280, 26);
		contenedor.add(fintf);
		fintf.setColumns(10);
		
		entregada = new JTextField();
		entregada.setColumns(10);
		entregada.setBounds(129, 196, 280, 26);
		contenedor.add(entregada);
	}
	
	//Método que genera los botones 
	public void buttons(){
		JButton btnIntroducirAct = new JButton("Introducir actividad");
		btnIntroducirAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Acciones de dicho botón:
				//Llamada al método addActividad de ActividadController
				controladorActividad.addActividad(
						asignatura.getText(),
						nombre.getText(), 
						inicio.getText(),
						fintf.getText(),
						entregada.getText());
				//Reseteado de campos 
				resetearCampos();
			}
		});
		btnIntroducirAct.setBounds(6, 229, 203, 29);
		contenedor.add(btnIntroducirAct);
		
		JButton btnConsultarAct = new JButton("Consultar actividades");
		btnConsultarAct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Acciones de dicho botón:
				//Llamada al método consultarActividades de dicha clase
				consultarActividades();
			}
		});
		btnConsultarAct.setBounds(221, 229, 188, 29);
		contenedor.add(btnConsultarAct);
	}
	
	//Método cuya función es cargar todos los registros existentes de la tabla actividad y mostrarlos por consola
	public void consultarActividades(){
		//Obtenemos la lista de actividades que nos devuelve el método loadActividades de ActividadController
		ArrayList<Actividad> actividades = controladorActividad.loadActividades();
		//Realizamos un recorrido sobre dicha lista
		for(int a=0; a<actividades.size(); a++){
			//Sacamos impreso por consola de los campos de cada registro que nos interesan 
			System.out.println("ACTIVIDAD "+actividades.get(a).toString());	
			System.out.println(
						
						"Id: "+actividades.get(a).getId()
						+" -Asignatura: "+actividades.get(a).getAsignatura()
						+" -Nombre: "+actividades.get(a).getNombre()
						+" -Fecha inicio: "+actividades.get(a).getInicio()
						+" -Fecha fin: "+actividades.get(a).getFin()
						+" -Entregada? "+actividades.get(a).isEntregada());
		}
	}
	
	//Método encargado de reiniciar los campos de texto tras introducir alguna actividad nueva
	public void resetearCampos(){
		asignatura.setText("");
		nombre.setText("");
		inicio.setText("");
		fintf.setText("");
		entregada.setText("");
	}
}
