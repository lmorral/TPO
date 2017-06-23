package tda;


public interface DMMedicionesTDA {

	public void inicializar();
	
	public void agregar(int anio, int mes, int dia, float medicion);
	
	public void eliminarAnio(int anio);
	
	public void eliminarMes(int mes, int anio);
	
	/** Es método pone en cero la precipitacion para ese día. Si todas las precipitaciones de 
	 *  de ese mes quedan en cero, se debe eliminar el mes tambien. Si todos los meses de ese año
	 *  quedaron en cero tambien se elimina el año.
	 *  */
	public void eliminarDia(int anio, int mes, int dia);
	
	public ConjuntoTDA anios();
	
	public ConjuntoTDA meses(int anio);
	
	/** Este método devuelve todas las precipitaciones del mes. 
	 *  Si algún día no hay precipitacion devuelve cero 
	 *  */
	public DiccionarioSimpleTDA mediciones(int anio, int mes);
	
	 
}
