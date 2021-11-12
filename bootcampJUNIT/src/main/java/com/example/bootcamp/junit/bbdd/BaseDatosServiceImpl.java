package com.example.bootcamp.junit.bbdd;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.bootcamp.junit.model.Articulo;

@Service
public class BaseDatosServiceImpl implements BaseDatosServiceI {

	public Map<Integer, Articulo> storage;

	public Integer lastIndex() {
		return storage.size();
	}
	@Override
	public void initBD() {
		storage = new HashMap<>();
		storage.put(1, new Articulo("Camiseta", 18.95));
		storage.put(2, new Articulo("Jersey", 21.95));
		storage.put(3, new Articulo("Cinturón", 30.95));
		storage.put(4, new Articulo("Sudadera", 15.95));
		storage.put(5, new Articulo("Pantalón", 25.95));
		storage.put(6, new Articulo("Zapato", 44.95));
		storage.put(7, new Articulo("Chaqueta", 65.95));
		storage.put(8, new Articulo("Chandal", 70.95));
	}

	@Override
	public Articulo findArticuloById(Integer id) {
		// TODO Auto-generated method stub
		System.out.println("Buscando el articulo con id " + id);
		return storage.get(id);
	}

	@Override
	public void insertarArticulo(Articulo a) {
		// TODO Auto-generated method stub
		System.out.println("Insertando el artículo " + a.getNombre());
		storage.put(storage.size() + 1, a);
	}
	@Override
	public Integer insertarArticuloAndGetId(Articulo a) {
		// TODO Auto-generated method stub
		storage.put(storage.size()+1, a);
		return storage.size();
	}

}
