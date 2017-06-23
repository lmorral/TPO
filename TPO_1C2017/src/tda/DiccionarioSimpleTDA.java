package tda;

public interface DiccionarioSimpleTDA {

		public void agregar(int clave, int valor);
		
		public void eliminar(int clave);
		
		public int recuperar(int clave);
		
		public ConjuntoTDA claves();
		
		public void inicializar();
		
}
