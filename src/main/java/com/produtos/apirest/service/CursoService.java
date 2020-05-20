package com.produtos.apirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.produtos.apirest.models.Cursos;
import com.produtos.apirest.respository.CursoRepository;

public class CursoService {

	@Autowired
	private CursoRepository cursos;
	
	public Cursos coletar(Integer id) {
		Optional<Cursos> obj = cursos.findById(id);
		return obj.orElse(null);
	}
}
