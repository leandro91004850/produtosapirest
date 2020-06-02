package com.produtos.apirest.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	// retorna um unico id
	@GetMapping("/cursos/{id}")
	public Cursos listaUnicoCurso(@PathVariable(value="id") int id) {
		return servico.findById(id);
		
	}
	
	//salva cursos
	@PostMapping("/cursos")
	public Cursos salvarProduto(@RequestBody Cursos cursos) {
		return servico.save(cursos);
	}
	
	// update cursos
	@PutMapping("/cursos/{id}")
	public ResponseEntity<Object> atualizarCurso(@RequestBody Cursos cursos, @PathVariable int id) {
		Cursos curso = servico.findById(id);
		cursos.setId(id);
		servico.save(cursos);
		
		return ResponseEntity.noContent().build();
	}
	
}
