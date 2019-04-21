package br.com.luizrezende.cadastro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luizrezende.cadastro.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
