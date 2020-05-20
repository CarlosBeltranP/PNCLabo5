package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Estudiante;

public interface EstudianteDAO {
	public List<Estudiante>findAll() throws DataAccessException;

	int save(Estudiante e, Integer newRow) throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;

	int delete(Estudiante e) throws DataAccessException;
	
	
}