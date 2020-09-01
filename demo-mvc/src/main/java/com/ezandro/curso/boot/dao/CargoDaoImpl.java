package com.ezandro.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.ezandro.curso.boot.domain.Cargo;

@Repository
public class CargoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao {
}
