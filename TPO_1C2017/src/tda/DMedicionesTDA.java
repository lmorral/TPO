package tda;

public interface DMedicionesTDA {

	public void inicializar();
	
	public void agregar(int anio, int mes, int dia, float medicion);
	
	public void eliminarAnio(int anio);
	
	public void eliminarMes(int dia);
	
	public void eliminarDia(int anio, int mes, int dia);
	
	public ConjuntoTDA anios();
	
	public ConjuntoMesesTDA meses(int anio);
	
	public ColaTDA mediciones();
	
	 
}
