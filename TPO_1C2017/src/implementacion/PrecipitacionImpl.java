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
		DiccionarioSimpleTDA ds= aux.mediciones().mediciones(anio, mes);
			int x;
			x=ds.recuperar(dia);
			return x;
	}
	
	private ABBMedicionesTDA BuscarArbol(ABBMedicionesTDA arbol, String campo){ 
		if(arbol.campo()==campo)
			return arbol;
		else if(arbol.campo().compareToIgnoreCase(campo)>0){
			return BuscarArbol(arbol.hijoIzquierdo(), campo);
		}
		else{
			return BuscarArbol(arbol.hijoDerecho(), campo);
		}
	}

	public ConjuntoStringTDA campos() { //PROBLEMA RECURSIVIDAD, FALTA HACER QUE PASA SI hijoDerecho e hijoIzquierdo NO estan vacios
		ConjuntoStringTDA res= new ConjuntoStringEstatico();
		res.inicializar();
		if (!arbol.arbolMedicionesVacio()){
			res=GuardaCampo(res, arbol);			
		}
		return res;
	}
	
	private ConjuntoStringTDA GuardaCampo(ConjuntoStringTDA res, ABBMedicionesTDA arbol){ //recorre arbol y guarda los campos
		if(arbol.hijoDerecho().arbolMedicionesVacio() && arbol.hijoIzquierdo().arbolMedicionesVacio()){
			res.agregar(arbol.campo());
			return res;
		}
		else if(arbol.hijoDerecho().arbolMedicionesVacio() && !arbol.hijoIzquierdo().arbolMedicionesVacio()){
			return GuardaCampo(res, arbol.hijoIzquierdo());
		}
		else if(!arbol.hijoDerecho().arbolMedicionesVacio() && arbol.hijoIzquierdo().arbolMedicionesVacio()){
			return GuardaCampo(res, arbol.hijoDerecho());
		}
		else{ // si el hijoDerecho e hijoIzquierdo NO estan vacios
			return GuardaCampo(res, arbol.hijoDerecho()); // ESTA MAL TIENE QUE IR POR LOS DOS LADOS (izquierdo y derecho)
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
			DiccionarioSimpleTDA ds=aux.mediciones().mediciones(mes,anio);
			ConjuntoTDA dias=ds.claves();
			int x,c=0;
			while(!dias.conjuntoVacio()){
				x=dias.elegir();
				dias.sacar(x);
				prom=prom+ds.recuperar(x);
				c=c+1;
			}
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
