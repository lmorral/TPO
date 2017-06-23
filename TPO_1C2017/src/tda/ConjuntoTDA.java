package tda;

/** De este TDA realice una implementación estática */
public interface ConjuntoTDA {
	
	/** No posee */
	public void inicializar ();

	/** inicializado */
	public boolean conjuntoVacio();

	/** inicializado */
	public void agregar(int valor);

	/** inicializado y no vacio */
	public int elegir();

	/** inicializado y no vacio */
	public void sacar(int valor);

	/** inicializado y no vacio */
	public boolean pertenece(int valor);
}
