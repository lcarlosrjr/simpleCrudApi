package br.com.luizrezende.cadastro.services.base;

import java.util.List;

import br.com.luizrezende.cadastro.domain.base.BaseEntity;

public interface BaseService<E extends BaseEntity> {

	public E create(E entity);

	public E readById(Integer id);

	public List<E> readAll();

	public E update(E entity);

	public void delete(Integer id);

}
