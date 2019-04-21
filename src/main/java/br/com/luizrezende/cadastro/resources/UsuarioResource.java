package br.com.luizrezende.cadastro.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.luizrezende.cadastro.domain.Usuario;
import br.com.luizrezende.cadastro.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@CrossOrigin
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<?> create(@Valid @RequestBody Usuario entity) {
		Usuario obj = service.create(entity);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> read(@PathVariable Integer id) {
		Usuario obj = service.readById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> readAll() {
		List<Usuario> objList = service.readAll();
		return ResponseEntity.ok().body(objList);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Usuario entity) {
		entity.setId(id);
		Usuario obj = service.update(entity);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/doc/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<?> readByCpf(@PathVariable String cpf) {
		Usuario obj = service.readByCpf(cpf);
		return ResponseEntity.ok().body(obj);
	}
}
