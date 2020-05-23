package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import Ubicacion.Ubicacion;
import acciones.Dar;
import main.Juego;

public class DarTest {
	static private Juego juego;
	static private Dar dar;
	
	@BeforeClass
	public static void before() {
		juego = new Juego();
	}

	@Test
	public void testNpcVencido() {	
		dar = new Dar(juego);		
		juego.generarEntorno();
		
		assertEquals("En tu inventario hay: una cerveza.",juego.getInventario().listarItems());
		assertEquals("fantasma ", juego.getUbicacion().getNpcs());
		dar.accionar("cerveza", "fantasma");
//		
//		assertEquals("No posees objetos en tu inventario.",juego.getInventario().listarItems());
//		
//		assertEquals("",juego.getUbicacion().getNpcs());
		
	}
//	@Test
//	public void testNpcNoVencido() {
//		juego.generarEntorno();
//		
//		assertEquals("fantasma ", juego.getUbicacion().getNpcs());
//		dar.accionar("espejo", "fantasma");
//		assertEquals("fantasma ",juego.getUbicacion().getNpcs());
//	}

}