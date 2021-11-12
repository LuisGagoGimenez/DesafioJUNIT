package com.example.bootcamp.junit.services;

import java.util.List;

import com.example.bootcamp.junit.model.Articulo;

public interface CarritoCompraService {
	void limpiarCesta();

	void addArticulo(Articulo a);

	Integer getNumArticulo();

	List<Articulo> getArticulos();

	Double totalPrice();

	Double calculadorDescuento(Double precio, Double porcentajeDescuento);

	Double aplicarDescuento(Integer idArticulo, Double porcentaje);
	
	Integer insertarArticuloAndGetID(Articulo a);
}
