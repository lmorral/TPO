package implementacion;

import tda.ColaPrioridadInvertidaTDA;

public class ColaPIEstatica implements ColaPrioridadInvertidaTDA {
	
	private int[]valores;
	private int[]prioridades;
	private int cant;
	
	public void inicializar() {
		valores= new int[100];
		prioridades= new int[100];
	}

	public void acolar(int valor, int prioridad) {
		int i;
		for(i=0;i<cant;i++)
		{
			if(prioridades[i]>prioridad)
				break;
		}
		for(int j=cant;j>i;j--)
		{
			valores[j]=valores[j-1];
			prioridades[j]=prioridades[j-1];
		
		}
		valores[i]=valor;
		prioridades[i]=prioridad;
		cant++;
	}

	public void dasacolar() {
		for(int i=0;i<cant-1;i++)
		{
			valores[i]=valores[i+1];
			prioridades[i]=prioridades[i+1];
		}
		cant--;
	}

	public int primero() {
		return valores[0];
	}

	public int prioridad() {
		return prioridades[0];
	}

	public boolean colaVacia() {
		return cant==0;
	}

	@Override
	public void desacolar() {
		// TODO Auto-generated method stub
		
	}
}