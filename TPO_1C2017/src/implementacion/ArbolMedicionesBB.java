package implementacion;

import tda.ABBMedicionesTDA;
import tda.DMMedicionesTDA;

public class ArbolMedicionesBB implements ABBMedicionesTDA {
	
	private NodoCampo primero;

	public void inicializar() {
		primero=null;
	}

	public void agregar(String campo, int anio, int mes, int dia, int medicion) {
		if(primero==null)
		{
			NodoCampo aux= new NodoCampo();
			aux.ciudad=campo;
			aux.hijoI= new ArbolMedicionesBB();
			aux.hijoI.inicializar();
			aux.hijoD= new ArbolMedicionesBB();
			aux.hijoD.inicializar();
			aux.mediciones= new DiccMulMediciones();
			aux.mediciones.inicializar();
			aux.mediciones.agregar(anio, mes, dia, medicion);
			primero=aux;
		}
		else if (campo.compareToIgnoreCase(primero.ciudad)>0)
		{
			primero.hijoD.agregar(campo, anio, mes, dia, medicion);
		}
		else if (campo.compareToIgnoreCase(primero.ciudad)<0)
		{
			primero.hijoI.agregar(campo, anio, mes, dia, medicion);
		}

	}

	public void eliminar(String campo) {
		if(primero != null)
		{
			if(primero.ciudad.equalsIgnoreCase(campo) && primero.hijoI.arbolMedicionesVacio() && primero.hijoD.arbolMedicionesVacio())
			{
				primero=null;
			}
			else if(primero.ciudad.equalsIgnoreCase(campo) && !primero.hijoI.arbolMedicionesVacio())
			{
				primero.ciudad = mayor(primero.hijoI);
				primero.hijoI.eliminar(primero.ciudad);
			}
			else if(primero.ciudad.equalsIgnoreCase(campo))
			{
				primero.ciudad = menor(primero.hijoD);
				primero.hijoD.eliminar(primero.ciudad);
			}
			else if(primero.ciudad.compareToIgnoreCase(campo)>0)
			{
				primero.hijoI.eliminar(campo);
				
			}
			else{
				primero.hijoD.eliminar(campo);
			}
		}
	}

	public void eliminarMedicionDia(String campo, int anio, int mes, int dia) {
		if (primero!=null){
			if(primero.ciudad.equalsIgnoreCase(campo)){
				primero.mediciones.eliminarDia(anio, mes, dia);
			}
			else if(primero.ciudad.compareToIgnoreCase(campo)>0){
				primero.hijoI.eliminarMedicionDia(campo, anio, mes, dia);
			}
			else{
				primero.hijoD.eliminarMedicionDia(campo, anio, mes, dia);
			}
		}
	}

	public String campo() {
		return primero.ciudad;
	}

	public DMMedicionesTDA mediciones() {
		return primero.mediciones;
	}

	public ABBMedicionesTDA hijoIzquierdo() {
		return primero.hijoI;
	}

	public ABBMedicionesTDA hijoDerecho() {
		return primero.hijoD;
	}

	public boolean arbolMedicionesVacio() {
		return primero==null;
	}
	
	private String menor(ABBMedicionesTDA arbol) {
		if(arbol.hijoDerecho().arbolMedicionesVacio()){
			return arbol.campo();
		}
		else{
			return mayor(arbol.hijoIzquierdo());
		}
	}

	private String mayor(ABBMedicionesTDA arbol) {

		if(arbol.hijoDerecho().arbolMedicionesVacio()){
			return arbol.campo();
		}
		else{
			return mayor(arbol.hijoDerecho());
		}
	}

}