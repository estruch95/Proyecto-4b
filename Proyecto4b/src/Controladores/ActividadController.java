package Controladores;



import java.util.ArrayList;

import Modelo.Actividad;
import Modelo.ConexionPostgreSQL;
import Modelo.ConexionPostgreSQL;
import Modelo.ModeloActividad;

public class ActividadController {
	//Atributos de la clase
	private ModeloActividad modeloActividad;
	int id = 0;

	public ActividadController() {
		// Constructor de la clase (Declaración de sus atributos)
		modeloActividad = new ModeloActividad();
	}
	
	//Método cuyo objetivo es realizar una inserción de datos a la BBDD con los parámetros recibidos 
	public void addActividad(String asignatura, String nombre, String inicio, String fin, String entregada){
		
		//Generamos instancia SQL
		ConexionPostgreSQL conexion = ConexionPostgreSQL.getInstance();
		//Realizamos un INSERT sobre la tabla actividades de nuestra BBDD insertando como datos los parámetros recibidos
		conexion.modifyQuery("INSERT INTO actividad(id, asignatura, nombre, inicio, fin, entregada) VALUES("+id+", '"+asignatura+"', '"+nombre+"', '"+inicio+"', '"+fin+"', "+entregada+");");
		id++;
		//Impreso informativo por consola
		System.out.println("Inserción de datos correcta.");
	}
	
	//Este método interactua con el modelo de datos Actividad para cargar todos los registros existentes de la tabla actividad
	public ArrayList<Actividad> loadActividades(){
		return modeloActividad.load();
	}
	
}
