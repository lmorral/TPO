package implementacion;

import auxiliares.Dias;
import tda.ConjuntoTDA;
import tda.DMMedicionesTDA;
import tda.DiccionarioSimpleTDA;

public class DiccMulMediciones implements DMMedicionesTDA {

	NodoMedicionesAnio origen;

	public void inicializar() {
		origen=null;
	}

	public void agregar(int anio, int mes, int dia, int medicion) {  //CHEQUEAR
		NodoMedicionesAnio aux= BuscarAnio(anio);
		if(aux==null){ //no existe anio
			aux=new NodoMedicionesAnio();
			aux.anio=anio;
			aux.siguienteAnio=origen;
			origen=aux;
			NodoMedicionesMes aux2= aux.medicionMes;
			aux2=new NodoMedicionesMes();
			aux2.mes=mes;
			aux2.cantidadDiasMes=Dias.getInstancia().cantidadDias(mes, anio);
			aux2.precipitacionPorDia= new int [aux2.cantidadDiasMes];
			for(int i=0;i<aux2.cantidadDiasMes;i++){
				aux2.precipitacionPorDia[i]=0;
			}
			aux2.siguienteMes=aux.medicionMes;
			aux.medicionMes=aux2;
			aux2.precipitacionPorDia[dia-1]=medicion;
		}
		else{  //existe anio
			NodoMedicionesMes auxm=BuscarMes(mes, aux);
			if(auxm==null){ //no existe mes
				NodoMedicionesMes aux2= aux.medicionMes;
				aux2=new NodoMedicionesMes();
				aux2.mes=mes;
				aux2.cantidadDiasMes=Dias.getInstancia().cantidadDias(mes, anio);
				aux2.precipitacionPorDia= new int [aux2.cantidadDiasMes];
				for(int i=0;i<aux2.cantidadDiasMes;i++){
					aux2.precipitacionPorDia[i]=0;
				}
				aux2.siguienteMes=aux.medicionMes;
				aux.medicionMes=aux2;
				aux2.precipitacionPorDia[dia-1]=medicion;
			}
			else if(auxm!=null){ //existe mes
				auxm.precipitacionPorDia[dia-1]=medicion;
			}
		}
	}
	
	private NodoMedicionesAnio BuscarAnio(int anio){
		NodoMedicionesAnio aux=origen;
		while (aux!=null && aux.anio!=anio){
			aux=aux.siguienteAnio;
		}
		return aux;
	}

	public void eliminarAnio(int anio) {
		if(origen!=null){
			if(origen.anio==anio){
				origen=origen.siguienteAnio;
			}
			else{
				NodoMedicionesAnio aux=origen;
				while(aux.siguienteAnio!=null && aux.siguienteAnio.anio!=anio){
					aux=aux.siguienteAnio;
				}
				if(aux.siguienteAnio!=null){
					aux.siguienteAnio=aux.siguienteAnio.siguienteAnio;
				}
			}
		}
	}

	public void eliminarMes(int mes, int anio) { //opcional. Se usa en eliminarDia
	}

	public void eliminarDia(int anio, int mes, int dia) {
		NodoMedicionesAnio auxa= BuscarAnio(anio);
		if(auxa!=null){
			NodoMedicionesMes auxm= BuscarMes(mes, auxa);
			if(auxm!=null){
				auxm.precipitacionPorDia[dia-1]=0;
				int cont=0; //chequea si se tiene que eliminar mes
				for(int i=0;i<auxm.cantidadDiasMes;i++){
					if(auxm.precipitacionPorDia[i]==0)
						++cont;
				}
				if(cont==auxm.cantidadDiasMes){ //si todos los dias estan en 0 
					if(auxa.medicionMes.mes==mes){ //mes en primera posicion
						auxa.medicionMes=auxa.medicionMes.siguienteMes;
					}
					else{ //mes en el medio o final
						NodoMedicionesMes aux=auxa.medicionMes;
						while(aux.siguienteMes!=null && aux.siguienteMes.mes!=mes){
							aux=aux.siguienteMes;
						}
						if(aux.siguienteMes!=null){
							aux.siguienteMes=aux.siguienteMes.siguienteMes;
						}
					}
				}
			}
		}
	}

	public ConjuntoTDA anios() {
		ConjuntoTDA res=new ConjuntoEstatico();
		res.inicializar();
		NodoMedicionesAnio aux=origen;
		while(aux!=null){
			res.agregar(aux.anio);
			aux=aux.siguienteAnio;
		}
		return res;
	}

	public ConjuntoTDA meses(int anio) {
		NodoMedicionesAnio auxa=BuscarAnio(anio);
		ConjuntoTDA res= new ConjuntoEstatico();
		res.inicializar();
		if(auxa!=null){
			NodoMedicionesMes auxm=auxa.medicionMes;
			while(auxm!=null){
				res.agregar(auxm.mes);
				auxm=auxm.siguienteMes;
			}
		}
		return res;
	}

	public DiccionarioSimpleTDA mediciones(int anio, int mes) {
		DiccionarioSimpleTDA res=new DiccSim();
		res.inicializar();
		NodoMedicionesAnio auxa=BuscarAnio(anio);
		if(auxa!=null){
			NodoMedicionesMes auxm=BuscarMes(mes, auxa);
			if(auxm!=null){
				for(int i=1;i<auxm.cantidadDiasMes+1;i++){
					res.agregar(i, auxm.precipitacionPorDia[i-1]);
				}
			}
		}
		return res;
	}
	
	private NodoMedicionesMes BuscarMes(int mes, NodoMedicionesAnio aux){
		NodoMedicionesMes aux2=aux.medicionMes;
		while(aux2!=null && aux2.mes!=mes){
			aux2=aux2.siguienteMes;
		}
		return aux2;
	}

}
