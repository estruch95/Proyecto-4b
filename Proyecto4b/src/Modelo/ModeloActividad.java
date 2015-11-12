package Modelo;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;

public class ModeloActividad {
	//Atributos de la clase
	
	public ModeloActividad() {
		// Constructor de la clase
	}
	
	//Método encargado de la extracción de datos que nos interesen de la BBDD
	public ArrayList<Actividad> load(){
		//Obtenemos instancia de ConexionMySql
		ConexionPostgreSQL conexion = ConexionPostgreSQL.getInstance();
		//Guardamos resultado de la consulta realizada en un objeto de tipo ResultSet
		ResultSet rs = conexion.query("SELECT * FROM actividad;");
		
		//Generamos una lista de actividades donde iremos volcando una a una todas las actividades recogidas y seteadas
		ArrayList<Actividad> actividades = new ArrayList<Actividad>();
		try{
			//Recorrido del ResultSet de la consulta
			while(rs.next()){
				//Creamos un nuevo objeto actividad
				Actividad actividad = new Actividad();
				
				//Seteamos todos los atributos de dicha actividad con los obtenidos de la BBDD
				actividad.setId((int) rs.getObject("id"));
				actividad.setAsignatura((String) rs.getObject("asignatura"));
				actividad.setNombre((String) rs.getObject("nombre"));
				
				//PD: Se realiza un casting de Date (SQL) a String (Java)
				Date date1 = (Date) rs.getObject("inicio"); 
				DateFormat formatoFechaInicio = new SimpleDateFormat("dd/MM/yyyy");
				String fechaStringInicio = formatoFechaInicio.format(date1);
				actividad.setInicio(fechaStringInicio);
				
				//PD:""
				Date date2 = (Date) rs.getObject("fin"); 
				DateFormat formatoFechaFin = new SimpleDateFormat("dd/MM/yyyy");
				String fechaStringFin = formatoFechaFin.format(date2);
				actividad.setFin(fechaStringFin);
				
				actividad.setEntregada((boolean) rs.getObject("entregada"));
				//Añadido de la actividad seteada a la lista de actividades 
				actividades.add(actividad);
			}
		}
		catch(SQLException errorLoadActividad){
			errorLoadActividad.printStackTrace();
			System.out.println("ERROR EN LOAD ACTIVIDAD");
		}
		
		//Devolvemos la lista de actividades recogida de la BBDD
		return actividades;
	} 
}
