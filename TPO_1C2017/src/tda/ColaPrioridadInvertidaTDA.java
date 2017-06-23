package tda;

/**
 * Esta estructura se implementar� como una cola con prioridad comun con la
 * diferencia que la menor prioridad se colocar� adelante y la mayor al final;
 * de manera tal que puedan utilizarla para cargar las precipitaciones para cada d�a
 * colocando el d�a 1 primero, el dia 2 segundo y asi sucesivamente.
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
