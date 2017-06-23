package tda;

public interface ABBMedicionesTDA {

	public void inicializar();
	
	public void agregar(String campo, int anio, int mes, int dia, int medicion);
	
	public void eliminar(String campo);
	
	public void eliminarMedicionDia(String campo, int anio, int mes, int dia);
	
	public String campo();
	
	public DMMedicionesTDA mediciones();
	
	public ABBMedicionesTDA hijoIzquierdo();
	
	public ABBMedicionesTDA hijoDerecho();
	
	public boolean arbolMedicionesVacio();
}
