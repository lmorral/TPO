package implementacion;

import tda.ABBMedicionesTDA;
import tda.DMMedicionesTDA;

public class AbbMediciones implements ABBMedicionesTDA {
	NodoCampo raiz;

	@Override
	public void inicializar() {
		raiz=null;
	}

	@Override
	public void agregar(String campo, int anio, int mes, int dia, int medicion) {
		// desarrollar dicc primero

	}

	@Override
	public void eliminar(String campo) {
		// desaroollar dicc primero

	}

	@Override
	public void eliminarMedicionDia(String campo, int anio, int mes, int dia) {
		// desarrollar dicc primero

	}

	@Override
	public String campo() {
		return raiz.campo;
	}

	@Override
	public DMMedicionesTDA mediciones() {
		return raiz.mediciones;
	}

	@Override
	public ABBMedicionesTDA hijoIzquierdo() {
		return raiz.hijoI;
	}

	@Override
	public ABBMedicionesTDA hijoDerecho() {
		return raiz.hijoD;
	}

	@Override
	public boolean arbolMedicionesVacio() {
		return raiz == null;
	}

}
