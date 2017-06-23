package tda;

/** 
 * 	Esta implementacion es similar a la del conjunto pero en lugar de int, con cadenas de caracteres <br> 
 * 
 *  En la comparaciones en lugar del == deberian utilizar el método equalIgnoreCase() para que ignore 
 *  las diferencias de capitalización
 *  
 *  */

public interface ConjuntoStringTDA {

	/** No posee */
	public void inicializar ();

	/** inicializado */
	public boolean conjuntoVacio();

	/** inicializado */
	public void agregar(String valor);

	/** inicializado y no vacio */
	public String elegir();

	/** inicializado y no vacio */
	public void sacar(String valor);

	/** inicializado y no vacio */
	public boolean pertenece(String valor);
	
	
}
