package br.com.luizrezende.cadastro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizrezende.cadastro.domain.Usuario;
import br.com.luizrezende.cadastro.repositories.UsuarioRepository;
import br.com.luizrezende.cadastro.services.base.BaseService;
import br.com.luizrezende.cadastro.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService implements BaseService<Usuario> {

	@Autowired
	private UsuarioRepository repo;

	@Override
	public Usuario create(Usuario entity) {
		return repo.save(entity);
	}

	@Override
	public Usuario readById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	@Override
	public List<Usuario> readAll() {
		return repo.findAll();
	}

	@Override
	public Usuario update(Usuario entity) {
		Usuario newEntity = readById(entity.getId());
		newEntity.setNome(((entity.getNome() != null) ? entity.getNome() : newEntity.getNome()));
		newEntity.setPeso(((entity.getPeso() != null) ? entity.getPeso() : newEntity.getPeso()));
		newEntity.setEstado(((entity.getEstado() != null) ? entity.getEstado() : newEntity.getEstado()));
		return repo.save(newEntity);
	}

	@Override
	public void delete(Integer id) {
		Usuario entity = readById(id);
		repo.delete(entity);
	}
	
	public Usuario readByCpf(String cpf) {
		List<Usuario> usuarioList = repo.findAll();
		Usuario u = null;
		for (Usuario usuario : usuarioList) {
			if(usuario.getCpf().contentEquals(cpf)) {
				u = usuario;
				break;
			}
		}
		return u;
	}
}
