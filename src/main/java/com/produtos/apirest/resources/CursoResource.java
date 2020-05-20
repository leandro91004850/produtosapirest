package com.produtos.apirest.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Cursos;
import com.produtos.apirest.respository.CursoRepository;

@RestController
public class CursoResource {
	
	@Autowired
	private CursoRepository servico;
	
/*	@GetMapping("/cursos")
	public List<Cursos> listaCursos(){
		return servico.findAll();
	}*/

	@RequestMapping(value="/cursos", method=RequestMethod.GET)
	public ResponseEntity<?> find() { 
		Iterable<Cursos> curso = servico.findAll();
		return ResponseEntity.ok().body(curso);		
	
	}
	
}
