package implementacion;

import tda.ColaPrioridadInvertidaTDA;

public class ColaPrioridadInvertidaEstatica implements ColaPrioridadInvertidaTDA {
	final int MAX=1000;
	int []valor;
	int []prioridad;
	int cant;
	
	public void inicializar(){
		valor= new int[MAX];
		prioridad = new int[MAX];
		cant=0;
	}
	
	public void acolar(int valor, int prioridad){
	    
	      

	}
	
	public void desacolar(){
	   
	}
		
	public int primero(){
	    return valor[0];
	}
	
	public int prioridad(){
	    return prioridad[cant-1];//preguntar
	}
	
	public boolean colaVacia(){
	    return cant==0;
	}
}