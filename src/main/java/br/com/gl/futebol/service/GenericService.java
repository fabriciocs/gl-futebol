package br.com.gl.futebol.service;

import org.springframework.data.domain.Pageable;

import br.com.gl.futebol.entity.HasID;

public interface GenericService<T extends HasID<?>> {

	GenericService<T> salvar(T entidade) throws ServiceException;
	
	GenericService<T> remover(T entidade) throws ServiceException;

	GenericService<T> buscar(String busca, Pageable pagina) throws ServiceException;
	
}
