package tda;

/**
 * Esta estructura se implementará como una cola con prioridad comun con la
 * diferencia que la menor prioridad se colocará adelante y la mayor al final;
 * de manera tal que puedan utilizarla para cargar las precipitaciones para cada día
 * colocando el día 1 primero, el dia 2 segundo y asi sucesivamente.
 * 
 * @author Claudio
 * */
public interface ColaPrioridadInvertidaTDA {

	/** no posee */
	public void inicializar();
	
	/** inicializada */
	public void acolar(int valor, int prioridad);
	
	/** inicializada y no vacia*/	
	public void desacolar();
	
	/** inicializada y no vacia*/
	public int primero();
	
	/** inicializada y no vacia*/
	public int prioridad();
	
	/** inicializada */
	public boolean colaVacia();
}
