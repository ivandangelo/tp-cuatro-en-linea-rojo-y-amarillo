package juego;

/**
 * Juego Cuatro en Lí­nea
 * 
 * Reglas:
 *
 * Empieza el jugador Rojo, cada jugador tiene UNA jugada por turno. Se pone UNA
 * ficha a la vez. Condición de Victoria: gana el primero que logra colocar
 * cuatro fichas alineadas en orden vertical, horizontal, diagonal descendente o
 * ascendente. Empate: si se completó el tablero y ningún jugador alineó cuatro
 * fichas.
 * 
 * Dimensiones del tablero. Mínimo: 4x4. Máximo: 9x16 (Sino no cabe en la
 * pantalla).
 *
 */
public class CuatroEnLinea {

	private Casillero[][] tablero;
	private String jugadorRojo;
	private String jugadorAmarillo;
	private boolean esTurnoRojo;
	private boolean hayGanador;
	private String ganador;

	/**
	 * pre : 'fila' y 'columna' son números mayores o iguales a 4. fila debe
	 * valer 9 como máximo. columna debe valer 16 como máximo.
	 * 
	 * post: Inicializa el tablero vacío. Concede el turno inicial al
	 * 'jugadorRojo'
	 * 
	 * 
	 * @param fila
	 *            : cantidad de filas que tiene el tablero.
	 * @param columna
	 *            : cantidad de columnas que tiene el tablero.
	 * @param jugadorRojo
	 *            : nombre del jugador con fichas rojas.
	 * @param jugadorAmarillo
	 *            : nombre del jugador con fichas amarillas.
	 */

	public CuatroEnLinea(int fila, int columna, String jugadorRojo, String jugadorAmarillo) {

		validarFilasYColumnas(fila, columna);
		tablero = new Casillero[fila][columna];
		this.jugadorAmarillo = jugadorAmarillo;
		this.jugadorRojo = jugadorRojo;
		validarNombres(jugadorRojo, jugadorAmarillo);
		esTurnoRojo = true;

		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = Casillero.VACIO;

			}

		}

	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden apilar en el
	 * tablero.
	 */

	public int contarFilas() {

		return tablero.length;
	}

	/**
	 * post: devuelve la cantidad máxima de fichas que se pueden alinear en el
	 * tablero.
	 */

	public int contarColumnas() {

		return tablero[0].length;
	}

	/**
	 * pre : fila está en el intervalo [1, contarFilas()], columnas está en el
	 * intervalo [1, contarColumnas()]. 
	 * post: indica qué ocupa el casillero en la posición dada por fila y columna.
	 * 
	 * @param fila
	 * @param columna
	 */

	public Casillero obtenerCasillero(int fila, int columna) {

		if ((fila < 1 || fila > contarFilas()) || (columna < 1 || columna > contarColumnas())) {
			throw new Error("Datos invalidos");

		}

		return tablero[fila - 1][columna - 1];
	}

	/**
	 * pre : el juego no terminó, columna está en el intervalo [1,
	 * contarColumnas()] y aún queda un Casillero.VACIO en la columna indicada.
	 * post: deja caer una ficha en la columna indicada.
	 * 
	 * @param columna
	 */
	public void soltarFicha(int columna) {

		verificarColumnaEnRango(columna);
		if (!termino()) {
			int ultimoCasilleroVacio = -1;
			columna--;
			boolean encontroCasilleroOcupado = false;

			for (int i = 0; i < tablero.length && !encontroCasilleroOcupado; i++) {
				encontroCasilleroOcupado = (tablero[i][columna] != Casillero.VACIO);
				if (!encontroCasilleroOcupado) {
					ultimoCasilleroVacio = i;

				}

			}

			if (ultimoCasilleroVacio >= 0 && esTurnoRojo) {
				tablero[ultimoCasilleroVacio][columna] = Casillero.ROJO;
				esTurnoRojo = false;

			} else if (ultimoCasilleroVacio >= 0) {
				tablero[ultimoCasilleroVacio][columna] = Casillero.AMARILLO;
				esTurnoRojo = true;
			}

		}
	}

	/**
	 * post: indica si el juego terminó porque uno de los jugadores ganó o no
	 * existen casilleros vacíos.
	 */
	public boolean termino() {

		boolean tableroLleno = false;
		int contador = 0;

		/* no hay mas lugar */
		for (int columna = 0; columna < tablero[0].length; columna++) {
			if (tablero[0][columna] != Casillero.VACIO) {
				contador++;

			}

			tableroLleno = (contador == tablero.length);

		}

		return hayGanador() || tableroLleno;
	}

	/**
	 * post: indica si el juego terminó y tiene un ganador.
	 */
	public boolean hayGanador() {

		hayGanador = hayGanadorHorizontal();
		hayGanador = hayGanadorVertical();
		hayGanador = hayGandorDiagonalDescendente();
		hayGanador = hayGanadorDiagonalAscendente();

		return hayGanador;

	}

	/**
	 * pre : el juego terminó. 
	 * 
	 * post: devuelve el nombre del jugador que ganó.
	 */
	public String obtenerGanador() {

		if (hayGanador()) {

			ganador = jugadorAmarillo;
			ganador = comprobarSiGanadorHorizontalEsRojo();

			if (ganador != jugadorRojo) ganador = comprobarSiElGanadorVerticalEsRojo();

			if (ganador != jugadorRojo) ganador = comprobarSiELGanadorDiagonalDescendenteEsRojo();

			if (ganador != jugadorRojo)	ganador = comprobarSiElGanadorDiagonalAscendenteEsRojo();	
		}

		return ganador;

	}

	/**
	 * 	post: 	valida la cantidadDeFilas ingresada en el constructor, 
	 * 			lanzando error si se ingresa una cantidad inválida. 
	 * 			El numero de filas y/o de columnas debe ser mayor o igual a 4.
	 * 			El número máximo de filas es 9. 
	 * 			El número máximo de columnas es 16.
	 * 
	 * @param cantidadDeFilas
	 */
	private void validarFilasYColumnas(int cantidadDeFilas, int cantidadDeColumnas) {

		if (cantidadDeFilas < 4 || cantidadDeFilas > 9 || cantidadDeColumnas < 4 || cantidadDeColumnas > 16) {
			throw new Error("El numero de filas y/o de columnas debe ser mayor o igual a 4."
					+ "El número máximo de filas es 9. El número máximo de columnas es 16.");

		}

	}

	/**
	 * post:	comprueba si hay ganador con cuatro en linea horizontal.
	 * 
	 * @return
	 */
	private boolean hayGanadorHorizontal() {

		/* Cuatro en linea horizontal */
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 3; columna < tablero[fila].length && !hayGanador; columna++) {

				hayGanador = (((tablero[fila][columna] == tablero[fila][columna - 1])
						&& (tablero[fila][columna] == tablero[fila][columna - 2])
						&& (tablero[fila][columna] == tablero[fila][columna - 3]))
						&& (tablero[fila][columna] != Casillero.VACIO));

			}

		}

		return hayGanador;

	}

	/**
	 * post:	comprueba si hay ganador con cuatro en linea vertical.
	 * 
	 * @return
	 */
	private boolean hayGanadorVertical() {

		/* Cuatro en linea vertical */
		for (int fila = 3; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[fila].length && !hayGanador; columna++) {

				hayGanador = ((tablero[fila][columna] == tablero[fila - 1][columna])
						&& (tablero[fila][columna] == tablero[fila - 2][columna])
						&& (tablero[fila][columna] == tablero[fila - 3][columna])
						&& (tablero[fila][columna] != Casillero.VACIO));

			}

		}

		return hayGanador;

	}

	/**
	 * post:	comprueba si hay ganador con cuatro en linea diagonal descendente.
	 * 
	 * @return
	 */
	private boolean hayGandorDiagonalDescendente() {

		/* Cuatro en linea diagonal descendente */
		for (int fila = 0; fila < tablero.length - 3; fila++) {
			for (int columna = 0; columna < tablero[fila].length - 3 && !hayGanador; columna++) {

				hayGanador = ((tablero[fila][columna] == tablero[fila + 1][columna + 1])
						&& (tablero[fila][columna] == tablero[fila + 2][columna + 2])
						&& (tablero[fila][columna] == tablero[fila + 3][columna + 3])
						&& (tablero[fila][columna] != Casillero.VACIO));

			}

		}

		return hayGanador;

	}

	/**
	 * post:	comprueba si hay ganador con cuatro en linea diagonal ascendente.
	 * 
	 * @return
	 */
	private boolean hayGanadorDiagonalAscendente() {

		for (int fila = 0; fila < tablero.length - 3; fila++) {
			for (int columna = 3; columna < tablero[fila].length && !hayGanador; columna++) {

				hayGanador = ((tablero[fila][columna] == tablero[fila + 1][columna - 1])
						&& (tablero[fila][columna] == tablero[fila + 2][columna - 2])
						&& (tablero[fila][columna] == tablero[fila + 3][columna - 3])
						&& (tablero[fila][columna] != Casillero.VACIO));

			}

		}

		return hayGanador;

	}

	/**
	 * post:	comprueba si el ganador para cuatro en linea horizontal es ROJO
	 * 
	 * @return
	 */
	private String comprobarSiGanadorHorizontalEsRojo() {

		/* Ganador horizontal */
		for (int fila = 0; fila < tablero.length; fila++) {
			for (int columna = 3; columna < tablero[fila].length; columna++) {

				if ((((tablero[fila][columna] == Casillero.ROJO))
						&& (tablero[fila][columna] == tablero[fila][columna - 1])
						&& (tablero[fila][columna] == tablero[fila][columna - 2])
						&& (tablero[fila][columna] == tablero[fila][columna - 3]))) {

					ganador = jugadorRojo;

				}
			}
		}

		return ganador;
	}

	/**
	 * post:	comprueba si el ganador para cuatro en linea Vertical es ROJO.
	 * 
	 * @return
	 */
	private String comprobarSiElGanadorVerticalEsRojo() {

		/* Ganador vertical */
		for (int fila = 3; fila < tablero.length; fila++) {
			for (int columna = 0; columna < tablero[fila].length; columna++) {

				if ((((tablero[fila][columna] == Casillero.ROJO))
						&& (tablero[fila][columna] == tablero[fila - 1][columna])
						&& (tablero[fila][columna] == tablero[fila - 2][columna])
						&& (tablero[fila][columna] == tablero[fila - 3][columna]))) {

					ganador = jugadorRojo;

				}
			}
		}

		return ganador;
	}

	/**
	 * post:	comprueba si el ganador para cuatro en linea diagonal descendente es ROJO.
	 * 
	 * @return
	 */
	private String comprobarSiELGanadorDiagonalDescendenteEsRojo() {

		/* Ganador diagonal descendente */
		for (int fila = 0; fila < tablero.length - 3; fila++) {
			for (int columna = 0; columna < tablero[fila].length - 3; columna++) {

				if ((((tablero[fila][columna] == Casillero.ROJO))
						&& (tablero[fila][columna] == tablero[fila + 1][columna + 1])
						&& (tablero[fila][columna] == tablero[fila + 2][columna + 2])
						&& (tablero[fila][columna] == tablero[fila + 3][columna + 3]))) {

					ganador = jugadorRojo;

				}
			}
		}

		return ganador;

	}

	/**
	 * post:	comprueba si el ganador para cuatro en linea diagonal ascendente es ROJO.
	 * 
	 * @return
	 */
	private String comprobarSiElGanadorDiagonalAscendenteEsRojo() {

		/* Ganador diagonal ascendente */
		for (int fila = 0; fila < tablero.length - 3; fila++) {
			for (int columna = 3; columna < tablero[fila].length; columna++) {

				if ((((tablero[fila][columna] == Casillero.ROJO))
						&& (tablero[fila][columna] == tablero[fila + 1][columna - 1])
						&& (tablero[fila][columna] == tablero[fila + 2][columna - 2])
						&& (tablero[fila][columna] == tablero[fila + 3][columna - 3]))) {

					ganador = jugadorRojo;

				}
			}

		}

		return ganador;

	}

	private void verificarColumnaEnRango(int columna) {

		if (columna < 1 || columna > contarColumnas()) {
			throw new Error("columna debe estar en el rango [1 , contarColumnas()]");

		}

	}
	
	private void validarNombres(String jugadorRojo , String jugadorAmarillo) {
		
		if(jugadorRojo.equals(jugadorAmarillo)) {
			this.jugadorRojo = jugadorRojo+" (Rojo)";
			this.jugadorAmarillo = jugadorAmarillo+" (Amarillo)";
			
		}
		
		
		if(jugadorRojo.equals("")) {
			this.jugadorRojo = "Rojo";
			
		}
		
		if(jugadorAmarillo.equals("")) {
			this.jugadorAmarillo = "Amarillo";
			
		}
		
	}

}
