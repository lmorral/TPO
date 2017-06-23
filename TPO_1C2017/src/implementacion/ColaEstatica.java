package implementacion;

import tda.ColaTDA;

public class ColaEstatica implements ColaTDA {
	int[] cola;
	int indice;
	public void inicializarCola() {
		indice=0;
		cola=new int[1000]; //ACORDARSE DE CAMBIAR O NO TAMAÑO
	}

	public void acolar(int valor) {
		cola[indice]=valor;
		indice++;
	}

	public void desacolar() {
		for (int i=0;i<indice-1;i++){
			cola[i] = cola[i+1];
		}
		indice --;
	}

	public int primero() {
		return cola[0];
	}

	public boolean colaVacia() {
		return indice == 0;
	}

}
