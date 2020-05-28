package com.produtos.apirest.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produtos.apirest.models.Cursos;

public interface CursoRepository extends JpaRepository<Cursos, Integer> {

	Cursos save(Integer id);
	Cursos findById(int id);

	


}
