package br.com.gl.futebol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.gl.futebol.entity.HasID;

//@Service
public class GenericServiceImpl<T extends HasID<?>> implements GenericService<T> {
	
	@Autowired
	public GenericServiceImpl(JpaRepository<T, ?> repository) {
		super();
		this.repository = repository;
	}

	private JpaRepository<T, ?> repository;

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

	@Override
	public GenericService<T> buscar(String busca, Pageable pagina) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
