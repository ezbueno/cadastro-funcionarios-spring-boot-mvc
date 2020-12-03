package com.ezandro.curso.boot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ezandro.curso.boot.domain.Cargo;
import com.ezandro.curso.boot.util.PaginacaoUtil;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {
	
	public PaginacaoUtil<Cargo> buscaPaginada(int pagina) {
		int tamanho = 5;
		int inicio = (pagina - 1) * tamanho;
		
		List<Cargo> cargos = getEntityManager()
				.createQuery("SELECT c FROM Cargo ORDER BY c.nome ASC", Cargo.class)
				.setFirstResult(inicio)
				.setMaxResults(tamanho)
				.getResultList();
		
		long totalRegistros = count();
		long totalPaginas = (totalRegistros + (tamanho - 1));
		
		return new PaginacaoUtil<>(tamanho, pagina, totalPaginas, cargos);
	}
	
	public long count() {
		return getEntityManager()
				.createQuery("SELECT COUNT(*) FROM Cargo", long.class)
				.getSingleResult();			
	}
}
