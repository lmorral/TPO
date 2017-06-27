package implementacion;

import tda.ABBMedicionesTDA;
import tda.ColaPrioridadInvertidaTDA;
import tda.ConjuntoStringTDA;
import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;
import tda.PrecipitacionesTDA;

public class PrecipitacionImpl implements PrecipitacionesTDA {

	ABBMedicionesTDA arbol;

	public void inicializar() {
		arbol = new ArbolMedicionesBB();
		arbol.inicializar();
	}

	public void agregar(String campo, int anio, int mes, int dia, int precipitacion) {
		arbol.agregar(campo, anio, mes, dia, precipitacion);
	}

	public void eliminar(String campo) {
		arbol.eliminar(campo);
	}

	public void eliminarMedicion(String campo, int anio, int mes, int dia) {
		arbol.eliminarMedicionDia(campo, anio, mes, dia);
	}

	public int medicionDeUnDia(String campo, int anio, int mes, int dia) { //VER
		ABBMedicionesTDA aux=BuscarArbol(arbol, campo);
		if (aux!=null){
			DiccionarioSimpleTDA ds= aux.mediciones().mediciones(anio, mes);
			int x;
			x=ds.recuperar(dia);
			return x;
		}
		else
			return -1; // que devuelvo si no existe
	}
	
	private ABBMedicionesTDA BuscarArbol(ABBMedicionesTDA arbol, String campo){ 
		if (!arbol.arbolMedicionesVacio()){
			if(arbol.campo().equalsIgnoreCase(campo))
				return arbol;
			else if(arbol.campo().compareToIgnoreCase(campo)>0){
				return BuscarArbol(arbol.hijoIzquierdo(), campo);
			}
			else{
				return BuscarArbol(arbol.hijoDerecho(), campo);
			}
		}
		else
			return null; // el arbol esta vacio o no existe campo
	}

	public ConjuntoStringTDA campos() { 
		ConjuntoStringTDA res= new ConjuntoStringEstatico();
		res.inicializar();
		if (!arbol.arbolMedicionesVacio()){
			GuardaCampo(res, arbol);			
		}
		return res;
	}
	
	private void GuardaCampo(ConjuntoStringTDA res, ABBMedicionesTDA arbol){ //recorre arbol y guarda los campos
		if (!arbol.arbolMedicionesVacio()){
		res.agregar(arbol.campo());	
		if(!arbol.hijoDerecho().arbolMedicionesVacio()){
			GuardaCampo(res, arbol.hijoDerecho());
		}
		if(!arbol.hijoIzquierdo().arbolMedicionesVacio()){
			GuardaCampo(res, arbol.hijoIzquierdo());
		}
		}
	}

	public ColaPrioridadInvertidaTDA mediciones(String campo, int anio, int mes) {
		ColaPrioridadInvertidaTDA res= new ColaPIEstatica();
		ABBMedicionesTDA aux=BuscarArbol(arbol, campo);
		if(aux!=null){
			DiccionarioSimpleTDA ds=aux.mediciones().mediciones(anio, mes);
			ConjuntoTDA dias=ds.claves();
			int x;
			while(!dias.conjuntoVacio()){
				x=dias.elegir();
				res.acolar(ds.recuperar(x), x);
				dias.sacar(x);
			}
		}
		return res;
	}

	public int promedioAnual(String campo, int anio) {		
		int prom=0;
		ABBMedicionesTDA aux=BuscarArbol(arbol, campo);
		if(aux!=null){
			for(int mes=1;mes<13;mes++){
				prom=promedioMensual(campo, anio, mes)+prom;
			}
		}
		return prom;
	}

	public int promedioMensual(String campo, int anio, int mes) { //sumo precip de todos los dias de ese mes y lo divido por la cant de dias
		int prom=0;
		ABBMedicionesTDA aux=BuscarArbol(arbol, campo);
		if(aux!=null){
			DiccionarioSimpleTDA ds=aux.mediciones().mediciones(anio,mes);
			ConjuntoTDA dias=ds.claves();
			int x,c=0;
			while(!dias.conjuntoVacio()){
				x=dias.elegir();
				dias.sacar(x);
				prom=prom+ds.recuperar(x);
				c=c+1;
			}
			if(c>0)
				prom=prom/c;
		}
		return prom;
	}

	public ColaPrioridadInvertidaTDA comparativaMensual(String campos, int mes) {
		ColaPrioridadInvertidaTDA res= new ColaPIEstatica();
		res.inicializar();
		ABBMedicionesTDA aux=BuscarArbol(arbol, campos);
		if(aux!=null){
			ConjuntoTDA anios=aux.mediciones().anios();
			int x, prom;
			while(!anios.conjuntoVacio()){
				x=anios.elegir();
				prom=promedioMensual(campos, x, mes);
				res.acolar(prom, x);
				anios.sacar(x);
			}
		}
		return res;
	}

}
