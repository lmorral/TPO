package implementacion;

import tda.ColaTDA;

public class ColaEstatica implements ColaTDA {
	private int cant;
	private int []c;

	public void inicializarCola() {
		cant=0;
		c=new int[100];
	}

	public void acolar(int valor) {
		c[cant]=valor;
		cant++;
	}

	public void desacolar() {
		for(int i=0;i<cant-1;i++)
			c[i]=c[i+1];
		cant--;
	}

	public int primero() {
		return c[0];
	}

	public boolean colaVacia() {
		return cant==0;
	}
}
