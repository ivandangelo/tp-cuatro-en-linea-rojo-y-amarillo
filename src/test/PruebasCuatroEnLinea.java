package test;

import juego.Casillero;
import juego.CuatroEnLinea;

import org.junit.Test;
import org.junit.Assert;

public class PruebasCuatroEnLinea {

	/**
	 * 
	 * *************************** 
	 * Tests para el Constructor.*
	 * ***************************
	 * 
	 */

	@Test
	public void probarSiIniciaElTableroConLosNombresVacias() {

		new CuatroEnLinea(5, 5, "", "");

	}

	@Test(expected = Error.class)
	public void probarCrearTablero10x10DebeDarError() {

		/* Condicion inicial */
		new CuatroEnLinea(10, 10, "Marcelo", "jugadorAmarillo");

	}

	@Test(expected = Error.class)
	public void probarCrearTablero4x17DebeDarError() {

		/* Condicion inicial */
		new CuatroEnLinea(4, 17, "Marcelo", "jugadorAmarillo");

	}

	@Test(expected = Error.class)
	public void probarCrearTablero2x2DebeDarError() {

		/* Condicion inicial */
		new CuatroEnLinea(2, 2, "Marcelo", "jugadorAmarillo");

	}

	@Test(expected = Error.class)
	public void crearTablero2x4DebeDarError() {

		/* Condicion inicial */
		new CuatroEnLinea(2, 4, "Marcelo", "jugadorAmarillo");

	}

	@Test(expected = Error.class)
	public void crearTablero4x2DebeDarError() {

		/* Condicion inicial */
		new CuatroEnLinea(2, 4, "jugador1", "jugadorAmarillo");

	}


	@Test
	public void probarSiIniciaElTableroConLosCasillerosVacios() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(5, 5, "jugador1", "jugador2");

		/* Operacion y comprobacion */
		for (int filas = 1; filas <= juego.contarFilas(); filas++) {
			for (int columna = 1; columna <= juego.contarColumnas(); columna++) {
				Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(filas, columna));

			}

		}

	}

	/**
	 * 
	 * ******************************************** 
	 * Tests para contarFilas() y contarColumnas()* 
	 * ********************************************
	 * 
	 */

	@Test
	public void crearTablero8x4YContarFilasDebeDar8() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(8, 4, "jugador1", "jugador2");

		/* Operacion y comprobacion */
		Assert.assertEquals(8, juego.contarFilas());

	}

	@Test
	public void crearTablero8x4YContarColumnasDebeDar4() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(8, 4, "jugador1", "jugador2");

		/* Operacion y comprobacion */
		Assert.assertEquals(4, juego.contarColumnas());

	}

	/**
	 * 
	 * ******************************* 
	 *  Tests para obtenerCasillero()*
	 * *******************************
	 * 
	 * 
	 */

	@Test(expected = Error.class)
	public void obtenerFila0Columna3DebeDarError() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(5, 5, "jugador1", "jugador2");

		/* Operacion */
		juego.obtenerCasillero(0, 3);

	}

	@Test(expected = Error.class)
	public void obtenerFila1Columna0DebeDarError() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(10, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.obtenerCasillero(0, 3);

	}

	@Test(expected = Error.class)
	public void obtenerFila11DebeDarError() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(10, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.obtenerCasillero(11, 5);

	}

	@Test(expected = Error.class)
	public void obtenerColumna11DebeDarError() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(10, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.obtenerCasillero(5, 11);

	}

	@Test
	public void obtenerCualquierCasilleroDebeDarVACIO() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 9, "jugador1", "jugador2");

		/* Comprobacion y operacion */
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(1, 1));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(9, 9));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(1, 9));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(9, 1));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(5, 5));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(8, 2));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(5, 9));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(3, 2));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(6, 7));

	}

	/**
	 * 
	 * ************************* 
	 * Tests para soltarFicha()*
	 * *************************
	 * 
	 */

	@Test
	public void soltar100FichasEnElMismoLugarDebeSoltarSolamente4Fichas() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 10, "jugador1", "jugador2");

		/* Operacion */
		for (int i = 0; i < 100; i++) {
			juego.soltarFicha(1);
		}

		/* Comprobacion */
		Assert.assertNotEquals("El casillero no debe estar vacío", Casillero.VACIO, juego.obtenerCasillero(1, 1));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(2, 4));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(3, 4));
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(4, 4));

	}

	@Test(expected = Error.class)
	public void soltarFichaEnColumna11DeberiaDarError() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(11);

	}

	@Test(expected = Error.class)
	public void soltarFichaEnColumna0DebeDarError() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(0);

	}

	@Test
	public void soltarUnaFichaDebeDarCasilleroROJO() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);

		/* Comprobacion */
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(4, 1));

	}

	@Test
	public void soltarDosFichasEnLaPosicionDeLaSegundaDebeDarmeUnaFichaAmarilla() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);
		juego.soltarFicha(2);

		/* Comprobacion */
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(4, 2));

	}

	@Test
	public void soltarVariasFichasDebeDarRojoYAmarilloEnSusCasillerosCorrespondientes() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(6);// Amarillo

		/* Comprobacion */
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(9, 1));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(9, 2));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(9, 3));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(9, 4));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(9, 5));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(9, 6));

	}

	@Test
	public void soltarFichasEnLaMismaColumnaDebeApilar() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo

		/* Comprobacion */
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(9, 1));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(8, 1));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(7, 1));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(6, 1));
		Assert.assertEquals(Casillero.ROJO, juego.obtenerCasillero(5, 1));
		Assert.assertEquals(Casillero.AMARILLO, juego.obtenerCasillero(4, 1));

	}

	/**
	 * ******************** 
	 * Test para termino()* 
	 * ********************
	 */

	@Test
	public void probarSiTerminoConTodosLosCasillerosOcupados() {

		/*Condicion inicial*/
		CuatroEnLinea juego = new CuatroEnLinea(6 , 6 , "jugador1" , "jugador2");

		/*Operacion*/
		for(int fila = 0 ; fila < juego.contarFilas() ; fila++) {
			for(int columna = 1 ; columna <= juego.contarColumnas() ; columna++) {
				juego.soltarFicha(columna);

			}	

		}

		/*Comprobacion*/
		Assert.assertTrue(juego.termino());

	}

	/**
	 * *********************** 
	 * Test para hayGanador()* 
	 * ***********************
	 */


	@Test
	public void hayGanadorEnJuegoConEmpateDebeDarFalse() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "jugador1", "jugador2");

		/*Operacion*/
		juego.soltarFicha(1); //Rojo
		juego.soltarFicha(1); //Amarillo
		juego.soltarFicha(1); //Rojo
		juego.soltarFicha(2); //Amarillo
		juego.soltarFicha(1); //Rojo
		juego.soltarFicha(2); //Amarillo
		juego.soltarFicha(3); //Rojo
		juego.soltarFicha(4); //Amarillo
		juego.soltarFicha(3); //Rojo
		juego.soltarFicha(3); //Amarillo
		juego.soltarFicha(2); //Rojo
		juego.soltarFicha(3); //Amarillo
		juego.soltarFicha(4); //Rojo
		juego.soltarFicha(2); //Amarillo
		juego.soltarFicha(4); //Rojo
		juego.soltarFicha(4); //Amarillo

		/*Comprobacion */
		Assert.assertFalse(juego.hayGanador());

	}

	// tests para hay ganador horizontal//
	@Test
	public void probarSiHayGanadorHorizontalEnLaUltimaFila() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(6, 6, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(4);// Rojo

		/* Comprobacion */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void despuesDeHaberGanadorHorizontalNoDebePoderTirarFicha() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(4);// Rojo
		juego.soltarFicha(5);// Amarillo

		/* Comprobacion */
		Assert.assertTrue(juego.hayGanador());
		Assert.assertEquals(Casillero.VACIO, juego.obtenerCasillero(9, 5));

	}

	@Test
	public void probarGanadorHorizontalEnElMedio() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(6, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(4);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(4);// Amarillo

		/* Comprobacion */
		Assert.assertTrue(juego.hayGanador());

	}

	// tests para ganador vertical//

	@Test
	public void probarSiHayGanadorVerticalEnLaPrimeraColumna() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(6, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(1);// Rojo

		/* Comprobacion */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void probarSiHayGanadorVerticalEnLaUltimaColumna() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(5, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(10);// Rojo

		/* Comprobacion */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void probarSiHayGanadorVerticalEnElMedio() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(5, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(5);// Rojo

		/* Comprobacion */
		Assert.assertTrue(juego.hayGanador());

	}

	// pruebas para ganador diagonal descendente//

	@Test
	public void JuegoConGanadorDiagonalDescendente4x4() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Juan", "Pedro");

		/*Operacion*/
		juego.soltarFicha(4); // Rojo
		juego.soltarFicha(3); // Amarillo
		juego.soltarFicha(3); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(2); // Rojo
		juego.soltarFicha(1); // Amarillo
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(4); // Amarillo
		juego.soltarFicha(1); // Rojo

		/* Comprobación */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void JuegoConGanadorDiagonalDescendente5x5() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(5, 5, "Juan", "Pedro");

		/*Operacion*/
		juego.soltarFicha(5); // Rojo
		juego.soltarFicha(4); // Amarillo
		juego.soltarFicha(4); // Rojo
		juego.soltarFicha(4); // Amarillo
		juego.soltarFicha(3); // Rojo
		juego.soltarFicha(5); // Amarillo
		juego.soltarFicha(3); // Rojo
		juego.soltarFicha(3); // Amarillo
		juego.soltarFicha(2); // Rojo
		juego.soltarFicha(3); // Amarillo
		juego.soltarFicha(2); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(2); // Rojo
		juego.soltarFicha(2); // Amarillo

		/* Comprobación */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void diagonalDescendenteAmarillaDesdeElPrimerCasilleroSuperiorDerecho (){

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea (9, 16, "Juan", "Pedro");

		/* Operación */
		//Primera ficha//
		juego.soltarFicha(16); //Rojo
		juego.soltarFicha(1);//Amarillo
		juego.soltarFicha(1);//Rojo
		juego.soltarFicha(1);//Amarillo
		juego.soltarFicha(1);//Rojo
		juego.soltarFicha(1);//Amarillo
		juego.soltarFicha(1);//Rojo
		juego.soltarFicha(1);//Amarillo
		juego.soltarFicha(1);//Rojo
		juego.soltarFicha(1);//Amarillo
		//Segunda ficha//
		juego.soltarFicha(2);//Rojo
		juego.soltarFicha(2);//Amarillo
		juego.soltarFicha(2);//Rojo
		juego.soltarFicha(2);//Amarillo
		juego.soltarFicha(2);//Rojo
		juego.soltarFicha(2);//Amarillo
		juego.soltarFicha(2);//Rojo
		juego.soltarFicha(2);//Amarillo
		//Tercera ficha//
		juego.soltarFicha(16);//Rojo
		juego.soltarFicha(3);//Amarillo
		juego.soltarFicha(3);//Rojo
		juego.soltarFicha(3);//Amarillo
		juego.soltarFicha(3);//Rojo
		juego.soltarFicha(3);//Amarillo
		juego.soltarFicha(3);//Rojo
		juego.soltarFicha(3);//Amarillo
		//Cuarta ficha//
		juego.soltarFicha(15);//Rojo
		juego.soltarFicha(4);//Amarillo 
		juego.soltarFicha(4);//Rojo 
		juego.soltarFicha(4);//Amarillo 
		juego.soltarFicha(4);//Rojo 
		juego.soltarFicha(4);//Amarillo 
		juego.soltarFicha(14);//Rojo 
		juego.soltarFicha(4);//Amarillo 

		boolean hayGanador = juego.hayGanador();

		/* Comprobación */
		Assert.assertTrue(hayGanador);

	}

	// pruebas para ganador diagonal ascendente//
	@Test
	public void ganadorDiagonalAscendente() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(8, 10, "Juan", "Pedro");

		/*Operacion*/
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(4);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(4);// Rojo

		/* Comprobación */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void juegoConGanadorDiagonalAscendente7x10() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(7, 10, "Juan", "Pedro");

		/*Operacion*/
		// Primera ficha//
		juego.soltarFicha(3); // Rojo
		juego.soltarFicha(3); // Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(3);// Rojo
		// Segunda ficha//
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(4);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(4);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(4);// Rojo
		// Tercera ficha//
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(5);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(5);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(5);// Amarillo
		juego.soltarFicha(5);// Rojo
		// Cuarta ficha//
		juego.soltarFicha(6);// Amarillo
		juego.soltarFicha(6);// Rojo
		juego.soltarFicha(6);// Amarillo
		juego.soltarFicha(6);// Rojo
		juego.soltarFicha(6);// Amarillo
		juego.soltarFicha(6);// Rojo
		juego.soltarFicha(6);// Amarillo
		juego.soltarFicha(6);// Rojo

		/* Comprobación */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void probarDiagonalAscendenteEsquinaSuperiorDerecha() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "Juan", "Pedro");

		/*Operacion*/
		// Primera ficha//
		juego.soltarFicha(7); // Rojo
		juego.soltarFicha(7); // Amarillo
		juego.soltarFicha(7);// Rojo
		juego.soltarFicha(7);// Amarillo
		juego.soltarFicha(7);// Rojo
		juego.soltarFicha(7);// Amarillo
		juego.soltarFicha(7);// Rojo
		// Segunda Ficha//
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		// Tercera Ficha//
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		// Cuarta Ficha//
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo

		/* Comprobación */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void ganadorConDiagonalAscendenteEsquinaIzquierdaInferior() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "Juan", "Pedro");

		/*Operacion*/
		// Primera ficha//
		juego.soltarFicha(1); // Rojo
		// Segunda ficha//
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(2);// Rojo
		// Tercera ficha//
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(3);// Rojo
		// Cuarta ficha//
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(4);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(4);// Rojo

		/* Comprobación */
		Assert.assertTrue(juego.hayGanador());

	}

	@Test
	public void ganadorConDiagonalAscendenteEsquinaDerechaInferior() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 10, "Juan", "Pedro");

		/*Operacion*/
		// Primera ficha//
		juego.soltarFicha(7); // Rojo
		// Segunda ficha//
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		// Tercera ficha//
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		// Cuarta ficha//
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo

		/* Comprobación */
		Assert.assertTrue(juego.hayGanador());

	}

	/**
	 * *************************** 
	 * Test para obtenerGanador()*
	 * ***************************
	 */

	@Test
	public void obtenerGanadorEnJuegoSinGanadorDebeDevolverNull() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(5, 5, "Pepe", "Dolores");

		/*Comprobacion*/
		Assert.assertNull(juego.obtenerGanador());

	}

	@Test
	public void obtenerGanadorEnJuegoConEmpateDevuelveNull() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "jugador1", "jugador2");

		/*Operacion*/
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(1); // Amarillo
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(3); // Rojo
		juego.soltarFicha(4); // Amarillo
		juego.soltarFicha(3); // Rojo
		juego.soltarFicha(3); // Amarillo
		juego.soltarFicha(2); // Rojo
		juego.soltarFicha(3); // Amarillo
		juego.soltarFicha(4); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(4); // Rojo
		juego.soltarFicha(4); // Amarillo


		/*Comprobacion */		
		Assert.assertNull(juego.obtenerGanador());

	}

	@Test
	public void JuegoConGanadorRojoDiagonalDescendente() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(4, 4, "Juan", "Pedro");

		/*Operacion*/
		juego.soltarFicha(4); // Rojo
		juego.soltarFicha(3); // Amarillo
		juego.soltarFicha(3); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(2); // Rojo
		juego.soltarFicha(1); // Amarillo
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(4); // Amarillo
		juego.soltarFicha(1); // Rojo

		/* Comprobación */
		Assert.assertEquals("Juan", juego.obtenerGanador());
	}

	@Test
	public void JuegoConGanadorAmarilloDiagonalDescendente() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(6, 6, "Juan", "Pedro");

		/*Operacion*/
		juego.soltarFicha(6); // Rojo
		juego.soltarFicha(4); // Amarillo
		juego.soltarFicha(4); // Rojo
		juego.soltarFicha(3); // Amarillo
		juego.soltarFicha(3); // Rojo
		juego.soltarFicha(2); // Amarillo
		juego.soltarFicha(2); // Rojo
		juego.soltarFicha(1); // Amarillo

		/* Comprobación */
		Assert.assertEquals("Pedro", juego.obtenerGanador());

	}
	
	
	@Test
	public void elGanadorEsRojoConDiagonalAscendenteDerechaEsquinaInferior() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "Juan", "Pedro");
		
		/*Operacion*/
		// Primera ficha//
		juego.soltarFicha(7); // Rojo
		juego.soltarFicha(7); // Amarillo
		juego.soltarFicha(7);// Rojo
		juego.soltarFicha(7);// Amarillo
		juego.soltarFicha(7);// Rojo
		juego.soltarFicha(7);// Amarillo
		juego.soltarFicha(7);// Rojo
		// Segunda Ficha//
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		// Tercera Ficha//
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		// Cuarta Ficha//
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo

		/*Comprobacion */
		Assert.assertEquals("ganador", "Juan", juego.obtenerGanador());
		

	}
	
	@Test
	public void elGanadorEsAmarilloConDiagonalAscendenteDerechaEsquinaSuperior() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "Juan", "Pedro");
		
		/*Operacion*/
		// Primera ficha//
		juego.soltarFicha(7); // Rojo
		juego.soltarFicha(7); // Amarillo
		juego.soltarFicha(7);// Rojo
		juego.soltarFicha(7);// Amarillo
		juego.soltarFicha(7);// Rojo
		juego.soltarFicha(7);// Amarillo
		juego.soltarFicha(7);// Rojo
		// Segunda Ficha//
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		// Tercera Ficha//
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		// Cuarta Ficha//
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(10);// Amarillo

		/*Comprobacion */
		Assert.assertEquals("ganador", "Pedro", juego.obtenerGanador());
		

	}
	
	@Test
	public void elGanadorEsAmarilloConDiagonalAscendenteDerechaEsquinaInferior() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "Juan", "Pedro");
		
		/*Operacion*/
		// Primera ficha//
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(7); // Amarillo
		juego.soltarFicha(7); // Rojo
		// Segunda Ficha//
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		// Tercera Ficha//
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		// Cuarta Ficha//
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(10);// Amarillo
	

		/*Comprobacion */
		Assert.assertEquals("ganador", "Pedro", juego.obtenerGanador());
		

	}
	
	@Test
	public void elGanadorEsRojoConDiagonalAscendenteDerechaEsquinaSuperior() {

		/* Condición inicial */
		CuatroEnLinea juego = new CuatroEnLinea(9, 10, "Juan", "Pedro");
		
		/*Operacion*/
		// Primera ficha//
		juego.soltarFicha(1); // Rojo
		juego.soltarFicha(7); // Amarillo
		juego.soltarFicha(7);// Rojo
		juego.soltarFicha(7);// Amarillo
		juego.soltarFicha(7);// Rojo
		juego.soltarFicha(7);// Amarillo
		juego.soltarFicha(7);// Rojo
		// Segunda Ficha//
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		juego.soltarFicha(8);// Amarillo
		juego.soltarFicha(8);// Rojo
		// Tercera Ficha//
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		juego.soltarFicha(9);// Rojo
		juego.soltarFicha(9);// Amarillo
		// Cuarta Ficha//
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(10);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(10);// Amarillo

		/*Comprobacion */
		Assert.assertEquals("ganador", "Juan", juego.obtenerGanador());
		

	}
	
	@Test
	public void probarGanadorHorizontalEnElMedioEsAmarillo() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(6, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(4);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(5);// Rojo
		juego.soltarFicha(4);// Amarillo

		/* Comprobacion */
		Assert.assertEquals("ganador", "jugador2", juego.obtenerGanador());

	}
	
	@Test
	public void probarSiElGanadorHorizontalEnLaUltimaFilaEsRojo() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(6, 6, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(4);// Rojo

		/* Comprobacion */
		Assert.assertEquals("ganador", "jugador1", juego.obtenerGanador());
	}
	
	@Test
	public void probarSiElGanadorVerticalEnLaPrimeraColumnaEsRojo() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(6, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(1);// Rojo

		/* Comprobacion */
		Assert.assertEquals("ganador", "jugador1", juego.obtenerGanador());

	}
	
	@Test
	public void probarSiElGanadorVerticalEnLaUltimaColumnaEsRojo() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(5, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(10);// Rojo

		/* Comprobacion */
		Assert.assertEquals("ganador", "jugador1", juego.obtenerGanador());

	}
	
	@Test
	public void probarSiElGanadorVerticalEnLaUltimaColumnaEsAmarillo() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(5, 10, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(10);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(2);// Amarillo

		/* Comprobacion */
		Assert.assertEquals("ganador", "jugador2", juego.obtenerGanador());

	}
	
	@Test
	public void probarSiElGanadorHorizontalEnLaUltimaFilaEsAmarillo() {

		/* Condicion inicial */
		CuatroEnLinea juego = new CuatroEnLinea(6, 6, "jugador1", "jugador2");

		/* Operacion */
		juego.soltarFicha(1);// Rojo
		juego.soltarFicha(1);// Amarillo
		juego.soltarFicha(2);// Rojo
		juego.soltarFicha(2);// Amarillo
		juego.soltarFicha(3);// Rojo
		juego.soltarFicha(3);// Amarillo
		juego.soltarFicha(6);// Rojo
		juego.soltarFicha(4);// Amarillo
		juego.soltarFicha(6);// Rojo
		juego.soltarFicha(4);// Amarillo

		/* Comprobacion */
		Assert.assertEquals("ganador", "jugador2", juego.obtenerGanador());
	}	

}
