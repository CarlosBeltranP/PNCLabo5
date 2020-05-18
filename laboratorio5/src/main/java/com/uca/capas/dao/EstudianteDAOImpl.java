package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Estudiante;

@Repository
public class EstudianteDAOImpl implements EstudianteDAO {

	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;
	
	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		Estudiante estudiante = entityManager.find(Estudiante.class,  code);
		return estudiante;
	}
	
	//Ver todos los estudiantes
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.estudiante");
		Query query = entityManager.createNativeQuery(sb.toString(),Estudiante.class);
		List<Estudiante>resulset=query.getResultList();
		return resulset;
	}

	//Guardar nuevo estudiante
	@Override
	@Transactional
	public int save(Estudiante e, Integer newRow) throws DataAccessException {
		try{
			if(newRow ==1) { entityManager.persist(e);
			}
			else entityManager.merge(e);
			entityManager.flush(); //sincronizo con la base
			return 1;
		}
		catch(Throwable t ) {
			t.printStackTrace();
			return 1;
		}
	}


}