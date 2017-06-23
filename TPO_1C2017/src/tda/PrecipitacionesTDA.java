package tda;


/**
 * Esta es una descripcion de las tareas que hace el sistema de registracion de mediciones.
 * 
 * @author Claudio
 * 
 * */
public interface PrecipitacionesTDA {
	
	public void inicializar();
	
	public void agregar(String campo, int anio, int mes, int dia, int precipitacion);
	
	public void eliminar(String campo);
	
	public void eliminarMedicion(String campo, int anio, int mes, int dia);
	
	public int medicionDeUnDia(String campo, int anio, int mes, int dia);
	
	/**
	 * Devuelve el conjunto de todos los campos que hay en la estructura.
	 * 
	 * */
	public ConjuntoStringTDA campos();
	
	public ColaPrioridadInvertidaTDA mediciones(String campo, int anio, int mes);
	
	public float promedioAnual(String campo, int anio);
	
	public float promedioMensual(String campo, int anio, int mes);
	
	/**
	 * Devuelve para un campo determinado la sumatoria de precipitaciones de un mes determinado para todos los años.<br>
	 * Devolviendo la sumatoria de las precipitaciones y el año, ordenado por años de manera ascendente
	 * 
	 * */
	public ColaPrioridadInvertidaTDA comparativaMensual(String campos, int mes);
	
	

}
