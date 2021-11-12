package com.example.bootcamp.junit.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootcamp.junit.bbdd.BaseDatosServiceImpl;
import com.example.bootcamp.junit.model.Articulo;

@Service
public class CarritoCompraServiceImpl implements CarritoCompraService {
	@Autowired
	private BaseDatosServiceImpl baseDatos;

	public List<Articulo> carrito = new ArrayList<>();

	@Override
	public void limpiarCesta() {
		// TODO Auto-generated method stub
		carrito.clear();
	}

	@Override
	public void addArticulo(Articulo a) {
		// TODO Auto-generated method stub
		carrito.add(a);
	}

	@Override
	public Integer getNumArticulo() {
		// TODO Auto-generated method stub
		return carrito.size();
	}

	@Override
	public List<Articulo> getArticulos() {
		// TODO Auto-generated method stub
		return carrito;
	}

	@Override
	public Double totalPrice() {
		// TODO Auto-generated method stub
		Double total = 0D;
		for (Articulo a : carrito) {
			total += a.getPrecio();

		}
		return total;
	}

	@Override
	public Double calculadorDescuento(Double precio, Double porcentajeDescuento) {
		// TODO Auto-generated method stub
		return precio - (precio * porcentajeDescuento / 100);
	}

	@Override
	public Double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		// TODO Auto-generated method stub
		Double resultado = null;
		Articulo articulo = baseDatos.findArticuloById(idArticulo);

		if (articulo != null) {

			resultado = calculadorDescuento(articulo.getPrecio(), porcentaje);
		} else {
			System.out.println("El artículo no ha sido encontrado (id=" + idArticulo + " no existe)");
		}
		return resultado;
	}

	@Override
	public Integer insertarArticuloAndGetID(Articulo a) {
		// TODO Auto-generated method stub
		Integer id = baseDatos.insertarArticuloAndGetId(a);
		addArticulo(a);
		return id;
	}

}
