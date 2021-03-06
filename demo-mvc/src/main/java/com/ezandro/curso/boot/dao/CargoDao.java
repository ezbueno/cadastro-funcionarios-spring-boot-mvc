package com.ezandro.curso.boot.dao;

import java.util.List;

import com.ezandro.curso.boot.domain.Cargo;
import com.ezandro.curso.boot.util.PaginacaoUtil;

public interface CargoDao {

	void save(Cargo cargo);

	void update(Cargo cargo);

	void delete(Long id);

	Cargo findById(Long id);

	List<Cargo> findAll();
	
	PaginacaoUtil<Cargo> buscaPaginada(int pagina);
}
