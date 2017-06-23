package implementacion;

import java.util.Random;

import tda.ConjuntoTDA;

public class ConjuntoEstatico implements ConjuntoTDA {
	private int cantidad;
	private int[]valores;

	public void inicializar() {
	cantidad=0;
	valores=new int[100];

	}

	public void agregar(int valor) {
		if(!pertenece (valor))
		{
			valores[cantidad]=valor;
			cantidad++;
		}

	}

	public int elegir() {
		Random X=new Random();
		int pocision=X.nextInt(cantidad);
		return valores[pocision];
	}

	public void sacar(int valor) {
		for(int i=0;i<cantidad;i++)
		{
			if(valores[i]==valor)
			{
				valores[i]=valores[cantidad-1];
				cantidad--;
			}
		}

	}

	public boolean conjuntoVacio() {
		return cantidad==0;
	}

	public boolean pertenece(int valor) {
		for(int i=0;i<cantidad;i++)
		{
			if(valores[i]==valor)
				return true;
		}
		return false;
	}

}
