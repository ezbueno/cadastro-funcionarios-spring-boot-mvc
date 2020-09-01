package com.ezandro.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.ezandro.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {
}
