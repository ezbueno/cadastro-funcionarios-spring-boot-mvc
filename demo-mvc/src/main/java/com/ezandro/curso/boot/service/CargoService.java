package com.ezandro.curso.boot.service;

import java.util.List;

import com.ezandro.curso.boot.domain.Cargo;
import com.ezandro.curso.boot.util.PaginacaoUtil;

public interface CargoService {
	
	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id);
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();

	boolean cargoTemFuncionarios(Long id);
	
	PaginacaoUtil<Cargo> buscarPorPagina(int pagina);
}
