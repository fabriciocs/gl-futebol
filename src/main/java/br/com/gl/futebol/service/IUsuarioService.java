package br.com.gl.futebol.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.gl.futebol.entity.Usuario;

public interface IUsuarioService extends GenericService<Usuario>{

	public abstract Page<Usuario> buscar(Optional<String> busca, Pageable pagina)
			throws ServiceException;

	public abstract Usuario get(Number parseNumber);

}