package br.com.gl.futebol.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.gl.futebol.entity.HasID;

public interface GenericService<T extends HasID<?>> {

	T salvar(T entidade) throws ServiceException;

	GenericService<T> remover(T entidade) throws ServiceException;

	Page<T> buscar(Optional<String> busca, Pageable pagina)
			throws ServiceException;

	T get(Number parseNumber);

}
