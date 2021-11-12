package com.example.bootcamp.junit.bbdd;

import com.example.bootcamp.junit.model.Articulo;

public interface BaseDatosServiceI {
	void initBD();

	Articulo findArticuloById(Integer articulo);

	void insertarArticulo(Articulo a);

	Integer insertarArticuloAndGetId(Articulo a);

	public Integer lastIndex();
}
