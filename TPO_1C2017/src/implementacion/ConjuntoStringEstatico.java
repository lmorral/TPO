package implementacion;

import java.util.Random;

import tda.ConjuntoStringTDA;

public class ConjuntoStringEstatico implements ConjuntoStringTDA {

	private int cantidad;
	private String[]palabras;

	public void inicializar() {
	cantidad=0;
	palabras=new String[1000];

	}

	public void agregar(String valor) {
		if(!pertenece (valor))
		{
			palabras[cantidad]=valor;
			cantidad++;
		}

	}

	public String elegir() {
		Random X=new Random();
		int posicion=X.nextInt(cantidad);
		return palabras[posicion];
	}

	public void sacar(String valor) {
		for(int i=0;i<cantidad;i++)
		{
			if(palabras[i].equalsIgnoreCase(valor))
			{
				palabras[i]=palabras[cantidad-1];
				cantidad--;
			}
		}

	}

	public boolean conjuntoVacio() {
		return cantidad==0;
	}

	public boolean pertenece(String valor) {
		for(int i=0;i<cantidad;i++)
		{
			if(palabras[i].equalsIgnoreCase(valor))
				return true;
		}
		return false;
	}

}
