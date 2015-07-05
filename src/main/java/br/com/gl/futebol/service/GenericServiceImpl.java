package br.com.gl.futebol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gl.futebol.entity.HasID;

//@Service
public abstract class GenericServiceImpl<T extends HasID<?>> implements
		GenericService<T> {

	@Autowired
	public GenericServiceImpl(JpaRepository<T, ?> repository) {
		super();
		this.repository = repository;
	}

	protected JpaRepository<T, ?> repository;

	@Override
	public GenericService<T> salvar(T entidade) throws ServiceException {
		repository.save(entidade);
		return this;
	}

	@Override
	public GenericService<T> remover(T entidade) throws ServiceException {
		repository.delete(entidade);
		return this;
	}

}
