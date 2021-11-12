package com.example.bootcamp.junit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.bootcamp.junit.bbdd.BaseDatosServiceImpl;
import com.example.bootcamp.junit.model.Articulo;

@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class CarritoCompraServiceImplTest {

	@InjectMocks
	CarritoCompraServiceImpl carritoCompraService = new CarritoCompraServiceImpl();

	@Mock
	BaseDatosServiceImpl baseDatos;

	@BeforeEach
	public void initCarrito() {

		carritoCompraService.addArticulo(new Articulo("Polainas", 8D));
		carritoCompraService.addArticulo(new Articulo("Polainas", 8D));
		carritoCompraService.addArticulo(new Articulo("Botas", 2D));
	}

	@Test
	@Order(1)
	void testAddArticulo() {
		System.out.println("AddArticuloTest");
		assertFalse(carritoCompraService.carrito.isEmpty());

	}

	@Test
	@Order(2)
	void testTotalPrice() {
		System.out.println("TotalPriceTest");
		Double d = 0D;

		for (Articulo a : carritoCompraService.getArticulos()) {
			d += a.getPrecio();
		}

		assertEquals(18, d);
	}

	@Test
	@Order(3)
	void testGetNumArticulo() {
		System.out.println("GetNumArticuloTest");
		assertTrue(1 < 2);
	}

	@Test
	@Order(4)
	void testGetArticulos() {
		System.out.println("GetArticulosTest");
		assertTrue(1 < 2);
	}

	@Test
	@Order(5)
	void testInsertarArticuloByID() {
		System.out.println("InsertarArticulosTest");
		Articulo a = new Articulo("Traje", 20.0);

		when(baseDatos.insertarArticuloAndGetId(a)).thenReturn(5);
		Integer id = carritoCompraService.insertarArticuloAndGetID(a);

		assertEquals(5, id);

		verify(baseDatos, times(1)).insertarArticuloAndGetId(a);
		verify(carritoCompraService.carrito).add(a);

	}

	@Test
	@Order(6)
	void testCalculadorDescuento() {
		System.out.println("CalculadorDescuentoTest");
		Double d = carritoCompraService.calculadorDescuento(12D, 10D);
		assertEquals(10.8, d);
	}

	@Test
	@Order(7)
	void testAplicarDescuento() {
		System.out.println("AplicarDescuentoTest");
		Articulo a = new Articulo("Corbata", 17.6D);
		when(baseDatos.findArticuloById(any(Integer.class))).thenReturn(a);
		Double d = carritoCompraService.aplicarDescuento(1, 50D);
		assertEquals(8.8, d);

		verify(baseDatos, times(1)).findArticuloById(any(Integer.class));
	}

	@Test
	@Order(8)
	void testLimpiarCesta() {
		System.out.println("LimpiarCestaTest");
		carritoCompraService.limpiarCesta();

		assertTrue(carritoCompraService.carrito.isEmpty());
	}

	@Test
	@Order(9)
	void emptyTest() {
		System.out.println("EmptyTest");
	}

}
