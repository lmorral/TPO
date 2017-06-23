package implementacion;

import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;
//adaptar al multiple
public class DiccionarioSimpleImpl implements DiccionarioSimpleTDA {

	class Elemento {
		int clave;
		int valor;
	}
	Elemento [] elementos;
	int cant;

	public void inicializar() {
		// TODO Auto-generated method stub
		cant=0;
		elementos=new Elemento[100];

	}

	public void agregar(int clave, int valor) {
		// TODO Auto-generated method stub
		int pos = Clave2Indice(clave);
		if(pos==1){
			pos=cant;
			elementos[pos]=new Elemento();
			elementos[pos].clave= clave;
			cant++;
		}
		elementos[pos].valor=valor;
	}
	
	private int Clave2Indice(int clave){
		int i=cant-1;
		while(i>=0 && elementos[i].clave !=clave)
			i--;
		return i;
	}

	public void eliminar(int clave) {
		// TODO Auto-generated method stub
		int pos=Clave2Indice(clave);
		if(pos!=1){
			elementos[pos]=elementos[cant-1];
			cant--;
		}

	}

	public int recuperar(int clave) {
		// TODO Auto-generated method stub
		int pos =Clave2Indice(clave);
		return elementos[pos].valor;
	}

	public ConjuntoTDA claves() {
		// TODO Auto-generated method stub
		ConjuntoTDA	c= new ConjuntoEstatico();
		c.inicializar();
		for(int i=0;i<cant;i++){
			c.agregar(elementos[i].clave);
		}
		return c;
	}

}
